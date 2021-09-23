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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
@CoordinatorLayout.c(Behavior.class)
/* loaded from: classes5.dex */
public class AppBarLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40944e;

    /* renamed from: f  reason: collision with root package name */
    public int f40945f;

    /* renamed from: g  reason: collision with root package name */
    public int f40946g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40947h;

    /* renamed from: i  reason: collision with root package name */
    public int f40948i;

    /* renamed from: j  reason: collision with root package name */
    public WindowInsetsCompat f40949j;
    public List<b> k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int[] p;

    /* loaded from: classes5.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Behavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        }
    }

    /* loaded from: classes5.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ScrollingViewBehavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static int Q(AppBarLayout appBarLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, appBarLayout)) == null) {
                CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) appBarLayout.getLayoutParams()).e();
                if (e2 instanceof BaseBehavior) {
                    return ((BaseBehavior) e2).M();
                }
                return 0;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        public float J(View view) {
            InterceptResult invokeL;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view)) == null) {
                if (view instanceof AppBarLayout) {
                    AppBarLayout appBarLayout = (AppBarLayout) view;
                    int totalScrollRange = appBarLayout.getTotalScrollRange();
                    int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                    int Q = Q(appBarLayout);
                    if ((downNestedPreScrollRange == 0 || totalScrollRange + Q > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                        return (Q / i2) + 1.0f;
                    }
                }
                return 0.0f;
            }
            return invokeL.floatValue;
        }

        @Override // com.baidu.live.framework.appbar.HeaderScrollingViewBehavior
        public int L(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
                if (view instanceof AppBarLayout) {
                    return ((AppBarLayout) view).getTotalScrollRange();
                }
                return super.L(view);
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
                for (int i2 = 0; i2 < size; i2++) {
                    View view = list.get(i2);
                    if (view instanceof AppBarLayout) {
                        return (AppBarLayout) view;
                    }
                }
                return null;
            }
            return (AppBarLayout) invokeL.objValue;
        }

        public final void R(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, view, view2) == null) {
                CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) view2.getLayoutParams()).e();
                if (e2 instanceof BaseBehavior) {
                    ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) e2).k) + M()) - I(view2));
                }
            }
        }

        public final void S(View view, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048581, this, view, view2) == null) && (view2 instanceof AppBarLayout)) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.j(view.getScrollY() > 0);
                }
            }
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, coordinatorLayout, view, view2)) == null) ? view2 instanceof AppBarLayout : invokeLLL.booleanValue;
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, coordinatorLayout, view, view2)) == null) {
                R(view, view2);
                S(view, view2);
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, view, rect, Boolean.valueOf(z)})) == null) {
                AppBarLayout H = H(coordinatorLayout.getDependencies(view));
                if (H != null) {
                    rect.offset(view.getLeft(), view.getTop());
                    Rect rect2 = this.f40966d;
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            if (obtainStyledAttributes.hasValue(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop)) {
                O(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements OnApplyWindowInsetsListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppBarLayout f40955a;

        public a(AppBarLayout appBarLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appBarLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40955a = appBarLayout;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, windowInsetsCompat)) == null) {
                this.f40955a.f(windowInsetsCompat);
                return windowInsetsCompat;
            }
            return (WindowInsetsCompat) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c extends b<AppBarLayout> {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i2) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (list = this.k) == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.k.get(i3);
            if (bVar != null) {
                bVar.a(this, i2);
            }
        }
    }

    public void addOnOffsetChangedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            if (bVar == null || this.k.contains(bVar)) {
                return;
            }
            this.k.add(bVar);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40947h : invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (((LayoutParams) getChildAt(i2).getLayoutParams()).c()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getTotalScrollRange() != 0 : invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f40944e = -1;
            this.f40945f = -1;
            this.f40946g = -1;
        }
    }

    public WindowInsetsCompat f(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, windowInsetsCompat)) == null) {
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
            if (!ObjectsCompat.equals(this.f40949j, windowInsetsCompat2)) {
                this.f40949j = windowInsetsCompat2;
                e();
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f40948i = 0;
        }
    }

    public int getDownNestedPreScrollRange() {
        InterceptResult invokeV;
        int topInset;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i2 = this.f40945f;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = layoutParams.f40953a;
                if ((i4 & 5) == 5) {
                    int i5 = i3 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    if ((i4 & 8) != 0) {
                        i3 = i5 + ViewCompat.getMinimumHeight(childAt);
                    } else {
                        if ((i4 & 2) != 0) {
                            topInset = ViewCompat.getMinimumHeight(childAt);
                        } else {
                            topInset = getTopInset();
                        }
                        i3 = i5 + (measuredHeight - topInset);
                    }
                } else if (i3 > 0) {
                    break;
                }
            }
            int max = Math.max(0, i3);
            this.f40945f = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getDownNestedScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int i2 = this.f40946g;
            if (i2 != -1) {
                return i2;
            }
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                int i5 = layoutParams.f40953a;
                if ((i5 & 1) == 0) {
                    break;
                }
                i4 += measuredHeight;
                if ((i5 & 2) != 0) {
                    i4 -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                    break;
                }
                i3++;
            }
            int max = Math.max(0, i4);
            this.f40946g = max;
            return max;
        }
        return invokeV.intValue;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int topInset = getTopInset();
            int minimumHeight = ViewCompat.getMinimumHeight(this);
            if (minimumHeight == 0) {
                int childCount = getChildCount();
                minimumHeight = childCount >= 1 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
                if (minimumHeight == 0) {
                    return getHeight() / 3;
                }
            }
            return (minimumHeight * 2) + topInset;
        }
        return invokeV.intValue;
    }

    public int getPendingAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f40948i : invokeV.intValue;
    }

    @Deprecated
    public float getTargetElevation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @VisibleForTesting
    public final int getTopInset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            WindowInsetsCompat windowInsetsCompat = this.f40949j;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int i2 = this.f40944e;
            if (i2 != -1) {
                return i2;
            }
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i5 = layoutParams.f40953a;
                if ((i5 & 1) == 0) {
                    break;
                }
                i4 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i5 & 2) != 0) {
                    i4 -= ViewCompat.getMinimumHeight(childAt);
                    break;
                }
                i3++;
            }
            int max = Math.max(0, i4 - getTopInset());
            this.f40944e = max;
            return max;
        }
        return invokeV.intValue;
    }

    public int getUpNestedPreScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? getTotalScrollRange() : invokeV.intValue;
    }

    public final void h(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.f40948i = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
            requestLayout();
        }
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            if (this.m != z) {
                this.m = z;
                refreshDrawableState();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean isLiftOnScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            if (this.n != z) {
                this.n = z;
                refreshDrawableState();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            if (this.p == null) {
                this.p = new int[4];
            }
            int[] iArr = this.p;
            int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
            iArr[0] = this.m ? R.attr.state_liftable : -R.attr.state_liftable;
            iArr[1] = (this.m && this.n) ? R.attr.state_lifted : -R.attr.state_lifted;
            iArr[2] = this.m ? R.attr.state_collapsible : -R.attr.state_collapsible;
            iArr[3] = (this.m && this.n) ? R.attr.state_collapsed : -R.attr.state_collapsed;
            return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            e();
            boolean z2 = false;
            this.f40947h = false;
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).b() != null) {
                    this.f40947h = true;
                    break;
                } else {
                    i6++;
                }
            }
            if (this.l) {
                return;
            }
            i((this.o || c()) ? true : true);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            e();
        }
    }

    public void removeOnOffsetChangedListener(b bVar) {
        List<b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) || (list = this.k) == null || bVar == null) {
            return;
        }
        list.remove(bVar);
    }

    public void setExpanded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            setExpanded(z, ViewCompat.isLaidOut(this));
        }
    }

    public void setLiftOnScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.o = z;
        }
    }

    public boolean setLiftable(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048615, this, z)) == null) {
            this.l = true;
            return i(z);
        }
        return invokeZ.booleanValue;
    }

    public boolean setLifted(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) ? j(z) : invokeZ.booleanValue;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            if (i2 == 1) {
                super.setOrientation(i2);
                return;
            }
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048618, this, f2) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        c.a.w.e.a.c.b(this, f2);
    }

    /* loaded from: classes5.dex */
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

        /* loaded from: classes5.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f40950e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f40951f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BaseBehavior f40952g;

            public a(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {baseBehavior, coordinatorLayout, appBarLayout};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40952g = baseBehavior;
                this.f40950e = coordinatorLayout;
                this.f40951f = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    this.f40952g.P(this.f40950e, this.f40951f, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        }

        /* loaded from: classes5.dex */
        public static abstract class b<T extends AppBarLayout> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public abstract boolean a(@NonNull T t);
        }

        public BaseBehavior() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = -1;
        }

        public static boolean W(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) ? (i2 & i3) == i3 : invokeII.booleanValue;
        }

        public static View Y(AppBarLayout appBarLayout, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, appBarLayout, i2)) == null) {
                int abs = Math.abs(i2);
                int childCount = appBarLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = appBarLayout.getChildAt(i3);
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

        public final void S(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int height;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
                int abs = Math.abs(M() - i2);
                float abs2 = Math.abs(f2);
                if (abs2 > 0.0f) {
                    height = Math.round((abs / abs2) * 1000.0f) * 3;
                } else {
                    height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
                }
                T(coordinatorLayout, t, i2, height);
            }
        }

        public final void T(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(1048585, this, coordinatorLayout, t, i2, i3) == null) {
                int M = M();
                if (M == i2) {
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
                    valueAnimator3.setInterpolator(c.a.w.e.a.a.f30511a);
                    this.m.addUpdateListener(new a(this, coordinatorLayout, t));
                } else {
                    valueAnimator2.cancel();
                }
                this.m.setDuration(Math.min(i3, 600));
                this.m.setIntValues(M, i2);
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
                    View view = weakReference.get();
                    return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final boolean V(CoordinatorLayout coordinatorLayout, T t, View view) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, coordinatorLayout, t, view)) == null) ? t.d() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight() : invokeLLL.booleanValue;
        }

        @Nullable
        public final View X(CoordinatorLayout coordinatorLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, coordinatorLayout)) == null) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt instanceof NestedScrollingChild) {
                        return childAt;
                    }
                }
                return null;
            }
            return (View) invokeL.objValue;
        }

        public final int Z(T t, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, t, i2)) == null) {
                int childCount = t.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = t.getChildAt(i3);
                    int top = childAt.getTop();
                    int bottom = childAt.getBottom();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (W(layoutParams.a(), 32)) {
                        top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    int i4 = -i2;
                    if (top <= i4 && bottom >= i4) {
                        return i3;
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

        public final int c0(T t, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, t, i2)) == null) {
                int abs = Math.abs(i2);
                int childCount = t.getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i4 >= childCount) {
                        break;
                    }
                    View childAt = t.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator b2 = layoutParams.b();
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i4++;
                    } else if (b2 != null) {
                        int a2 = layoutParams.a();
                        if ((a2 & 1) != 0) {
                            i3 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((a2 & 2) != 0) {
                                i3 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i3 -= t.getTopInset();
                        }
                        if (i3 > 0) {
                            float f2 = i3;
                            return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation((abs - childAt.getTop()) / f2)));
                        }
                    }
                }
                return i2;
            }
            return invokeLI.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: d0 */
        public void N(CoordinatorLayout coordinatorLayout, T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048593, this, coordinatorLayout, t) == null) {
                o0(coordinatorLayout, t);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.ViewOffsetBehavior, com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: e0 */
        public boolean l(CoordinatorLayout coordinatorLayout, T t, int i2) {
            InterceptResult invokeLLI;
            int round;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, coordinatorLayout, t, i2)) == null) {
                boolean l = super.l(coordinatorLayout, t, i2);
                int pendingAction = t.getPendingAction();
                int i3 = this.n;
                if (i3 >= 0 && (pendingAction & 8) == 0) {
                    View childAt = t.getChildAt(i3);
                    int i4 = -childAt.getBottom();
                    if (this.o) {
                        round = ViewCompat.getMinimumHeight(childAt) + t.getTopInset();
                    } else {
                        round = Math.round(childAt.getHeight() * this.p);
                    }
                    P(coordinatorLayout, t, i4 + round);
                } else if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i5 = -t.getUpNestedPreScrollRange();
                        if (z) {
                            S(coordinatorLayout, t, i5, 0.0f);
                        } else {
                            P(coordinatorLayout, t, i5);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            S(coordinatorLayout, t, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, t, 0);
                        }
                    }
                }
                t.g();
                this.n = -1;
                G(MathUtils.clamp(E(), -t.getTotalScrollRange(), 0));
                q0(coordinatorLayout, t, E(), 0, true);
                t.a(E());
                return l;
            }
            return invokeLLI.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: f0 */
        public boolean m(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) t.getLayoutParams())).height == -2) {
                    coordinatorLayout.onMeasureChild(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
                    return true;
                }
                return super.m(coordinatorLayout, t, i2, i3, i4, i5);
            }
            return invokeCommon.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: g0 */
        public void q(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{coordinatorLayout, t, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) || i3 == 0) {
                return;
            }
            if (i3 < 0) {
                int i7 = -t.getTotalScrollRange();
                i5 = i7;
                i6 = t.getDownNestedPreScrollRange() + i7;
            } else {
                i5 = -t.getUpNestedPreScrollRange();
                i6 = 0;
            }
            if (i5 != i6) {
                iArr[1] = O(coordinatorLayout, t, i3, i5, i6);
                p0(i3, t, view, i4);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: h0 */
        public void s(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{coordinatorLayout, t, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                if (i5 < 0) {
                    O(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
                    p0(i5, t, view, i6);
                }
                if (t.isLiftOnScroll()) {
                    t.j(view.getScrollY() > 0);
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
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = t.getChildAt(i2);
                    int bottom = childAt.getBottom() + E;
                    if (childAt.getTop() + E <= 0 && bottom >= 0) {
                        SavedState savedState = new SavedState(y);
                        savedState.firstVisibleChildIndex = i2;
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
        public boolean A(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            InterceptResult invokeCommon;
            ValueAnimator valueAnimator;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{coordinatorLayout, t, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                boolean z = (i2 & 2) != 0 && (t.isLiftOnScroll() || V(coordinatorLayout, t, view));
                if (z && (valueAnimator = this.m) != null) {
                    valueAnimator.cancel();
                }
                this.q = null;
                this.l = i3;
                return z;
            }
            return invokeCommon.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
        /* renamed from: l0 */
        public void C(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048602, this, coordinatorLayout, t, view, i2) == null) {
                if (this.l == 0 || i2 == 1) {
                    o0(coordinatorLayout, t);
                }
                this.q = new WeakReference<>(view);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.framework.appbar.HeaderBehavior
        /* renamed from: m0 */
        public int Q(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                int M = M();
                int i5 = 0;
                if (i3 != 0 && M >= i3 && M <= i4) {
                    int clamp = MathUtils.clamp(i2, i3, i4);
                    if (M != clamp) {
                        int c0 = t.b() ? c0(t, clamp) : clamp;
                        boolean G = G(c0);
                        i5 = M - clamp;
                        this.k = clamp - c0;
                        if (!G && t.b()) {
                            coordinatorLayout.dispatchDependentViewsChanged(t);
                        }
                        t.a(E());
                        q0(coordinatorLayout, t, clamp, clamp < M ? -1 : 1, false);
                    }
                } else {
                    this.k = 0;
                }
                return i5;
            }
            return invokeCommon.intValue;
        }

        public final boolean n0(CoordinatorLayout coordinatorLayout, T t) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, coordinatorLayout, t)) == null) {
                List<View> dependents = coordinatorLayout.getDependents(t);
                int size = dependents.size();
                for (int i2 = 0; i2 < size; i2++) {
                    CoordinatorLayout.Behavior e2 = ((CoordinatorLayout.e) dependents.get(i2).getLayoutParams()).e();
                    if (e2 instanceof ScrollingViewBehavior) {
                        return ((ScrollingViewBehavior) e2).K() != 0;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public final void o0(CoordinatorLayout coordinatorLayout, T t) {
            int M;
            int Z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048606, this, coordinatorLayout, t) == null) || (Z = Z(t, (M = M()))) < 0) {
                return;
            }
            View childAt = t.getChildAt(Z);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int a2 = layoutParams.a();
            if ((a2 & 17) == 17) {
                int i2 = -childAt.getTop();
                int i3 = -childAt.getBottom();
                if (Z == t.getChildCount() - 1) {
                    i3 += t.getTopInset();
                }
                if (W(a2, 2)) {
                    i3 += ViewCompat.getMinimumHeight(childAt);
                } else if (W(a2, 5)) {
                    int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i3;
                    if (M < minimumHeight) {
                        i2 = minimumHeight;
                    } else {
                        i3 = minimumHeight;
                    }
                }
                if (W(a2, 32)) {
                    i2 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    i3 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                if (M < (i3 + i2) / 2) {
                    i2 = i3;
                }
                S(coordinatorLayout, t, MathUtils.clamp(i2, -t.getTotalScrollRange(), 0), 0.0f);
            }
        }

        public final void p0(int i2, T t, View view, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), t, view, Integer.valueOf(i3)}) == null) && i3 == 1) {
                int M = M();
                if ((i2 >= 0 || M != 0) && (i2 <= 0 || M != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                ViewCompat.stopNestedScroll(view, 1);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void q0(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, boolean z) {
            View Y;
            boolean z2;
            View X;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{coordinatorLayout, t, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) || (Y = Y(t, i2)) == null) {
                return;
            }
            int a2 = ((LayoutParams) Y.getLayoutParams()).a();
            if ((a2 & 1) != 0) {
                int minimumHeight = ViewCompat.getMinimumHeight(Y);
                if (i3 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i2) < (Y.getBottom() - minimumHeight) - t.getTopInset()) : (-i2) >= (Y.getBottom() - minimumHeight) - t.getTopInset()) {
                    z2 = true;
                    if (t.isLiftOnScroll() && (X = X(coordinatorLayout)) != null) {
                        z2 = X.getScrollY() > 0;
                    }
                    boolean j2 = t.j(z2);
                    if (Build.VERSION.SDK_INT < 11) {
                        if (z || (j2 && n0(coordinatorLayout, t))) {
                            t.jumpDrawablesToCurrentState();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            z2 = false;
            if (t.isLiftOnScroll()) {
                z2 = X.getScrollY() > 0;
            }
            boolean j22 = t.j(z2);
            if (Build.VERSION.SDK_INT < 11) {
            }
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
            this.n = -1;
        }

        /* loaded from: classes5.dex */
        public static class SavedState extends AbsSavedState {
            public static /* synthetic */ Interceptable $ic;
            public static final Parcelable.Creator<SavedState> CREATOR;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean firstVisibleChildAtMinimumHeight;
            public int firstVisibleChildIndex;
            public float firstVisibleChildPercentageShown;

            /* loaded from: classes5.dex */
            public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                public a() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                public SavedState[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public void writeToParcel(Parcel parcel, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                    super.writeToParcel(parcel, i2);
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
        this.f40944e = -1;
        this.f40945f = -1;
        this.f40946g = -1;
        this.f40948i = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            c.a.w.e.a.c.a(this);
            c.a.w.e.a.c.c(this, attributeSet, 0, R.style.Widget_Design_AppBarLayout);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_expanded)) {
            h(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_elevation)) {
            c.a.w.e.a.c.b(this, obtainStyledAttributes.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_liftOnScroll)) {
            this.o = obtainStyledAttributes.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        }
        obtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new a(this));
    }

    public void setExpanded(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            h(z, z2, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new LayoutParams(-1, -2) : (LayoutParams) invokeV.objValue;
    }

    public void removeOnOffsetChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, cVar) == null) {
            removeOnOffsetChangedListener((b) cVar);
        }
    }

    public void addOnOffsetChangedListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            addOnOffsetChangedListener((b) cVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, layoutParams)) == null) {
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

    /* loaded from: classes5.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40953a;

        /* renamed from: b  reason: collision with root package name */
        public Interpolator f40954b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
            this.f40953a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f40953a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f40954b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f40953a : invokeV.intValue;
        }

        public Interpolator b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f40954b : (Interpolator) invokeV.objValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f40953a;
                return (i2 & 1) == 1 && (i2 & 10) != 0;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40953a = 1;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f40953a = 1;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.f40953a = 1;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((LinearLayout.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.f40953a = 1;
        }
    }
}
