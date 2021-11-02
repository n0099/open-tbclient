package com.baidu.tbadk.core.view.slideLoadingLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class LottieSlideLoadingLayout extends BaseSlideLoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public static final int w;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;
    public ContinuousAnimationView mLoadingLottieView;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2113301514, "Lcom/baidu/tbadk/core/view/slideLoadingLayout/LottieSlideLoadingLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2113301514, "Lcom/baidu/tbadk/core/view/slideLoadingLayout/LottieSlideLoadingLayout;");
                return;
            }
        }
        v = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds230);
        w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        x = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds144);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LottieSlideLoadingLayout(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? v : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingPointToBottomDistance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? w : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public int getLoadingVewMaxHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? x : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void initLoadingView(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, frameLayout) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.uni_slide_loading_view, (ViewGroup) frameLayout, true);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) frameLayout.findViewById(R.id.loading_lottie_view);
            this.mLoadingLottieView = continuousAnimationView;
            continuousAnimationView.setMinAndMaxProgress(0.0f, 1.0f);
            this.mLoadingLottieView.setSpeed(1.3f);
            this.mLoadingLottieView.setAnimation(R.raw.lottie_frs_refresh);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToLoadingPointEnd(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mLoadingLottieView.setMinAndMaxFrame(19, 42);
            this.mLoadingLottieView.loop(true);
            this.mLoadingLottieView.playAnimation();
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToLoadingPointStart(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToLoadingPointUpdate(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToTopEnd(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mLoadingLottieView.cancelAnimation();
            this.mLoadingLottieView.setFrame(0);
            this.mLoadingLottieView.setMinAndMaxProgress(0.0f, 1.0f);
            this.mLoadingLottieView.setAlpha(1.0f);
            this.mLoadingLottieView.loop(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToTopStart(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onAnimToTopUpdate(int i2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.mLoadingLottieView.setAlpha((float) ((1.0f - f3) * 0.3d));
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onFingerDrag(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mLoadingLottieView.setAlpha(f2);
            this.mLoadingLottieView.setFrame((int) (f2 * 10.0f));
        }
    }

    @Override // com.baidu.tbadk.core.view.slideLoadingLayout.BaseSlideLoadingLayout
    public void onFingerDragEnd(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (f2 < getLoadingPointRatio()) {
                loadingViewScrollToTop();
            } else {
                startLoading();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LottieSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieSlideLoadingLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }
}
