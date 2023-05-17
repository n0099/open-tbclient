package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.ui.animview.util.DebugUtil;
/* loaded from: classes4.dex */
public class EruptionAnimElementEx extends EruptionAnimElement {
    public static final boolean DEBUG = false;

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public EruptionAnimElementEx(int i, BaseAnimatedElement.ScaleType scaleType, IResourceProvider iResourceProvider) {
        super(i, null, scaleType);
        IResourcePackage.LottieResource lottie;
        if (iResourceProvider != null && (lottie = iResourceProvider.getLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, Integer.valueOf(i))) != null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this.mLottieDrawable = lottieDrawable;
            lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
            try {
                this.mLottieDrawable.setComposition(lottie.mLottieComposition);
            } catch (Exception e) {
                if (DebugUtil.isApkInDebug()) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Drawable.Callback)) {
            setDrawableCallback((Drawable.Callback) objArr[0]);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.eruption.EruptionAnimElement, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        parseOtherParams(objArr);
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.setCallback(this.mDrawableCallback.get());
            setScaleType(this.mLottieDrawable);
        }
        enableDrawDebugBound(false, -65281);
    }
}
