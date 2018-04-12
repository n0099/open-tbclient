package android.support.transition;
/* loaded from: classes2.dex */
class TransitionManagerIcs extends TransitionManagerImpl {
    private final TransitionManagerPort mTransitionManager = new TransitionManagerPort();

    @Override // android.support.transition.TransitionManagerImpl
    public void setTransition(SceneImpl sceneImpl, TransitionImpl transitionImpl) {
        this.mTransitionManager.setTransition(((SceneIcs) sceneImpl).mScene, transitionImpl == null ? null : ((TransitionIcs) transitionImpl).mTransition);
    }

    @Override // android.support.transition.TransitionManagerImpl
    public void setTransition(SceneImpl sceneImpl, SceneImpl sceneImpl2, TransitionImpl transitionImpl) {
        this.mTransitionManager.setTransition(((SceneIcs) sceneImpl).mScene, ((SceneIcs) sceneImpl2).mScene, transitionImpl == null ? null : ((TransitionIcs) transitionImpl).mTransition);
    }

    @Override // android.support.transition.TransitionManagerImpl
    public void transitionTo(SceneImpl sceneImpl) {
        this.mTransitionManager.transitionTo(((SceneIcs) sceneImpl).mScene);
    }
}
