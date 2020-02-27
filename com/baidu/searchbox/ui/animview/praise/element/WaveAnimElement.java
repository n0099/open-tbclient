package com.baidu.searchbox.ui.animview.praise.element;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenu;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
/* loaded from: classes13.dex */
public class WaveAnimElement extends BaseAnimatedElement {
    private static final boolean DEBUG = false;
    private Context mCtx;
    private g mLottieDrawable;

    public WaveAnimElement(Context context, Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        this.mCtx = context;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie("wave", new Object[0]);
        if (lottie != null) {
            this.mLottieDrawable = new g();
            this.mLottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.a(lottie.mLottieComposition);
            this.mLottieDrawable.setCallback(this.mDrawableCallback);
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, SupportMenu.CATEGORY_MASK);
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
