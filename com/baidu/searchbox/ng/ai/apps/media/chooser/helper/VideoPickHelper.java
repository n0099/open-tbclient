package com.baidu.searchbox.ng.ai.apps.media.chooser.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import com.baidu.ar.util.APIUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.io.File;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VideoPickHelper {
    private static final boolean DEBUG = false;
    private static final String MODULE_TAG = "ChooseVideo";
    private static final String TAG = "VideoPickHelper";
    private static final String VIDEO_PREFIX = "VID_";
    private static final String VIDEO_SUFFIX = ".mp4";
    private static PickVideoTask mTask;

    /* loaded from: classes2.dex */
    public static class PickData {
        public VideoChooserConfig config;
        public String info;
        public VideoChooserResult result;
        public Uri uri;
    }

    /* loaded from: classes2.dex */
    public static class VideoChooserResult {
        public long duration;
        public long height;
        long id;
        String realFilePath;
        public long size;
        public String tempPath;
        public long width;
    }

    /* loaded from: classes2.dex */
    private static class SingletonHolder {
        public static final VideoPickHelper sInstance = new VideoPickHelper();

        private SingletonHolder() {
        }
    }

    private VideoPickHelper() {
    }

    public static VideoPickHelper getInstance() {
        return SingletonHolder.sInstance;
    }

    public static boolean performVideoChooseAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, JSONObject jSONObject) {
        VideoChooserConfig fromJson = VideoChooserConfig.fromJson(jSONObject);
        if (fromJson.sourceType == 2) {
            startRecordActivity(context, unitedSchemeEntity, callbackHandler, aiApp, fromJson);
            return true;
        }
        startPickActivity(context, unitedSchemeEntity, callbackHandler, aiApp, fromJson);
        return true;
    }

    private static void startRecordActivity(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final VideoChooserConfig videoChooserConfig) {
        final Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
        if (resultDispatcher != null) {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            final File saveMediaFile = getSaveMediaFile(aiApp);
            if (APIUtils.hasNougat()) {
                fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", saveMediaFile);
                intent.setFlags(3);
            } else {
                fromFile = Uri.fromFile(saveMediaFile);
            }
            intent.putExtra("output", fromFile);
            intent.putExtra("android.intent.extra.durationLimit", videoChooserConfig.maxDuration);
            intent.putExtra("android.intent.extra.videoQuality", 1);
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.searchbox.ng.ai.apps.media.chooser.helper.VideoPickHelper.1
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                    if (intent2 != null) {
                        PickData pickData = new PickData();
                        if (fromFile != null && fromFile.equals(intent2.getData())) {
                            pickData.uri = Uri.fromFile(saveMediaFile);
                        }
                        pickData.config = videoChooserConfig;
                        VideoPickHelper.consumePickAction(context, unitedSchemeEntity, callbackHandler, aiApp, pickData);
                        return true;
                    }
                    return true;
                }
            });
            resultDispatcher.startActivityForResult(intent);
        }
    }

    private static File getSaveMediaFile(@NonNull AiApp aiApp) {
        File file = new File(StorageUtil.getAiappTmpDirectory(aiApp.id) + File.separator + VIDEO_PREFIX + Calendar.getInstance().getTimeInMillis() + VIDEO_SUFFIX);
        AiAppsFileUtils.createNewFileSafely(file);
        return file;
    }

    private static void startPickActivity(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp, final VideoChooserConfig videoChooserConfig) {
        ActivityResultDispatcher resultDispatcher;
        if ((context instanceof ActivityResultDispatcherHolder) && (resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher()) != null) {
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.searchbox.ng.ai.apps.media.chooser.helper.VideoPickHelper.2
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
                    if (intent != null) {
                        PickData pickData = new PickData();
                        pickData.uri = intent.getData();
                        pickData.config = VideoChooserConfig.this;
                        VideoPickHelper.consumePickAction(context, unitedSchemeEntity, callbackHandler, aiApp, pickData);
                        return true;
                    }
                    return true;
                }
            });
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("video/*");
            if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                resultDispatcher.startActivityForResult(intent);
            } else {
                AiAppsLog.e(MODULE_TAG, "当前ROM不支持此功能");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void consumePickAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, @NonNull PickData pickData) {
        if (pickData.uri != null) {
            if (mTask == null || mTask.getStatus() == AsyncTask.Status.FINISHED) {
                mTask = new PickVideoTask(context, unitedSchemeEntity, callbackHandler);
                mTask.execute(pickData);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class VideoChooserConfig {
        public static final int MAX_DURATION = 60;
        public static final int TYPE_ALBUM = 1;
        public static final int TYPE_CAMERA = 2;
        public static final int TYPE_CAMERA_AND_ALBUM = 3;
        public String callback;
        public int sourceType = 3;
        public boolean compressed = true;
        public int maxDuration = 60;

        public static VideoChooserConfig fromJson(JSONObject jSONObject) {
            VideoChooserConfig videoChooserConfig = new VideoChooserConfig();
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray(ChooseVideoAction.KEY_SOURCE);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    int i = 0;
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        char c = 65535;
                        switch (optString.hashCode()) {
                            case -1367751899:
                                if (optString.equals("camera")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 92896879:
                                if (optString.equals(ChooseVideoAction.KEY_SOURCE_ALBUM)) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                i |= 1;
                                break;
                            case 1:
                                i |= 2;
                                break;
                        }
                    }
                    videoChooserConfig.sourceType = i;
                }
                videoChooserConfig.compressed = jSONObject.optBoolean(ChooseVideoAction.KEY_COMPRESSED, true);
                int optInt = jSONObject.optInt(ChooseVideoAction.KEY_MAX_DURATION, 60);
                if (optInt > 60) {
                    optInt = 60;
                }
                videoChooserConfig.maxDuration = optInt;
                videoChooserConfig.callback = jSONObject.optString("cb");
            }
            return videoChooserConfig;
        }
    }
}
