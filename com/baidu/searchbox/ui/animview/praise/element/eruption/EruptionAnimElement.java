package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes4.dex */
public class EruptionAnimElement extends BaseAnimatedElement {
    public static final boolean DEBUG = false;
    public int mEruptionIndex;
    public LottieDrawable mLottieDrawable;

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public EruptionAnimElement(int i, Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mEruptionIndex = i;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f, long j) {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.setProgress(f);
        this.mLottieDrawable.draw(canvas);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, Integer.valueOf(this.mEruptionIndex));
        if (lottie != null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this.mLottieDrawable = lottieDrawable;
            lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.setComposition(lottie.mLottieComposition);
            this.mLottieDrawable.setCallback(this.mDrawableCallback.get());
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -65281);
    }
}
