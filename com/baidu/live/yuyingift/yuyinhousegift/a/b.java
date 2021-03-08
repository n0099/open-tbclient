package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.animation.LinearInterpolator;
/* loaded from: classes10.dex */
public class b extends a {
    public b(View view) {
        super(view);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.a
    protected AnimatorSet Zz() {
        AnimatorSet animatorSet = new AnimatorSet();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.0f);
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.0f);
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.0f);
        animatorSet.play(ObjectAnimator.ofPropertyValuesHolder(this.mTarget, ofFloat, ofFloat2)).with(ObjectAnimator.ofPropertyValuesHolder(this.mTarget, ofFloat3));
        animatorSet.setDuration(500L);
        animatorSet.setInterpolator(new LinearInterpolator());
        return animatorSet;
    }
}
