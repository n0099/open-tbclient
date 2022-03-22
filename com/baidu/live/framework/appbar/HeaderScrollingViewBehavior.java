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
/* loaded from: classes4.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final Rect f25821d;

    /* renamed from: e  reason: collision with root package name */
    public final Rect f25822e;

    /* renamed from: f  reason: collision with root package name */
    public int f25823f;

    /* renamed from: g  reason: collision with root package name */
    public int f25824g;

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
        this.f25821d = new Rect();
        this.f25822e = new Rect();
        this.f25823f = 0;
    }

    public static int N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 0 ? BadgeDrawable.TOP_START : i : invokeI.intValue;
    }

    @Override // com.baidu.live.framework.appbar.ViewOffsetBehavior
    public void F(CoordinatorLayout coordinatorLayout, View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048576, this, coordinatorLayout, view, i) == null) {
            View H = H(coordinatorLayout.l(view));
            if (H != null) {
                CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
                Rect rect = this.f25821d;
                rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
                WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
                if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                    rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                    rect.right -= lastWindowInsets.getSystemWindowInsetRight();
                }
                Rect rect2 = this.f25822e;
                GravityCompat.apply(N(eVar.f25835c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
                int I = I(H);
                view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
                this.f25823f = rect2.top - H.getBottom();
                return;
            }
            super.F(coordinatorLayout, view, i);
            this.f25823f = 0;
        }
    }

    public abstract View H(List<View> list);

    public final int I(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            if (this.f25824g == 0) {
                return 0;
            }
            float J = J(view);
            int i = this.f25824g;
            return MathUtils.clamp((int) (J * i), 0, i);
        }
        return invokeL.intValue;
    }

    public float J(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view)) == null) {
            return 1.0f;
        }
        return invokeL.floatValue;
    }

    public final int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25824g : invokeV.intValue;
    }

    public int L(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) ? view.getMeasuredHeight() : invokeL.intValue;
    }

    public final int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f25823f : invokeV.intValue;
    }

    public final void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f25824g = i;
        }
    }

    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        View H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            int i5 = view.getLayoutParams().height;
            if ((i5 == -1 || i5 == -2) && (H = H(coordinatorLayout.l(view))) != null) {
                if (ViewCompat.getFitsSystemWindows(H) && !ViewCompat.getFitsSystemWindows(view)) {
                    ViewCompat.setFitsSystemWindows(view, true);
                    if (ViewCompat.getFitsSystemWindows(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = View.MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.D(view, i, i2, View.MeasureSpec.makeMeasureSpec((size - H.getMeasuredHeight()) + L(H), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
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
        this.f25821d = new Rect();
        this.f25822e = new Rect();
        this.f25823f = 0;
    }
}
