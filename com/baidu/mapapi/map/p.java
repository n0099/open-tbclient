package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* loaded from: classes2.dex */
public class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f7091a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7092b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f7093c;

    public p(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.f7093c = swipeDismissTouchListener;
        this.f7091a = layoutParams;
        this.f7092b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        dismissCallbacks = this.f7093c.f7000f;
        view = this.f7093c.f6999e;
        obj = this.f7093c.l;
        dismissCallbacks.onDismiss(view, obj);
        view2 = this.f7093c.f6999e;
        view2.setTranslationX(0.0f);
        this.f7091a.height = this.f7092b;
        view3 = this.f7093c.f6999e;
        view3.setLayoutParams(this.f7091a);
    }
}
