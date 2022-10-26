package com.baidu.live.framework.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Rect d;
    public final Rect e;
    public int f;
    public int g;

    public static int N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 0 ? BadgeDrawable.TOP_START : i : invokeI.intValue;
    }

    public abstract View H(List list);

    public float J(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            return 1.0f;
        }
        return invokeL.floatValue;
    }

    public HeaderScrollingViewBehavior() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new Rect();
        this.e = new Rect();
        this.f = 0;
    }

    @Override // com.baidu.live.framework.appbar.ViewOffsetBehavior
    public void F(CoordinatorLayout coordinatorLayout, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, coordinatorLayout, view2, i) == null) {
            View H = H(coordinatorLayout.l(view2));
            if (H != null) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) view2.getLayoutParams();
                Rect rect = this.d;
                rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
                WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
                if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view2)) {
                    rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                    rect.right -= lastWindowInsets.getSystemWindowInsetRight();
                }
                Rect rect2 = this.e;
                GravityCompat.apply(N(eVar.c), view2.getMeasuredWidth(), view2.getMeasuredHeight(), rect, rect2, i);
                int I = I(H);
                view2.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
                this.f = rect2.top - H.getBottom();
                return;
            }
            super.F(coordinatorLayout, view2, i);
            this.f = 0;
        }
    }

    public final int I(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            if (this.g == 0) {
                return 0;
            }
            float J = J(view2);
            int i = this.g;
            return MathUtils.clamp((int) (J * i), 0, i);
        }
        return invokeL.intValue;
    }

    public int L(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            return view2.getMeasuredHeight();
        }
        return invokeL.intValue;
    }

    public final void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.g = i;
        }
    }

    public final int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, View view2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        View H;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int i6 = view2.getLayoutParams().height;
            if ((i6 == -1 || i6 == -2) && (H = H(coordinatorLayout.l(view2))) != null) {
                if (ViewCompat.getFitsSystemWindows(H) && !ViewCompat.getFitsSystemWindows(view2)) {
                    ViewCompat.setFitsSystemWindows(view2, true);
                    if (ViewCompat.getFitsSystemWindows(view2)) {
                        view2.requestLayout();
                        return true;
                    }
                }
                int size = View.MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                int measuredHeight = (size - H.getMeasuredHeight()) + L(H);
                if (i6 == -1) {
                    i5 = 1073741824;
                } else {
                    i5 = Integer.MIN_VALUE;
                }
                coordinatorLayout.D(view2, i, i2, View.MeasureSpec.makeMeasureSpec(measuredHeight, i5), i4);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
