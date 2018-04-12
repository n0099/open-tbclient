package android.support.transition;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class SceneApi21 extends SceneWrapper {
    @Override // android.support.transition.SceneImpl
    public void init(ViewGroup viewGroup) {
        this.mScene = new android.transition.Scene(viewGroup);
    }

    @Override // android.support.transition.SceneImpl
    public void init(ViewGroup viewGroup, View view2) {
        this.mScene = new android.transition.Scene(viewGroup, view2);
    }

    @Override // android.support.transition.SceneImpl
    public void enter() {
        this.mScene.enter();
    }
}
