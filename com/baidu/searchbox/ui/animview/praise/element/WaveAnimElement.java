package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
/* loaded from: classes4.dex */
public class WaveAnimElement extends BaseAnimatedElement {
    public static final boolean DEBUG = false;
    public LottieDrawable mLottieDrawable;

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public WaveAnimElement(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
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
        IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie("wave", new Object[0]);
        if (lottie != null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this.mLottieDrawable = lottieDrawable;
            lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.setComposition(lottie.mLottieComposition);
            this.mLottieDrawable.setCallback(this.mDrawableCallback.get());
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -65536);
    }
}
