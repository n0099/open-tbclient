package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenu;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
/* loaded from: classes6.dex */
public class WaveAnimElementEx extends WaveAnimElement {
    private static final boolean DEBUG = false;

    public WaveAnimElementEx(BaseAnimatedElement.ScaleType scaleType, IResourceProvider iResourceProvider) {
        super(null, scaleType);
        IResourcePackage.LottieResource lottie;
        if (iResourceProvider != null && (lottie = iResourceProvider.getLottie("wave", new Object[0])) != null) {
            this.mLottieDrawable = new g();
            this.mLottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.a(lottie.mLottieComposition);
            setScaleType(this.mLottieDrawable);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.WaveAnimElement, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        parseOtherParams(objArr);
        if (this.mLottieDrawable != null) {
            this.mLottieDrawable.setCallback(this.mDrawableCallback);
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, SupportMenu.CATEGORY_MASK);
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Drawable.Callback)) {
            setDrawableCallback((Drawable.Callback) objArr[0]);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.WaveAnimElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }
}
