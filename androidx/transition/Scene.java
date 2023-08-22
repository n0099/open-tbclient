package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public class Scene {
    public Context mContext;
    public Runnable mEnterAction;
    public Runnable mExitAction;
    public View mLayout;
    public int mLayoutId;
    public ViewGroup mSceneRoot;

    public Scene(@NonNull ViewGroup viewGroup) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926b8);
    }

    public void setEnterAction(@Nullable Runnable runnable) {
        this.mEnterAction = runnable;
    }

    public void setExitAction(@Nullable Runnable runnable) {
        this.mExitAction = runnable;
    }

    public Scene(ViewGroup viewGroup, int i, Context context) {
        this.mLayoutId = -1;
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i;
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i, @NonNull Context context) {
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926bb);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926bb, sparseArray);
        }
        Scene scene = (Scene) sparseArray.get(i);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i, context);
        sparseArray.put(i, scene2);
        return scene2;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view2) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view2;
    }

    public static void setCurrentScene(@NonNull ViewGroup viewGroup, @Nullable Scene scene) {
        viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f0926b8, scene);
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
        Runnable runnable = this.mEnterAction;
        if (runnable != null) {
            runnable.run();
        }
        setCurrentScene(this.mSceneRoot, this);
    }

    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.mSceneRoot) == this && (runnable = this.mExitAction) != null) {
            runnable.run();
        }
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public boolean isCreatedFromLayoutResource() {
        if (this.mLayoutId > 0) {
            return true;
        }
        return false;
    }
}
