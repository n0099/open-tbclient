package a.a.a.c.b;

import android.os.Handler;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.minivideo.plugin.capture.download.core.DownloadStatusDeliveryImpl;
import d.a.k.b.c.a;
import d.a.k.b.c.b;
import d.a.k.b.c.c;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class trw implements c {

    /* renamed from: a  reason: collision with root package name */
    public Executor f1433a;

    /* loaded from: classes.dex */
    public static class bv implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final b f1434a;

        /* renamed from: b  reason: collision with root package name */
        public final a f1435b;

        public bv(b bVar) {
            this.f1434a = bVar;
            this.f1435b = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.f1434a.h()) {
                case 102:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                    this.f1435b.onConnecting();
                    return;
                case 103:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1434a.e() + " acceptRanges: " + this.f1434a.i());
                    this.f1435b.onConnected(this.f1434a.e(), this.f1434a.i());
                    return;
                case 104:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1434a.d() + " length: " + this.f1434a.e() + " percent: " + this.f1434a.f());
                    this.f1435b.onProgress(this.f1434a.d(), this.f1434a.e(), this.f1434a.f());
                    return;
                case 105:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1434a.g());
                    if (this.f1434a.b()) {
                        return;
                    }
                    this.f1434a.l(true);
                    this.f1435b.onCompleted(this.f1434a.g());
                    return;
                case 106:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                    this.f1435b.onDownloadPaused();
                    return;
                case 107:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                    this.f1435b.onDownloadCanceled();
                    return;
                case 108:
                    d.a.k.b.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1434a.c().getCause());
                    this.f1435b.onFailed((DownloadException) this.f1434a.c());
                    return;
                default:
                    return;
            }
        }
    }

    public trw(Handler handler) {
        this.f1433a = new we(this, handler);
    }

    @Override // d.a.k.b.c.c
    public void post(b bVar) {
        this.f1433a.execute(new bv(bVar));
    }
}
