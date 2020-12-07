package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class t implements h {
    private final Object AK;
    private final b.a AM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Object obj) {
        this.AK = obj;
        this.AM = b.zQ.g(this.AK.getClass());
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.AM.a(jVar, event, this.AK);
    }
}
