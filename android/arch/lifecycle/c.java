package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class c implements h {
    private final g[] bM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g[] gVarArr) {
        this.bM = gVarArr;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        o oVar = new o();
        for (g gVar : this.bM) {
            gVar.a(jVar, event, false, oVar);
        }
        for (g gVar2 : this.bM) {
            gVar2.a(jVar, event, true, oVar);
        }
    }
}
