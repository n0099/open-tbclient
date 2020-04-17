package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class t implements h {
    private final Object yC;
    private final b.a yD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object obj) {
        this.yC = obj;
        this.yD = b.xK.g(this.yC.getClass());
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.yD.a(jVar, event, this.yC);
    }
}
