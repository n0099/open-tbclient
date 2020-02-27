package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class v implements h {
    private final g cO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(g gVar) {
        this.cO = gVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.cO.a(jVar, event, false, null);
        this.cO.a(jVar, event, true, null);
    }
}
