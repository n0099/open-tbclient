package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes2.dex */
public class z extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WearMapView f7144b;

    public z(WearMapView wearMapView, View view) {
        this.f7144b = wearMapView;
        this.f7143a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f7143a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
