package android.support.b;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class an extends t implements al {
    @Override // android.support.b.t, android.support.b.q
    public void a(r rVar, Object obj) {
        this.uU = rVar;
        if (obj == null) {
            this.uY = new a((am) rVar);
        } else {
            this.uY = (Visibility) obj;
        }
    }

    @Override // android.support.b.al
    public boolean b(af afVar) {
        return ((Visibility) this.uY).isVisible(c(afVar));
    }

    @Override // android.support.b.al
    public Animator a(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((Visibility) this.uY).onAppear(viewGroup, c(afVar), i, c(afVar2), i2);
    }

    @Override // android.support.b.al
    public Animator b(ViewGroup viewGroup, af afVar, int i, af afVar2, int i2) {
        return ((Visibility) this.uY).onDisappear(viewGroup, c(afVar), i, c(afVar2), i2);
    }

    /* loaded from: classes2.dex */
    private static class a extends Visibility {
        private final am vU;

        a(am amVar) {
            this.vU = amVar;
        }

        @Override // android.transition.Visibility, android.transition.Transition
        public void captureStartValues(TransitionValues transitionValues) {
            t.a((r) this.vU, transitionValues);
        }

        @Override // android.transition.Visibility, android.transition.Transition
        public void captureEndValues(TransitionValues transitionValues) {
            t.b(this.vU, transitionValues);
        }

        @Override // android.transition.Visibility, android.transition.Transition
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.vU.createAnimator(viewGroup, t.a(transitionValues), t.a(transitionValues2));
        }

        @Override // android.transition.Visibility
        public boolean isVisible(TransitionValues transitionValues) {
            if (transitionValues == null) {
                return false;
            }
            af afVar = new af();
            t.a(transitionValues, afVar);
            return this.vU.b(afVar);
        }

        @Override // android.transition.Visibility
        public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.vU.a(viewGroup, t.a(transitionValues), i, t.a(transitionValues2), i2);
        }

        @Override // android.transition.Visibility
        public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.vU.b(viewGroup, t.a(transitionValues), i, t.a(transitionValues2), i2);
        }
    }
}
