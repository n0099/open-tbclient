package a.a.a.c.b;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import d.b.k.b.c.a;
import d.b.k.b.c.b;
import d.b.k.b.c.c;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class trw implements c {

    /* renamed from: a  reason: collision with root package name */
    public Executor f1428a;

    /* loaded from: classes.dex */
    public static class bv implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final b f1429a;

        /* renamed from: b  reason: collision with root package name */
        public final a f1430b;

        public bv(b bVar) {
            this.f1429a = bVar;
            this.f1430b = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.f1429a.h()) {
                case 102:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                    this.f1430b.onConnecting();
                    return;
                case 103:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1429a.e() + " acceptRanges: " + this.f1429a.i());
                    this.f1430b.onConnected(this.f1429a.e(), this.f1429a.i());
                    return;
                case 104:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1429a.d() + " length: " + this.f1429a.e() + " percent: " + this.f1429a.f());
                    this.f1430b.onProgress(this.f1429a.d(), this.f1429a.e(), this.f1429a.f());
                    return;
                case 105:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1429a.g());
                    if (this.f1429a.b()) {
                        return;
                    }
                    this.f1429a.l(true);
                    this.f1430b.onCompleted(this.f1429a.g());
                    return;
                case 106:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                    this.f1430b.onDownloadPaused();
                    return;
                case 107:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                    this.f1430b.onDownloadCanceled();
                    return;
                case 108:
                    d.b.k.b.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1429a.c().getCause());
                    this.f1430b.onFailed((DownloadException) this.f1429a.c());
                    return;
                default:
                    return;
            }
        }
    }

    public trw(Handler handler) {
        this.f1428a = new we(this, handler);
    }

    @Override // d.b.k.b.c.c
    public void post(b bVar) {
        this.f1428a.execute(new bv(bVar));
    }
}
