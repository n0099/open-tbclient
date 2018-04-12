package android.support.transition;

import android.animation.Animator;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class FadeIcs extends TransitionIcs implements VisibilityImpl {
    public FadeIcs(TransitionInterface transitionInterface) {
        init(transitionInterface, new FadePort());
    }

    public FadeIcs(TransitionInterface transitionInterface, int i) {
        init(transitionInterface, new FadePort(i));
    }

    @Override // android.support.transition.VisibilityImpl
    public boolean isVisible(TransitionValues transitionValues) {
        return ((FadePort) this.mTransition).isVisible(transitionValues);
    }

    @Override // android.support.transition.VisibilityImpl
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        return ((FadePort) this.mTransition).onAppear(viewGroup, transitionValues, i, transitionValues2, i2);
    }

    @Override // android.support.transition.VisibilityImpl
    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        return ((FadePort) this.mTransition).onDisappear(viewGroup, transitionValues, i, transitionValues, i);
    }
}
