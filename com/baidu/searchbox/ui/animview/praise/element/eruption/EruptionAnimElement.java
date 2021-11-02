package com.baidu.searchbox.ui.animview.praise.element.eruption;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class EruptionAnimElement extends BaseAnimatedElement {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;
    public int mEruptionIndex;
    public LottieDrawable mLottieDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EruptionAnimElement(int i2, Drawable.Callback callback, BaseAnimatedElement.ScaleType scaleType) {
        super(callback, scaleType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), callback, scaleType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Drawable.Callback) objArr2[0], (BaseAnimatedElement.ScaleType) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEruptionIndex = i2;
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onDispatchAnimate(Canvas canvas, float f2, long j) {
        LottieDrawable lottieDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Float.valueOf(f2), Long.valueOf(j)}) == null) || (lottieDrawable = this.mLottieDrawable) == null) {
            return;
        }
        lottieDrawable.setProgress(f2);
        this.mLottieDrawable.draw(canvas);
    }

    @Override // com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr) == null) {
            IResourcePackage.LottieResource lottie = this.mResourceProvider.getLottie(ComboPraiseProvider.RES_KEY_SUFFIX_ERUPTION, Integer.valueOf(this.mEruptionIndex));
            if (lottie != null) {
                LottieDrawable lottieDrawable = new LottieDrawable();
                this.mLottieDrawable = lottieDrawable;
                lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
                this.mLottieDrawable.setComposition(lottie.mLottieComposition);
                this.mLottieDrawable.setCallback(this.mDrawableCallback);
                setScaleType(this.mLottieDrawable);
            }
            enableDrawDebugBound(false, -65281);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
