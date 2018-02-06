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
                this.uS = new i(this, i);
            } else {
                this.uS = new i(this);
            }
        } else if (i > 0) {
            this.uS = new h(this, i);
        } else {
            this.uS = new h(this);
        }
    }

    public g() {
        this(-1);
    }

    @Override // android.support.b.aj, android.support.b.n, android.support.b.r
    public void captureEndValues(af afVar) {
        this.uS.captureEndValues(afVar);
    }

    @Override // android.support.b.aj, android.support.b.n, android.support.b.r
    public void captureStartValues(af afVar) {
        this.uS.captureStartValues(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return this.uS.createAnimator(viewGroup, afVar, afVar2);
    }
}
