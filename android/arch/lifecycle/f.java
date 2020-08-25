package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes18.dex */
public class f implements h {
    private final e yQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.yQ = eVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.yQ.a(jVar);
                return;
            case ON_START:
                this.yQ.b(jVar);
                return;
            case ON_RESUME:
                this.yQ.c(jVar);
                return;
            case ON_PAUSE:
                this.yQ.d(jVar);
                return;
            case ON_STOP:
                this.yQ.e(jVar);
                return;
            case ON_DESTROY:
                this.yQ.f(jVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
