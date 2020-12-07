package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f implements h {
    private final e zX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.zX = eVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.zX.a(jVar);
                return;
            case ON_START:
                this.zX.b(jVar);
                return;
            case ON_RESUME:
                this.zX.c(jVar);
                return;
            case ON_PAUSE:
                this.zX.d(jVar);
                return;
            case ON_STOP:
                this.zX.e(jVar);
                return;
            case ON_DESTROY:
                this.zX.f(jVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
