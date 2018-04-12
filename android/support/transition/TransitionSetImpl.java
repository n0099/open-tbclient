package android.support.transition;
/* loaded from: classes2.dex */
interface TransitionSetImpl {
    TransitionSetImpl addTransition(TransitionImpl transitionImpl);

    int getOrdering();

    TransitionSetImpl removeTransition(TransitionImpl transitionImpl);

    TransitionSetImpl setOrdering(int i);
}
