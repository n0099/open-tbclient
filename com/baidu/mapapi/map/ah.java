package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes15.dex */
class ah extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2908a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ WearMapView f2909b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WearMapView wearMapView, View view) {
        this.f2909b = wearMapView;
        this.f2908a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2908a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
