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
    public Executor f1446a;

    /* loaded from: classes.dex */
    public static class bv implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final b f1447a;

        /* renamed from: b  reason: collision with root package name */
        public final a f1448b;

        public bv(b bVar) {
            this.f1447a = bVar;
            this.f1448b = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.f1447a.h()) {
                case 102:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                    this.f1448b.onConnecting();
                    return;
                case 103:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1447a.e() + " acceptRanges: " + this.f1447a.i());
                    this.f1448b.onConnected(this.f1447a.e(), this.f1447a.i());
                    return;
                case 104:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1447a.d() + " length: " + this.f1447a.e() + " percent: " + this.f1447a.f());
                    this.f1448b.onProgress(this.f1447a.d(), this.f1447a.e(), this.f1447a.f());
                    return;
                case 105:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1447a.g());
                    if (this.f1447a.b()) {
                        return;
                    }
                    this.f1447a.l(true);
                    this.f1448b.onCompleted(this.f1447a.g());
                    return;
                case 106:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                    this.f1448b.onDownloadPaused();
                    return;
                case 107:
                    d.a.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                    this.f1448b.onDownloadCanceled();
                    return;
                case 108:
                    d.a.k.b.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1447a.c().getCause());
                    this.f1448b.onFailed((DownloadException) this.f1447a.c());
                    return;
                default:
                    return;
            }
        }
    }

    public trw(Handler handler) {
        this.f1446a = new we(this, handler);
    }

    @Override // d.a.k.b.c.c
    public void post(b bVar) {
        this.f1446a.execute(new bv(bVar));
    }
}
