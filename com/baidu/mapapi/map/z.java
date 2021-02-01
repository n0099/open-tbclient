package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes4.dex */
class z extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2818a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ WearMapView f2819b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WearMapView wearMapView, View view) {
        this.f2819b = wearMapView;
        this.f2818a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2818a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
