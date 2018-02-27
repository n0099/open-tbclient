package android.support.b;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class aa extends n {
    public aa() {
        super(true);
        if (Build.VERSION.SDK_INT < 19) {
            this.uR = new ab(this);
        } else {
            this.uR = new ad(this);
        }
    }

    public aa W(int i) {
        ((ac) this.uR).Y(i);
        return this;
    }

    public aa a(n nVar) {
        ((ac) this.uR).b(nVar.uR);
        return this;
    }

    @Override // android.support.b.n, android.support.b.r
    public void captureEndValues(af afVar) {
        this.uR.captureEndValues(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public void captureStartValues(af afVar) {
        this.uR.captureStartValues(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return this.uR.createAnimator(viewGroup, afVar, afVar2);
    }
}
