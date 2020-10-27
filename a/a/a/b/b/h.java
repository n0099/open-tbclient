package a.a.a.b.b;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class h implements com.baidu.cloudbase.download.a.c {

    /* renamed from: a  reason: collision with root package name */
    public Executor f955a;

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        public final com.baidu.cloudbase.download.a.b yE;
        public final com.baidu.cloudbase.download.a.a yF;

        public a(com.baidu.cloudbase.download.a.b bVar) {
            this.yE = bVar;
            this.yF = this.yE.uH();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.yE.getStatus()) {
                case 102:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.yF.onConnecting();
                    return;
                case 103:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.yE.getLength() + " acceptRanges: " + this.yE.isAcceptRanges());
                    this.yF.onConnected(this.yE.getLength(), this.yE.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.yE.getFinished() + " length: " + this.yE.getLength() + " percent: " + this.yE.getPercent());
                    this.yF.onProgress(this.yE.getFinished(), this.yE.getLength(), this.yE.getPercent());
                    return;
                case 105:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.yE.getSavedPath());
                    if (this.yE.getCalledCompleted()) {
                        return;
                    }
                    this.yE.setCalledCompleted(true);
                    this.yF.onCompleted(this.yE.getSavedPath());
                    return;
                case 106:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.yF.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.yF.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.cloudbase.download.b.c.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.yE.getException().getCause());
                    this.yF.c((DownloadException) this.yE.getException());
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f956a;

        public b(h hVar, Handler handler) {
            this.f956a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f956a.post(runnable);
        }
    }

    public h(Handler handler) {
        this.f955a = new b(this, handler);
    }

    @Override // com.baidu.cloudbase.download.a.c
    public void a(com.baidu.cloudbase.download.a.b bVar) {
        this.f955a.execute(new a(bVar));
    }
}
