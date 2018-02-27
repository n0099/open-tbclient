package android.support.b;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class g extends aj {
    public g(int i) {
        super(true);
        if (Build.VERSION.SDK_INT >= 19) {
            if (i > 0) {
                this.uR = new i(this, i);
            } else {
                this.uR = new i(this);
            }
        } else if (i > 0) {
            this.uR = new h(this, i);
        } else {
            this.uR = new h(this);
        }
    }

    public g() {
        this(-1);
    }

    @Override // android.support.b.aj, android.support.b.n, android.support.b.r
    public void captureEndValues(af afVar) {
        this.uR.captureEndValues(afVar);
    }

    @Override // android.support.b.aj, android.support.b.n, android.support.b.r
    public void captureStartValues(af afVar) {
        this.uR.captureStartValues(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return this.uR.createAnimator(viewGroup, afVar, afVar2);
    }
}
