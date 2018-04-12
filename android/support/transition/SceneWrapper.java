package android.support.transition;

import android.view.ViewGroup;
/* loaded from: classes2.dex */
abstract class SceneWrapper extends SceneImpl {
    android.transition.Scene mScene;

    @Override // android.support.transition.SceneImpl
    public ViewGroup getSceneRoot() {
        return this.mScene.getSceneRoot();
    }

    @Override // android.support.transition.SceneImpl
    public void exit() {
        this.mScene.exit();
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
