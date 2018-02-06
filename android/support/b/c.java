package android.support.b;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class c extends n {
    public c() {
        super(true);
        if (Build.VERSION.SDK_INT < 19) {
            this.uS = new d(this);
        } else {
            this.uS = new e(this);
        }
    }

    @Override // android.support.b.n, android.support.b.r
    public void captureEndValues(af afVar) {
        this.uS.captureEndValues(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public void captureStartValues(af afVar) {
        this.uS.captureStartValues(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        return this.uS.createAnimator(viewGroup, afVar, afVar2);
    }
}
