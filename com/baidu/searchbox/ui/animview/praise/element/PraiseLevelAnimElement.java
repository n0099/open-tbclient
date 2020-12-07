package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
/* loaded from: classes6.dex */
public class PraiseLevelAnimElement extends BaseAnimatedElement {
    private static final boolean DEBUG = false;
    private static final float FACTOR_SCALE_OUT = 0.82f;
    private static final float FACTOR_VIBRATION = 0.56f;
    public static final int TYPE_SCALE_IN = 0;
    public static final int TYPE_SCALE_OUT = 2;
    public static final int TYPE_VIBRATION = 1;
    protected g[] mLottieArray;
    protected int mMaxLevel;
    private int mShowType;

    public PraiseLevelAnimElement(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mShowType = -1;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        this.mMaxLevel = this.mResourceProvider.getResourceCounts("level");
        if (this.mMaxLevel > 0) {
            this.mLottieArray = new g[this.mMaxLevel + 1];
            for (int i = 0; i <= this.mMaxLevel; i++) {
                IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie("level", Integer.valueOf(i));
                if (lottie != null) {
                    g gVar = new g();
                    gVar.setImageAssetDelegate(lottie.mImageAssetDelegate);
                    gVar.a(lottie.mLottieComposition);
                    gVar.setCallback(this.mDrawableCallback);
                    this.mLottieArray[i] = gVar;
                }
            }
        }
        enableDrawDebugBound(false, -16711936);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onDispatchAnimate(Canvas canvas, float f, long j) {
        g levelLottieView = getLevelLottieView(j);
        if (levelLottieView != null) {
            levelLottieView.setProgress(getTransformFraction(this.mShowType, f));
            levelLottieView.draw(canvas);
        }
    }

    public void setShowType(int i) {
        this.mShowType = i;
    }

    private float getTransformFraction(int i, float f) {
        switch (i) {
            case 0:
                return f * FACTOR_VIBRATION;
            case 1:
                return (0.26f * f) + FACTOR_VIBRATION;
            case 2:
                return (0.18f * f) + FACTOR_SCALE_OUT;
            default:
                return f;
        }
    }

    private int getSafetyIndex(int i) {
        if (i < 0) {
            return 0;
        }
        return i > this.mMaxLevel ? this.mMaxLevel : i;
    }

    private g getLevelLottieView(long j) {
        if (this.mLottieArray == null || this.mMaxLevel <= 0 || this.mLottieArray.length != this.mMaxLevel + 1) {
            return null;
        }
        g gVar = this.mLottieArray[getSafetyIndex(PraiseLevelUtil.matchPraiseLevel(j).mLevelImgIndex)];
        setScaleType(gVar);
        return gVar;
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        g[] gVarArr;
        if (this.mLottieArray != null && this.mLottieArray.length > 0) {
            for (g gVar : this.mLottieArray) {
                if (gVar != null) {
                    gVar.recycleBitmaps();
                }
            }
        }
    }
}
