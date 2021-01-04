package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
/* loaded from: classes11.dex */
public class d extends a {
    public d(View view) {
        super(view);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.a
    protected AnimatorSet aby() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.mTarget, "alpha", 1.0f, 1.0f));
        animatorSet.setDuration(640L);
        animatorSet.setInterpolator(new LinearInterpolator());
        return animatorSet;
    }
}
