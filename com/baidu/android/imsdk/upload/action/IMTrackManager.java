package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes2.dex */
public class IMTrackManager {
    public static final int FAIL_MAX_COUNT = 3;
    public static final int RETRY_MAX_COUNT = 1;
    public static final String TAG = "IMTrackManager";
    public static int retryCount;

    public static /* synthetic */ int access$208() {
        int i = retryCount;
        retryCount = i + 1;
        return i;
    }

    public static void clearIMTrack(Context context, IMPbGenerator iMPbGenerator) {
        iMPbGenerator.clearIMActions();
        IMTrackDatabase.getInstance(context).clearAllTables();
        retryCount = 0;
    }

    public static void requestIMRealUpload(final Context context, @NonNull IMPushPb.Action action) {
        final byte[] generateIMRealClient = new IMPbGenerator().generateIMRealClient(context, action);
        if (generateIMRealClient == null || generateIMRealClient.length >= 307200) {
            return;
        }
        IMPushUploadManager.getInstance(context).requestUpload(null, generateIMRealClient, "", new IMPushUploadResponseListener() { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.4
            @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
            public void uploadResponse(int i, String str) {
                LogUtils.d(IMTrackManager.TAG, "uploadIMRealAction response :" + i + ", msg :" + str);
                if (i != 0) {
                    IMPushUploadManager.getInstance(context).requestUpload(null, generateIMRealClient, "", null);
                }
            }
        });
    }

    public static void requestUpload(final Context context) {
        final IMPbGenerator iMPbGenerator = new IMPbGenerator();
        byte[] generateIMClient = iMPbGenerator.generateIMClient(context);
        if (generateIMClient != null && generateIMClient.length < 307200) {
            IMPushUploadManager.getInstance(context).requestUpload(null, generateIMClient, "", new IMPushUploadResponseListener() { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.2
                @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
                public void uploadResponse(int i, String str) {
                    LogUtils.d(IMTrackManager.TAG, "uploadIMData response :" + i + ", msg :" + str);
                    Utility.setIMTrackTime(context);
                    if (i == 0) {
                        IMTrackManager.clearIMTrack(context, iMPbGenerator);
                        int unused = IMTrackManager.retryCount = 0;
                        return;
                    }
                    int i2 = 1;
                    if (IMTrackManager.retryCount < 1) {
                        IMTrackManager.requestUpload(context);
                        IMTrackManager.access$208();
                        return;
                    }
                    int unused2 = IMTrackManager.retryCount = 0;
                    int iMTrackFailCount = Utility.getIMTrackFailCount(context);
                    if (iMTrackFailCount >= 3) {
                        IMTrackManager.clearIMTrack(context, iMPbGenerator);
                    } else {
                        i2 = 1 + iMTrackFailCount;
                    }
                    Utility.setIMTrackFailCount(context, i2);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("RequestUpload payload.length = ");
        sb.append(generateIMClient != null ? generateIMClient.length : 0);
        sb.append(", clear datas and no upload.");
        LogUtils.d(TAG, sb.toString());
        clearIMTrack(context, iMPbGenerator);
    }

    public static void uploadIMActionData(final Context context) {
        if (context != null && RequsetNetworkUtils.isConnected(context) && Utility.needIMTrack(context)) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.1
                @Override // java.lang.Runnable
                public void run() {
                    IMTrackManager.requestUpload(context);
                }
            });
        }
    }

    public static void uploadIMRealAction(final Context context, @NonNull final IMPushPb.Action action) {
        if (context == null || !RequsetNetworkUtils.isConnected(context)) {
            return;
        }
        TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.3
            @Override // java.lang.Runnable
            public void run() {
                IMTrackManager.requestIMRealUpload(context, action);
            }
        });
    }
}
