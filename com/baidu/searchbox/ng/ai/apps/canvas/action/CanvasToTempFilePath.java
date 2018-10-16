package com.baidu.searchbox.ng.ai.apps.canvas.action;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.canvas.CanvasManager;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
import com.baidu.searchbox.ng.ai.apps.canvas.view.CanvasView;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragment;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.webkit.sdk.WebView;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CanvasToTempFilePath extends AbsCanvasAction {
    public static final String ACTION_TYPE = "/swan/canvas/toTempFilePath";
    private static final String PATH_DOT = ".";
    private static final String SECOND_LEVEL_JSON_KEY = "tempFilePath";

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

    public CanvasToTempFilePath(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        final String str;
        AiAppsFragment topAiAppsFragment;
        unitedSchemeEntity.result = resultCode(201);
        final CanvasToTempFileModel parseMsgToModel = parseMsgToModel(unitedSchemeEntity);
        if (parseMsgToModel == null) {
            AiAppsLog.e("AiAppCanvas", "CanvasToTempFilePath action parse model is null");
            return false;
        }
        String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(aiApp.id);
        if (TextUtils.isEmpty(aiappTmpDirectory)) {
            AiAppsLog.e("AiAppCanvas", "CanvasToTempFilePath cache path is empty");
            return false;
        }
        String str2 = aiappTmpDirectory + File.separator + Calendar.getInstance().getTimeInMillis();
        if (parseMsgToModel.isJpgFile()) {
            str = str2 + ".jpg";
        } else {
            str = str2 + ".png";
        }
        if (TextUtils.isEmpty(parseMsgToModel.slaveId) && (topAiAppsFragment = AiAppsController.getInstance().getTopAiAppsFragment()) != null) {
            parseMsgToModel.slaveId = topAiAppsFragment.getSlaveWebViewId();
        }
        if (TextUtils.isEmpty(parseMsgToModel.slaveId) || TextUtils.isEmpty(parseMsgToModel.id)) {
            AiAppsLog.e("AiAppCanvas", "CanvasToTempFilePath slave id = " + parseMsgToModel.slaveId + " ; cavas id = " + parseMsgToModel.id);
            return false;
        }
        final CanvasView canvasViewByCanvasId = CanvasManager.getIns().getCanvasViewByCanvasId(parseMsgToModel);
        if (canvasViewByCanvasId == null) {
            AiAppsLog.e("AiAppCanvas", "CanvasToTempFilePath canvas view is null");
            return false;
        }
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.canvas.action.CanvasToTempFilePath.1
            /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str3;
                JSONException e;
                boolean tempFilePath = parseMsgToModel.toTempFilePath(canvasViewByCanvasId, str);
                HashMap<String, String> params = unitedSchemeEntity.getParams();
                if (params != null && !params.isEmpty()) {
                    String str4 = params.get("params");
                    JSONObject jSONObject = new JSONObject();
                    if (str4 == null) {
                        str3 = null;
                    } else {
                        try {
                            str3 = new JSONObject(str4).optString("cb");
                            try {
                                jSONObject.putOpt("tempFilePath", StorageUtil.path2Scheme(str, aiApp.id));
                            } catch (JSONException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (TextUtils.isEmpty(str3)) {
                                }
                            }
                        } catch (JSONException e3) {
                            str3 = null;
                            e = e3;
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        callbackHandler.handleSchemeDispatchCallback(str3, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, tempFilePath ? 0 : 1001).toString());
                    }
                }
            }
        }, "tempFilePath");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.ng.ai.apps.canvas.action.AbsCanvasAction, com.baidu.searchbox.ng.ai.apps.canvas.action.ICanvasPreHandle
    public CanvasToTempFileModel parseMsgToModel(UnitedSchemeEntity unitedSchemeEntity) {
        String str = unitedSchemeEntity.getParams().get("params");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new CanvasToTempFileModel(str);
    }
}
