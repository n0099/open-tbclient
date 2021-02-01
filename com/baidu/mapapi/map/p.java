package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup.LayoutParams f2805a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f2806b;
    final /* synthetic */ SwipeDismissTouchListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.c = swipeDismissTouchListener;
        this.f2805a = layoutParams;
        this.f2806b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        dismissCallbacks = this.c.f;
        view = this.c.e;
        obj = this.c.l;
        dismissCallbacks.onDismiss(view, obj);
        view2 = this.c.e;
        view2.setTranslationX(0.0f);
        this.f2805a.height = this.f2806b;
        view3 = this.c.e;
        view3.setLayoutParams(this.f2805a);
    }
}
