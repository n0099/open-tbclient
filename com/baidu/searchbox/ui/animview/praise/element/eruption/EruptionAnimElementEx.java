package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes6.dex */
public class EruptionAnimElementEx extends EruptionAnimElement {
    private static final boolean DEBUG = false;

    public EruptionAnimElementEx(int i, BaseAnimatedElement.ScaleType scaleType, IResourceProvider iResourceProvider) {
        super(i, null, scaleType);
        IResourcePackage.LottieResource lottie;
        if (iResourceProvider != null && (lottie = iResourceProvider.getLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, Integer.valueOf(i))) != null) {
            this.mLottieDrawable = new g();
            this.mLottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            this.mLottieDrawable.a(lottie.mLottieComposition);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimElement, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        parseOtherParams(objArr);
        if (this.mLottieDrawable != null) {
            this.mLottieDrawable.setCallback(this.mDrawableCallback);
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -65281);
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Drawable.Callback)) {
            setDrawableCallback((Drawable.Callback) objArr[0]);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }
}
