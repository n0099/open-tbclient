package com.baidu.tbadk.core;

import android.view.animation.Animation;
import java.lang.ref.WeakReference;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ BaseFragmentActivity NW;
    private final /* synthetic */ Animation.AnimationListener val$listener;
    private final /* synthetic */ WeakReference val$reference;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(BaseFragmentActivity baseFragmentActivity, Animation.AnimationListener animationListener, WeakReference weakReference) {
        this.NW = baseFragmentActivity;
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
        list = this.NW.animationList;
        synchronized (list) {
            list2 = this.NW.animationList;
            list2.remove(this.val$reference);
        }
    }
}
