package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class t implements h {
    private final Object cH;
    private final b.a cI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object obj) {
        this.cH = obj;
        this.cI = b.bG.g(this.cH.getClass());
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.cI.a(jVar, event, this.cH);
    }
}
