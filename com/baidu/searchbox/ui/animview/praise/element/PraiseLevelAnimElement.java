package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.searchbox.ui.animview.util.PraiseLevelUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
/* loaded from: classes7.dex */
public class PraiseLevelAnimElement extends BaseAnimatedElement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final float FACTOR_SCALE_OUT = 0.82f;
    public static final float FACTOR_VIBRATION = 0.56f;
    public static final int TYPE_SCALE_IN = 0;
    public static final int TYPE_SCALE_OUT = 2;
    public static final int TYPE_VIBRATION = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public LottieDrawable[] mLottieArray;
    public int mMaxLevel;
    public int mShowType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PraiseLevelAnimElement(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback, scaleType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable.Callback) objArr2[0], (BaseAnimatedElement.ScaleType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShowType = -1;
    }

    private LottieDrawable getLevelLottieView(long j) {
        InterceptResult invokeJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
            LottieDrawable[] lottieDrawableArr = this.mLottieArray;
            if (lottieDrawableArr == null || (i2 = this.mMaxLevel) <= 0 || lottieDrawableArr.length != i2 + 1) {
                return null;
            }
            LottieDrawable lottieDrawable = this.mLottieArray[getSafetyIndex(PraiseLevelUtil.matchPraiseLevel(j).mLevelImgIndex)];
            setScaleType(lottieDrawable);
            return lottieDrawable;
        }
        return (LottieDrawable) invokeJ.objValue;
    }

    private int getSafetyIndex(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (i2 < 0) {
                return 0;
            }
            int i3 = this.mMaxLevel;
            return i2 > i3 ? i3 : i2;
        }
        return invokeI.intValue;
    }

    private float getTransformFraction(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? f2 : (f2 * 0.18f) + 0.82f : (f2 * 0.26f) + 0.56f : f2 * 0.56f : invokeCommon.floatValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f2, long j) {
        LottieDrawable levelLottieView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f2), Long.valueOf(j)}) == null) || (levelLottieView = getLevelLottieView(j)) == null) {
            return;
        }
        levelLottieView.setProgress(getTransformFraction(this.mShowType, f2));
        levelLottieView.draw(canvas);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            int resourceCounts = this.mResourceProvider.getResourceCounts(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
            this.mMaxLevel = resourceCounts;
            if (resourceCounts > 0) {
                this.mLottieArray = new LottieDrawable[resourceCounts + 1];
                for (int i2 = 0; i2 <= this.mMaxLevel; i2++) {
                    IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, Integer.valueOf(i2));
                    if (lottie != null) {
                        LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
                        lottieDrawable.setComposition(lottie.mLottieComposition);
                        lottieDrawable.setCallback(this.mDrawableCallback);
                        this.mLottieArray[i2] = lottieDrawable;
                    }
                }
            }
            enableDrawDebugBound(false, DebugControllerOverlayDrawable.TEXT_COLOR_IMAGE_OK);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void setShowType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.mShowType = i2;
        }
    }
}
