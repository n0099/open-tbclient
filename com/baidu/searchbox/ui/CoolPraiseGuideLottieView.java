package com.baidu.searchbox.ui;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager;
/* loaded from: classes4.dex */
public class CoolPraiseGuideLottieView extends LottieAnimationView {
    public static final int ANIM_DURATION = 8000;
    public static final int HEIGTH = 145;
    public static final int WIDTH = 145;
    public static IResourcePackage.LottieResource lottieResource;
    public AnimatorListenerAdapter mAnimatorListenerAdapter;
    public ValueAnimator mValueAnimator;

    public CoolPraiseGuideLottieView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        IResourceProvider provider;
        if (lottieResource == null && (provider = PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL)) != null) {
            lottieResource = provider.getPraiseGuideLottie();
        }
        IResourcePackage.LottieResource lottieResource2 = lottieResource;
        if (lottieResource2 != null) {
            setImageAssetDelegate(lottieResource2.mImageAssetDelegate);
            setComposition(lottieResource.mLottieComposition);
            setProgress(0.0f);
        }
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        this.mAnimatorListenerAdapter = animatorListenerAdapter;
    }

    public CoolPraiseGuideLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public CoolPraiseGuideLottieView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void cancel() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public int getRealHeigth() {
        return dip2px(getContext(), 145.0f);
    }

    public int getRealWidth() {
        return dip2px(getContext(), 145.0f);
    }

    public void play() {
        if (lottieResource == null) {
            return;
        }
        setProgress(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mValueAnimator = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.CoolPraiseGuideLottieView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CoolPraiseGuideLottieView.this.setProgress(valueAnimator.getAnimatedFraction());
            }
        });
        AnimatorListenerAdapter animatorListenerAdapter = this.mAnimatorListenerAdapter;
        if (animatorListenerAdapter != null) {
            this.mValueAnimator.addListener(animatorListenerAdapter);
        }
        this.mValueAnimator.setDuration(8000L);
        this.mValueAnimator.start();
    }
}
