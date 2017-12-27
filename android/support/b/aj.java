package android.support.b;

import android.animation.Animator;
import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public abstract class aj extends n implements am {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(boolean z) {
        super(true);
        if (!z) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.uR = new an();
            } else {
                this.uR = new ak();
            }
            this.uR.a(this);
        }
    }

    @Override // android.support.b.n, android.support.b.r
    public void captureEndValues(af afVar) {
        this.uR.captureEndValues(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public void captureStartValues(af afVar) {
        this.uR.captureStartValues(afVar);
    }

    @Override // android.support.b.am
    public boolean b(af afVar) {
        return ((al) this.uR).b(afVar);
    }

    @Override // android.support.b.am
    public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((al) this.uR).a(viewGroup, afVar, i, afVar2, i2);
    }

    @Override // android.support.b.am
    public Animator b(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((al) this.uR).b(viewGroup, afVar, i, afVar2, i2);
    }
}
