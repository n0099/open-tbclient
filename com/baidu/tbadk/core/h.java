package com.baidu.tbadk.core;

import android.view.animation.Animation;
import java.lang.ref.WeakReference;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    private final /* synthetic */ Animation.AnimationListener val$listener;
    private final /* synthetic */ WeakReference val$reference;
    final /* synthetic */ BaseFragmentActivity yG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BaseFragmentActivity baseFragmentActivity, Animation.AnimationListener animationListener, WeakReference weakReference) {
        this.yG = baseFragmentActivity;
        this.val$listener = animationListener;
        this.val$reference = weakReference;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        if (this.val$listener != null) {
            this.val$listener.onAnimationStart(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        if (this.val$listener != null) {
            this.val$listener.onAnimationRepeat(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        List list;
        List list2;
        if (this.val$listener != null) {
            this.val$listener.onAnimationEnd(animation);
        }
        list = this.yG.animationList;
        synchronized (list) {
            list2 = this.yG.animationList;
            list2.remove(this.val$reference);
        }
    }
}
