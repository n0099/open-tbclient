package android.support.transition;
/* loaded from: classes2.dex */
class TransitionManagerKitKat extends TransitionManagerImpl {
    private final android.transition.TransitionManager mTransitionManager = new android.transition.TransitionManager();

    @Override // android.support.transition.TransitionManagerImpl
    public void setTransition(SceneImpl sceneImpl, TransitionImpl transitionImpl) {
        this.mTransitionManager.setTransition(((SceneWrapper) sceneImpl).mScene, transitionImpl == null ? null : ((TransitionKitKat) transitionImpl).mTransition);
    }

    @Override // android.support.transition.TransitionManagerImpl
    public void setTransition(SceneImpl sceneImpl, SceneImpl sceneImpl2, TransitionImpl transitionImpl) {
        this.mTransitionManager.setTransition(((SceneWrapper) sceneImpl).mScene, ((SceneWrapper) sceneImpl2).mScene, transitionImpl == null ? null : ((TransitionKitKat) transitionImpl).mTransition);
    }

    @Override // android.support.transition.TransitionManagerImpl
    public void transitionTo(SceneImpl sceneImpl) {
        this.mTransitionManager.transitionTo(((SceneWrapper) sceneImpl).mScene);
    }
}
