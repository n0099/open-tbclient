package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f implements h {
    private final e bN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bN = eVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.bN.a(jVar);
                return;
            case ON_START:
                this.bN.b(jVar);
                return;
            case ON_RESUME:
                this.bN.c(jVar);
                return;
            case ON_PAUSE:
                this.bN.d(jVar);
                return;
            case ON_STOP:
                this.bN.e(jVar);
                return;
            case ON_DESTROY:
                this.bN.f(jVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
