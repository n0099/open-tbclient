package com.baidu.searchbox.ng.ai.apps.storage.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppSchemeStatusCode;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SaveFileAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/file/save";
    private static final String KEY_SAVED_FILE_PATH = "savedFilePath";
    private static final String KEY_TEMP_FILE_PATH = "tempFilePath";
    private static final String MODULE_TAG = "saveFile";

    public SaveFileAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (context == null || callbackHandler == null || aiApp == null || aiApp.getStorage() == null) {
            AiAppsLog.e(MODULE_TAG, "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String scheme2Path = StorageUtil.scheme2Path(optParamsAsJo.optString("tempFilePath"), AiApp.getAiAppId());
        if (TextUtils.isEmpty(scheme2Path)) {
            AiAppsLog.e(MODULE_TAG, "temp file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        int checkFilePath = aiApp.getStorage().checkFilePath(scheme2Path);
        if (checkFilePath > 2000) {
            AiAppsLog.e(MODULE_TAG, "file path status code : " + checkFilePath);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(checkFilePath, AiAppSchemeStatusCode.getErrMessage(checkFilePath)));
            return false;
        }
        String saveFile = aiApp.getStorage().saveFile(scheme2Path);
        if (TextUtils.isEmpty(saveFile)) {
            AiAppsLog.e(MODULE_TAG, "save file path is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, AiAppSchemeStatusCode.getErrMessage(2003)));
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_SAVED_FILE_PATH, StorageUtil.path2Scheme(saveFile, AiApp.getAiAppId()));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            AiAppsLog.w(MODULE_TAG, "save file path to scheme fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
    }
}
