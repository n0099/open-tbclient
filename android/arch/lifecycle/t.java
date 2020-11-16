package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class t implements h {
    private final Object zS;
    private final b.a zT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object obj) {
        this.zS = obj;
        this.zT = b.za.g(this.zS.getClass());
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.zT.a(jVar, event, this.zS);
    }
}
