package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
/* loaded from: classes4.dex */
public class ShakeAnimElement extends BaseAnimatedElement {
    public static final boolean DEBUG = false;
    public static final float FACTOR_SHAKE = 0.6f;
    public static final int TYPE_SCALE_IN = 0;
    public static final int TYPE_SHAKE = 1;
    public LottieDrawable mLottieDrawable;
    public int mShowType;

    private float getTransformFraction(int i, float f) {
        return i != 0 ? i != 1 ? f : (f * 0.39999998f) + 0.6f : f * 0.6f;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public ShakeAnimElement(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mShowType = -1;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f, long j) {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.setProgress(getTransformFraction(this.mShowType, f));
        this.mLottieDrawable.draw(canvas);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie("shake", new Object[0]);
        if (lottie != null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this.mLottieDrawable = lottieDrawable;
            lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.setComposition(lottie.mLottieComposition);
            this.mLottieDrawable.setCallback(this.mDrawableCallback.get());
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -256);
    }

    public void setShowType(int i) {
        this.mShowType = i;
    }
}
