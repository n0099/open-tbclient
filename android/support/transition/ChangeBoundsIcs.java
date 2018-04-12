package android.support.transition;
/* loaded from: classes2.dex */
class ChangeBoundsIcs extends TransitionIcs implements ChangeBoundsInterface {
    public ChangeBoundsIcs(TransitionInterface transitionInterface) {
        init(transitionInterface, new ChangeBoundsPort());
    }

    @Override // android.support.transition.ChangeBoundsInterface
    public void setResizeClip(boolean z) {
        ((ChangeBoundsPort) this.mTransition).setResizeClip(z);
    }
}
