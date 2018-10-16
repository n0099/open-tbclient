package com.baidu.searchbox.ng.ai.apps.canvas.action;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.canvas.CanvasManager;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasBasicModel;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.webkit.sdk.WebView;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasInsertAction extends AbsCanvasAction {
    public static final String ACTION_TYPE = "/swan/canvas/insert";

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ void callback(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        super.callback(unitedSchemeEntity, callbackHandler, z);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ WebView getBdWebViewBySlaveId(UnitedSchemeEntity unitedSchemeEntity, String str) {
        return super.getBdWebViewBySlaveId(unitedSchemeEntity, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ CanvasBasicModel parseMsgToModel(UnitedSchemeEntity unitedSchemeEntity) {
        return super.parseMsgToModel(unitedSchemeEntity);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public /* bridge */ /* synthetic */ JSONObject resultCode(int i) {
        return super.resultCode(i);
    }

    public CanvasInsertAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        boolean z = false;
        CanvasBasicModel parseMsgToModel = parseMsgToModel(unitedSchemeEntity);
        if (parseMsgToModel == null) {
            unitedSchemeEntity.result = resultCode(201);
            AiAppsLog.e("AiAppCanvas", "insert action parse model is null");
        } else {
            WebView bdWebViewBySlaveId = getBdWebViewBySlaveId(unitedSchemeEntity, parseMsgToModel.slaveId);
            if (bdWebViewBySlaveId != null && CanvasManager.getIns().insert(context, bdWebViewBySlaveId, parseMsgToModel)) {
                z = true;
            }
            callback(unitedSchemeEntity, callbackHandler, z);
        }
        return z;
    }
}
