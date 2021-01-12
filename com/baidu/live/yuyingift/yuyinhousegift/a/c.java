package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
/* loaded from: classes10.dex */
public class c extends com.baidu.live.yuyingift.yuyinhousegift.a.a {
    private a bXS;

    /* loaded from: classes10.dex */
    public interface a {
        void XH();
    }

    public c(View view) {
        super(view);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.a
    protected AnimatorSet XG() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mTarget, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.5f, 1.2f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.5f, 1.2f));
        ofPropertyValuesHolder.setDuration(440L);
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.c.1
            boolean bXT;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!this.bXT && ((Float) valueAnimator.getAnimatedValue()).floatValue() > 0.01d) {
                    this.bXT = true;
                    if (c.this.bXS != null) {
                        c.this.bXS.XH();
                    }
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTarget, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(560L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playSequentially(ofPropertyValuesHolder, ofFloat);
        return animatorSet;
    }

    public void a(a aVar) {
        this.bXS = aVar;
    }
}
