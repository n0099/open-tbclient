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
    public Executor f1414a;

    /* loaded from: classes.dex */
    public static class bv implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final b f1415a;

        /* renamed from: b  reason: collision with root package name */
        public final a f1416b;

        public bv(b bVar) {
            this.f1415a = bVar;
            this.f1416b = bVar.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.f1415a.h()) {
                case 102:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTING");
                    this.f1416b.onConnecting();
                    return;
                case 103:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CONNECTED length: " + this.f1415a.e() + " acceptRanges: " + this.f1415a.i());
                    this.f1416b.onConnected(this.f1415a.e(), this.f1415a.i());
                    return;
                case 104:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PROGRESS finished: " + this.f1415a.d() + " length: " + this.f1415a.e() + " percent: " + this.f1415a.f());
                    this.f1416b.onProgress(this.f1415a.d(), this.f1415a.e(), this.f1415a.f());
                    return;
                case 105:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_COMPLETED Path:" + this.f1415a.g());
                    if (this.f1415a.b()) {
                        return;
                    }
                    this.f1415a.l(true);
                    this.f1416b.onCompleted(this.f1415a.g());
                    return;
                case 106:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_PAUSED");
                    this.f1416b.onDownloadPaused();
                    return;
                case 107:
                    d.b.k.b.d.c.a(DownloadStatusDeliveryImpl.TAG, "STATUS_CANCELED");
                    this.f1416b.onDownloadCanceled();
                    return;
                case 108:
                    d.b.k.b.d.c.b(DownloadStatusDeliveryImpl.TAG, "STATUS_FAILED error: " + this.f1415a.c().getCause());
                    this.f1416b.onFailed((DownloadException) this.f1415a.c());
                    return;
                default:
                    return;
            }
        }
    }

    public trw(Handler handler) {
        this.f1414a = new we(this, handler);
    }

    @Override // d.b.k.b.c.c
    public void post(b bVar) {
        this.f1414a.execute(new bv(bVar));
    }
}
