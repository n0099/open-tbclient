package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes3.dex */
class ah extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2909a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ WearMapView f2910b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WearMapView wearMapView, View view) {
        this.f2910b = wearMapView;
        this.f2909a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2909a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
