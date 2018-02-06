package android.support.b;

import android.animation.Animator;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class h extends p implements al {
    public h(r rVar) {
        a(rVar, new j());
    }

    public h(r rVar, int i) {
        a(rVar, new j(i));
    }

    @Override // android.support.b.al
    public boolean b(af afVar) {
        return ((j) this.uT).b(afVar);
    }

    @Override // android.support.b.al
    public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((j) this.uT).a(viewGroup, afVar, i, afVar2, i2);
    }

    @Override // android.support.b.al
    public Animator b(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((j) this.uT).b(viewGroup, afVar, i, afVar, i);
    }
}
