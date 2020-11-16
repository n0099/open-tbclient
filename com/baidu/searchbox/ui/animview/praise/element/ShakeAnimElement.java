package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.InputDeviceCompat;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
/* loaded from: classes14.dex */
public class ShakeAnimElement extends BaseAnimatedElement {
    private static final boolean DEBUG = false;
    private static final float FACTOR_SHAKE = 0.6f;
    public static final int TYPE_SCALE_IN = 0;
    public static final int TYPE_SHAKE = 1;
    protected g mLottieDrawable;
    private int mShowType;

    public ShakeAnimElement(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mShowType = -1;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie("shake", new Object[0]);
        if (lottie != null) {
            this.mLottieDrawable = new g();
            this.mLottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.a(lottie.mLottieComposition);
            this.mLottieDrawable.setCallback(this.mDrawableCallback);
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, InputDeviceCompat.SOURCE_ANY);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onDispatchAnimate(Canvas canvas, float f, long j) {
        if (this.mLottieDrawable != null) {
            this.mLottieDrawable.setProgress(getTransformFraction(this.mShowType, f));
            this.mLottieDrawable.draw(canvas);
        }
    }

    public void setShowType(int i) {
        this.mShowType = i;
    }

    private float getTransformFraction(int i, float f) {
        switch (i) {
            case 0:
                return f * FACTOR_SHAKE;
            case 1:
                return (0.39999998f * f) + FACTOR_SHAKE;
            default:
                return f;
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        if (this.mLottieDrawable != null) {
            this.mLottieDrawable.recycleBitmaps();
        }
    }
}
