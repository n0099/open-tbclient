package com.baidu.searchbox.ng.ai.apps.canvas.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.canvas.CanvasManager;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasDrawModel;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasDrawAction extends AbsCanvasAction {
    public static final String ACTION_TYPE = "/swan/canvas/drawCanvas";

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.callback(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ WebView getBdWebViewBySlaveId(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.getBdWebViewBySlaveId(unitedSchemeEntity, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ JSONObject resultCode(int i) {
        return super.resultCode(i);
    }

    public CanvasDrawAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        CanvasDrawModel parseMsgToModel = parseMsgToModel(unitedSchemeEntity);
        if (parseMsgToModel == null) {
            AiAppsLog.e("AiAppCanvas", "draw model is null");
            unitedSchemeEntity.result = resultCode(201);
            return false;
        }
        boolean drawCanvas = CanvasManager.getIns().drawCanvas(context, parseMsgToModel);
        callback(unitedSchemeEntity, callbackHandler, drawCanvas);
        return drawCanvas;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public CanvasDrawModel parseMsgToModel(UnitedSchemeEntity unitedSchemeEntity) {
        return new CanvasDrawModel(unitedSchemeEntity.getParams().get("params"));
    }
}
