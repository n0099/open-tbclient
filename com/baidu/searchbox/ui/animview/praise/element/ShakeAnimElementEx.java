package com.baidu.searchbox.ui.animview.praise.element;

import android.graphics.drawable.Drawable;
import com.airbnb.lottie.LottieDrawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ShakeAnimElementEx extends ShakeAnimElement {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG = false;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShakeAnimElementEx(BaseAnimatedElement.ScaleType scaleType, IResourceProvider iResourceProvider) {
        super(null, scaleType);
        IResourcePackage.LottieResource lottie;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {scaleType, iResourceProvider};
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
        if (iResourceProvider == null || (lottie = iResourceProvider.getLottie("shake", new Object[0])) == null) {
            return;
        }
        LottieDrawable lottieDrawable = new LottieDrawable();
        this.mLottieDrawable = lottieDrawable;
        lottieDrawable.setImageAssetDelegate(lottie.mImageAssetDelegate);
        this.mLottieDrawable.setComposition(lottie.mLottieComposition);
    }

    private void parseOtherParams(Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, objArr) == null) || objArr == null || objArr.length <= 0 || !(objArr[0] instanceof Drawable.Callback)) {
            return;
        }
        setDrawableCallback((Drawable.Callback) objArr[0]);
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.ShakeAnimElement, com.baidu.searchbox.ui.animview.base.BaseAnimatedElement
    public void onInit(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, objArr) == null) {
            parseOtherParams(objArr);
            LottieDrawable lottieDrawable = this.mLottieDrawable;
            if (lottieDrawable != null) {
                lottieDrawable.setCallback(this.mDrawableCallback);
                setScaleType(this.mLottieDrawable);
            }
            enableDrawDebugBound(false, -256);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.element.ShakeAnimElement, com.baidu.searchbox.ui.animview.base.IAnimatedElement
    public void releaseResouces() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }
}
