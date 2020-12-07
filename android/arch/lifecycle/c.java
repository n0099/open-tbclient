package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes15.dex */
public class c implements h {
    private final g[] zW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(g[] gVarArr) {
        this.zW = gVarArr;
    }

    @Override // android.arch.lifecycle.h
    public void a(j jVar, Lifecycle.Event event) {
        o oVar = new o();
        for (g gVar : this.zW) {
            gVar.a(jVar, event, false, oVar);
        }
        for (g gVar2 : this.zW) {
            gVar2.a(jVar, event, true, oVar);
        }
    }
}
