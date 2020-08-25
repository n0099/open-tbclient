package com.baidu.pass.biometrics.face.liveness.activity;

import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LivenessRecogActivity livenessRecogActivity, Animation animation) {
        this.b = livenessRecogActivity;
        this.a = animation;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageView imageView;
        imageView = this.b.z;
        imageView.startAnimation(this.a);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
