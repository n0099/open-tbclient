package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f implements h {
    private final e bM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bM = eVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.bM.a(jVar);
                return;
            case ON_START:
                this.bM.b(jVar);
                return;
            case ON_RESUME:
                this.bM.c(jVar);
                return;
            case ON_PAUSE:
                this.bM.d(jVar);
                return;
            case ON_STOP:
                this.bM.e(jVar);
                return;
            case ON_DESTROY:
                this.bM.f(jVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
