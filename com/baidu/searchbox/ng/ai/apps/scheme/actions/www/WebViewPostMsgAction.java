package com.baidu.searchbox.ng.ai.apps.scheme.actions.www;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsWebViewWidget;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsWebViewMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WebViewPostMsgAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/webviewPostMessage";
    private static final boolean DEBUG = false;
    private static final String MODULE_TAG = "webviewPostMsg";
    private static final String PARAM_DATA_KEY = "data";
    private static final String TAG = "WebViewPostMsgAction";
    private AiAppsWebViewWidget mWebViewWidget;

    public WebViewPostMsgAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        AiAppsLog.i(MODULE_TAG, "start post webview msg");
        if (this.mWebViewWidget == null) {
            AiAppsLog.e(MODULE_TAG, "none webview widget");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
            return false;
        }
        WWWParams params = this.mWebViewWidget.getParams();
        if (params == null) {
            AiAppsLog.e(MODULE_TAG, "none WWWParams");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "none params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
            return false;
        } else if (!paramAsJo.has("data")) {
            AiAppsLog.e(MODULE_TAG, "none param data");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
            return false;
        } else {
            AiAppsController.getInstance().sendJSMessage(new AiAppsWebViewMessage.Builder().wvID(params.slaveId).webViewId(params.id).eventType(AiAppsWebViewMessage.EVENT_TYPE_PUSH_MESSAGE).data(paramAsJo.optString("data")).build());
            AiAppsLog.i(MODULE_TAG, "post webview msg success");
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public void setWebViewWidget(AiAppsWebViewWidget aiAppsWebViewWidget) {
        this.mWebViewWidget = aiAppsWebViewWidget;
    }
}
