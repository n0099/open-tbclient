package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.PathType;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetImageInfoAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getImageInfo";
    private static final int GET_INFO_FAILED = 1;
    private static final String KEY_PARAMS = "params";
    private static final String MODULE_TAG = "getImageInfo";
    private static final String PARAMS_PATH_KEY = "src";

    public GetImageInfoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "illegal aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        String optString = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params")).optString("src");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(MODULE_TAG, "path null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        JSONObject jSONObject = null;
        if (StorageUtil.getPathType(optString) == PathType.BD_FILE) {
            jSONObject = getImgInfo(StorageUtil.scheme2Path(optString, aiApp.id), optString);
        } else if (StorageUtil.getPathType(optString) == PathType.RELATIVE) {
            jSONObject = getImgInfo(StorageUtil.relativeToPath(optString, aiApp, aiApp.getVersion()), optString);
        }
        if (jSONObject != null) {
            AiAppsLog.i(MODULE_TAG, "getImgInfo success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }

    private JSONObject getImgInfo(String str, String str2) {
        AiAppsLog.i(MODULE_TAG, "getImgInfo start");
        ExifInterface exifInterface = getExifInterface(str);
        if (exifInterface == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("width", exifInterface.getAttributeInt("ImageWidth", 0));
            jSONObject.put("height", exifInterface.getAttributeInt("ImageLength", 0));
            jSONObject.put("path", str2);
            jSONObject.put("orientation", getImgOrientation(exifInterface.getAttributeInt("Orientation", -1)));
            jSONObject.put("type", getImgType(str));
        } catch (JSONException e) {
            AiAppsLog.e(MODULE_TAG, "getImgInfo failed");
            e.printStackTrace();
        }
        AiAppsLog.i(MODULE_TAG, "getImgInfo end");
        return jSONObject;
    }

    private String getImgOrientation(int i) {
        switch (i) {
            case 1:
                return "up";
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return "left";
            case 7:
                return "right-mirrored";
            case 8:
                return MarkerModel.SubBase.RIGHT;
            default:
                return "";
        }
    }

    private ExifInterface getExifInterface(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ExifInterface(str);
        } catch (IOException e) {
            return null;
        }
    }

    private String getImgType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        String str2 = options.outMimeType;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split("/");
        return split[split.length - 1];
    }
}
