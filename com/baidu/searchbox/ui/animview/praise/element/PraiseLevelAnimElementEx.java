package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes4.dex */
public class PraiseLevelAnimElementEx extends PraiseLevelAnimElement {
    public static final boolean DEBUG = false;

    @Override // com.baidu.searchbox.ui.animview.praise.element.PraiseLevelAnimElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }

    public PraiseLevelAnimElementEx(BaseAnimatedElement.ScaleType scaleType, IResourceProvider iResourceProvider) {
        super(null, scaleType);
        if (iResourceProvider != null) {
            int resourceCounts = iResourceProvider.getResourceCounts("level");
            this.mMaxLevel = resourceCounts;
            if (resourceCounts > 0) {
                this.mLottieArray = new LottieDrawable[resourceCounts + 1];
                for (int i = 0; i <= this.mMaxLevel; i++) {
                    IResourcePackage.LottieResource lottie = iResourceProvider.getLottie("level", Integer.valueOf(i));
                    if (lottie != null) {
                        LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
                        lottieDrawable.setComposition(lottie.mLottieComposition);
                        this.mLottieArray[i] = lottieDrawable;
                    }
                }
            }
        }
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Drawable.Callback)) {
            setDrawableCallback((Drawable.Callback) objArr[0]);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.PraiseLevelAnimElement, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        parseOtherParams(objArr);
        for (int i = 0; i <= this.mMaxLevel; i++) {
            LottieDrawable[] lottieDrawableArr = this.mLottieArray;
            if (lottieDrawableArr != null && lottieDrawableArr[i] != null) {
                lottieDrawableArr[i].setCallback(this.mDrawableCallback.get());
            }
        }
        enableDrawDebugBound(false, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
    }
}
