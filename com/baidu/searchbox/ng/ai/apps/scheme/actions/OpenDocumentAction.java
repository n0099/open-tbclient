package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppDocumentUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OpenDocumentAction extends AiAppAction implements NetworkDef {
    public static final String ACTION_TYPE = "/swan/file/openDocument";
    public static final String MESSAGE_ILLEGAL_ACTIVITY = "illegal activity == null";
    public static final String MESSAGE_ILLEGAL_AIAPP = "aiApp is null";
    public static final String MESSAGE_ILLEGAL_APPID = "illegal appId";
    public static final String MESSAGE_ILLEGAL_FILEPATH = "illegal filePath";
    public static final String MESSAGE_ILLEGAL_FILE_EXT = "illegal file ext";
    public static final String MESSAGE_ILLEGAL_FILE_MIMETYPE = "illegal file mimeType";
    public static final String MESSAGE_ILLEGAL_PARAMS = "illegal params";
    public static final String MESSAGE_ILLEGAL_REALFILEPATH = "illegal realFilePath";
    public static final String MESSAGE_ILLEGAL_URI_PATH = "illegal Uri path";
    public static final String MESSAGE_NOT_FOUND_PLUGIN = "not found plugin,mimeType=";
    public static final String MESSAGE_NOT_SUPPORT_MIMETYPE = "not support this mimeType=";
    public static final String PARAMS_FILEPATH = "filePath";
    public static final String PARAMS_FILETYPE = "fileType";

    public OpenDocumentAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "aiApp is null");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        String optString = paramAsJo.optString("filePath");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_FILEPATH);
            return false;
        }
        String aiAppId = AiApp.getAiAppId();
        if (TextUtils.isEmpty(aiAppId)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String scheme2Path = StorageUtil.scheme2Path(optString, aiAppId);
        if (TextUtils.isEmpty(scheme2Path)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_REALFILEPATH);
            return false;
        }
        String optString2 = paramAsJo.optString(PARAMS_FILETYPE);
        String fileExtFromUrl = getFileExtFromUrl(scheme2Path);
        if (!TextUtils.isEmpty(fileExtFromUrl)) {
            optString2 = fileExtFromUrl;
        } else if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_FILE_EXT);
            return false;
        }
        String guessSupportMimeTypeFromExt = AiAppDocumentUtil.guessSupportMimeTypeFromExt(optString2);
        if (TextUtils.isEmpty(guessSupportMimeTypeFromExt)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_FILE_MIMETYPE);
            return false;
        }
        Uri parse = Uri.parse(scheme2Path);
        if (parse == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_URI_PATH);
            return false;
        }
        if (parse.getScheme() == null) {
            parse = Uri.fromFile(new File(scheme2Path));
        }
        Activity activity = aiApp.getActivity();
        if (activity == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, MESSAGE_ILLEGAL_ACTIVITY);
            return false;
        } else if (!AiAppDocumentUtil.getSupportMimeType(guessSupportMimeTypeFromExt)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, MESSAGE_NOT_SUPPORT_MIMETYPE + guessSupportMimeTypeFromExt);
            return false;
        } else if (!isReadPluginAvailable(activity, guessSupportMimeTypeFromExt)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, MESSAGE_NOT_FOUND_PLUGIN + guessSupportMimeTypeFromExt);
            return false;
        } else {
            AiAppsRuntime.getPluginRuntime().openDocument(activity, parse, guessSupportMimeTypeFromExt);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    public static boolean isReadPluginAvailable(Context context, String str) {
        return AiAppsRuntime.getPluginRuntime().isReadPluginAvailable(context, str);
    }

    public static String getFileExtFromUrl(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= 0) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }
}
