package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes11.dex */
public class EruptionAnimElement extends BaseAnimatedElement {
    private static final boolean DEBUG = false;
    private Context mCtx;
    private int mEruptionIndex;
    private g mLottieDrawable;
    private int mPivotX;
    private int mPivotY;
    private float mRotateAngle;

    public EruptionAnimElement(Context context, int i, Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mCtx = context;
        this.mEruptionIndex = i;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, Integer.valueOf(this.mEruptionIndex));
        if (lottie != null) {
            this.mLottieDrawable = new g();
            this.mLottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.b(lottie.mLottieComposition);
            this.mLottieDrawable.setCallback(this.mDrawableCallback);
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -65281);
    }

    public void setRotate(float f, int i, int i2) {
        this.mRotateAngle = f;
        this.mPivotX = i;
        this.mPivotY = i2;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void dispatchAnimate(Canvas canvas, float f, long j) {
        if (this.mDrawDebugRect) {
            canvas.save();
            canvas.translate(this.mLeft, this.mTop);
            canvas.rotate(this.mRotateAngle, this.mPivotX, this.mPivotY);
            canvas.drawRect(0.0f, 0.0f, this.mWidth, this.mHeight, this.mDebugPaint);
            canvas.restore();
        }
        canvas.save();
        canvas.translate(this.mLeft, this.mTop);
        canvas.rotate(this.mRotateAngle, this.mPivotX, this.mPivotY);
        if (this.mVisibility) {
            performCanvasDrawMatrix(canvas);
            onDispatchAnimate(canvas, f, j);
        }
        canvas.restore();
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onDispatchAnimate(Canvas canvas, float f, long j) {
        if (this.mLottieDrawable != null) {
            if (this.mInterpolator != null) {
                f = this.mInterpolator.getInterpolation(f);
            }
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
