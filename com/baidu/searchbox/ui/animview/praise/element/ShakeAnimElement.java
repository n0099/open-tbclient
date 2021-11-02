package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ShakeAnimElement extends BaseAnimatedElement {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final float FACTOR_SHAKE = 0.6f;
    public static final int TYPE_SCALE_IN = 0;
    public static final int TYPE_SHAKE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public LottieDrawable mLottieDrawable;
    public int mShowType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShakeAnimElement(Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
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

    private float getTransformFraction(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) ? i2 != 0 ? i2 != 1 ? f2 : (f2 * 0.39999998f) + 0.6f : f2 * 0.6f : invokeCommon.floatValue;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f2, long j) {
        LottieDrawable lottieDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f2), Long.valueOf(j)}) == null) || (lottieDrawable = this.mLottieDrawable) == null) {
            return;
        }
        lottieDrawable.setProgress(getTransformFraction(this.mShowType, f2));
        this.mLottieDrawable.draw(canvas);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie("shake", new Object[0]);
            if (lottie != null) {
                LottieDrawable lottieDrawable = new LottieDrawable();
                this.mLottieDrawable = lottieDrawable;
                lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
                this.mLottieDrawable.setComposition(lottie.mLottieComposition);
                this.mLottieDrawable.setCallback(this.mDrawableCallback);
                setScaleType(this.mLottieDrawable);
            }
            enableDrawDebugBound(false, -256);
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
