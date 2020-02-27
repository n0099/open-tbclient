package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class t implements h {
    private final Object cI;
    private final b.a cJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object obj) {
        this.cI = obj;
        this.cJ = b.bG.g(this.cI.getClass());
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.cJ.a(jVar, event, this.cI);
    }
}
