package a.a.a.b.b;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public class h implements com.baidu.cloudbase.download.a.c {

    /* renamed from: a  reason: collision with root package name */
    public Executor f1042a;

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        public final com.baidu.cloudbase.download.a.b zt;
        public final com.baidu.cloudbase.download.a.a zu;

        public a(com.baidu.cloudbase.download.a.b bVar) {
            this.zt = bVar;
            this.zu = this.zt.ui();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.zt.getStatus()) {
                case 102:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.zu.onConnecting();
                    return;
                case 103:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.zt.getLength() + " acceptRanges: " + this.zt.isAcceptRanges());
                    this.zu.onConnected(this.zt.getLength(), this.zt.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.zt.getFinished() + " length: " + this.zt.getLength() + " percent: " + this.zt.getPercent());
                    this.zu.onProgress(this.zt.getFinished(), this.zt.getLength(), this.zt.getPercent());
                    return;
                case 105:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.zt.getSavedPath());
                    if (this.zt.getCalledCompleted()) {
                        return;
                    }
                    this.zt.setCalledCompleted(true);
                    this.zu.onCompleted(this.zt.getSavedPath());
                    return;
                case 106:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.zu.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.zu.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.cloudbase.download.b.c.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.zt.getException().getCause());
                    this.zu.c((DownloadException) this.zt.getException());
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f1043a;

        public b(h hVar, Handler handler) {
            this.f1043a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f1043a.post(runnable);
        }
    }

    public h(Handler handler) {
        this.f1042a = new b(this, handler);
    }

    @Override // com.baidu.cloudbase.download.a.c
    public void a(com.baidu.cloudbase.download.a.b bVar) {
        this.f1042a.execute(new a(bVar));
    }
}
