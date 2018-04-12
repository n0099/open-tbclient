package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class VisibilityIcs extends TransitionIcs implements VisibilityImpl {
    @Override // android.support.transition.TransitionIcs, android.support.transition.TransitionImpl
    public void init(TransitionInterface transitionInterface, Object obj) {
        this.mExternalTransition = transitionInterface;
        if (obj == null) {
            this.mTransition = new VisibilityWrapper((VisibilityInterface) transitionInterface);
        } else {
            this.mTransition = (VisibilityPort) obj;
        }
    }

    @Override // android.support.transition.VisibilityImpl
    public boolean isVisible(TransitionValues transitionValues) {
        return ((VisibilityPort) this.mTransition).isVisible(transitionValues);
    }

    @Override // android.support.transition.VisibilityImpl
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        return ((VisibilityPort) this.mTransition).onAppear(viewGroup, transitionValues, i, transitionValues2, i2);
    }

    @Override // android.support.transition.VisibilityImpl
    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        return ((VisibilityPort) this.mTransition).onDisappear(viewGroup, transitionValues, i, transitionValues2, i2);
    }

    /* loaded from: classes2.dex */
    private static class VisibilityWrapper extends VisibilityPort {
        private VisibilityInterface mVisibility;

        VisibilityWrapper(VisibilityInterface visibilityInterface) {
            this.mVisibility = visibilityInterface;
        }

        @Override // android.support.transition.VisibilityPort, android.support.transition.TransitionPort
        public void captureStartValues(TransitionValues transitionValues) {
            this.mVisibility.captureStartValues(transitionValues);
        }

        @Override // android.support.transition.VisibilityPort, android.support.transition.TransitionPort
        public void captureEndValues(TransitionValues transitionValues) {
            this.mVisibility.captureEndValues(transitionValues);
        }

        @Override // android.support.transition.VisibilityPort, android.support.transition.TransitionPort
        public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
            return this.mVisibility.createAnimator(viewGroup, transitionValues, transitionValues2);
        }

        @Override // android.support.transition.VisibilityPort
        public boolean isVisible(TransitionValues transitionValues) {
            return this.mVisibility.isVisible(transitionValues);
        }

        @Override // android.support.transition.VisibilityPort
        public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.mVisibility.onAppear(viewGroup, transitionValues, i, transitionValues2, i2);
        }

        @Override // android.support.transition.VisibilityPort
        public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
            return this.mVisibility.onDisappear(viewGroup, transitionValues, i, transitionValues2, i2);
        }
    }
}
