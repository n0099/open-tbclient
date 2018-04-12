package android.support.transition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
final class ScenePort {
    private Context mContext;
    Runnable mEnterAction;
    Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public ScenePort(ViewGroup viewGroup) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
    }

    private ScenePort(ViewGroup viewGroup, int i, Context context) {
        this.mLayoutId = -1;
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i;
    }

    public ScenePort(ViewGroup viewGroup, View view2) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view2;
    }

    public static ScenePort getSceneForLayout(ViewGroup viewGroup, int i, Context context) {
        return new ScenePort(viewGroup, i, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCurrentScene(View view2, ScenePort scenePort) {
        view2.setTag(R.id.transition_current_scene, scenePort);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ScenePort getCurrentScene(View view2) {
        return (ScenePort) view2.getTag(R.id.transition_current_scene);
    }

    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public void exit() {
        if (getCurrentScene(this.mSceneRoot) == this && this.mExitAction != null) {
            this.mExitAction.run();
        }
    }

    public void enter() {
        if (this.mLayoutId > 0 || this.mLayout != null) {
            getSceneRoot().removeAllViews();
            if (this.mLayoutId > 0) {
                LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
            } else {
                this.mSceneRoot.addView(this.mLayout);
            }
        }
        if (this.mEnterAction != null) {
            this.mEnterAction.run();
        }
        setCurrentScene(this.mSceneRoot, this);
    }

    public void setEnterAction(Runnable runnable) {
        this.mEnterAction = runnable;
    }

    public void setExitAction(Runnable runnable) {
        this.mExitAction = runnable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCreatedFromLayoutResource() {
        return this.mLayoutId > 0;
    }
}
