package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class e implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Animation f4010a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LivenessRecogActivity f4011b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LivenessRecogActivity livenessRecogActivity, Animation animation) {
        this.f4011b = livenessRecogActivity;
        this.f4010a = animation;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageView imageView;
        imageView = this.f4011b.z;
        imageView.startAnimation(this.f4010a);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
