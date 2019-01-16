package com.baidu.searchbox.ng.ai.apps.media.chooser.helper;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.media.chooser.helper.VideoPickHelper;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import rx.a.b.a;
import rx.d;
import rx.functions.b;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class PickVideoTask extends AsyncTask<VideoPickHelper.PickData, String, TaskToken> {
    private static final boolean DEBUG = false;
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_INFO = "info";
    public static final String KEY_OUTPUT = "outputPath";
    public static final String KEY_PATH = "path";
    public static final String KEY_RESULT = "success";
    public static final String KEY_WIDTH = "width";
    private static final String TAG = "PickVideoTask";
    private WeakReference<Context> mContextRef;
    private UnitedSchemeEntity mEntityRef;
    private CallbackHandler mSchemeCallbackRef;

    /* loaded from: classes2.dex */
    public interface OnCompressResultCallback {
        void onResult(boolean z, Bundle bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PickVideoTask(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.mContextRef = new WeakReference<>(context);
        this.mEntityRef = unitedSchemeEntity;
        this.mSchemeCallbackRef = callbackHandler;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public TaskToken doInBackground(VideoPickHelper.PickData... pickDataArr) {
        VideoPickHelper.PickData pickData;
        TaskToken taskToken = new TaskToken();
        if (pickDataArr == null) {
            pickData = null;
        } else {
            pickData = pickDataArr[0];
        }
        if (pickData == null || pickData.uri == null) {
            return taskToken.setError(true, "uri is null");
        }
        Context context = this.mContextRef.get();
        if (context == null) {
            return taskToken.setError(true, "context is null");
        }
        return TaskStrategy.create(pickData).doInBackground(context, taskToken);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(TaskToken taskToken) {
        super.onPostExecute((PickVideoTask) taskToken);
        if (taskToken.getError() || taskToken.isFinished()) {
            if (taskToken.object instanceof VideoPickHelper.PickData) {
                notifyResult((VideoPickHelper.PickData) taskToken.object);
                return;
            }
            return;
        }
        switch (taskToken.nextAction) {
            case 1:
                if (taskToken.object instanceof VideoPickHelper.PickData) {
                    performVideoCompressed((VideoPickHelper.PickData) taskToken.object);
                    return;
                }
                return;
            case 2:
                if (taskToken.object instanceof VideoPickHelper.PickData) {
                    performMovingVideo((VideoPickHelper.PickData) taskToken.object);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void performVideoCompressed(@NonNull final VideoPickHelper.PickData pickData) {
        Context context = this.mContextRef.get();
        if (context != null && (context instanceof Activity) && pickData.result != null) {
            Bundle bundle = new Bundle();
            bundle.putString("path", pickData.result.realFilePath);
            bundle.putLong("height", pickData.result.height);
            bundle.putLong("width", pickData.result.width);
            bundle.putString(KEY_OUTPUT, getCompressOutputTmpPath(AiApp.getAiAppId(), pickData.result.realFilePath));
            AiAppsRuntime.getPluginRuntime().compressVideo(context, bundle, new OnCompressResultCallback() { // from class: com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.1
                @Override // com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.OnCompressResultCallback
                public void onResult(boolean z, Bundle bundle2) {
                    if (!z) {
                        PickVideoTask.this.notifyResult(pickData);
                        return;
                    }
                    if (bundle2.getBoolean("success", false)) {
                        String string = bundle2.getString("path");
                        if (!TextUtils.isEmpty(string)) {
                            File file = new File(string);
                            pickData.result.size = file.length();
                            pickData.result.tempPath = StorageUtil.path2Scheme(string, AiApp.getAiAppId());
                        }
                    } else {
                        pickData.info = bundle2.getString("info");
                    }
                    PickVideoTask.this.notifyResult(pickData);
                }
            });
        }
    }

    private void performMovingVideo(@NonNull final VideoPickHelper.PickData pickData) {
        d.just(pickData).map(new f<VideoPickHelper.PickData, String>() { // from class: com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.f
            public String call(VideoPickHelper.PickData pickData2) {
                if (pickData2.result == null) {
                    return null;
                }
                String str = pickData2.result.realFilePath;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String outputTmpPath = PickVideoTask.this.getOutputTmpPath(AiApp.getAiAppId(), str);
                if (TextUtils.isEmpty(outputTmpPath)) {
                    return null;
                }
                if (AiAppsFileUtils.copyFile(new File(str), new File(outputTmpPath)) <= 0) {
                    outputTmpPath = null;
                }
                return outputTmpPath;
            }
        }).subscribeOn(Schedulers.io()).observeOn(a.cew()).subscribe(new b<String>() { // from class: com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            public void call(String str) {
                if (!TextUtils.isEmpty(str) && pickData.result != null) {
                    pickData.result.tempPath = StorageUtil.path2Scheme(str, AiApp.getAiAppId());
                }
                PickVideoTask.this.notifyResult(pickData);
            }
        });
    }

    private String getCompressOutputTmpPath(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String createTmpFile = StorageUtil.createTmpFile(str, new File(AiAppsFileUtils.insertTagInFileName(str2, "_compressed")).getName(), null);
        AiAppsFileUtils.createNewFileSafely(new File(createTmpFile));
        return createTmpFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getOutputTmpPath(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String createTmpFile = StorageUtil.createTmpFile(str, new File(str2).getName(), null);
        AiAppsFileUtils.createNewFileSafely(new File(createTmpFile));
        return createTmpFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResult(@NonNull VideoPickHelper.PickData pickData) {
        if (this.mEntityRef != null && this.mSchemeCallbackRef != null && pickData.result != null && pickData.config != null && !TextUtils.isEmpty(pickData.config.callback)) {
            CallbackHandler callbackHandler = this.mSchemeCallbackRef;
            String str = pickData.config.callback;
            VideoPickHelper.VideoChooserResult videoChooserResult = pickData.result;
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(videoChooserResult.tempPath)) {
                try {
                    jSONObject.put("info", pickData.info);
                } catch (JSONException e) {
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
                return;
            }
            try {
                jSONObject.put("tempFilePath", videoChooserResult.tempPath);
                jSONObject.put("duration", videoChooserResult.duration / 1000);
                jSONObject.put("height", videoChooserResult.height);
                jSONObject.put("width", videoChooserResult.width);
                jSONObject.put(ChooseVideoAction.CB_KEY_SIZE, videoChooserResult.size);
            } catch (JSONException e2) {
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class TaskStrategy {
        private static final TaskStrategy EMPTY = new TaskStrategy(null) { // from class: com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.TaskStrategy.1
            @Override // com.baidu.searchbox.ng.ai.apps.media.chooser.helper.PickVideoTask.TaskStrategy
            public TaskToken doInBackground(Context context, TaskToken taskToken) {
                return taskToken;
            }
        };
        protected VideoPickHelper.PickData pickData;

        public abstract TaskToken doInBackground(Context context, TaskToken taskToken);

        public TaskStrategy(@NonNull VideoPickHelper.PickData pickData) {
            this.pickData = pickData;
        }

        public static TaskStrategy create(VideoPickHelper.PickData pickData) {
            if (pickData == null || pickData.config == null) {
                return EMPTY;
            }
            switch (pickData.config.sourceType) {
                case 1:
                case 3:
                    return new AlbumTaskStrategy(pickData);
                case 2:
                    return new CameraTaskStrategy(pickData);
                default:
                    return EMPTY;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean needCompressed(@NonNull VideoPickHelper.PickData pickData) {
            return (pickData.config == null || !pickData.config.compressed || pickData.result.height == 0 || pickData.result.width == 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TaskToken {
        static final int COMPRESSED = 1;
        static final int DONE = 0;
        static final int MOVE = 2;
        public String extra;
        private boolean mIsError = false;
        int nextAction = 0;
        public Object object;

        /* loaded from: classes2.dex */
        public @interface Action {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public TaskToken nextAction(@Action int i, Object obj) {
            this.nextAction = i;
            this.object = obj;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public TaskToken setError(boolean z, String str) {
            this.mIsError = z;
            this.extra = str;
            return this;
        }

        public boolean getError() {
            return this.mIsError;
        }

        public boolean isFinished() {
            return this.nextAction == 0;
        }
    }
}
