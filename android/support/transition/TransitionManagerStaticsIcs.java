package android.support.transition;

import android.view.ViewGroup;
/* loaded from: classes2.dex */
class TransitionManagerStaticsIcs extends TransitionManagerStaticsImpl {
    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void go(SceneImpl sceneImpl) {
        TransitionManagerPort.go(((SceneIcs) sceneImpl).mScene);
    }

    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void go(SceneImpl sceneImpl, TransitionImpl transitionImpl) {
        TransitionManagerPort.go(((SceneIcs) sceneImpl).mScene, transitionImpl == null ? null : ((TransitionIcs) transitionImpl).mTransition);
    }

    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void beginDelayedTransition(ViewGroup viewGroup) {
        TransitionManagerPort.beginDelayedTransition(viewGroup);
    }

    @Override // android.support.transition.TransitionManagerStaticsImpl
    public void beginDelayedTransition(ViewGroup viewGroup, TransitionImpl transitionImpl) {
        TransitionManagerPort.beginDelayedTransition(viewGroup, transitionImpl == null ? null : ((TransitionIcs) transitionImpl).mTransition);
    }
}
