package com.baidu.searchbox.ng.ai.apps.storage.actions;

import android.content.Context;
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
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetSavedFileListAction extends AiAppAction {
    public static final String ACTION_TYPE = "/swan/file/getSavedFileList";
    private static final String KEY_CREATE_TIME = "createTime";
    private static final String KEY_FILE_LIST = "fileList";
    private static final String KEY_FILE_PATH = "filePath";
    private static final String KEY_SIZE = "size";
    private static final String MODULE_TAG = "getSavedFileList";

    public GetSavedFileListAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (context == null || callbackHandler == null || aiApp == null || aiApp.getStorage() == null) {
            AiAppsLog.e(MODULE_TAG, "execute fail");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        ArrayList arrayList = (ArrayList) aiApp.getStorage().getSavedFileList();
        JSONArray jSONArray = new JSONArray();
        if (arrayList == null || arrayList.size() == 0) {
            AiAppsLog.e(MODULE_TAG, "file list is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, 0));
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FileInfo fileInfo = (FileInfo) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("filePath", StorageUtil.path2Scheme(fileInfo.getPath(), AiApp.getAiAppId()));
                jSONObject.put(KEY_CREATE_TIME, fileInfo.getCreatedTime());
                jSONObject.put("size", fileInfo.getSize());
            } catch (JSONException e) {
                AiAppsLog.w(MODULE_TAG, "file info to json fail");
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(KEY_FILE_LIST, jSONArray);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0));
            return true;
        } catch (JSONException e2) {
            AiAppsLog.e(MODULE_TAG, "file list to json fail");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(2003, AiAppSchemeStatusCode.getErrMessage(2003)));
            return false;
        }
    }
}
