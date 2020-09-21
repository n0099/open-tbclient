package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class t implements h {
    private final Object zB;
    private final b.a zC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object obj) {
        this.zB = obj;
        this.zC = b.yJ.g(this.zB.getClass());
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.zC.a(jVar, event, this.zB);
    }
}
