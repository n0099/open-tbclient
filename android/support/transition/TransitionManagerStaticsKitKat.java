package android.support.transition;

import android.view.ViewGroup;
/* loaded from: classes2.dex */
class TransitionManagerStaticsKitKat extends TransitionManagerStaticsImpl {
    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void go(SceneImpl sceneImpl) {
        android.transition.TransitionManager.go(((SceneWrapper) sceneImpl).mScene);
    }

    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void go(SceneImpl sceneImpl, TransitionImpl transitionImpl) {
        android.transition.TransitionManager.go(((SceneWrapper) sceneImpl).mScene, transitionImpl == null ? null : ((TransitionKitKat) transitionImpl).mTransition);
    }

    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void beginDelayedTransition(ViewGroup viewGroup) {
        android.transition.TransitionManager.beginDelayedTransition(viewGroup);
    }

    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void beginDelayedTransition(ViewGroup viewGroup, TransitionImpl transitionImpl) {
        android.transition.TransitionManager.beginDelayedTransition(viewGroup, transitionImpl == null ? null : ((TransitionKitKat) transitionImpl).mTransition);
    }
}
