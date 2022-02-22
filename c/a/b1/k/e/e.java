package c.a.b1.k.e;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes.dex */
public interface e extends Runnable {

    /* loaded from: classes.dex */
    public interface a {
        void a(DownloadException downloadException);

        void onDownloadCanceled();

        void onDownloadCompleted(String str);

        void onDownloadPaused();

        void onDownloadProgress(long j2, long j3);
    }

    void cancel();

    boolean isComplete();

    boolean isDownloading();

    void pause();
}
