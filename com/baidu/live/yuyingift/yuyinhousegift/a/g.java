package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
/* loaded from: classes11.dex */
public class g extends com.baidu.live.yuyingift.yuyinhousegift.a.a {
    private a cbY;

    /* loaded from: classes11.dex */
    public interface a {
        void Zx();
    }

    public g(View view) {
        super(view);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.a
    protected AnimatorSet Zw() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mTarget, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.2f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.2f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 1.0f, 1.0f));
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.g.1
            boolean cbW;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!this.cbW && ((Float) valueAnimator.getAnimatedValue()).floatValue() > 0.01d) {
                    this.cbW = true;
                    if (g.this.cbY != null) {
                        g.this.cbY.Zx();
                    }
                }
            }
        });
        ofPropertyValuesHolder.setDuration(440L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playSequentially(ofPropertyValuesHolder);
        return animatorSet;
    }

    public void a(a aVar) {
        this.cbY = aVar;
    }
}
