package com.baidu.i.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a extends UnitedSchemeBaseDispatcher {
    private static final boolean DEBUG = b.DEBUG;
    private static final String TAG = a.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "nativeView";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.i(TAG, String.format(Locale.getDefault(), "entity(%s)", unitedSchemeEntity.getUri()));
        }
        c.d(TAG, "start UnitedSchemeNativeViewDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (DEBUG) {
                Log.w(TAG, "Uri action is null");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            char c = 65535;
            switch (path.hashCode()) {
                case 3417674:
                    if (path.equals("open")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    a(context, unitedSchemeEntity, callbackHandler);
                    return true;
                default:
                    if (DEBUG) {
                        Log.w(TAG, "action " + path + " not support");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
                    return false;
            }
        }
    }

    private boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONObject jSONObject;
        String str = null;
        e aDa = e.aDa();
        if (aDa == null) {
            c.e(TAG, "swan app is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (TextUtils.isEmpty(aDa.id)) {
            c.e(TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                c.e(TAG, "object is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = optParamsAsJo.optString(BdStatsConstant.StatsKey.TYPE);
            if (optString == null) {
                c.e(TAG, "module is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!optString.equals("ba")) {
                c.e(TAG, "module val is not ba");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                try {
                    jSONObject = new JSONObject(unitedSchemeEntity.getParam("params"));
                    if (jSONObject != null) {
                        try {
                            str = jSONObject.optString("cb");
                        } catch (JSONException e) {
                            e = e;
                            e.printStackTrace();
                            if (str != null) {
                            }
                            c.e(TAG, "KYE_CALL_BACK_NAME is null");
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                            return false;
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject = null;
                }
                if (str != null || jSONObject == null) {
                    c.e(TAG, "KYE_CALL_BACK_NAME is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                boolean e3 = e(context, jSONObject);
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), 0);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                callbackHandler.handleSchemeDispatchCallback(str, wrapCallbackParams.toString());
                c.e(TAG, e3 ? "navigateToForum succ" : " navigateToForum fail");
                return true;
            }
        }
    }

    private boolean e(Context context, JSONObject jSONObject) {
        String str = null;
        try {
            str = jSONObject.optJSONObject("params").optString(TbTitleActivityConfig.FORUM_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            c.e(TAG, "params parse exception:", e);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FrsActivityConfig createNormalCfg = new FrsActivityConfig(context).createNormalCfg(str, "smart_app");
        createNormalCfg.setCallFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg));
        return true;
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}
