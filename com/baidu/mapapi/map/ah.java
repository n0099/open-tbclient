package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes26.dex */
class ah extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f2068a;
    final /* synthetic */ WearMapView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WearMapView wearMapView, View view) {
        this.b = wearMapView;
        this.f2068a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2068a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
