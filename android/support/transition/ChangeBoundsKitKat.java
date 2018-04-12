package android.support.transition;
/* loaded from: classes2.dex */
class ChangeBoundsKitKat extends TransitionKitKat implements ChangeBoundsInterface {
    public ChangeBoundsKitKat(TransitionInterface transitionInterface) {
        init(transitionInterface, new android.transition.ChangeBounds());
    }

    @Override // android.support.transition.ChangeBoundsInterface
    public void setResizeClip(boolean z) {
        ((android.transition.ChangeBounds) this.mTransition).setResizeClip(z);
    }
}
