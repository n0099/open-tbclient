package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes2.dex */
public class ak extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ WearMapView b;

    public ak(WearMapView wearMapView, View view2) {
        this.b = wearMapView;
        this.a = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
