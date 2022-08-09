package com.baidu.live.framework.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.t90;
import java.lang.ref.WeakReference;
import java.util.List;
@CoordinatorLayout.c(Behavior.class)
/* loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public WindowInsetsCompat f;
    public List<b> g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int[] l;

    /* loaded from: classes2.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes2.dex */
        public static abstract class a extends BaseBehavior.b<AppBarLayout> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public Behavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Behavior(Context context, AttributeSet attributeSet) {
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
        }
    }

    /* loaded from: classes2.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ScrollingViewBehavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static int Q(AppBarLayout appBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, appBarLayout)) == null) {
                CoordinatorLayout.Behavior e = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).e();
                if (e instanceof BaseBehavior) {
                    return ((BaseBehavior) e).M();
                }
                return 0;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        public float J(View view2) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
                if (view2 instanceof AppBarLayout) {
                    AppBarLayout appBarLayout = (AppBarLayout) view2;
                    int totalScrollRange = appBarLayout.getTotalScrollRange();
                    int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                    int Q = Q(appBarLayout);
                    if ((downNestedPreScrollRange == 0 || totalScrollRange + Q > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                        return (Q / i) + 1.0f;
                    }
                }
                return 0.0f;
            }
            return invokeL.floatValue;
        }

        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        public int L(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
                if (view2 instanceof AppBarLayout) {
                    return ((AppBarLayout) view2).getTotalScrollRange();
                }
                return super.L(view2);
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        /* renamed from: P */
        public AppBarLayout H(List<View> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    View view2 = list.get(i);
                    if (view2 instanceof AppBarLayout) {
                        return (AppBarLayout) view2;
                    }
                }
                return null;
            }
            return (AppBarLayout) invokeL.objValue;
        }

        public final void R(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, view2, view3) == null) {
                CoordinatorLayout.Behavior e = ((CoordinatorLayout.e) view3.getLayoutParams()).e();
                if (e instanceof BaseBehavior) {
                    ViewCompat.offsetTopAndBottom(view2, (((view3.getBottom() - view2.getTop()) + ((BaseBehavior) e).k) + M()) - I(view3));
                }
            }
        }

        public final void S(View view2, View view3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048581, this, view2, view3) == null) && (view3 instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) view3;
                if (appBarLayout.i()) {
                    appBarLayout.n(view2.getScrollY() > 0);
                }
            }
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean e(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, coordinatorLayout, view2, view3)) == null) ? view3 instanceof AppBarLayout : invokeLLL.booleanValue;
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean h(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, coordinatorLayout, view2, view3)) == null) {
                R(view2, view3);
                S(view2, view3);
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean w(CoordinatorLayout coordinatorLayout, View view2, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, view2, rect, Boolean.valueOf(z)})) == null) {
                AppBarLayout H = H(coordinatorLayout.l(view2));
                if (H != null) {
                    rect.offset(view2.getLeft(), view2.getTop());
                    Rect rect2 = this.d;
                    rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                    if (!rect2.contains(rect)) {
                        H.setExpanded(false, !z);
                        return true;
                    }
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040447});
            if (obtainStyledAttributes.hasValue(0)) {
                O(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements OnApplyWindowInsetsListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppBarLayout a;

        public a(AppBarLayout appBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appBarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = appBarLayout;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, windowInsetsCompat)) == null) {
                this.a.j(windowInsetsCompat);
                return windowInsetsCompat;
            }
            return (WindowInsetsCompat) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface b<T extends AppBarLayout> {
        void a(T t, int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppBarLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (list = this.g) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.g.get(i2);
            if (bVar != null) {
                bVar.a(this, i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new LayoutParams(-1, -2) : (LayoutParams) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layoutParams)) == null) {
            if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
                return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }
        return (LayoutParams) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (((LayoutParams) getChildAt(i).getLayoutParams()).c()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? getTotalScrollRange() != 0 : invokeV.booleanValue;
    }

    public int getDownNestedPreScrollRange() {
        InterceptResult invokeV;
        int topInset;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i = this.b;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = layoutParams.a;
                if ((i3 & 5) == 5) {
                    int i4 = i2 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((i3 & 8) != 0) {
                        i2 = i4 + ViewCompat.getMinimumHeight(childAt);
                    } else {
                        if ((i3 & 2) != 0) {
                            topInset = ViewCompat.getMinimumHeight(childAt);
                        } else {
                            topInset = getTopInset();
                        }
                        i2 = i4 + (measuredHeight - topInset);
                    }
                } else if (i2 > 0) {
                    break;
                }
            }
            int max = Math.max(0, i2);
            this.b = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getDownNestedScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i = this.c;
            if (i != -1) {
                return i;
            }
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int i4 = layoutParams.a;
                if ((i4 & 1) == 0) {
                    break;
                }
                i3 += measuredHeight;
                if ((i4 & 2) != 0) {
                    i3 -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                    break;
                }
                i2++;
            }
            int max = Math.max(0, i3);
            this.c = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getPendingAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e : invokeV.intValue;
    }

    @Deprecated
    public float getTargetElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @VisibleForTesting
    public final int getTopInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            WindowInsetsCompat windowInsetsCompat = this.f;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.getSystemWindowInsetTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int getTotalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i = this.a;
            if (i != -1) {
                return i;
            }
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = layoutParams.a;
                if ((i4 & 1) == 0) {
                    break;
                }
                i3 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i4 & 2) != 0) {
                    i3 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
                i2++;
            }
            int max = Math.max(0, i3 - getTopInset());
            this.a = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getUpNestedPreScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? getTotalScrollRange() : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.a = -1;
            this.b = -1;
            this.c = -1;
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public WindowInsetsCompat j(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, windowInsetsCompat)) == null) {
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(this.f, windowInsetsCompat2)) {
                this.f = windowInsetsCompat2;
                h();
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.e = 0;
        }
    }

    public final void l(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
            requestLayout();
        }
    }

    public final boolean m(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            if (this.i != z) {
                this.i = z;
                refreshDrawableState();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            if (this.j != z) {
                this.j = z;
                refreshDrawableState();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            if (this.l == null) {
                this.l = new int[4];
            }
            int[] iArr = this.l;
            int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
            iArr[0] = this.i ? R.attr.obfuscated_res_0x7f040490 : -2130969744;
            iArr[1] = (this.i && this.j) ? R.attr.obfuscated_res_0x7f040491 : -2130969745;
            iArr[2] = this.i ? R.attr.obfuscated_res_0x7f04048f : -2130969743;
            iArr[3] = (this.i && this.j) ? R.attr.obfuscated_res_0x7f04048e : -2130969742;
            return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            h();
            boolean z2 = false;
            this.d = false;
            int childCount = getChildCount();
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    break;
                } else if (((LayoutParams) getChildAt(i5).getLayoutParams()).b() != null) {
                    this.d = true;
                    break;
                } else {
                    i5++;
                }
            }
            if (this.h) {
                return;
            }
            m((this.k || f()) ? true : true);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i, i2) == null) {
            super.onMeasure(i, i2);
            h();
        }
    }

    public void setExpanded(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            l(z, z2, true);
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048608, this, i) == null) && i == 1) {
            super.setOrientation(i);
        }
    }

    @Deprecated
    public void setTargetElevation(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048609, this, f) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        t90.b(this, f);
    }

    /* loaded from: classes2.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int k;
        public int l;
        public ValueAnimator m;
        public int n;
        public boolean o;
        public float p;
        public WeakReference<View> q;
        public b r;

        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CoordinatorLayout a;
            public final /* synthetic */ AppBarLayout b;
            public final /* synthetic */ BaseBehavior c;

            public a(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {baseBehavior, coordinatorLayout, appBarLayout};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = baseBehavior;
                this.a = coordinatorLayout;
                this.b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.c.P(this.a, this.b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes2.dex */
        public static abstract class b<T extends AppBarLayout> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public abstract boolean a(@NonNull T t);
        }

        public BaseBehavior() {
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
            this.n = -1;
        }

        public static boolean W(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) ? (i & i2) == i2 : invokeII.booleanValue;
        }

        public static View Y(AppBarLayout appBarLayout, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, appBarLayout, i)) == null) {
                int abs = Math.abs(i);
                int childCount = appBarLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = appBarLayout.getChildAt(i2);
                    if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                        return childAt;
                    }
                }
                return null;
            }
            return (View) invokeLI.objValue;
        }

        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        public int M() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? E() + this.k : invokeV.intValue;
        }

        public final void S(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i), Float.valueOf(f)}) == null) {
                int abs = Math.abs(M() - i);
                float abs2 = Math.abs(f);
                if (abs2 > 0.0f) {
                    height = Math.round((abs / abs2) * 1000.0f) * 3;
                } else {
                    height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
                }
                T(coordinatorLayout, t, i, height);
            }
        }

        public final void T(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(1048585, this, coordinatorLayout, t, i, i2) == null) {
                int M = M();
                if (M == i) {
                    ValueAnimator valueAnimator = this.m;
                    if (valueAnimator == null || !valueAnimator.isRunning()) {
                        return;
                    }
                    this.m.cancel();
                    return;
                }
                ValueAnimator valueAnimator2 = this.m;
                if (valueAnimator2 == null) {
                    ValueAnimator valueAnimator3 = new ValueAnimator();
                    this.m = valueAnimator3;
                    valueAnimator3.setInterpolator(new DecelerateInterpolator());
                    this.m.addUpdateListener(new a(this, coordinatorLayout, t));
                } else {
                    valueAnimator2.cancel();
                }
                this.m.setDuration(Math.min(i2, 600));
                this.m.setIntValues(M, i);
                this.m.start();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: U */
        public boolean H(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, t)) == null) {
                b bVar = this.r;
                if (bVar != null) {
                    return bVar.a(t);
                }
                WeakReference<View> weakReference = this.q;
                if (weakReference != null) {
                    View view2 = weakReference.get();
                    return (view2 == null || !view2.isShown() || view2.canScrollVertically(-1)) ? false : true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean V(CoordinatorLayout coordinatorLayout, T t, View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, coordinatorLayout, t, view2)) == null) ? t.g() && coordinatorLayout.getHeight() - view2.getHeight() <= t.getHeight() : invokeLLL.booleanValue;
        }

        @Nullable
        public final View X(CoordinatorLayout coordinatorLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, coordinatorLayout)) == null) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    if (childAt instanceof NestedScrollingChild) {
                        return childAt;
                    }
                }
                return null;
            }
            return (View) invokeL.objValue;
        }

        public final int Z(T t, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, t, i)) == null) {
                int childCount = t.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = t.getChildAt(i2);
                    int top = childAt.getTop();
                    int bottom = childAt.getBottom();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (W(layoutParams.a(), 32)) {
                        top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    int i3 = -i;
                    if (top <= i3 && bottom >= i3) {
                        return i2;
                    }
                }
                return -1;
            }
            return invokeLI.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: a0 */
        public int K(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, t)) == null) ? -t.getDownNestedScrollRange() : invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: b0 */
        public int L(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, t)) == null) ? t.getTotalScrollRange() : invokeL.intValue;
        }

        public final int c0(T t, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, t, i)) == null) {
                int abs = Math.abs(i);
                int childCount = t.getChildCount();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = t.getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator b2 = layoutParams.b();
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i3++;
                    } else if (b2 != null) {
                        int a2 = layoutParams.a();
                        if ((a2 & 1) != 0) {
                            i2 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((a2 & 2) != 0) {
                                i2 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i2 -= t.getTopInset();
                        }
                        if (i2 > 0) {
                            float f = i2;
                            return Integer.signum(i) * (childAt.getTop() + Math.round(f * b2.getInterpolation((abs - childAt.getTop()) / f)));
                        }
                    }
                }
                return i;
            }
            return invokeLI.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: d0 */
        public void N(CoordinatorLayout coordinatorLayout, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, coordinatorLayout, t) == null) {
                p0(coordinatorLayout, t);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.ViewOffsetBehavior, com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: e0 */
        public boolean l(CoordinatorLayout coordinatorLayout, T t, int i) {
            InterceptResult invokeLLI;
            int round;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, coordinatorLayout, t, i)) == null) {
                boolean l = super.l(coordinatorLayout, t, i);
                int pendingAction = t.getPendingAction();
                int i2 = this.n;
                if (i2 >= 0 && (pendingAction & 8) == 0) {
                    View childAt = t.getChildAt(i2);
                    int i3 = -childAt.getBottom();
                    if (this.o) {
                        round = ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                    } else {
                        round = Math.round(childAt.getHeight() * this.p);
                    }
                    P(coordinatorLayout, t, i3 + round);
                } else if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i4 = -t.getUpNestedPreScrollRange();
                        if (z) {
                            S(coordinatorLayout, t, i4, 0.0f);
                        } else {
                            P(coordinatorLayout, t, i4);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            S(coordinatorLayout, t, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, t, 0);
                        }
                    }
                }
                t.k();
                this.n = -1;
                G(MathUtils.clamp(E(), -t.getTotalScrollRange(), 0));
                r0(coordinatorLayout, t, E(), 0, true);
                t.a(E());
                return l;
            }
            return invokeLLI.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: f0 */
        public boolean m(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) t.getLayoutParams())).height == -2) {
                    coordinatorLayout.D(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                    return true;
                }
                return super.m(coordinatorLayout, t, i, i2, i3, i4);
            }
            return invokeCommon.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: g0 */
        public void q(CoordinatorLayout coordinatorLayout, T t, View view2, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{coordinatorLayout, t, view2, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3)}) == null) || i2 == 0) {
                return;
            }
            if (i2 < 0) {
                int i6 = -t.getTotalScrollRange();
                i4 = i6;
                i5 = t.getDownNestedPreScrollRange() + i6;
            } else {
                i4 = -t.getUpNestedPreScrollRange();
                i5 = 0;
            }
            if (i4 != i5) {
                iArr[1] = O(coordinatorLayout, t, i2, i4, i5);
                q0(i2, t, view2, i3);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: h0 */
        public void s(CoordinatorLayout coordinatorLayout, T t, View view2, int i, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{coordinatorLayout, t, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                if (i4 < 0) {
                    O(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
                    q0(i4, t, view2, i5);
                }
                if (t.i()) {
                    t.n(view2.getScrollY() > 0);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: i0 */
        public void x(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048598, this, coordinatorLayout, t, parcelable) == null) {
                if (parcelable instanceof SavedState) {
                    SavedState savedState = (SavedState) parcelable;
                    super.x(coordinatorLayout, t, savedState.getSuperState());
                    this.n = savedState.firstVisibleChildIndex;
                    this.p = savedState.firstVisibleChildPercentageShown;
                    this.o = savedState.firstVisibleChildAtMinimumHeight;
                    return;
                }
                super.x(coordinatorLayout, t, parcelable);
                this.n = -1;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: j0 */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, coordinatorLayout, t)) == null) {
                Parcelable y = super.y(coordinatorLayout, t);
                int E = E();
                int childCount = t.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = t.getChildAt(i);
                    int bottom = childAt.getBottom() + E;
                    if (childAt.getTop() + E <= 0 && bottom >= 0) {
                        SavedState savedState = new SavedState(y);
                        savedState.firstVisibleChildIndex = i;
                        savedState.firstVisibleChildAtMinimumHeight = bottom == ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                        savedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                        return savedState;
                    }
                }
                return y;
            }
            return (Parcelable) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: k0 */
        public boolean A(CoordinatorLayout coordinatorLayout, T t, View view2, View view3, int i, int i2) {
            InterceptResult invokeCommon;
            ValueAnimator valueAnimator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{coordinatorLayout, t, view2, view3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                boolean z = (i & 2) != 0 && (t.i() || V(coordinatorLayout, t, view2));
                if (z && (valueAnimator = this.m) != null) {
                    valueAnimator.cancel();
                }
                this.q = null;
                this.l = i2;
                return z;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: l0 */
        public void C(CoordinatorLayout coordinatorLayout, T t, View view2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048602, this, coordinatorLayout, t, view2, i) == null) {
                if (this.l == 0 || i == 1) {
                    p0(coordinatorLayout, t);
                }
                this.q = new WeakReference<>(view2);
            }
        }

        public void m0(@Nullable b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
                this.r = bVar;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: n0 */
        public int Q(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                int M = M();
                int i4 = 0;
                if (i2 != 0 && M >= i2 && M <= i3) {
                    int clamp = MathUtils.clamp(i, i2, i3);
                    if (M != clamp) {
                        int c0 = t.e() ? c0(t, clamp) : clamp;
                        boolean G = G(c0);
                        i4 = M - clamp;
                        this.k = clamp - c0;
                        if (!G && t.e()) {
                            coordinatorLayout.f(t);
                        }
                        t.a(E());
                        r0(coordinatorLayout, t, clamp, clamp < M ? -1 : 1, false);
                    }
                } else {
                    this.k = 0;
                }
                return i4;
            }
            return invokeCommon.intValue;
        }

        public final boolean o0(CoordinatorLayout coordinatorLayout, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, coordinatorLayout, t)) == null) {
                List<View> m = coordinatorLayout.m(t);
                int size = m.size();
                for (int i = 0; i < size; i++) {
                    CoordinatorLayout.Behavior e = ((CoordinatorLayout.e) m.get(i).getLayoutParams()).e();
                    if (e instanceof ScrollingViewBehavior) {
                        return ((ScrollingViewBehavior) e).K() != 0;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public final void p0(CoordinatorLayout coordinatorLayout, T t) {
            int M;
            int Z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048607, this, coordinatorLayout, t) == null) || (Z = Z(t, (M = M()))) < 0) {
                return;
            }
            View childAt = t.getChildAt(Z);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int a2 = layoutParams.a();
            if ((a2 & 17) == 17) {
                int i = -childAt.getTop();
                int i2 = -childAt.getBottom();
                if (Z == t.getChildCount() - 1) {
                    i2 += t.getTopInset();
                }
                if (W(a2, 2)) {
                    i2 += ViewCompat.getMinimumHeight(childAt);
                } else if (W(a2, 5)) {
                    int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i2;
                    if (M < minimumHeight) {
                        i = minimumHeight;
                    } else {
                        i2 = minimumHeight;
                    }
                }
                if (W(a2, 32)) {
                    i += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    i2 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                if (M < (i2 + i) / 2) {
                    i = i2;
                }
                S(coordinatorLayout, t, MathUtils.clamp(i, -t.getTotalScrollRange(), 0), 0.0f);
            }
        }

        public final void q0(int i, T t, View view2, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), t, view2, Integer.valueOf(i2)}) == null) && i2 == 1) {
                int M = M();
                if ((i >= 0 || M != 0) && (i <= 0 || M != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                ViewCompat.stopNestedScroll(view2, 1);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void r0(CoordinatorLayout coordinatorLayout, T t, int i, int i2, boolean z) {
            View Y;
            boolean z2;
            View X;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (Y = Y(t, i)) == null) {
                return;
            }
            int a2 = ((LayoutParams) Y.getLayoutParams()).a();
            if ((a2 & 1) != 0) {
                int minimumHeight = ViewCompat.getMinimumHeight(Y);
                if (i2 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i) < (Y.getBottom() - minimumHeight) - t.getTopInset()) : (-i) >= (Y.getBottom() - minimumHeight) - t.getTopInset()) {
                    z2 = true;
                    if (t.i() && (X = X(coordinatorLayout)) != null) {
                        z2 = X.getScrollY() > 0;
                    }
                    boolean n = t.n(z2);
                    if (!z || (n && o0(coordinatorLayout, t))) {
                        t.jumpDrawablesToCurrentState();
                    }
                    return;
                }
            }
            z2 = false;
            if (t.i()) {
                z2 = X.getScrollY() > 0;
            }
            boolean n2 = t.n(z2);
            if (z) {
            }
            t.jumpDrawablesToCurrentState();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseBehavior(Context context, AttributeSet attributeSet) {
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
            this.n = -1;
        }

        /* loaded from: classes2.dex */
        public static class SavedState extends AbsSavedState {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<SavedState> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;

            /* loaded from: classes2.dex */
            public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public a() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    InterceptResult invokeLL;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: c */
                public SavedState[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
                }
            }

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1111593215, "Lcom/baidu/live/framework/appbar/AppBarLayout$BaseBehavior$SavedState;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1111593215, "Lcom/baidu/live/framework/appbar/AppBarLayout$BaseBehavior$SavedState;");
                        return;
                    }
                }
                CREATOR = new a();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcel, classLoader};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((Parcel) objArr2[0], (ClassLoader) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                    super.writeToParcel(parcel, i);
                    parcel.writeInt(this.firstVisibleChildIndex);
                    parcel.writeFloat(this.firstVisibleChildPercentageShown);
                    parcel.writeByte(this.firstVisibleChildAtMinimumHeight ? (byte) 1 : (byte) 0);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SavedState(Parcelable parcelable) {
                super(parcelable);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {parcelable};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Parcelable) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarLayout(Context context, AttributeSet attributeSet) {
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
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            t90.a(this);
            t90.c(this, attributeSet, 0, R.style.obfuscated_res_0x7f100120);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842964, R.attr.obfuscated_res_0x7f040448, R.attr.obfuscated_res_0x7f040449, R.attr.obfuscated_res_0x7f040481, R.attr.obfuscated_res_0x7f04048c, R.attr.obfuscated_res_0x7f04048d, R.attr.obfuscated_res_0x7f040493, R.attr.obfuscated_res_0x7f040494}, 0, R.style.obfuscated_res_0x7f100120);
        if (obtainStyledAttributes.hasValue(2)) {
            l(obtainStyledAttributes.getBoolean(2, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(1)) {
            t90.b(this, obtainStyledAttributes.getDimensionPixelSize(1, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(3)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(3, false));
            }
            if (obtainStyledAttributes.hasValue(7)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(7, false));
            }
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.k = obtainStyledAttributes.getBoolean(4, false);
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this));
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Interpolator b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04048a, R.attr.obfuscated_res_0x7f04048b});
            this.a = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
        }

        public Interpolator b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (Interpolator) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.a;
                return (i & 1) == 1 && (i & 10) != 0;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.a = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {marginLayoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.a = 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((LinearLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.a = 1;
        }
    }
}
