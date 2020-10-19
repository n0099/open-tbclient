package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.g;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
/* loaded from: classes9.dex */
public class PraiseLevelAnimElementEx extends PraiseLevelAnimElement {
    private static final boolean DEBUG = false;

    public PraiseLevelAnimElementEx(BaseAnimatedElement.ScaleType scaleType, IResourceProvider iResourceProvider) {
        super(null, scaleType);
        if (iResourceProvider != null) {
            this.mMaxLevel = iResourceProvider.getResourceCounts("level");
            if (this.mMaxLevel > 0) {
                this.mLottieArray = new g[this.mMaxLevel + 1];
                for (int i = 0; i <= this.mMaxLevel; i++) {
                    IResourcePackage.LottieResource lottie = iResourceProvider.getLottie("level", Integer.valueOf(i));
                    if (lottie != null) {
                        g gVar = new g();
                        gVar.setImageAssetDelegate(lottie.mImageAssetDelegate);
                        gVar.a(lottie.mLottieComposition);
                        this.mLottieArray[i] = gVar;
                    }
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.PraiseLevelAnimElement, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    protected void onInit(Object... objArr) {
        parseOtherParams(objArr);
        for (int i = 0; i <= this.mMaxLevel; i++) {
            if (this.mLottieArray[i] != null) {
                this.mLottieArray[i].setCallback(this.mDrawableCallback);
            }
        }
        enableDrawDebugBound(false, -16711936);
    }

    private void parseOtherParams(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Drawable.Callback)) {
            setDrawableCallback((Drawable.Callback) objArr[0]);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.PraiseLevelAnimElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
    }
}
