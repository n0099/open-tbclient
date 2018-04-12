package android.support.transition;

import android.content.Context;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class SceneStaticsApi21 extends SceneStaticsImpl {
    @Override // android.support.transition.SceneStaticsImpl
    public SceneImpl getSceneForLayout(ViewGroup viewGroup, int i, Context context) {
        SceneApi21 sceneApi21 = new SceneApi21();
        sceneApi21.mScene = android.transition.Scene.getSceneForLayout(viewGroup, i, context);
        return sceneApi21;
    }
}
