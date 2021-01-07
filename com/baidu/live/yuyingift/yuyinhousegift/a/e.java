package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.LinearInterpolator;
/* loaded from: classes11.dex */
public class e extends a {
    public float endX;
    public float endY;
    public float startX;
    public float startY;

    public e(View view, float f, float f2, float f3, float f4) {
        super(view);
        this.startX = f;
        this.startY = f2;
        this.endX = f3;
        this.endY = f4;
        this.ccF = abz();
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.a
    protected AnimatorSet abz() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofPropertyValuesHolder(this.mTarget, PropertyValuesHolder.ofFloat("scaleX", 1.2f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 1.2f, 1.0f))).with(ObjectAnimator.ofPropertyValuesHolder(this.mTarget, PropertyValuesHolder.ofFloat("x", this.startX, this.endX), PropertyValuesHolder.ofFloat("y", this.startY, this.endY)));
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.setDuration(500L);
        return animatorSet;
    }
}
