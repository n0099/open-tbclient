package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.map.SwipeDismissTouchListener;
/* loaded from: classes2.dex */
public class p extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f7126a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7127b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeDismissTouchListener f7128c;

    public p(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.f7128c = swipeDismissTouchListener;
        this.f7126a = layoutParams;
        this.f7127b = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        SwipeDismissTouchListener.DismissCallbacks dismissCallbacks;
        View view;
        Object obj;
        View view2;
        View view3;
        dismissCallbacks = this.f7128c.f7035f;
        view = this.f7128c.f7034e;
        obj = this.f7128c.l;
        dismissCallbacks.onDismiss(view, obj);
        view2 = this.f7128c.f7034e;
        view2.setTranslationX(0.0f);
        this.f7126a.height = this.f7127b;
        view3 = this.f7128c.f7034e;
        view3.setLayoutParams(this.f7126a);
    }
}
