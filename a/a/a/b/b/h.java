package a.a.a.b.b;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public class h implements com.baidu.cloudbase.download.a.c {

    /* renamed from: a  reason: collision with root package name */
    public Executor f1020a;

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        public final com.baidu.cloudbase.download.a.b Cf;
        public final com.baidu.cloudbase.download.a.a Cg;

        public a(com.baidu.cloudbase.download.a.b bVar) {
            this.Cf = bVar;
            this.Cg = this.Cf.tY();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.Cf.getStatus()) {
                case 102:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.Cg.onConnecting();
                    return;
                case 103:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.Cf.getLength() + " acceptRanges: " + this.Cf.isAcceptRanges());
                    this.Cg.onConnected(this.Cf.getLength(), this.Cf.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.Cf.getFinished() + " length: " + this.Cf.getLength() + " percent: " + this.Cf.getPercent());
                    this.Cg.onProgress(this.Cf.getFinished(), this.Cf.getLength(), this.Cf.getPercent());
                    return;
                case 105:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.Cf.getSavedPath());
                    if (this.Cf.getCalledCompleted()) {
                        return;
                    }
                    this.Cf.setCalledCompleted(true);
                    this.Cg.onCompleted(this.Cf.getSavedPath());
                    return;
                case 106:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.Cg.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.cloudbase.download.b.c.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.Cg.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.cloudbase.download.b.c.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.Cf.getException().getCause());
                    this.Cg.c((DownloadException) this.Cf.getException());
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Executor {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f1021a;

        public b(h hVar, Handler handler) {
            this.f1021a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f1021a.post(runnable);
        }
    }

    public h(Handler handler) {
        this.f1020a = new b(this, handler);
    }

    @Override // com.baidu.cloudbase.download.a.c
    public void a(com.baidu.cloudbase.download.a.b bVar) {
        this.f1020a.execute(new a(bVar));
    }
}
