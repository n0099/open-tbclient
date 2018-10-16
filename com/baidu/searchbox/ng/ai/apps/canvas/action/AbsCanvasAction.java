package com.baidu.searchbox.ng.ai.apps.canvas.action;

import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class AbsCanvasAction extends AiAppAction implements ICanvasPreHandle {
    static final String MODULE_TAG = "AiAppCanvas";

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsCanvasAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public CanvasBasicModel parseMsgToModel(UnitedSchemeEntity unitedSchemeEntity) {
        return new CanvasBasicModel(unitedSchemeEntity.getParams().get("params"));
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public WebView getBdWebViewBySlaveId(UnitedSchemeEntity unitedSchemeEntity, String str) {
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(str);
        if (webViewManager == null) {
            unitedSchemeEntity.result = resultCode(1001);
            return null;
        }
        NgWebView webView = webViewManager.getWebView();
        if (webView == null) {
            unitedSchemeEntity.result = resultCode(1001);
            return null;
        }
        return webView.getCurrentWebView();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public JSONObject resultCode(int i) {
        return UnitedSchemeUtility.wrapCallbackParams(i);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : 1001);
    }
}
