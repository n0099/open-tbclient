package b.a.a.a.a;

import android.os.Handler;
/* loaded from: classes3.dex */
public abstract class ah {

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f1054b = false;

    public final void a(Handler handler) {
        if (this.f1054b) {
            return;
        }
        this.f1054b = true;
        b(handler);
        new StringBuilder().append(d()).append(" [startup]");
    }

    public final void b() {
        if (this.f1054b) {
            this.f1054b = false;
            c();
            new StringBuilder().append(d()).append(" [shutdown]");
        }
    }

    public abstract void b(Handler handler);

    public abstract void c();

    public abstract String d();
}
