package c.a.b1.k.e;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes.dex */
public interface g extends Runnable {

    /* loaded from: classes.dex */
    public interface a {
        void b(DownloadException downloadException);

        void onConnectCanceled();

        void onConnectPaused();

        void onConnected(long j2, long j3, boolean z);

        void onConnecting();
    }

    void cancel();

    boolean isCanceled();

    boolean isPaused();

    void pause();
}
