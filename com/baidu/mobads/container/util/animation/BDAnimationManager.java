package com.baidu.mobads.container.util.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import java.util.List;
/* loaded from: classes2.dex */
public class BDAnimationManager {
    public static final String TAG = "BDAnimationManager";
    public AnimationSet animationSet;
    public AnimatorSet animatorSet;
    public List<BDAnimation> mAnimations;
    public long DURATION = 1000;
    public long mDuration = 1000;
    public int repeatCount = 0;
    public int repeatMode = 2;
    public boolean fillAfter = true;

    public BDAnimationManager(List<BDAnimation> list) {
        this.mAnimations = list;
    }

    public void cancelAnimations() {
        this.animationSet.cancel();
        this.animationSet.reset();
    }

    public void startAnimations(View view) {
        try {
            this.animationSet = new AnimationSet(true);
            for (int i = 0; i < this.mAnimations.size(); i++) {
                this.animationSet.addAnimation(this.mAnimations.get(i).animation);
            }
            view.startAnimation(this.animationSet);
        } catch (Throwable th) {
            Log.e(TAG, "startAnimations fail: ", th);
        }
    }

    public void startAnimators() {
        try {
            this.animatorSet = new AnimatorSet();
            ObjectAnimator objectAnimator = null;
            for (int i = 0; i < this.mAnimations.size(); i++) {
                BDAnimation bDAnimation = this.mAnimations.get(i);
                if (i == 0) {
                    this.animatorSet.play(bDAnimation.animator);
                } else {
                    this.animatorSet.play(bDAnimation.animator).with(objectAnimator);
                }
                objectAnimator = bDAnimation.animator;
            }
            this.animatorSet.start();
        } catch (Throwable th) {
            Log.e(TAG, "startAnimators fail: ", th);
        }
    }
}
