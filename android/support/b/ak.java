package android.support.b;

import android.animation.Animator;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class ak extends p implements al {
    @Override // android.support.b.p, android.support.b.q
    public void a(r rVar, Object obj) {
        this.uT = rVar;
        if (obj == null) {
            this.uS = new a((am) rVar);
        } else {
            this.uS = (ao) obj;
        }
    }

    @Override // android.support.b.al
    public boolean b(af afVar) {
        return ((ao) this.uS).b(afVar);
    }

    @Override // android.support.b.al
    public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((ao) this.uS).a(viewGroup, afVar, i, afVar2, i2);
    }

    @Override // android.support.b.al
    public Animator b(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((ao) this.uS).b(viewGroup, afVar, i, afVar2, i2);
    }

    /* loaded from: classes2.dex */
    private static class a extends ao {
        private am vT;

        a(am amVar) {
            this.vT = amVar;
        }

        @Override // android.support.b.ao, android.support.b.z
        public void captureStartValues(af afVar) {
            this.vT.captureStartValues(afVar);
        }

        @Override // android.support.b.ao, android.support.b.z
        public void captureEndValues(af afVar) {
            this.vT.captureEndValues(afVar);
        }

        @Override // android.support.b.ao, android.support.b.z
        public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
            return this.vT.createAnimator(viewGroup, afVar, afVar2);
        }

        @Override // android.support.b.ao
        public boolean b(af afVar) {
            return this.vT.b(afVar);
        }

        @Override // android.support.b.ao
        public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
            return this.vT.a(viewGroup, afVar, i, afVar2, i2);
        }

        @Override // android.support.b.ao
        public Animator b(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
            return this.vT.b(viewGroup, afVar, i, afVar2, i2);
        }
    }
}
