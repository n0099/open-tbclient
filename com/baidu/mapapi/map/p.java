package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* loaded from: classes2.dex */
public class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f7090a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7091b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f7092c;

    public p(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.f7092c = swipeDismissTouchListener;
        this.f7090a = layoutParams;
        this.f7091b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        dismissCallbacks = this.f7092c.f6999f;
        view = this.f7092c.f6998e;
        obj = this.f7092c.l;
        dismissCallbacks.onDismiss(view, obj);
        view2 = this.f7092c.f6998e;
        view2.setTranslationX(0.0f);
        this.f7090a.height = this.f7091b;
        view3 = this.f7092c.f6998e;
        view3.setLayoutParams(this.f7090a);
    }
}
