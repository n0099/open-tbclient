package android.support.transition;

import android.content.Context;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
class SceneStaticsKitKat extends SceneStaticsImpl {
    @Override // android.support.transition.SceneStaticsImpl
    public SceneImpl getSceneForLayout(ViewGroup viewGroup, int i, Context context) {
        SceneKitKat sceneKitKat = new SceneKitKat();
        sceneKitKat.mScene = android.transition.Scene.getSceneForLayout(viewGroup, i, context);
        return sceneKitKat;
    }
}
