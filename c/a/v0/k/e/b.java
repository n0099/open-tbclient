package c.a.v0.k.e;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes4.dex */
public interface b {
    void a(DownloadException downloadException);

    void b(DownloadException downloadException);

    void onConnectCanceled();

    void onConnected(long j2, long j3, boolean z);

    void onConnecting();

    void onDownloadCanceled();

    void onDownloadCompleted(String str);

    void onDownloadPaused();

    void onDownloadProgress(long j2, long j3, int i2);

    void onStarted();
}
