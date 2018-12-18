package com.baidu.searchbox.ng.ai.apps.media.video.action;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.performance.AiAppActionErrorCode;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
import rx.a.b.a;
import rx.d;
import rx.functions.b;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class SaveVideoAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/saveVideoToPhotosAlbum";
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "SaveVideoAction";
    private static final String SCHEME_BDFILE = "bdfile";
    private static final String VIDEO_DIR = "Video";

    public SaveVideoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        final File file;
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
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
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                return false;
            }
            final String optString2 = paramAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                aiApp.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_MAPP_IMAGES, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.media.video.action.SaveVideoAction.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(Boolean bool) {
                        if (bool.booleanValue()) {
                            SaveVideoAction.this.saveToAlbum(context, file, callbackHandler, optString2);
                        } else {
                            callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams((int) AiAppActionErrorCode.Accredit.SAVE_IMAGE_ALBUM_USER_DENY, "Permission denied").toString());
                        }
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        } catch (Exception e) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveToAlbum(@NonNull final Context context, @NonNull File file, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        if (file == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
        } else {
            d.just(file).map(new f<File, File>() { // from class: com.baidu.searchbox.ng.ai.apps.media.video.action.SaveVideoAction.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                public File call(File file2) {
                    String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(AiApp.getAiAppId());
                    if (!TextUtils.isEmpty(aiappTmpDirectory) && file2.getPath().startsWith(aiappTmpDirectory)) {
                        return SaveVideoAction.this.copyToVideoDirectory(context, file2);
                    }
                    return null;
                }
            }).subscribeOn(Schedulers.io()).observeOn(a.ccX()).subscribe(new b<File>() { // from class: com.baidu.searchbox.ng.ai.apps.media.video.action.SaveVideoAction.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(File file2) {
                    if (file2 == null) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                        return;
                    }
                    Uri fromFile = Uri.fromFile(file2);
                    SaveVideoAction.this.insertVideoToMediaStore(context, file2.getPath(), -1L);
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertVideoToMediaStore(Context context, String str, long j) {
        if (checkFile(str)) {
            long timeWrap = getTimeWrap(j);
            ContentValues initCommonContentValues = initCommonContentValues(str, timeWrap);
            initCommonContentValues.put("datetaken", Long.valueOf(timeWrap));
            initCommonContentValues.put("mime_type", getVideoMimeType(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, initCommonContentValues);
        }
    }

    private ContentValues initCommonContentValues(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long timeWrap = getTimeWrap(j);
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(timeWrap));
        contentValues.put("date_added", Long.valueOf(timeWrap));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    private String getVideoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    private long getTimeWrap(long j) {
        if (j <= 0) {
            return System.currentTimeMillis();
        }
        return j;
    }

    private boolean checkFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File copyToVideoDirectory(Context context, @NonNull File file) {
        File videoPath = getVideoPath(context);
        if (videoPath == null) {
            return null;
        }
        File file2 = new File(videoPath, file.getName());
        if (AiAppsFileUtils.copyFile(file, file2) <= 0) {
            file2 = null;
        }
        return file2;
    }

    public static File getVideoPath(Context context) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
        if (file.exists()) {
            String str = VIDEO_DIR;
            if (!new File(file, VIDEO_DIR).exists() && new File(file, "video").exists()) {
                str = "video";
            }
            File file2 = new File(file, str);
            if ((file2.exists() || file2.mkdirs()) && file2.canWrite()) {
                return file2;
            }
        }
        File file3 = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "baidu" + File.separator + "searchbox" + File.separator + VIDEO_DIR);
        if (!file3.exists() && !file3.mkdirs()) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                File file4 = new File(externalFilesDir.getPath() + File.separator + VIDEO_DIR);
                if (file4.exists() || file4.mkdirs()) {
                    return file4;
                }
            }
            File file5 = new File(context.getFilesDir().getPath() + File.separator + VIDEO_DIR);
            if (file5.exists() || file5.mkdirs()) {
                return file5;
            }
            return null;
        }
        return file3;
    }
}
