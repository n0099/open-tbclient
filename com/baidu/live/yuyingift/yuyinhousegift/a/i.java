package com.baidu.live.yuyingift.yuyinhousegift.a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes11.dex */
public class i extends com.baidu.live.yuyingift.yuyinhousegift.a.a {
    private a ccL;

    /* loaded from: classes11.dex */
    public interface a {
        void abA();
    }

    public i(View view) {
        super(view);
    }

    @Override // com.baidu.live.yuyingift.yuyinhousegift.a.a
    public AnimatorSet abz() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mTarget, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.8f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.8f, 1.0f));
        ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.live.yuyingift.yuyinhousegift.a.i.1
            boolean ccH;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!this.ccH && ((Float) valueAnimator.getAnimatedValue()).floatValue() > 0.2d) {
                    this.ccH = true;
                    if (i.this.ccL != null) {
                        i.this.ccL.abA();
                    }
                }
            }
        });
        ofPropertyValuesHolder.setDuration(360L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTarget, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(640L);
        animatorSet.play(ofPropertyValuesHolder).after(ofFloat);
        return animatorSet;
    }

    public void a(a aVar) {
        this.ccL = aVar;
    }
}
