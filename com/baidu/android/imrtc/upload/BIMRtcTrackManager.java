package com.baidu.android.imrtc.upload;

import android.content.Context;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.TaskManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.utils.RequsetNetworkUtils;
/* loaded from: classes6.dex */
public class BIMRtcTrackManager {
    public static final String TAG = "BIMRtcTrackManager";

    public static void uploadRtcActionData(final Context context) {
        if (context != null && RequsetNetworkUtils.isConnected(context)) {
            TaskManager.getInstance().submitForNetWork(new Runnable() { // from class: com.baidu.android.imrtc.upload.BIMRtcTrackManager.1
                @Override // java.lang.Runnable
                public void run() {
                    BIMRtcTrackManager.requestRtcUpload(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestRtcUpload(final Context context) {
        final BIMRtcPbGenerator bIMRtcPbGenerator = new BIMRtcPbGenerator();
        byte[] generateRtcClient = bIMRtcPbGenerator.generateRtcClient(context);
        if (generateRtcClient == null) {
            LogUtils.d(TAG, "RequestUpload payload is null ");
        } else {
            IMPushUploadManager.getInstance(context).requestUpload(null, generateRtcClient, "", new IMPushUploadResponseListener() { // from class: com.baidu.android.imrtc.upload.BIMRtcTrackManager.2
                @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
                public void uploadResponse(int i, String str) {
                    LogUtils.d(BIMRtcTrackManager.TAG, "requestRtcUpload response :" + i + ", msg :" + str);
                    if (i == 0) {
                        BIMRtcTrackManager.clearRtcTrack(context, bIMRtcPbGenerator);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearRtcTrack(Context context, BIMRtcPbGenerator bIMRtcPbGenerator) {
        bIMRtcPbGenerator.clearRtcActions(context);
    }
}
