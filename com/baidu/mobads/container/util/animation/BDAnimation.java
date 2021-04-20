package com.baidu.mobads.container.util.animation;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
/* loaded from: classes2.dex */
public class BDAnimation {
    public Animation animation;
    public ObjectAnimator animator;
    public long DURATION = 1000;
    public long mDuration = 1000;
    public int repeatCount = 0;
    public boolean fillAfter = true;

    public void alphaAnimation(float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        this.animation = alphaAnimation;
        alphaAnimation.setDuration(this.mDuration);
        this.animation.setRepeatCount(this.repeatCount);
        this.animation.setFillAfter(this.fillAfter);
    }

    public void cancelAnimations() {
        this.animation.cancel();
        this.animation.reset();
    }

    public void rotateAnimation(float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f2, 1, 0.5f, 1, 0.5f);
        this.animation = rotateAnimation;
        rotateAnimation.setDuration(this.mDuration);
        this.animation.setRepeatCount(this.repeatCount);
        this.animation.setFillAfter(this.fillAfter);
    }

    public void scaleAnimation(float f2, float f3, float f4, float f5, float f6, float f7) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f4, f5, f6, f7);
        this.animation = scaleAnimation;
        scaleAnimation.setDuration(this.mDuration);
        this.animation.setRepeatCount(this.repeatCount);
        this.animation.setFillAfter(false);
        this.animation.setFillEnabled(true);
    }

    public void startAnimations(View view) {
        view.startAnimation(this.animation);
    }

    public void translateAnimation(float f2, float f3) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 0, f2, 1, 0.0f, 0, f3);
        this.animation = translateAnimation;
        translateAnimation.setDuration(this.mDuration);
        this.animation.setRepeatCount(this.repeatCount);
        this.animation.setFillAfter(this.fillAfter);
    }
}
