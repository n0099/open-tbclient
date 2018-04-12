package android.support.transition;
/* loaded from: classes2.dex */
class TransitionSetKitKat extends TransitionKitKat implements TransitionSetImpl {
    private android.transition.TransitionSet mTransitionSet = new android.transition.TransitionSet();

    public TransitionSetKitKat(TransitionInterface transitionInterface) {
        init(transitionInterface, this.mTransitionSet);
    }

    @Override // android.support.transition.TransitionSetImpl
    public int getOrdering() {
        return this.mTransitionSet.getOrdering();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionSetImpl
    public TransitionSetKitKat setOrdering(int i) {
        this.mTransitionSet.setOrdering(i);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionSetImpl
    public TransitionSetKitKat addTransition(TransitionImpl transitionImpl) {
        this.mTransitionSet.addTransition(((TransitionKitKat) transitionImpl).mTransition);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.transition.TransitionSetImpl
    public TransitionSetKitKat removeTransition(TransitionImpl transitionImpl) {
        this.mTransitionSet.removeTransition(((TransitionKitKat) transitionImpl).mTransition);
        return this;
    }
}
