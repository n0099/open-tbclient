package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes15.dex */
public class v implements h {
    private final g AR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(g gVar) {
        this.AR = gVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.AR.a(jVar, event, false, null);
        this.AR.a(jVar, event, true, null);
    }
}
