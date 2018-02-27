package android.support.b;

import android.animation.Animator;
import android.transition.Fade;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class i extends t implements al {
    public i(r rVar) {
        a(rVar, new Fade());
    }

    public i(r rVar, int i) {
        a(rVar, new Fade(i));
    }

    @Override // android.support.b.al
    public boolean b(af afVar) {
        return ((Fade) this.uX).isVisible(c(afVar));
    }

    @Override // android.support.b.al
    public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((Fade) this.uX).onAppear(viewGroup, c(afVar), i, c(afVar2), i2);
    }

    @Override // android.support.b.al
    public Animator b(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((Fade) this.uX).onDisappear(viewGroup, c(afVar), i, c(afVar2), i2);
    }
}
