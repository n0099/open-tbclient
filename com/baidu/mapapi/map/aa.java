package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
/* loaded from: classes2.dex */
public class aa extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f7070a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WearMapView f7071b;

    public aa(WearMapView wearMapView, View view) {
        this.f7071b = wearMapView;
        this.f7070a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f7070a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
