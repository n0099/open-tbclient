package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.AiAppSchemeStatusCode;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.PathType;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetLocalImgDataAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getLocalImgData";
    private static final String MODULE_TAG = "GetLocalImgDataAction";
    private static final String PATH_KEY = "filePath";

    public GetLocalImgDataAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (!AiAppsRuntime.getAiAppAbTestRuntime().isGetLocalImgDataOn()) {
            AiAppsLog.e(MODULE_TAG, "GetLocalImgData is refused");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(null, 2007, AiAppSchemeStatusCode.getErrMessage(2007));
            return false;
        } else if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "illegal aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        } else {
            String optString = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity).optString("filePath");
            if (TextUtils.isEmpty(optString)) {
                AiAppsLog.e(MODULE_TAG, "GetLocalImgDataAction bdfile path null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (StorageUtil.getPathType(optString) != PathType.BD_FILE) {
                AiAppsLog.e(MODULE_TAG, "invalid path : " + optString);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(null, 2006, AiAppSchemeStatusCode.getErrMessage(2006));
                return false;
            } else {
                String scheme2Path = StorageUtil.scheme2Path(optString, aiApp.id);
                if (TextUtils.isEmpty(scheme2Path)) {
                    AiAppsLog.e(MODULE_TAG, "GetLocalImgDataAction realPath null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("filePath", scheme2Path);
                    AiAppsLog.i(MODULE_TAG, "getLocalImgData success");
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    return true;
                } catch (JSONException e) {
                    AiAppsLog.e(MODULE_TAG, "getLocalImgData failed");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
        }
    }
}
