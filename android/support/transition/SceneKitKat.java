package android.support.transition;

import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
class SceneKitKat extends SceneWrapper {
    private static Field sEnterAction;
    private static Method sSetCurrentScene;
    private View mLayout;

    @Override // android.support.transition.SceneImpl
    public void init(ViewGroup viewGroup) {
        this.mScene = new android.transition.Scene(viewGroup);
    }

    @Override // android.support.transition.SceneImpl
    public void init(ViewGroup viewGroup, View view2) {
        if (view2 instanceof ViewGroup) {
            this.mScene = new android.transition.Scene(viewGroup, (ViewGroup) view2);
            return;
        }
        this.mScene = new android.transition.Scene(viewGroup);
        this.mLayout = view2;
    }

    @Override // android.support.transition.SceneImpl
    public void enter() {
        if (this.mLayout != null) {
            ViewGroup sceneRoot = getSceneRoot();
            sceneRoot.removeAllViews();
            sceneRoot.addView(this.mLayout);
            invokeEnterAction();
            updateCurrentScene(sceneRoot);
            return;
        }
        this.mScene.enter();
    }

    private void invokeEnterAction() {
        if (sEnterAction == null) {
            try {
                sEnterAction = android.transition.Scene.class.getDeclaredField("mEnterAction");
                sEnterAction.setAccessible(true);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Runnable runnable = (Runnable) sEnterAction.get(this.mScene);
            if (runnable != null) {
                runnable.run();
            }
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    private void updateCurrentScene(View view2) {
        if (sSetCurrentScene == null) {
            try {
                sSetCurrentScene = android.transition.Scene.class.getDeclaredMethod("setCurrentScene", View.class, android.transition.Scene.class);
                sSetCurrentScene.setAccessible(true);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            sSetCurrentScene.invoke(null, view2, this.mScene);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
