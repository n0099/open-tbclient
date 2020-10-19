package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class f implements h {
    private final e zh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.zh = eVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
                this.zh.a(jVar);
                return;
            case ON_START:
                this.zh.b(jVar);
                return;
            case ON_RESUME:
                this.zh.c(jVar);
                return;
            case ON_PAUSE:
                this.zh.d(jVar);
                return;
            case ON_STOP:
                this.zh.e(jVar);
                return;
            case ON_DESTROY:
                this.zh.f(jVar);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
