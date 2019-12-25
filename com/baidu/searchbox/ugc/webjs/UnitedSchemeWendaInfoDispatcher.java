package com.baidu.searchbox.ugc.webjs;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.eventmessage.WendaBarEventMessage;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UnitedSchemeWendaInfoDispatcher extends UnitedSchemeBaseDispatcher {
    private static final String ACTION_GET_DETAIL_PAGE_INFO = "getDetailPageInfo";
    public static final String MODULE_WENDA = "wenda";
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = UnitedSchemeWendaInfoDispatcher.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "wenda";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        int i;
        JSONObject jSONObject;
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (DEBUG) {
                Log.w(TAG, "Uri action is null");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            if (ACTION_GET_DETAIL_PAGE_INFO.equalsIgnoreCase(path)) {
                String str = unitedSchemeEntity.getParams().get("params");
                if (str == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String str2 = null;
                String str3 = null;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject(str);
                    i = jSONObject3.optInt("status");
                    try {
                        str2 = jSONObject3.optString("titleName");
                        str3 = jSONObject3.optString(SuspensionBallEntity.KEY_SCHEME);
                        jSONObject = jSONObject3.optJSONObject("ext");
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        jSONObject = jSONObject2;
                        if (i != -1) {
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                        return false;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    i = -1;
                }
                if (i != -1 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                    return false;
                }
                EventBusWrapper.post(new WendaBarEventMessage(i, str2, str3, jSONObject));
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}
