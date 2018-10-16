package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppActionErrorCode;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SaveImageAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/saveImageToPhotosAlbum";
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "SaveImageAction";
    public static final String MODULE_TAG = "SaveImage";
    private static final String SCHEME_BDFILE = "bdfile";

    public SaveImageAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        final File file;
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "illegal aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        }
        String optString = paramAsJo.optString("filePath");
        try {
            File file2 = null;
            if (SCHEME_BDFILE.equalsIgnoreCase(URI.create(optString).getScheme())) {
                String scheme2Path = StorageUtil.scheme2Path(optString, aiApp.id);
                if (!TextUtils.isEmpty(scheme2Path)) {
                    file2 = new File(scheme2Path);
                }
                file = file2;
            } else {
                String relativeToPath = StorageUtil.relativeToPath(optString, aiApp, aiApp.getVersion());
                if (TextUtils.isEmpty(relativeToPath)) {
                    file = null;
                } else {
                    file = new File(relativeToPath);
                }
            }
            if (file == null || !file.exists() || !file.isFile()) {
                AiAppsLog.e(MODULE_TAG, "can not find such file");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                return false;
            }
            final String optString2 = paramAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                AiAppsLog.e(MODULE_TAG, "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                AiAppsLog.e(MODULE_TAG, "the context is not an activity");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_MAPP_IMAGES, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.SaveImageAction.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(Boolean bool) {
                        if (!bool.booleanValue()) {
                            AiAppsLog.i(SaveImageAction.MODULE_TAG, "Permission denied");
                            callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams((int) AiAppActionErrorCode.Accredit.SAVE_IMAGE_ALBUM_USER_DENY, "Permission denied").toString());
                            return;
                        }
                        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.SaveImageAction.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TextUtils.isEmpty(SaveImageAction.this.saveToAlbum(context, file))) {
                                    AiAppsLog.e(SaveImageAction.MODULE_TAG, "can not save to album");
                                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
                                    return;
                                }
                                AiAppsLog.i(SaveImageAction.MODULE_TAG, "save success");
                                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                            }
                        }, SaveImageAction.LOG_TAG);
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        } catch (Exception e) {
            AiAppsLog.e(MODULE_TAG, "Illegal file_path");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveToAlbum(Context context, File file) {
        try {
            String insertImage = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
            if (!TextUtils.isEmpty(insertImage)) {
                String realPathFromURI = getRealPathFromURI(Uri.parse(insertImage), context);
                if (!TextUtils.isEmpty(realPathFromURI)) {
                    File file2 = new File(realPathFromURI);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(file2));
                    context.sendBroadcast(intent);
                }
            }
            AiAppsLog.i(MODULE_TAG, "save success");
            return insertImage;
        } catch (FileNotFoundException e) {
            AiAppsLog.e(MODULE_TAG, "save failed:" + e.getMessage());
            return null;
        }
    }

    private static String getRealPathFromURI(Uri uri, Context context) {
        Cursor cursor;
        Cursor cursor2;
        String string;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursor != null) {
                try {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                    cursor.moveToFirst();
                    string = cursor.getString(columnIndexOrThrow);
                } catch (SQLException e) {
                    cursor2 = cursor;
                    AiAppsFileUtils.closeSafely(cursor2);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    AiAppsFileUtils.closeSafely(cursor);
                    throw th;
                }
            } else {
                string = null;
            }
            AiAppsFileUtils.closeSafely(cursor);
            return string;
        } catch (SQLException e2) {
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
