package b.a.a.a.a;

import android.os.Handler;
/* loaded from: classes15.dex */
final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Handler f1071a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ p f1072b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, Handler handler) {
        this.f1072b = pVar;
        this.f1071a = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        al hO = al.hO();
        hO.f1058b = true;
        hO.c(this.f1071a.getLooper());
        if (!hO.b() || hO.Bu == null) {
            return;
        }
        o.b(hO.Bu, 2);
    }
}
