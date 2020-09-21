package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes11.dex */
public class EruptionAnimElement extends BaseAnimatedElement {
    private static final boolean DEBUG = false;
    private int mEruptionIndex;
    protected g mLottieDrawable;

    public EruptionAnimElement(int i, Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mEruptionIndex = i;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, Integer.valueOf(this.mEruptionIndex));
        if (lottie != null) {
            this.mLottieDrawable = new g();
            this.mLottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.a(lottie.mLottieComposition);
            this.mLottieDrawable.setCallback(this.mDrawableCallback);
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -65281);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onDispatchAnimate(Canvas canvas, float f, long j) {
        if (this.mLottieDrawable != null) {
            this.mLottieDrawable.setProgress(f);
            this.mLottieDrawable.draw(canvas);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        if (this.mLottieDrawable != null) {
            this.mLottieDrawable.recycleBitmaps();
        }
    }
}
