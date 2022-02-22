package com.baidu.nadcore.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d0.l0.i;
import c.a.d0.l0.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SlideHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_MASK_COLOR = "#40000000";
    public static final String DEFAULT_SHADOW_DRAWABLE = "sliding_layout_shadow.9.png";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canSlide;
    public View mMaskView;
    public SlidingPaneLayout mSlideLayout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlideHelper() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void attachActivity(Activity activity) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            slidingPaneLayout.attachActivity(activity);
        }
    }

    public void attachSlideActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        attachSlideView(activity, activity.findViewById(16908290));
        attachActivity(activity);
    }

    public void attachSlideView(Context context, View view, SlidingPaneLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, context, view, layoutParams) == null) && view != null && this.canSlide) {
            boolean isFocused = view.isFocused();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.removeView(view);
            if (this.mMaskView == null) {
                View view2 = new View(context);
                this.mMaskView = view2;
                view2.setBackgroundColor(Color.parseColor("#40000000"));
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
            this.mSlideLayout = customSlidingPanelLayout;
            customSlidingPanelLayout.setShadowDrawable(r.e(context, "sliding_layout_shadow.9.png"));
            this.mSlideLayout.addView(this.mMaskView, layoutParams2);
            this.mSlideLayout.addView(view, layoutParams2);
            this.mSlideLayout.setSliderFadeColor(0);
            if (layoutParams == null) {
                viewGroup.addView(this.mSlideLayout);
            } else {
                viewGroup.addView(this.mSlideLayout, layoutParams);
            }
            if (isFocused) {
                this.mSlideLayout.requestFocus();
            }
        }
    }

    public void closePane() {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (slidingPaneLayout = this.mSlideLayout) == null) {
            return;
        }
        slidingPaneLayout.closePane();
    }

    public void forceActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            slidingPaneLayout.forceActivityTransparent(z);
        }
    }

    public View getMaskView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMaskView : (View) invokeV.objValue;
    }

    public void setActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            if (z) {
                slidingPaneLayout.convertActivityToTranslucent();
            } else {
                slidingPaneLayout.convertActivityFromTranslucent();
            }
        }
    }

    public void setAutoSlideToRight(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (slidingPaneLayout = this.mSlideLayout) == null) {
            return;
        }
        slidingPaneLayout.setAutoSlideToRight(z);
    }

    public void setCanSlide(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setCanSlidable(z);
        }
    }

    public void setEnableReleaseWhenNoTranslucent(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (slidingPaneLayout = this.mSlideLayout) == null) {
            return;
        }
        slidingPaneLayout.setEnableReleaseWhenNoTranslucent(z);
    }

    public void setFadeColor(int i2) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (slidingPaneLayout = this.mSlideLayout) == null) {
            return;
        }
        slidingPaneLayout.setSliderFadeColor(i2);
    }

    public void setNightMode(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setNightMode(z);
        }
    }

    public void setOnTransparentListener(i iVar) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, iVar) == null) || (slidingPaneLayout = this.mSlideLayout) == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout) || iVar == null) {
            return;
        }
        ((CustomSlidingPanelLayout) slidingPaneLayout).setOnTransparentListener(iVar);
    }

    public void setRegionFactor(double d2) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d2)}) == null) || (slidingPaneLayout = this.mSlideLayout) == null) {
            return;
        }
        slidingPaneLayout.setCanSlideRegionFactor(d2);
    }

    public void setShadowDrawable(Drawable drawable) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) || (slidingPaneLayout = this.mSlideLayout) == null) {
            return;
        }
        slidingPaneLayout.setShadowDrawable(drawable);
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, slideInterceptor) == null) || slideInterceptor == null || (slidingPaneLayout = this.mSlideLayout) == null || !(slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            return;
        }
        ((CustomSlidingPanelLayout) slidingPaneLayout).setSlideInterceptor(slideInterceptor);
    }

    public void setSlideListener(SlidingPaneLayout.e eVar) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) || (slidingPaneLayout = this.mSlideLayout) == null || eVar == null) {
            return;
        }
        slidingPaneLayout.setPanelSlideListener(eVar);
    }

    public void showShadow(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || (slidingPaneLayout = this.mSlideLayout) == null) {
            return;
        }
        slidingPaneLayout.isShowShadow(z);
    }

    public View wrapSlideView(Context context, View view, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, context, view, slideInterceptor)) == null) {
            if (view == null || !this.canSlide) {
                return view;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            if (this.mMaskView == null) {
                View view2 = new View(context);
                this.mMaskView = view2;
                view2.setBackgroundColor(Color.parseColor("#40000000"));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
            this.mSlideLayout = customSlidingPanelLayout;
            customSlidingPanelLayout.setShadowDrawable(r.e(context, "sliding_layout_shadow.9.png"));
            this.mSlideLayout.addView(this.mMaskView, layoutParams);
            this.mSlideLayout.addView(view, layoutParams);
            if (slideInterceptor != null) {
                ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
            }
            return this.mSlideLayout;
        }
        return (View) invokeLLL.objValue;
    }

    public SlideHelper(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.canSlide = true;
        this.canSlide = z;
    }

    public void attachSlideView(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, view) == null) {
            attachSlideView(context, view, null);
        }
    }
}
