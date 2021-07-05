package com.baidu.adp.widget.design.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class AppBarLayoutStickyBehavior extends AppBarLayout.Behavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AppBarLayout f2482a;

    /* renamed from: b  reason: collision with root package name */
    public AppBarLayout.OnOffsetChangedListener f2483b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2484c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2485d;

    /* loaded from: classes.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AppBarLayoutStickyBehavior f2486a;

        public a(AppBarLayoutStickyBehavior appBarLayoutStickyBehavior) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appBarLayoutStickyBehavior};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2486a = appBarLayoutStickyBehavior;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) || appBarLayout == null) {
                return;
            }
            if (Math.abs(i2) < appBarLayout.getTotalScrollRange()) {
                this.f2486a.f2484c = false;
            } else if (this.f2486a.f2484c) {
            } else {
                this.f2486a.f2484c = true;
                appBarLayout.setActivated(false);
                appBarLayout.setExpanded(false, false);
            }
        }
    }

    public AppBarLayoutStickyBehavior() {
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
        this.f2484c = false;
        this.f2485d = false;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, appBarLayout) == null) {
            expandedAppBarLayout(appBarLayout, true);
        }
    }

    public boolean isSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2484c : invokeV.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, layoutParams) == null) {
            super.onAttachedToLayoutParams(layoutParams);
            AppBarLayout appBarLayout = this.f2482a;
            if (appBarLayout == null || (onOffsetChangedListener = this.f2483b) == null || this.f2485d) {
                return;
            }
            appBarLayout.addOnOffsetChangedListener(onOffsetChangedListener);
            this.f2485d = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromLayoutParams();
            AppBarLayout appBarLayout = this.f2482a;
            if (appBarLayout == null || (onOffsetChangedListener = this.f2483b) == null || !this.f2485d) {
                return;
            }
            appBarLayout.removeOnOffsetChangedListener(onOffsetChangedListener);
            this.f2485d = false;
        }
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appBarLayout, z) == null) {
            appBarLayout.setActivated(true);
            appBarLayout.setExpanded(true, z);
            this.f2484c = false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
        InterceptResult invokeLLI;
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, coordinatorLayout, appBarLayout, i2)) == null) {
            if (this.f2482a == null) {
                this.f2482a = appBarLayout;
            }
            if (this.f2483b == null) {
                this.f2483b = new a(this);
            }
            AppBarLayout appBarLayout2 = this.f2482a;
            if (appBarLayout2 != null && (onOffsetChangedListener = this.f2483b) != null && !this.f2485d) {
                appBarLayout2.addOnOffsetChangedListener(onOffsetChangedListener);
                this.f2485d = true;
            }
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i2);
        }
        return invokeLLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{coordinatorLayout, appBarLayout, view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            if (this.f2484c) {
                return false;
            }
            return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f2, f3, z);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{coordinatorLayout, appBarLayout, view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f2484c) {
                return false;
            }
            return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, f2, f3);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{coordinatorLayout, appBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) || this.f2484c) {
            return;
        }
        super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2, i3, iArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{coordinatorLayout, appBarLayout, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || this.f2484c) {
            return;
        }
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, i2, i3, i4, i5);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{coordinatorLayout, appBarLayout, view, view2, Integer.valueOf(i2)})) == null) {
            if (this.f2484c) {
                return false;
            }
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view, view2, i2);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarLayoutStickyBehavior(Context context, AttributeSet attributeSet) {
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
        this.f2484c = false;
        this.f2485d = false;
    }
}
