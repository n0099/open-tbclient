package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class c implements h {
    private final g[] yq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g[] gVarArr) {
        this.yq = gVarArr;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        o oVar = new o();
        for (g gVar : this.yq) {
            gVar.a(jVar, event, false, oVar);
        }
        for (g gVar2 : this.yq) {
            gVar2.a(jVar, event, true, oVar);
        }
    }
}
