package b.a.a.a.a;

import android.os.Handler;
/* loaded from: classes4.dex */
final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Handler f1072a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ p f1073b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, Handler handler) {
        this.f1073b = pVar;
        this.f1072a = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        al hO = al.hO();
        hO.f1059b = true;
        hO.c(this.f1072a.getLooper());
        if (!hO.b() || hO.Bw == null) {
            return;
        }
        o.b(hO.Bw, 2);
    }
}
