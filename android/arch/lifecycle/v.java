package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes11.dex */
public class v implements h {
    private final g zH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(g gVar) {
        this.zH = gVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.zH.a(jVar, event, false, null);
        this.zH.a(jVar, event, true, null);
    }
}
