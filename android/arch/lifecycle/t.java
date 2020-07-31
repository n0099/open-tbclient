package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class t implements h {
    private final Object zc;
    private final b.a zd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object obj) {
        this.zc = obj;
        this.zd = b.yk.g(this.zc.getClass());
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.zd.a(jVar, event, this.zc);
    }
}
