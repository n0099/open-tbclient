package com.baidu.searchbox.ng.ai.apps.storage.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppSchemeStatusCode;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RemoveSavedFileAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/file/removeSavedFile";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String MODULE_TAG = "removeSavedFile";

    public RemoveSavedFileAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
        String scheme2Path = StorageUtil.scheme2Path(optParamsAsJo.optString("filePath"), AiApp.getAiAppId());
        if (TextUtils.isEmpty(scheme2Path)) {
            AiAppsLog.e(MODULE_TAG, "file path is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        int checkFilePath = aiApp.getStorage().checkFilePath(scheme2Path);
        if (checkFilePath > 2000) {
            AiAppsLog.e(MODULE_TAG, "file path status code : " + checkFilePath);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(checkFilePath, AiAppSchemeStatusCode.getErrMessage(checkFilePath)));
            return false;
        } else if (AiAppsFileUtils.deleteFile(scheme2Path)) {
            AiAppsLog.i(MODULE_TAG, "file delete success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        } else {
            AiAppsLog.e(MODULE_TAG, "file delete fail");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2004, AiAppSchemeStatusCode.getErrMessage(2004)));
            return false;
        }
    }
}
