package com.baidu.lcp.sdk.a;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMPushUploadManager;
import com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
/* loaded from: classes14.dex */
public class b {
    private static int retryCount = 0;

    static /* synthetic */ int access$208() {
        int i = retryCount;
        retryCount = i + 1;
        return i;
    }

    public static void as(final Context context) {
        if (context == null || !RequsetNetworkUtils.isConnected(context) || !d.aw(context) || !d.ay(context)) {
            com.baidu.lcp.sdk.d.d.e("LcpTrackManager", "uploadTrackActionData return");
        } else {
            com.baidu.lcp.sdk.c.a.aH(context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.requestUpload(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestUpload(final Context context) {
        byte[] au = new c().au(context);
        com.baidu.lcp.sdk.d.d.d("LcpTrackManager", "RequestUpload payload.length = " + (au != null ? au.length : 0));
        if (au == null || au.length >= 307200 || au.length <= 0) {
            com.baidu.lcp.sdk.d.d.d("LcpTrackManager", "RequestUpload payload.length = " + (au != null ? au.length : 0) + ", clear datas and no upload.");
            at(context);
            return;
        }
        com.baidu.lcp.sdk.d.d.d("LcpTrackManager", "requestUpload begin");
        IMPushUploadManager.getInstance(context).requestUpload(null, au, "", new IMPushUploadResponseListener() { // from class: com.baidu.lcp.sdk.a.b.2
            @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
            public void uploadResponse(int i, String str) {
                int i2 = 1;
                com.baidu.lcp.sdk.d.d.d("LcpTrackManager", "uploadIMData response :" + i + ", msg :" + str);
                d.av(context);
                if (i == 0) {
                    b.at(context);
                    int unused = b.retryCount = 0;
                } else if (b.retryCount < 1) {
                    b.requestUpload(context);
                    b.access$208();
                } else {
                    int unused2 = b.retryCount = 0;
                    int ax = d.ax(context);
                    if (ax >= 3) {
                        b.at(context);
                    } else {
                        i2 = ax + 1;
                    }
                    d.g(context, i2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void at(Context context) {
        d.aB(context);
        retryCount = 0;
    }

    public static void a(final Context context, @NonNull final IMPushPb.Action action) {
        if (context != null && RequsetNetworkUtils.isConnected(context)) {
            com.baidu.lcp.sdk.c.a.aH(context).submitForNetWork(new Runnable() { // from class: com.baidu.lcp.sdk.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.b(context, action);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, @NonNull IMPushPb.Action action) {
        final byte[] c = new c().c(context, action);
        if (c != null && c.length < 307200) {
            IMPushUploadManager.getInstance(context).requestUpload(null, c, "", new IMPushUploadResponseListener() { // from class: com.baidu.lcp.sdk.a.b.4
                @Override // com.baidu.android.imsdk.upload.action.IMPushUploadResponseListener
                public void uploadResponse(int i, String str) {
                    com.baidu.lcp.sdk.d.d.d("LcpTrackManager", "uploadInitData response :" + i + ", msg :" + str);
                    if (i != 0) {
                        IMPushUploadManager.getInstance(context).requestUpload(null, c, "", null);
                    }
                }
            });
        }
    }
}
