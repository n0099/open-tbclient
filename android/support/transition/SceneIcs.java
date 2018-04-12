package android.support.transition;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class SceneIcs extends SceneImpl {
    ScenePort mScene;

    @Override // android.support.transition.SceneImpl
    public void init(ViewGroup viewGroup) {
        this.mScene = new ScenePort(viewGroup);
    }

    @Override // android.support.transition.SceneImpl
    public void init(ViewGroup viewGroup, View view2) {
        this.mScene = new ScenePort(viewGroup, view2);
    }

    @Override // android.support.transition.SceneImpl
    public void enter() {
        this.mScene.enter();
    }

    @Override // android.support.transition.SceneImpl
    public void exit() {
        this.mScene.exit();
    }

    @Override // android.support.transition.SceneImpl
    public ViewGroup getSceneRoot() {
        return this.mScene.getSceneRoot();
    }

    @Override // android.support.transition.SceneImpl
    public void setEnterAction(Runnable runnable) {
        this.mScene.setEnterAction(runnable);
    }

    @Override // android.support.transition.SceneImpl
    public void setExitAction(Runnable runnable) {
        this.mScene.setExitAction(runnable);
    }
}
