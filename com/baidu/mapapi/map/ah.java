package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes20.dex */
class ah extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ WearMapView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WearMapView wearMapView, View view) {
        this.b = wearMapView;
        this.a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
