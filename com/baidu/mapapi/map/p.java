package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* loaded from: classes2.dex */
public class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f7381a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7382b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f7383c;

    public p(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i2) {
        this.f7383c = swipeDismissTouchListener;
        this.f7381a = layoutParams;
        this.f7382b = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        dismissCallbacks = this.f7383c.f7284f;
        view = this.f7383c.f7283e;
        obj = this.f7383c.l;
        dismissCallbacks.onDismiss(view, obj);
        view2 = this.f7383c.f7283e;
        view2.setTranslationX(0.0f);
        this.f7381a.height = this.f7382b;
        view3 = this.f7383c.f7283e;
        view3.setLayoutParams(this.f7381a);
    }
}
