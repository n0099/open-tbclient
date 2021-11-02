package com.baidu.searchbox.ui;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.IResourcePackage;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.resource.PraiseResourceAPSManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CoolPraiseGuideLottieView extends LottieAnimationView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIM_DURATION = 8000;
    public static final int HEIGTH = 145;
    public static final int WIDTH = 145;
    public static IResourcePackage.LottieResource lottieResource;
    public transient /* synthetic */ FieldHolder $fh;
    public AnimatorListenerAdapter mAnimatorListenerAdapter;
    public ValueAnimator mValueAnimator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoolPraiseGuideLottieView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        init(context);
    }

    public static int dip2px(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    private void init(Context context) {
        IResourceProvider provider;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            if (lottieResource == null && (provider = PraiseResourceAPSManager.getInstance().getProvider(PraiseResourceAPSManager.PRAISE_PACKAGE_NAME_FOR_NORMAL)) != null) {
                lottieResource = provider.getPraiseGuideLottie();
            }
            IResourcePackage.LottieResource lottieResource2 = lottieResource;
            if (lottieResource2 != null) {
                setImageAssetDelegate(lottieResource2.mImageAssetDelegate);
                setComposition(lottieResource.mLottieComposition);
                setProgress(0.0f);
            }
        }
    }

    public void cancel() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (valueAnimator = this.mValueAnimator) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public int getRealHeigth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? dip2px(getContext(), 145.0f) : invokeV.intValue;
    }

    public int getRealWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? dip2px(getContext(), 145.0f) : invokeV.intValue;
    }

    public void play() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || lottieResource == null) {
            return;
        }
        setProgress(0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mValueAnimator = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.baidu.searchbox.ui.CoolPraiseGuideLottieView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CoolPraiseGuideLottieView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.this$0.setProgress(valueAnimator.getAnimatedFraction());
                }
            }
        });
        AnimatorListenerAdapter animatorListenerAdapter = this.mAnimatorListenerAdapter;
        if (animatorListenerAdapter != null) {
            this.mValueAnimator.addListener(animatorListenerAdapter);
        }
        this.mValueAnimator.setDuration(8000L);
        this.mValueAnimator.start();
    }

    public void setAnimatorListenerAdapter(AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, animatorListenerAdapter) == null) {
            this.mAnimatorListenerAdapter = animatorListenerAdapter;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoolPraiseGuideLottieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoolPraiseGuideLottieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        init(context);
    }
}
