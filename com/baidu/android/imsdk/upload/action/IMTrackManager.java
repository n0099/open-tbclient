package com.baidu.android.imsdk.upload.action;

import android.content.Context;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes3.dex */
public class IMTrackManager {
    private static final int FAIL_MAX_COUNT = 3;
    private static final int RETRY_MAX_COUNT = 1;
    public static final String TAG = "IMTrackManager";
    private static final int UPLOAD_MAX_LENGTH = 307200;
    private static int retryCount = 0;

    static /* synthetic */ int access$208() {
        int i = retryCount;
        retryCount = i + 1;
        return i;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestUpload(final Context context) {
        final IMPbGenerator iMPbGenerator = new IMPbGenerator();
        byte[] generateIMClient = iMPbGenerator.generateIMClient(context);
        if (generateIMClient == null || generateIMClient.length >= 307200) {
            LogUtils.d(TAG, "RequestUpload payload.length = " + (generateIMClient != null ? generateIMClient.length : 0) + ", clear datas and no upload.");
            clearIMTrack(context, iMPbGenerator);
            return;
        }
        IMPushUploadManager.getInstance(context).requestUpload(null, generateIMClient, "", new IMPushUploadResponseListener() { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.2
            @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
            public void uploadResponse(int i, String str) {
                int i2 = 1;
                LogUtils.d(IMTrackManager.TAG, "uploadIMData response :" + i + ", msg :" + str);
                Utility.setIMTrackTime(context);
                if (i == 0) {
                    IMTrackManager.clearIMTrack(context, iMPbGenerator);
                    int unused = IMTrackManager.retryCount = 0;
                } else if (IMTrackManager.retryCount < 1) {
                    IMTrackManager.requestUpload(context);
                    IMTrackManager.access$208();
                } else {
                    int unused2 = IMTrackManager.retryCount = 0;
                    int iMTrackFailCount = Utility.getIMTrackFailCount(context);
                    if (iMTrackFailCount >= 3) {
                        IMTrackManager.clearIMTrack(context, iMPbGenerator);
                    } else {
                        i2 = iMTrackFailCount + 1;
                    }
                    Utility.setIMTrackFailCount(context, i2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearIMTrack(Context context, IMPbGenerator iMPbGenerator) {
        iMPbGenerator.clearIMActions();
        IMTrackDatabase.getInstance(context).clearAllTables();
        retryCount = 0;
    }

    public static void uploadIMInitAction(final Context context) {
        if (context != null && RequsetNetworkUtils.isConnected(context)) {
            TaskManager.getInstance(context).submitForNetWork(new Runnable() { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.3
                @Override // java.lang.Runnable
                public void run() {
                    IMTrackManager.requestInitIMUpload(context);
                }
            });
        }
    }

    public static void requestInitIMUpload(Context context) {
        byte[] generateInitIMClient = new IMPbGenerator().generateInitIMClient(context);
        if (generateInitIMClient != null && generateInitIMClient.length < 307200) {
            IMPushUploadManager.getInstance(context).requestUpload(null, generateInitIMClient, "", new IMPushUploadResponseListener() { // from class: com.baidu.android.imsdk.upload.action.IMTrackManager.4
                @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
                public void uploadResponse(int i, String str) {
                    LogUtils.d(IMTrackManager.TAG, "uploadInitData response :" + i + ", msg :" + str);
                }
            });
        }
    }
}
