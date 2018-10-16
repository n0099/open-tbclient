package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetSwanHistoryAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getHistory";
    public static final String KEY_APP_ID = "appid";
    public static final String KEY_DATA_STAMP = "dataStamp";
    public static final String KEY_HISTORY = "history";
    public static final String KEY_ICON_URL = "iconUrl";
    public static final String KEY_SCHEME = "scheme";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TYPE = "type";
    private static final String MODULE_TAG = "history";
    public static final String SCHEME_CONSTANT_CONNECT = "\"}&from=";
    public static final String SCHEME_CONSTANT_START = "baiduboxapp://v19/swan/launch?params={\"appid\":\"";

    /* loaded from: classes2.dex */
    public interface OnSwanHistoryListener {
        void onFinish(JSONObject jSONObject);
    }

    public GetSwanHistoryAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e("history", "none aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal aiApp");
            return false;
        }
        final String optString = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e("history", "none cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (!(context instanceof Activity)) {
            AiAppsLog.e("history", "error context");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "the context is not an activity");
            return false;
        } else {
            aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_MAPP_I_GET_HISTORY, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(Boolean bool) {
                    if (bool.booleanValue()) {
                        GetSwanHistoryAction.this.getSwanHistory(unitedSchemeEntity, callbackHandler, optString);
                        return;
                    }
                    AiAppsLog.e("history", "permission denied");
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSwanHistory(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final String str) {
        AiAppsLog.i("history", "start get history");
        AiAppsRuntime.getHistoryRuntime().getSwanHistory(new OnSwanHistoryListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction.OnSwanHistoryListener
            public void onFinish(JSONObject jSONObject) {
                if (jSONObject == null || jSONObject.length() == 0) {
                    AiAppsLog.i("history", "none history");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), str);
                    return;
                }
                AiAppsLog.i("history", "get history :" + jSONObject.toString());
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), str);
            }
        });
    }
}
