package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes4.dex */
public class PraiseLevelAnimElement extends BaseAnimatedElement {
    public static final boolean DEBUG = false;
    public static final float FACTOR_SCALE_OUT = 0.82f;
    public static final float FACTOR_VIBRATION = 0.56f;
    public static final int TYPE_SCALE_IN = 0;
    public static final int TYPE_SCALE_OUT = 2;
    public static final int TYPE_VIBRATION = 1;
    public LottieDrawable[] mLottieArray;
    public int mMaxLevel;
    public int mShowType;

    private float getTransformFraction(int i, float f) {
        return i != 0 ? i != 1 ? i != 2 ? f : (f * 0.18f) + 0.82f : (f * 0.26f) + 0.56f : f * 0.56f;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public PraiseLevelAnimElement(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mShowType = -1;
    }

    private LottieDrawable getLevelLottieView(long j) {
        int i;
        LottieDrawable[] lottieDrawableArr = this.mLottieArray;
        if (lottieDrawableArr != null && (i = this.mMaxLevel) > 0 && lottieDrawableArr.length == i + 1) {
            LottieDrawable lottieDrawable = this.mLottieArray[getSafetyIndex(PraiseLevelUtil.matchPraiseLevel(j).mLevelImgIndex)];
            setScaleType(lottieDrawable);
            return lottieDrawable;
        }
        return null;
    }

    private int getSafetyIndex(int i) {
        if (i < 0) {
            return 0;
        }
        int i2 = this.mMaxLevel;
        if (i > i2) {
            return i2;
        }
        return i;
    }

    public void setShowType(int i) {
        this.mShowType = i;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f, long j) {
        LottieDrawable levelLottieView = getLevelLottieView(j);
        if (levelLottieView == null) {
            return;
        }
        levelLottieView.setProgress(getTransformFraction(this.mShowType, f));
        levelLottieView.draw(canvas);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        int resourceCounts = this.mResourceProvider.getResourceCounts("level");
        this.mMaxLevel = resourceCounts;
        if (resourceCounts > 0) {
            this.mLottieArray = new LottieDrawable[resourceCounts + 1];
            for (int i = 0; i <= this.mMaxLevel; i++) {
                IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie("level", Integer.valueOf(i));
                if (lottie != null) {
                    LottieDrawable lottieDrawable = new LottieDrawable();
                    lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
                    lottieDrawable.setComposition(lottie.mLottieComposition);
                    lottieDrawable.setCallback(this.mDrawableCallback.get());
                    this.mLottieArray[i] = lottieDrawable;
                }
            }
        }
        enableDrawDebugBound(false, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
    }
}
