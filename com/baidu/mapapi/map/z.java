package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes6.dex */
class z extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2820a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ WearMapView f2821b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(WearMapView wearMapView, View view) {
        this.f2821b = wearMapView;
        this.f2820a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2820a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
