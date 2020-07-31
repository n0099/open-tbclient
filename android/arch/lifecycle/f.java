package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class f implements h {
    private final e yr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.yr = eVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.yr.a(jVar);
                return;
            case ON_START:
                this.yr.b(jVar);
                return;
            case ON_RESUME:
                this.yr.c(jVar);
                return;
            case ON_PAUSE:
                this.yr.d(jVar);
                return;
            case ON_STOP:
                this.yr.e(jVar);
                return;
            case ON_DESTROY:
                this.yr.f(jVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
