package com.baidu.searchbox.ng.ai.apps.storage.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppSchemeStatusCode;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.storage.FileInfo;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetSavedFileInfoAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/file/getSavedFileInfo";
    private static final String KEY_CREATE_TIME = "createTime";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String KEY_SIZE = "size";
    private static final String MODULE_TAG = "getSavedFile";

    public GetSavedFileInfoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
        FileInfo savedFileInfo = aiApp.getStorage().getSavedFileInfo(scheme2Path);
        if (savedFileInfo == null) {
            AiAppsLog.e(MODULE_TAG, "file info is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, AiAppSchemeStatusCode.getErrMessage(2001)));
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CREATE_TIME, Math.round((float) (savedFileInfo.getCreatedTime() / 1000)));
            jSONObject.put("size", savedFileInfo.getSize());
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            AiAppsLog.w(MODULE_TAG, "file info to json fail");
            e.printStackTrace();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, AiAppSchemeStatusCode.getErrMessage(2003)));
            return false;
        }
    }
}
