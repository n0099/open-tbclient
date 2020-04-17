package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements h {
    private final e xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.xR = eVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.xR.a(jVar);
                return;
            case ON_START:
                this.xR.b(jVar);
                return;
            case ON_RESUME:
                this.xR.c(jVar);
                return;
            case ON_PAUSE:
                this.xR.d(jVar);
                return;
            case ON_STOP:
                this.xR.e(jVar);
                return;
            case ON_DESTROY:
                this.xR.f(jVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
