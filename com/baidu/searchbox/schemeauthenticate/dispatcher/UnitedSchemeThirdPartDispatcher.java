package com.baidu.searchbox.schemeauthenticate.dispatcher;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.schemeauthenticate.AuthenticateNetManager;
import com.baidu.searchbox.schemeauthenticate.AuthenticateUtils;
import com.baidu.searchbox.schemeauthenticate.SchemeAuthenticateMonitor;
import com.baidu.searchbox.schemeauthenticate.database.AuthenticateControl;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UnitedSchemeThirdPartDispatcher extends UnitedSchemeBaseDispatcher {
    public static final String ACTION_INIT_CONFIG = "config";
    public static final String KEY_SCHEME_LIST = "schemeList";
    public static final String MODULE_NAME = "thirdPart";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = UnitedSchemeThirdPartDispatcher.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return UnitedSchemeBaseDispatcher.DISPATCHER_NOT_FIRST_LEVEL;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AuthenticateNetManager.SiteauthenticateResult siteauthenticateResult) {
        if (DEBUG) {
            String str = TAG;
            Log.i(str, "callback entity:" + unitedSchemeEntity + ",result:" + siteauthenticateResult);
        }
        if (siteauthenticateResult != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("expireTime", siteauthenticateResult.getExpireTime() / 1000);
                jSONObject.put("schemeList", new JSONArray(siteauthenticateResult.getSchemeList()));
            } catch (Exception e) {
                if (DEBUG) {
                    String str2 = TAG;
                    Log.i(str2, "handlerConfig e:" + e);
                }
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 0));
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (DEBUG) {
            String str = TAG;
            Log.i(str, "invoke entity:" + unitedSchemeEntity);
        }
        String path = unitedSchemeEntity.getPath(false);
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (!TextUtils.isEmpty(path) && params != null && params.size() > 0) {
            if (unitedSchemeEntity.isOnlyVerify()) {
                return true;
            }
            if (TextUtils.equals(path, "config")) {
                if (!handlerConfig(unitedSchemeEntity, callbackHandler)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                }
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        if (!unitedSchemeEntity.isOnlyVerify()) {
            UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action/params");
        }
        if (DEBUG) {
            Log.w(TAG, "Uri action/params is null");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
        return false;
    }

    private boolean handlerConfig(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        String param = unitedSchemeEntity.getParam("params");
        if (DEBUG) {
            String str = TAG;
            Log.i(str, "handlerConfig params:" + param);
        }
        try {
            JSONObject jSONObject = new JSONObject(param);
            jSONObject.getString("type");
            jSONObject.getJSONArray("schemeList");
            new AuthenticateNetManager().authenticateConfig(AppRuntime.getAppContext(), unitedSchemeEntity.getReferUrl(), jSONObject, new AuthenticateNetManager.Authenticatecallback() { // from class: com.baidu.searchbox.schemeauthenticate.dispatcher.UnitedSchemeThirdPartDispatcher.1
                @Override // com.baidu.searchbox.schemeauthenticate.AuthenticateNetManager.Authenticatecallback
                public void onFailure() {
                    if (UnitedSchemeThirdPartDispatcher.DEBUG) {
                        Log.i(UnitedSchemeThirdPartDispatcher.TAG, "handlerConfig onFailure");
                    }
                    UnitedSchemeThirdPartDispatcher.this.callback(unitedSchemeEntity, callbackHandler, null);
                }

                @Override // com.baidu.searchbox.schemeauthenticate.AuthenticateNetManager.Authenticatecallback
                public void onNoNetwork() {
                    if (UnitedSchemeThirdPartDispatcher.DEBUG) {
                        Log.i(UnitedSchemeThirdPartDispatcher.TAG, "handlerConfig onNoNetwork");
                    }
                    UnitedSchemeThirdPartDispatcher.this.callback(unitedSchemeEntity, callbackHandler, null);
                }

                @Override // com.baidu.searchbox.schemeauthenticate.AuthenticateNetManager.Authenticatecallback
                public void onsucess(AuthenticateNetManager.SiteauthenticateResult siteauthenticateResult) {
                    if (UnitedSchemeThirdPartDispatcher.DEBUG) {
                        String str2 = UnitedSchemeThirdPartDispatcher.TAG;
                        Log.i(str2, "handlerConfig onsucess result:" + siteauthenticateResult);
                    }
                    if (siteauthenticateResult != null) {
                        SchemeAuthenticateMonitor.SiteAuthenticateInfo siteauthenticateResult2SiteAuthenticateInfo = AuthenticateNetManager.siteauthenticateResult2SiteAuthenticateInfo(siteauthenticateResult);
                        SchemeAuthenticateMonitor.getInstanse().updateSiteAuthenticateInfo(unitedSchemeEntity.getReferUrl(), siteauthenticateResult2SiteAuthenticateInfo.getType(), siteauthenticateResult2SiteAuthenticateInfo);
                        UnitedSchemeThirdPartDispatcher.this.saveCache(siteauthenticateResult);
                        UnitedSchemeThirdPartDispatcher.this.callback(unitedSchemeEntity, callbackHandler, siteauthenticateResult);
                    }
                }
            });
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                String str2 = TAG;
                Log.i(str2, "handlerConfig e:" + e);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCache(AuthenticateNetManager.SiteauthenticateResult siteauthenticateResult) {
        AuthenticateControl.AuthenticateItem authenticateItem = new AuthenticateControl.AuthenticateItem();
        authenticateItem.expireTime = siteauthenticateResult.getExpireTime();
        authenticateItem.url = siteauthenticateResult.getUrl();
        authenticateItem.schemeList = siteauthenticateResult.getSchemeList();
        authenticateItem.type = siteauthenticateResult.getType();
        authenticateItem.signKey = AuthenticateUtils.getAuthKey(siteauthenticateResult.getUrl(), siteauthenticateResult.getType());
        AuthenticateControl.getInstance(AppRuntime.getAppContext()).insertInfo(authenticateItem);
    }
}
