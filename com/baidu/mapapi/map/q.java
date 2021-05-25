package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* loaded from: classes2.dex */
public class q extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f7100a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f7102c;

    public q(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i2) {
        this.f7102c = swipeDismissTouchListener;
        this.f7100a = layoutParams;
        this.f7101b = i2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        dismissCallbacks = this.f7102c.f7000f;
        view = this.f7102c.f6999e;
        obj = this.f7102c.l;
        dismissCallbacks.onDismiss(view, obj);
        view2 = this.f7102c.f6999e;
        view2.setTranslationX(0.0f);
        this.f7100a.height = this.f7101b;
        view3 = this.f7102c.f6999e;
        view3.setLayoutParams(this.f7100a);
    }
}
