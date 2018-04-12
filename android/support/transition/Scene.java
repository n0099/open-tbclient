package android.support.transition;

import android.content.Context;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class Scene {
    private static SceneStaticsImpl sImpl;
    SceneImpl mImpl;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            sImpl = new SceneStaticsApi21();
        } else if (Build.VERSION.SDK_INT >= 19) {
            sImpl = new SceneStaticsKitKat();
        } else {
            sImpl = new SceneStaticsIcs();
        }
    }

    public Scene(@NonNull ViewGroup viewGroup) {
        this.mImpl = createSceneImpl();
        this.mImpl.init(viewGroup);
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view2) {
        this.mImpl = createSceneImpl();
        this.mImpl.init(viewGroup, view2);
    }

    private Scene(SceneImpl sceneImpl) {
        this.mImpl = sceneImpl;
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i, @NonNull Context context) {
        SparseArray sparseArray;
        SparseArray sparseArray2 = (SparseArray) viewGroup.getTag(R.id.transition_scene_layoutid_cache);
        if (sparseArray2 == null) {
            SparseArray sparseArray3 = new SparseArray();
            viewGroup.setTag(R.id.transition_scene_layoutid_cache, sparseArray3);
            sparseArray = sparseArray3;
        } else {
            sparseArray = sparseArray2;
        }
        Scene scene = (Scene) sparseArray.get(i);
        if (scene == null) {
            Scene scene2 = new Scene(sImpl.getSceneForLayout(viewGroup, i, context));
            sparseArray.put(i, scene2);
            return scene2;
        }
        return scene;
    }

    private SceneImpl createSceneImpl() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new SceneApi21();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return new SceneKitKat();
        }
        return new SceneIcs();
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mImpl.getSceneRoot();
    }

    public void exit() {
        this.mImpl.exit();
    }

    public void enter() {
        this.mImpl.enter();
    }

    public void setEnterAction(@Nullable Runnable runnable) {
        this.mImpl.setEnterAction(runnable);
    }

    public void setExitAction(@Nullable Runnable runnable) {
        this.mImpl.setExitAction(runnable);
    }
}
