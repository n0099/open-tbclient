package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
/* loaded from: classes4.dex */
public class WaveAnimElementEx extends WaveAnimElement {
    public static final boolean DEBUG = false;

    @Override // com.baidu.searchbox.ui.animview.praise.element.WaveAnimElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public WaveAnimElementEx(BaseAnimatedElement.ScaleType scaleType, IResourceProvider iResourceProvider) {
        super(null, scaleType);
        IResourcePackage.LottieResource lottie;
        if (iResourceProvider != null && (lottie = iResourceProvider.getLottie("wave", new Object[0])) != null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this.mLottieDrawable = lottieDrawable;
            lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.setComposition(lottie.mLottieComposition);
            setScaleType(this.mLottieDrawable);
        }
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Drawable.Callback)) {
            setDrawableCallback((Drawable.Callback) objArr[0]);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.WaveAnimElement, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        parseOtherParams(objArr);
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.setCallback(this.mDrawableCallback.get());
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -65536);
    }
}
