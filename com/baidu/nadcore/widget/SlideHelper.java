package com.baidu.nadcore.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.SlidingPaneLayout;
import com.baidu.tieba.h71;
import com.baidu.tieba.j71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void closePane() {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (slidingPaneLayout = this.mSlideLayout) != null) {
            slidingPaneLayout.o();
        }
    }

    public View getMaskView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mMaskView;
        }
        return (View) invokeV.objValue;
    }

    public SlideHelper(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.canSlide = true;
        this.canSlide = z;
    }

    public void attachActivity(Activity activity) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            slidingPaneLayout.m(activity);
        }
    }

    public void attachSlideActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null) {
            attachSlideView(activity, activity.findViewById(16908290));
            attachActivity(activity);
        }
    }

    public void forceActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            slidingPaneLayout.w(z);
        }
    }

    public void setActivityTransparent(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            if (z) {
                slidingPaneLayout.r();
            } else {
                slidingPaneLayout.q();
            }
        }
    }

    public void setAutoSlideToRight(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null) {
            slidingPaneLayout.setAutoSlideToRight(z);
        }
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
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null) {
            slidingPaneLayout.setEnableReleaseWhenNoTranslucent(z);
        }
    }

    public void setFadeColor(int i) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (slidingPaneLayout = this.mSlideLayout) != null) {
            slidingPaneLayout.setSliderFadeColor(i);
        }
    }

    public void setNightMode(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setNightMode(z);
        }
    }

    public void setOnTransparentListener(h71 h71Var) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, h71Var) == null) && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout) && h71Var != null) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setOnTransparentListener(h71Var);
        }
    }

    public void setRegionFactor(double d) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Double.valueOf(d)}) == null) && (slidingPaneLayout = this.mSlideLayout) != null) {
            slidingPaneLayout.setCanSlideRegionFactor(d);
        }
    }

    public void setShadowDrawable(Drawable drawable) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, drawable) == null) && (slidingPaneLayout = this.mSlideLayout) != null) {
            slidingPaneLayout.setShadowDrawable(drawable);
        }
    }

    public void setSlideInterceptor(SlideInterceptor slideInterceptor) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, slideInterceptor) == null) && slideInterceptor != null && (slidingPaneLayout = this.mSlideLayout) != null && (slidingPaneLayout instanceof CustomSlidingPanelLayout)) {
            ((CustomSlidingPanelLayout) slidingPaneLayout).setSlideInterceptor(slideInterceptor);
        }
    }

    public void setSlideListener(SlidingPaneLayout.e eVar) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) && (slidingPaneLayout = this.mSlideLayout) != null && eVar != null) {
            slidingPaneLayout.setPanelSlideListener(eVar);
        }
    }

    public void showShadow(boolean z) {
        SlidingPaneLayout slidingPaneLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (slidingPaneLayout = this.mSlideLayout) != null) {
            slidingPaneLayout.A(z);
        }
    }

    public void attachSlideView(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, view2) == null) {
            attachSlideView(context, view2, null);
        }
    }

    public void attachSlideView(Context context, View view2, SlidingPaneLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, context, view2, layoutParams) == null) && view2 != null && this.canSlide) {
            boolean isFocused = view2.isFocused();
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            viewGroup.removeView(view2);
            if (this.mMaskView == null) {
                View view3 = new View(context);
                this.mMaskView = view3;
                view3.setBackgroundColor(Color.parseColor("#40000000"));
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
            this.mSlideLayout = customSlidingPanelLayout;
            customSlidingPanelLayout.setShadowDrawable(j71.e(context, "sliding_layout_shadow.9.png"));
            this.mSlideLayout.addView(this.mMaskView, layoutParams2);
            this.mSlideLayout.addView(view2, layoutParams2);
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

    public View wrapSlideView(Context context, View view2, SlideInterceptor slideInterceptor) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, context, view2, slideInterceptor)) == null) {
            if (view2 != null && this.canSlide) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                if (this.mMaskView == null) {
                    View view3 = new View(context);
                    this.mMaskView = view3;
                    view3.setBackgroundColor(Color.parseColor("#40000000"));
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                CustomSlidingPanelLayout customSlidingPanelLayout = new CustomSlidingPanelLayout(context);
                this.mSlideLayout = customSlidingPanelLayout;
                customSlidingPanelLayout.setShadowDrawable(j71.e(context, "sliding_layout_shadow.9.png"));
                this.mSlideLayout.addView(this.mMaskView, layoutParams);
                this.mSlideLayout.addView(view2, layoutParams);
                if (slideInterceptor != null) {
                    ((CustomSlidingPanelLayout) this.mSlideLayout).setSlideInterceptor(slideInterceptor);
                }
                return this.mSlideLayout;
            }
            return view2;
        }
        return (View) invokeLLL.objValue;
    }
}
