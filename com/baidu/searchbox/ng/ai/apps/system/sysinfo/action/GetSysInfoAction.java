package com.baidu.searchbox.ng.ai.apps.system.sysinfo.action;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.system.sysinfo.util.AiAppsSysInfoUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetSysInfoAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getCommonSysInfo";
    private static final boolean DEBUG = false;
    private static final String KEY_CB = "cb";
    private static final String KEY_PARAMS = "params";
    private static final String MODULE_TAG = "GetSysInfo";
    private static final String TAG = "GetSysInfoAction";
    private String mCallback;

    public GetSysInfoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.i(MODULE_TAG, "aiApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        this.mCallback = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            AiAppsLog.i(MODULE_TAG, "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_SYS_INFO, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.system.sysinfo.action.GetSysInfoAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (bool.booleanValue()) {
                    GetSysInfoAction.this.handleAuthorized(context, unitedSchemeEntity, callbackHandler, aiApp);
                    return;
                }
                AiAppsLog.i(GetSysInfoAction.MODULE_TAG, "non-authorized");
                callbackHandler.handleSchemeDispatchCallback(GetSysInfoAction.this.mCallback, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        });
        AiAppsLog.i(MODULE_TAG, "callback success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        String cuid = AiAppsSysInfoUtil.getCUID();
        String imei = AiAppsSysInfoUtil.getIMEI(context);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", cuid);
            jSONObject.put("imei", imei);
            AiAppsLog.i(MODULE_TAG, "fetch commonSysInfo success");
            callbackHandler.handleSchemeDispatchCallback(this.mCallback, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e) {
        }
    }
}
