package com.baidu.searchbox.ng.ai.apps.storage.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppSchemeStatusCode;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.storage.PathType;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetFileInfoAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/file/getInfo";
    private static final String ALGORITHM_MD5 = "md5";
    private static final String ALGORITHM_SHA1 = "sha1";
    private static final String KEY_ALGORITHM = "digestAlgorithm";
    private static final String KEY_DIGEST = "digest";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String KEY_SIZE = "size";
    private static final String MODULE_TAG = "fileInfo";
    private static final String TAG = "GetFileInfoAction";

    public GetFileInfoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
        String optString = optParamsAsJo.optString("filePath");
        String str = "";
        if (StorageUtil.getPathType(optString) == PathType.BD_FILE) {
            str = StorageUtil.scheme2Path(optString, AiApp.getAiAppId());
        } else if (StorageUtil.getPathType(optString) == PathType.RELATIVE) {
            str = StorageUtil.relativeToPath(optString, aiApp, aiApp.getVersion());
        }
        if (TextUtils.isEmpty(str)) {
            AiAppsLog.e(MODULE_TAG, "absolute filePath is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        File file = new File(str);
        String encrypt = AiAppEncryptUtils.encrypt(TextUtils.equals(optParamsAsJo.optString(KEY_ALGORITHM, "md5"), "md5") ? AiAppEncryptUtils.ENCRYPT_MD5 : AiAppEncryptUtils.ENCRYPT_SHA1, file, false);
        if (TextUtils.isEmpty(encrypt)) {
            AiAppsLog.e(MODULE_TAG, "hash is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2001, AiAppSchemeStatusCode.getErrMessage(2001)));
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_DIGEST, encrypt);
            jSONObject.put("size", file.length());
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, AiAppSchemeStatusCode.getErrMessage(2003)));
            return false;
        }
    }
}
