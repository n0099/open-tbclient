package com.baidu.adp.widget.design.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
    public AppBarLayout a;
    public AppBarLayout.OnOffsetChangedListener b;
    public boolean c;
    public boolean d;

    /* loaded from: classes.dex */
    public class a implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppBarLayoutStickyBehavior a;

        public a(AppBarLayoutStickyBehavior appBarLayoutStickyBehavior) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appBarLayoutStickyBehavior};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = appBarLayoutStickyBehavior;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, appBarLayout, i) != null) || appBarLayout == null) {
                return;
            }
            if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
                if (this.a.c) {
                    return;
                }
                this.a.c = true;
                appBarLayout.setActivated(false);
                appBarLayout.setExpanded(false, false);
                return;
            }
            this.a.c = false;
        }
    }

    public AppBarLayoutStickyBehavior() {
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
        this.c = false;
        this.d = false;
    }

    public boolean isSticky() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromLayoutParams();
            AppBarLayout appBarLayout = this.a;
            if (appBarLayout != null && (onOffsetChangedListener = this.b) != null && this.d) {
                appBarLayout.removeOnOffsetChangedListener(onOffsetChangedListener);
                this.d = false;
            }
        }
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
        this.c = false;
        this.d = false;
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, appBarLayout) == null) {
            expandedAppBarLayout(appBarLayout, true);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, layoutParams) == null) {
            super.onAttachedToLayoutParams(layoutParams);
            AppBarLayout appBarLayout = this.a;
            if (appBarLayout != null && (onOffsetChangedListener = this.b) != null && !this.d) {
                appBarLayout.addOnOffsetChangedListener(onOffsetChangedListener);
                this.d = true;
            }
        }
    }

    public void expandedAppBarLayout(AppBarLayout appBarLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, appBarLayout, z) == null) {
            appBarLayout.setActivated(true);
            appBarLayout.setExpanded(true, z);
            this.c = false;
        }
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view2, @NonNull MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(coordinatorLayout, view2, motionEvent);
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view2, @NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(coordinatorLayout, view2, motionEvent);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
        InterceptResult invokeLLI;
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, coordinatorLayout, appBarLayout, i)) == null) {
            if (this.a == null) {
                this.a = appBarLayout;
            }
            if (this.b == null) {
                this.b = new a(this);
            }
            AppBarLayout appBarLayout2 = this.a;
            if (appBarLayout2 != null && (onOffsetChangedListener = this.b) != null && !this.d) {
                appBarLayout2.addOnOffsetChangedListener(onOffsetChangedListener);
                this.d = true;
            }
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i);
        }
        return invokeLLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view2, float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{coordinatorLayout, appBarLayout, view2, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (this.c) {
                return false;
            }
            return super.onNestedFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view2, f, f2, z);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view2, int i, int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048589, this, new Object[]{coordinatorLayout, appBarLayout, view2, Integer.valueOf(i), Integer.valueOf(i2), iArr}) != null) || this.c) {
            return;
        }
        super.onNestedPreScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view2, i, i2, iArr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{coordinatorLayout, appBarLayout, view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (this.c) {
                return false;
            }
            return super.onNestedPreFling(coordinatorLayout, (CoordinatorLayout) appBarLayout, view2, f, f2);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view2, View view3, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{coordinatorLayout, appBarLayout, view2, view3, Integer.valueOf(i)})) == null) {
            if (this.c) {
                return false;
            }
            return super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view2, view3, i);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{coordinatorLayout, appBarLayout, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) != null) || this.c) {
            return;
        }
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) appBarLayout, view2, i, i2, i3, i4);
    }
}
