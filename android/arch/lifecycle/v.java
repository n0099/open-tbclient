package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes14.dex */
public class v implements h {
    private final g zY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(g gVar) {
        this.zY = gVar;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        this.zY.a(jVar, event, false, null);
        this.zY.a(jVar, event, true, null);
    }
}
