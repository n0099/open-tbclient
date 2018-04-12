package android.support.transition;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
abstract class SceneImpl {
    public abstract void enter();

    public abstract void exit();

    public abstract ViewGroup getSceneRoot();

    public abstract void init(ViewGroup viewGroup);

    public abstract void init(ViewGroup viewGroup, View view2);

    public abstract void setEnterAction(Runnable runnable);

    public abstract void setExitAction(Runnable runnable);
}
