package com.baidu.live.framework.coordinatorlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.framework.appbar.AppBarLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<Map<String, Constructor<Behavior>>> A;
    public static final Comparator<View> B;
    public static final Pools.Pool<Rect> C;
    public static final String y;
    public static final Class<?>[] z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f35406e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.w.e.b.a<View> f35407f;

    /* renamed from: g  reason: collision with root package name */
    public final List<View> f35408g;

    /* renamed from: h  reason: collision with root package name */
    public final List<View> f35409h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f35410i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f35411j;

    /* renamed from: k  reason: collision with root package name */
    public final int[] f35412k;
    public boolean l;
    public boolean m;
    public int[] n;
    public View o;
    public View p;
    public f q;
    public boolean r;
    public WindowInsetsCompat s;
    public boolean t;
    public Drawable u;
    public ViewGroup.OnHierarchyChangeListener v;
    public OnApplyWindowInsetsListener w;
    public final NestedScrollingParentHelper x;

    /* loaded from: classes8.dex */
    public static abstract class Behavior<V extends View> {
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

        public boolean A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{coordinatorLayout, v, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                if (i3 == 0) {
                    return z(coordinatorLayout, v, view, view2, i2);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Deprecated
        public void B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, v, view) == null) {
            }
        }

        public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, coordinatorLayout, v, view, i2) == null) && i2 == 0) {
                B(coordinatorLayout, v, view);
            }
        }

        public boolean D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, coordinatorLayout, v, motionEvent)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, coordinatorLayout, v)) == null) ? d(coordinatorLayout, v) > 0.0f : invokeLL.booleanValue;
        }

        public boolean b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, coordinatorLayout, v, rect)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @ColorInt
        public int c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, coordinatorLayout, v)) == null) {
                return -16777216;
            }
            return invokeLL.intValue;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, coordinatorLayout, v)) == null) {
                return 0.0f;
            }
            return invokeLL.floatValue;
        }

        public boolean e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, coordinatorLayout, v, view)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @NonNull
        public WindowInsetsCompat f(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull WindowInsetsCompat windowInsetsCompat) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, coordinatorLayout, v, windowInsetsCompat)) == null) ? windowInsetsCompat : (WindowInsetsCompat) invokeLLL.objValue;
        }

        public void g(@NonNull e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            }
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, coordinatorLayout, v, view)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public void i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, coordinatorLayout, v, view) == null) {
            }
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        public boolean k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, coordinatorLayout, v, motionEvent)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public boolean l(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048591, this, coordinatorLayout, v, i2)) == null) {
                return false;
            }
            return invokeLLI.booleanValue;
        }

        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i3, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{coordinatorLayout, v, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{coordinatorLayout, v, view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean o(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{coordinatorLayout, v, view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Deprecated
        public void p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{coordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            }
        }

        public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{coordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) && i4 == 0) {
                p(coordinatorLayout, v, view, i2, i3, iArr);
            }
        }

        @Deprecated
        public void r(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{coordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            }
        }

        @Deprecated
        public void s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{coordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) && i6 == 0) {
                r(coordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        public void t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{coordinatorLayout, v, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), iArr}) == null) {
                iArr[0] = iArr[0] + i4;
                iArr[1] = iArr[1] + i5;
                s(coordinatorLayout, v, view, i2, i3, i4, i5, i6);
            }
        }

        @Deprecated
        public void u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{coordinatorLayout, v, view, view2, Integer.valueOf(i2)}) == null) {
            }
        }

        public void v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{coordinatorLayout, v, view, view2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && i3 == 0) {
                u(coordinatorLayout, v, view, view2, i2);
            }
        }

        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{coordinatorLayout, v, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048603, this, coordinatorLayout, v, parcelable) == null) {
            }
        }

        @Nullable
        public Parcelable y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, coordinatorLayout, v)) == null) ? View.BaseSavedState.EMPTY_STATE : (Parcelable) invokeLL.objValue;
        }

        @Deprecated
        public boolean z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{coordinatorLayout, v, view, view2, Integer.valueOf(i2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements OnApplyWindowInsetsListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoordinatorLayout a;

        public a(CoordinatorLayout coordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coordinatorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coordinatorLayout;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, windowInsetsCompat)) == null) {
                this.a.H(windowInsetsCompat);
                return windowInsetsCompat;
            }
            return (WindowInsetsCompat) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        @NonNull
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes8.dex */
    public @interface c {
        Class<? extends Behavior> value();
    }

    /* loaded from: classes8.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f35413e;

        public d(CoordinatorLayout coordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coordinatorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35413e = coordinatorLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) || (onHierarchyChangeListener = this.f35413e.v) == null) {
                return;
            }
            onHierarchyChangeListener.onChildViewAdded(view, view2);
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) {
                this.f35413e.u(2);
                ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f35413e.v;
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewRemoved(view, view2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f35424e;

        public f(CoordinatorLayout coordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coordinatorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35424e = coordinatorLayout;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f35424e.u(0);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class g implements Comparator<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, view2)) == null) {
                float z = ViewCompat.getZ(view);
                float z2 = ViewCompat.getZ(view2);
                if (z > z2) {
                    return -1;
                }
                return z < z2 ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-480144868, "Lcom/baidu/live/framework/coordinatorlayout/CoordinatorLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-480144868, "Lcom/baidu/live/framework/coordinatorlayout/CoordinatorLayout;");
                return;
            }
        }
        Package r0 = CoordinatorLayout.class.getPackage();
        y = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            B = new g();
        } else {
            B = null;
        }
        z = new Class[]{Context.class, AttributeSet.class};
        A = new ThreadLocal<>();
        C = new Pools.SynchronizedPool(12);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(@NonNull Context context) {
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

    public static int C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) {
            if (i2 == 0) {
                return 17;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static int D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) {
            if ((i2 & 7) == 0) {
                i2 |= GravityCompat.START;
            }
            return (i2 & 112) == 0 ? i2 | 48 : i2;
        }
        return invokeI.intValue;
    }

    public static int E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? i2 == 0 ? BadgeDrawable.TOP_END : i2 : invokeI.intValue;
    }

    @NonNull
    public static Rect a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            Rect acquire = C.acquire();
            return acquire == null ? new Rect() : acquire;
        }
        return (Rect) invokeV.objValue;
    }

    public static int c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65544, null, i2, i3, i4)) == null) ? i2 < i3 ? i3 : i2 > i4 ? i4 : i2 : invokeIII.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior v(Context context, AttributeSet attributeSet, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, attributeSet, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(".")) {
                str = context.getPackageName() + str;
            } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(y)) {
                str = y + '.' + str;
            }
            try {
                Map<String, Constructor<Behavior>> map = A.get();
                if (map == null) {
                    map = new HashMap<>();
                    A.set(map);
                }
                Constructor<Behavior> constructor = map.get(str);
                if (constructor == null) {
                    constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(z);
                    constructor.setAccessible(true);
                    map.put(str, constructor);
                }
                return constructor.newInstance(context, attributeSet);
            } catch (Exception e2) {
                throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
            }
        }
        return (Behavior) invokeLLL.objValue;
    }

    public static void z(@NonNull Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, rect) == null) {
            rect.setEmpty();
            C.release(rect);
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.m && this.q != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.q);
            }
            this.r = false;
        }
    }

    public final void B(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                Behavior e2 = ((e) childAt.getLayoutParams()).e();
                if (e2 != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    if (z2) {
                        e2.k(this, childAt, obtain);
                    } else {
                        e2.D(this, childAt, obtain);
                    }
                    obtain.recycle();
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                ((e) getChildAt(i3).getLayoutParams()).l();
            }
            this.o = null;
            this.l = false;
        }
    }

    public final void F(View view, int i2) {
        e eVar;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2) == null) || (i3 = (eVar = (e) view.getLayoutParams()).f35421i) == i2) {
            return;
        }
        ViewCompat.offsetLeftAndRight(view, i2 - i3);
        eVar.f35421i = i2;
    }

    public final void G(View view, int i2) {
        e eVar;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, view, i2) == null) || (i3 = (eVar = (e) view.getLayoutParams()).f35422j) == i2) {
            return;
        }
        ViewCompat.offsetTopAndBottom(view, i2 - i3);
        eVar.f35422j = i2;
    }

    public final WindowInsetsCompat H(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, windowInsetsCompat)) == null) {
            if (!ObjectsCompat.equals(this.s, windowInsetsCompat)) {
                this.s = windowInsetsCompat;
                boolean z2 = true;
                boolean z3 = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
                this.t = z3;
                setWillNotDraw((z3 || getBackground() != null) ? false : false);
                e(windowInsetsCompat);
                requestLayout();
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.w == null) {
                this.w = new a(this);
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.w);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.m) {
                if (this.q == null) {
                    this.q = new f(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.q);
            }
            this.r = true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, layoutParams)) == null) ? (layoutParams instanceof e) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    public final void d(e eVar, Rect rect, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, rect, i2, i3) == null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
            int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
            rect.set(max, max2, i2 + max, i3 + max2);
        }
    }

    public void dispatchDependentViewsChanged(@NonNull View view) {
        List g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, view) == null) || (g2 = this.f35407f.g(view)) == null || g2.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < g2.size(); i2++) {
            View view2 = (View) g2.get(i2);
            Behavior e2 = ((e) view2.getLayoutParams()).e();
            if (e2 != null) {
                e2.h(this, view2, view);
            }
        }
    }

    public boolean doViewsOverlap(@NonNull View view, @NonNull View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, view, view2)) == null) {
            boolean z2 = false;
            if (view.getVisibility() == 0 && view2.getVisibility() == 0) {
                Rect a2 = a();
                g(view, view.getParent() != this, a2);
                Rect a3 = a();
                g(view2, view2.getParent() != this, a3);
                try {
                    if (a2.left <= a3.right && a2.top <= a3.bottom && a2.right >= a3.left) {
                        if (a2.bottom >= a3.top) {
                            z2 = true;
                        }
                    }
                    return z2;
                } finally {
                    z(a2);
                    z(a3);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{canvas, view, Long.valueOf(j2)})) == null) {
            e eVar = (e) view.getLayoutParams();
            Behavior behavior = eVar.a;
            if (behavior != null) {
                float d2 = behavior.d(this, view);
                if (d2 > 0.0f) {
                    if (this.f35410i == null) {
                        this.f35410i = new Paint();
                    }
                    this.f35410i.setColor(eVar.a.c(this, view));
                    this.f35410i.setAlpha(c(Math.round(d2 * 255.0f), 0, 255));
                    int save = canvas.save();
                    if (view.isOpaque()) {
                        canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                    }
                    canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f35410i);
                    canvas.restoreToCount(save);
                }
            }
            return super.drawChild(canvas, view, j2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.u;
            boolean z2 = false;
            if (drawable != null && drawable.isStateful()) {
                z2 = false | drawable.setState(drawableState);
            }
            if (z2) {
                invalidate();
            }
        }
    }

    public final WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, windowInsetsCompat)) == null) {
            if (windowInsetsCompat.isConsumed()) {
                return windowInsetsCompat;
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (ViewCompat.getFitsSystemWindows(childAt) && (e2 = ((e) childAt.getLayoutParams()).e()) != null) {
                    e2.f(this, childAt, windowInsetsCompat);
                    if (windowInsetsCompat.isConsumed()) {
                        break;
                    }
                }
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                } else if (o(getChildAt(i2))) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2 != this.r) {
                if (z2) {
                    b();
                } else {
                    A();
                }
            }
        }
    }

    public void g(View view, boolean z2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{view, Boolean.valueOf(z2), rect}) == null) {
            if (view.isLayoutRequested() || view.getVisibility() == 8) {
                rect.setEmpty();
            } else if (z2) {
                h(view, rect);
            } else {
                rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view)) == null) {
            List<View> h2 = this.f35407f.h(view);
            this.f35409h.clear();
            if (h2 != null) {
                this.f35409h.addAll(h2);
            }
            return this.f35409h;
        }
        return (List) invokeL.objValue;
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            x();
            return Collections.unmodifiableList(this.f35406e);
        }
        return (List) invokeV.objValue;
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            List g2 = this.f35407f.g(view);
            this.f35409h.clear();
            if (g2 != null) {
                this.f35409h.addAll(g2);
            }
            return this.f35409h;
        }
        return (List) invokeL.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.s : (WindowInsetsCompat) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.x.getNestedScrollAxes() : invokeV.intValue;
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.u : (Drawable) invokeV.objValue;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom()) : invokeV.intValue;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight()) : invokeV.intValue;
    }

    public void h(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, view, rect) == null) {
            c.a.w.e.b.b.a(this, view, rect);
        }
    }

    public void i(View view, int i2, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048607, this, view, i2, rect, rect2) == null) {
            e eVar = (e) view.getLayoutParams();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            j(view, i2, rect, rect2, eVar, measuredWidth, measuredHeight);
            d(eVar, rect2, measuredWidth, measuredHeight);
        }
    }

    public boolean isPointInChildBounds(@NonNull View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048608, this, view, i2, i3)) == null) {
            Rect a2 = a();
            h(view, a2);
            try {
                return a2.contains(i2, i3);
            } finally {
                z(a2);
            }
        }
        return invokeLII.booleanValue;
    }

    public final void j(View view, int i2, Rect rect, Rect rect2, e eVar, int i3, int i4) {
        int width;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view, Integer.valueOf(i2), rect, rect2, eVar, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(C(eVar.f35415c), i2);
            int absoluteGravity2 = GravityCompat.getAbsoluteGravity(D(eVar.f35416d), i2);
            int i5 = absoluteGravity & 7;
            int i6 = absoluteGravity & 112;
            int i7 = absoluteGravity2 & 7;
            int i8 = absoluteGravity2 & 112;
            if (i7 == 1) {
                width = rect.left + (rect.width() / 2);
            } else if (i7 != 5) {
                width = rect.left;
            } else {
                width = rect.right;
            }
            if (i8 == 16) {
                height = rect.top + (rect.height() / 2);
            } else if (i8 != 80) {
                height = rect.top;
            } else {
                height = rect.bottom;
            }
            if (i5 == 1) {
                width -= i3 / 2;
            } else if (i5 != 5) {
                width -= i3;
            }
            if (i6 == 16) {
                height -= i4 / 2;
            } else if (i6 != 80) {
                height -= i4;
            }
            rect2.set(width, height, i3 + width, i4 + height);
        }
    }

    public final int k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            int[] iArr = this.n;
            if (iArr == null) {
                String str = "No keylines defined for " + this + " - attempted index lookup " + i2;
                return 0;
            } else if (i2 >= 0 && i2 < iArr.length) {
                return iArr[i2];
            } else {
                String str2 = "Keyline index " + i2 + " out of range for " + this;
                return 0;
            }
        }
        return invokeI.intValue;
    }

    public void l(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, view, rect) == null) {
            rect.set(((e) view.getLayoutParams()).g());
        }
    }

    public e m(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, view)) == null) {
            e eVar = (e) view.getLayoutParams();
            if (!eVar.f35414b) {
                if (view instanceof b) {
                    eVar.n(((b) view).getBehavior());
                    eVar.f35414b = true;
                } else {
                    c cVar = null;
                    for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                        cVar = (c) cls.getAnnotation(c.class);
                        if (cVar != null) {
                            break;
                        }
                    }
                    if (cVar != null) {
                        try {
                            eVar.n(cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        } catch (Exception unused) {
                            String str = "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?";
                        }
                    }
                    eVar.f35414b = true;
                }
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public final void n(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, list) == null) {
            list.clear();
            boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
            int childCount = getChildCount();
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
            }
            Comparator<View> comparator = B;
            if (comparator != null) {
                Collections.sort(list, comparator);
            }
        }
    }

    public final boolean o(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, view)) == null) ? this.f35407f.j(view) : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onAttachedToWindow();
            B(false);
            if (this.r) {
                if (this.q == null) {
                    this.q = new f(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.q);
            }
            if (this.s == null && ViewCompat.getFitsSystemWindows(this)) {
                ViewCompat.requestApplyInsets(this);
            }
            this.m = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDetachedFromWindow();
            B(false);
            if (this.r && this.q != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.q);
            }
            View view = this.p;
            if (view != null) {
                onStopNestedScroll(view);
            }
            this.m = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, canvas) == null) {
            super.onDraw(canvas);
            if (!this.t || this.u == null) {
                return;
            }
            WindowInsetsCompat windowInsetsCompat = this.s;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.u.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.u.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                B(true);
            }
            boolean w = w(motionEvent, 0);
            if (actionMasked == 1 || actionMasked == 3) {
                B(true);
            }
            return w;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int size = this.f35406e.size();
            for (int i6 = 0; i6 < size; i6++) {
                View view = this.f35406e.get(i6);
                if (view.getVisibility() != 8 && ((e2 = ((e) view.getLayoutParams()).e()) == null || !e2.l(this, view, layoutDirection))) {
                    onLayoutChild(view, layoutDirection);
                }
            }
        }
    }

    public void onLayoutChild(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048620, this, view, i2) == null) {
            e eVar = (e) view.getLayoutParams();
            if (!eVar.a()) {
                View view2 = eVar.f35423k;
                if (view2 != null) {
                    q(view, view2, i2);
                    return;
                }
                int i3 = eVar.f35417e;
                if (i3 >= 0) {
                    r(view, i3, i2);
                    return;
                } else {
                    p(view, i2);
                    return;
                }
            }
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x011e, code lost:
        if (r0.m(r30, r20, r11, r21, r23, 0) == false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Behavior e2;
        e eVar;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048621, this, i2, i3) == null) {
            x();
            f();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            boolean z2 = layoutDirection == 1;
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            int i14 = paddingLeft + paddingRight;
            int i15 = paddingTop + paddingBottom;
            int suggestedMinimumWidth = getSuggestedMinimumWidth();
            int suggestedMinimumHeight = getSuggestedMinimumHeight();
            boolean z3 = this.s != null && ViewCompat.getFitsSystemWindows(this);
            int size3 = this.f35406e.size();
            int i16 = suggestedMinimumWidth;
            int i17 = suggestedMinimumHeight;
            int i18 = 0;
            int i19 = 0;
            while (i19 < size3) {
                View view = this.f35406e.get(i19);
                if (view.getVisibility() == 8) {
                    i12 = i19;
                    i9 = size3;
                    i10 = paddingLeft;
                } else {
                    e eVar2 = (e) view.getLayoutParams();
                    int i20 = eVar2.f35417e;
                    if (i20 < 0 || mode == 0) {
                        i4 = i18;
                    } else {
                        int k2 = k(i20);
                        int absoluteGravity = GravityCompat.getAbsoluteGravity(E(eVar2.f35415c), layoutDirection) & 7;
                        i4 = i18;
                        if ((absoluteGravity == 3 && !z2) || (absoluteGravity == 5 && z2)) {
                            i5 = Math.max(0, (size - paddingRight) - k2);
                        } else if ((absoluteGravity == 5 && !z2) || (absoluteGravity == 3 && z2)) {
                            i5 = Math.max(0, k2 - paddingLeft);
                        }
                        if (z3 || ViewCompat.getFitsSystemWindows(view)) {
                            i6 = i2;
                            i7 = i3;
                        } else {
                            i6 = View.MeasureSpec.makeMeasureSpec(size - (this.s.getSystemWindowInsetLeft() + this.s.getSystemWindowInsetRight()), mode);
                            i7 = View.MeasureSpec.makeMeasureSpec(size2 - (this.s.getSystemWindowInsetTop() + this.s.getSystemWindowInsetBottom()), mode2);
                        }
                        e2 = eVar2.e();
                        if (e2 == null) {
                            eVar = eVar2;
                            i11 = i4;
                            i12 = i19;
                            i8 = i17;
                            i10 = paddingLeft;
                            i13 = i16;
                            i9 = size3;
                        } else {
                            eVar = eVar2;
                            i8 = i17;
                            i9 = size3;
                            i10 = paddingLeft;
                            i11 = i4;
                            i12 = i19;
                            i13 = i16;
                        }
                        onMeasureChild(view, i6, i5, i7, 0);
                        e eVar3 = eVar;
                        int max = Math.max(i13, i14 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar3).leftMargin + ((ViewGroup.MarginLayoutParams) eVar3).rightMargin);
                        int max2 = Math.max(i8, i15 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin);
                        i18 = View.combineMeasuredStates(i11, view.getMeasuredState());
                        i16 = max;
                        i17 = max2;
                    }
                    i5 = 0;
                    if (z3) {
                    }
                    i6 = i2;
                    i7 = i3;
                    e2 = eVar2.e();
                    if (e2 == null) {
                    }
                    onMeasureChild(view, i6, i5, i7, 0);
                    e eVar32 = eVar;
                    int max3 = Math.max(i13, i14 + view.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar32).leftMargin + ((ViewGroup.MarginLayoutParams) eVar32).rightMargin);
                    int max22 = Math.max(i8, i15 + view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar32).topMargin + ((ViewGroup.MarginLayoutParams) eVar32).bottomMargin);
                    i18 = View.combineMeasuredStates(i11, view.getMeasuredState());
                    i16 = max3;
                    i17 = max22;
                }
                i19 = i12 + 1;
                paddingLeft = i10;
                size3 = i9;
            }
            int i21 = i18;
            setMeasuredDimension(View.resolveSizeAndState(i16, i2, (-16777216) & i21), View.resolveSizeAndState(i17, i3, i21 << 16));
        }
    }

    public void onMeasureChild(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            measureChildWithMargins(view, i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        InterceptResult invokeCommon;
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z2)})) == null) {
            int childCount = getChildCount();
            boolean z3 = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(0) && (e2 = eVar.e()) != null) {
                        z3 |= e2.n(this, childAt, view, f2, f3, z2);
                    }
                }
            }
            if (z3) {
                u(1);
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048624, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(0) && (e2 = eVar.e()) != null) {
                        z2 |= e2.o(this, childAt, view, f2, f3);
                    }
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            onNestedPreScroll(view, i2, i3, iArr, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            onNestedScroll(view, i2, i3, i4, i5, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048630, this, view, view2, i2) == null) {
            onNestedScrollAccepted(view, view2, i2, 0);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int id = childAt.getId();
                Behavior e2 = m(childAt).e();
                if (id != -1 && e2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                    e2.x(this, childAt, parcelable2);
                }
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Parcelable y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                int id = childAt.getId();
                Behavior e2 = ((e) childAt.getLayoutParams()).e();
                if (id != -1 && e2 != null && (y2 = e2.y(this, childAt)) != null) {
                    sparseArray.append(id, y2);
                }
            }
            savedState.behaviorStates = sparseArray;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048634, this, view, view2, i2)) == null) ? onStartNestedScroll(view, view2, i2, 0) : invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, view) == null) {
            onStopNestedScroll(view, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r3 != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z2;
        Behavior e2;
        boolean D;
        MotionEvent motionEvent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.o == null) {
                z2 = w(motionEvent, 1);
            } else {
                z2 = false;
            }
            View view = this.o;
            if (view != null && (e2 = ((e) view.getLayoutParams()).e()) != null) {
                D = e2.D(this, this.o, motionEvent);
                motionEvent2 = null;
                if (this.o != null) {
                    D |= super.onTouchEvent(motionEvent);
                } else if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (actionMasked != 1 || actionMasked == 3) {
                    B(false);
                }
                return D;
            }
            D = false;
            motionEvent2 = null;
            if (this.o != null) {
            }
            if (motionEvent2 != null) {
            }
            if (actionMasked != 1) {
            }
            B(false);
            return D;
        }
        return invokeL.booleanValue;
    }

    public final void p(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048639, this, view, i2) == null) {
            e eVar = (e) view.getLayoutParams();
            Rect a2 = a();
            a2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
            if (this.s != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view)) {
                a2.left += this.s.getSystemWindowInsetLeft();
                a2.top += this.s.getSystemWindowInsetTop();
                a2.right -= this.s.getSystemWindowInsetRight();
                a2.bottom -= this.s.getSystemWindowInsetBottom();
            }
            Rect a3 = a();
            GravityCompat.apply(D(eVar.f35415c), view.getMeasuredWidth(), view.getMeasuredHeight(), a2, a3, i2);
            view.layout(a3.left, a3.top, a3.right, a3.bottom);
            z(a2);
            z(a3);
        }
    }

    public final void q(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048640, this, view, view2, i2) == null) {
            Rect a2 = a();
            Rect a3 = a();
            try {
                h(view2, a2);
                i(view, i2, a2, a3);
                view.layout(a3.left, a3.top, a3.right, a3.bottom);
            } finally {
                z(a2);
                z(a3);
            }
        }
    }

    public final void r(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048641, this, view, i2, i3) == null) {
            e eVar = (e) view.getLayoutParams();
            int absoluteGravity = GravityCompat.getAbsoluteGravity(E(eVar.f35415c), i3);
            int i4 = absoluteGravity & 7;
            int i5 = absoluteGravity & 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (i3 == 1) {
                i2 = width - i2;
            }
            int k2 = k(i2) - measuredWidth;
            int i6 = 0;
            if (i4 == 1) {
                k2 += measuredWidth / 2;
            } else if (i4 == 5) {
                k2 += measuredWidth;
            }
            if (i5 == 16) {
                i6 = 0 + (measuredHeight / 2);
            } else if (i5 == 80) {
                i6 = measuredHeight + 0;
            }
            int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(k2, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
            int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
            view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048642, this, view, rect, z2)) == null) {
            Behavior e2 = ((e) view.getLayoutParams()).e();
            if (e2 == null || !e2.w(this, view, rect, z2)) {
                return super.requestChildRectangleOnScreen(view, rect, z2);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z2) == null) {
            super.requestDisallowInterceptTouchEvent(z2);
            if (!z2 || this.l) {
                return;
            }
            B(false);
            this.l = true;
        }
    }

    public final void s(View view, Rect rect, int i2) {
        boolean z2;
        boolean z3;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048644, this, view, rect, i2) == null) || !ViewCompat.isLaidOut(view) || view.getWidth() <= 0 || view.getHeight() <= 0) {
            return;
        }
        e eVar = (e) view.getLayoutParams();
        Behavior e2 = eVar.e();
        Rect a2 = a();
        Rect a3 = a();
        a3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (e2 != null && e2.b(this, view, a2)) {
            if (!a3.contains(a2)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + a2.toShortString() + " | Bounds:" + a3.toShortString());
            }
        } else {
            a2.set(a3);
        }
        z(a3);
        if (a2.isEmpty()) {
            z(a2);
            return;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.f35420h, i2);
        boolean z4 = true;
        if ((absoluteGravity & 48) != 48 || (i7 = (a2.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.f35422j) >= (i8 = rect.top)) {
            z2 = false;
        } else {
            G(view, i8 - i7);
            z2 = true;
        }
        if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - a2.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.f35422j) < (i6 = rect.bottom)) {
            G(view, height - i6);
            z2 = true;
        }
        if (!z2) {
            G(view, 0);
        }
        if ((absoluteGravity & 3) != 3 || (i4 = (a2.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.f35421i) >= (i5 = rect.left)) {
            z3 = false;
        } else {
            F(view, i5 - i4);
            z3 = true;
        }
        if ((absoluteGravity & 5) != 5 || (width = ((getWidth() - a2.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.f35421i) >= (i3 = rect.right)) {
            z4 = z3;
        } else {
            F(view, width - i3);
        }
        if (!z4) {
            F(view, 0);
        }
        z(a2);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z2) == null) {
            super.setFitsSystemWindows(z2);
            I();
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, onHierarchyChangeListener) == null) {
            this.v = onHierarchyChangeListener;
        }
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048647, this, drawable) == null) || (drawable2 = this.u) == drawable) {
            return;
        }
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Drawable mutate = drawable != null ? drawable.mutate() : null;
        this.u = mutate;
        if (mutate != null) {
            if (mutate.isStateful()) {
                this.u.setState(getDrawableState());
            }
            DrawableCompat.setLayoutDirection(this.u, ViewCompat.getLayoutDirection(this));
            this.u.setVisible(getVisibility() == 0, false);
            this.u.setCallback(this);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            setStatusBarBackground(new ColorDrawable(i2));
        }
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            setStatusBarBackground(i2 != 0 ? ContextCompat.getDrawable(getContext(), i2) : null);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            super.setVisibility(i2);
            boolean z2 = i2 == 0;
            Drawable drawable = this.u;
            if (drawable == null || drawable.isVisible() == z2) {
                return;
            }
            this.u.setVisible(z2, false);
        }
    }

    public void t(View view, int i2) {
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048651, this, view, i2) == null) {
            e eVar = (e) view.getLayoutParams();
            if (eVar.f35423k != null) {
                Rect a2 = a();
                Rect a3 = a();
                Rect a4 = a();
                h(eVar.f35423k, a2);
                boolean z2 = false;
                g(view, false, a3);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                j(view, i2, a2, a4, eVar, measuredWidth, measuredHeight);
                z2 = (a4.left == a3.left && a4.top == a3.top) ? true : true;
                d(eVar, a4, measuredWidth, measuredHeight);
                int i3 = a4.left - a3.left;
                int i4 = a4.top - a3.top;
                if (i3 != 0) {
                    ViewCompat.offsetLeftAndRight(view, i3);
                }
                if (i4 != 0) {
                    ViewCompat.offsetTopAndBottom(view, i4);
                }
                if (z2 && (e2 = eVar.e()) != null) {
                    e2.h(this, view, eVar.f35423k);
                }
                z(a2);
                z(a3);
                z(a4);
            }
        }
    }

    public final void u(int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048652, this, i2) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int size = this.f35406e.size();
            Rect a2 = a();
            Rect a3 = a();
            Rect a4 = a();
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.f35406e.get(i3);
                e eVar = (e) view.getLayoutParams();
                if (i2 != 0 || view.getVisibility() != 8) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (eVar.l == this.f35406e.get(i4)) {
                            t(view, layoutDirection);
                        }
                    }
                    g(view, true, a3);
                    if (eVar.f35419g != 0 && !a3.isEmpty()) {
                        int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.f35419g, layoutDirection);
                        int i5 = absoluteGravity & 112;
                        if (i5 == 48) {
                            a2.top = Math.max(a2.top, a3.bottom);
                        } else if (i5 == 80) {
                            a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                        }
                        int i6 = absoluteGravity & 7;
                        if (i6 == 3) {
                            a2.left = Math.max(a2.left, a3.right);
                        } else if (i6 == 5) {
                            a2.right = Math.max(a2.right, getWidth() - a3.left);
                        }
                    }
                    if (eVar.f35420h != 0 && view.getVisibility() == 0) {
                        s(view, a2, layoutDirection);
                    }
                    if (i2 != 2) {
                        l(view, a4);
                        if (!a4.equals(a3)) {
                            y(view, a3);
                        }
                    }
                    for (int i7 = i3 + 1; i7 < size; i7++) {
                        View view2 = this.f35406e.get(i7);
                        e eVar2 = (e) view2.getLayoutParams();
                        Behavior e2 = eVar2.e();
                        if (e2 != null && e2.e(this, view2, view)) {
                            if (i2 == 0 && eVar2.f()) {
                                eVar2.j();
                            } else {
                                if (i2 != 2) {
                                    z2 = e2.h(this, view2, view);
                                } else {
                                    e2.i(this, view2, view);
                                    z2 = true;
                                }
                                if (i2 == 1) {
                                    eVar2.o(z2);
                                }
                            }
                        }
                    }
                }
            }
            z(a2);
            z(a3);
            z(a4);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.u : invokeL.booleanValue;
    }

    public final boolean w(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048654, this, motionEvent, i2)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            List<View> list = this.f35408g;
            n(list);
            int size = list.size();
            MotionEvent motionEvent2 = null;
            boolean z2 = false;
            boolean z3 = false;
            for (int i3 = 0; i3 < size; i3++) {
                View view = list.get(i3);
                e eVar = (e) view.getLayoutParams();
                Behavior e2 = eVar.e();
                if (!(z2 || z3) || actionMasked == 0) {
                    if (!z2 && e2 != null) {
                        if (i2 == 0) {
                            z2 = e2.k(this, view, motionEvent);
                        } else if (i2 == 1) {
                            z2 = e2.D(this, view, motionEvent);
                        }
                        if (z2) {
                            this.o = view;
                        }
                    }
                    boolean c2 = eVar.c();
                    boolean h2 = eVar.h(this, view);
                    z3 = h2 && !c2;
                    if (h2 && !z3) {
                        break;
                    }
                } else if (e2 != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i2 == 0) {
                        e2.k(this, view, motionEvent2);
                    } else if (i2 == 1) {
                        e2.D(this, view, motionEvent2);
                    }
                }
            }
            list.clear();
            return z2;
        }
        return invokeLI.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.f35406e.clear();
            this.f35407f.c();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                e m = m(childAt);
                m.d(this, childAt);
                this.f35407f.b(childAt);
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (i3 != i2) {
                        View childAt2 = getChildAt(i3);
                        if (m.b(this, childAt, childAt2)) {
                            if (!this.f35407f.d(childAt2)) {
                                this.f35407f.b(childAt2);
                            }
                            this.f35407f.a(childAt2, childAt);
                        }
                    }
                }
            }
            this.f35406e.addAll(this.f35407f.i());
            Collections.reverse(this.f35406e);
        }
    }

    public void y(View view, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048656, this, view, rect) == null) {
            ((e) view.getLayoutParams()).p(rect);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new e(-2, -2) : (e) invokeV.objValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr, Integer.valueOf(i4)}) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(i4) && (e2 = eVar.e()) != null) {
                        int[] iArr2 = this.f35411j;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                        e2.q(this, childAt, view, i2, i3, iArr2, i4);
                        int[] iArr3 = this.f35411j;
                        i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                        int[] iArr4 = this.f35411j;
                        i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                        z2 = true;
                    }
                }
            }
            iArr[0] = i5;
            iArr[1] = i6;
            if (z2) {
                u(1);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            onNestedScroll(view, i2, i3, i4, i5, 0, this.f35412k);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048631, this, view, view2, i2, i3) == null) {
            this.x.onNestedScrollAccepted(view, view2, i2, i3);
            this.p = view2;
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i3) && (e2 = eVar.e()) != null) {
                    e2.v(this, childAt, view, view2, i2, i3);
                }
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048635, this, view, view2, i2, i3)) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    Behavior e2 = eVar.e();
                    if (e2 != null) {
                        boolean A2 = e2.A(this, childAt, view, view2, i2, i3);
                        z2 |= A2;
                        eVar.q(i3, A2);
                    } else {
                        eVar.q(i3, false);
                    }
                }
            }
            return z2;
        }
        return invokeLLII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048637, this, view, i2) == null) {
            this.x.onStopNestedScroll(view, i2);
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i2)) {
                    Behavior e2 = eVar.e();
                    if (e2 != null) {
                        e2.C(this, childAt, view, i2);
                    }
                    eVar.k(i2);
                    eVar.j();
                }
            }
            this.p = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
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
        this.f35406e = new ArrayList();
        this.f35407f = new c.a.w.e.b.a<>();
        this.f35408g = new ArrayList();
        this.f35409h = new ArrayList();
        this.f35411j = new int[2];
        this.f35412k = new int[2];
        this.x = new NestedScrollingParentHelper(this);
        if (i2 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i2, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.n = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.n.length;
            for (int i5 = 0; i5 < length; i5++) {
                int[] iArr = this.n;
                iArr[i5] = (int) (iArr[i5] * f2);
            }
        }
        this.u = obtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        I();
        super.setOnHierarchyChangeListener(new d(this));
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, attributeSet)) == null) ? new e(getContext(), attributeSet) : (e) invokeL.objValue;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        Behavior e2;
        int min;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), iArr}) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(i6) && (e2 = eVar.e()) != null) {
                        int[] iArr2 = this.f35411j;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                        e2.t(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                        int[] iArr3 = this.f35411j;
                        i7 = i4 > 0 ? Math.max(i7, iArr3[0]) : Math.min(i7, iArr3[0]);
                        if (i5 > 0) {
                            min = Math.max(i8, this.f35411j[1]);
                        } else {
                            min = Math.min(i8, this.f35411j[1]);
                        }
                        i8 = min;
                        z2 = true;
                    }
                }
            }
            iArr[0] = iArr[0] + i7;
            iArr[1] = iArr[1] + i8;
            if (z2) {
                u(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, layoutParams)) == null) {
            if (layoutParams instanceof e) {
                return new e((e) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new e((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new e(layoutParams);
        }
        return (e) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public static class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<Parcelable> behaviorStates;

        /* loaded from: classes8.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1002113044, "Lcom/baidu/live/framework/coordinatorlayout/CoordinatorLayout$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1002113044, "Lcom/baidu/live/framework/coordinatorlayout/CoordinatorLayout$SavedState;");
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
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                this.behaviorStates.append(iArr[i4], readParcelableArray[i4]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                SparseArray<Parcelable> sparseArray = this.behaviorStates;
                int size = sparseArray != null ? sparseArray.size() : 0;
                parcel.writeInt(size);
                int[] iArr = new int[size];
                Parcelable[] parcelableArr = new Parcelable[size];
                for (int i3 = 0; i3 < size; i3++) {
                    iArr[i3] = this.behaviorStates.keyAt(i3);
                    parcelableArr[i3] = this.behaviorStates.valueAt(i3);
                }
                parcel.writeIntArray(iArr);
                parcel.writeParcelableArray(parcelableArr, i2);
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

    /* loaded from: classes8.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Behavior a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35414b;

        /* renamed from: c  reason: collision with root package name */
        public int f35415c;

        /* renamed from: d  reason: collision with root package name */
        public int f35416d;

        /* renamed from: e  reason: collision with root package name */
        public int f35417e;

        /* renamed from: f  reason: collision with root package name */
        public int f35418f;

        /* renamed from: g  reason: collision with root package name */
        public int f35419g;

        /* renamed from: h  reason: collision with root package name */
        public int f35420h;

        /* renamed from: i  reason: collision with root package name */
        public int f35421i;

        /* renamed from: j  reason: collision with root package name */
        public int f35422j;

        /* renamed from: k  reason: collision with root package name */
        public View f35423k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i2, int i3) {
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
            this.f35414b = false;
            this.f35415c = 0;
            this.f35416d = 0;
            this.f35417e = -1;
            this.f35418f = -1;
            this.f35419g = 0;
            this.f35420h = 0;
            this.q = new Rect();
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35423k == null && this.f35418f != -1 : invokeV.booleanValue;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            InterceptResult invokeLLL;
            Behavior behavior;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, view, view2)) == null) ? view2 == this.l || r(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || ((behavior = this.a) != null && behavior.e(coordinatorLayout, view, view2)) : invokeLLL.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a == null) {
                    this.m = false;
                }
                return this.m;
            }
            return invokeV.booleanValue;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, coordinatorLayout, view)) == null) {
                if (this.f35418f == -1) {
                    this.l = null;
                    this.f35423k = null;
                    return null;
                }
                if (this.f35423k == null || !s(view, coordinatorLayout)) {
                    m(view, coordinatorLayout);
                }
                return this.f35423k;
            }
            return (View) invokeLL.objValue;
        }

        @Nullable
        public Behavior e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (Behavior) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : invokeV.booleanValue;
        }

        public Rect g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : (Rect) invokeV.objValue;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, coordinatorLayout, view)) == null) {
                boolean z = this.m;
                if (z) {
                    return true;
                }
                Behavior behavior = this.a;
                boolean a = (behavior != null ? behavior.a(coordinatorLayout, view) : false) | z;
                this.m = a;
                return a;
            }
            return invokeLL.booleanValue;
        }

        public boolean i(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        return false;
                    }
                    return this.o;
                }
                return this.n;
            }
            return invokeI.booleanValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.p = false;
            }
        }

        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
                q(i2, false);
            }
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.m = false;
            }
        }

        public final void m(View view, CoordinatorLayout coordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, view, coordinatorLayout) == null) {
                View findViewById = coordinatorLayout.findViewById(this.f35418f);
                this.f35423k = findViewById;
                if (findViewById == null) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.f35423k = null;
                        return;
                    }
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f35418f) + " to anchor view " + view);
                } else if (findViewById == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.f35423k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                } else {
                    for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                        if (parent == view) {
                            if (coordinatorLayout.isInEditMode()) {
                                this.l = null;
                                this.f35423k = null;
                                return;
                            }
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                        if (parent instanceof View) {
                            findViewById = (View) parent;
                        }
                    }
                    this.l = findViewById;
                }
            }
        }

        public void n(@Nullable Behavior behavior) {
            Behavior behavior2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, behavior) == null) || (behavior2 = this.a) == behavior) {
                return;
            }
            if (behavior2 != null) {
                behavior2.j();
            }
            this.a = behavior;
            this.f35414b = true;
            if (behavior != null) {
                behavior.g(this);
            }
        }

        public void o(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
                this.p = z;
            }
        }

        public void p(Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, rect) == null) {
                this.q.set(rect);
            }
        }

        public void q(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (i2 == 0) {
                    this.n = z;
                } else if (i2 != 1) {
                } else {
                    this.o = z;
                }
            }
        }

        public final boolean r(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, view, i2)) == null) {
                int absoluteGravity = GravityCompat.getAbsoluteGravity(((e) view.getLayoutParams()).f35419g, i2);
                return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.f35420h, i2) & absoluteGravity) == absoluteGravity;
            }
            return invokeLI.booleanValue;
        }

        public final boolean s(View view, CoordinatorLayout coordinatorLayout) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view, coordinatorLayout)) == null) {
                if (this.f35423k.getId() != this.f35418f) {
                    return false;
                }
                View view2 = this.f35423k;
                for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                    if (parent != null && parent != view) {
                        if (parent instanceof View) {
                            view2 = (View) parent;
                        }
                    } else {
                        this.l = null;
                        this.f35423k = null;
                        return false;
                    }
                }
                this.l = view2;
                return true;
            }
            return invokeLL.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
            this.f35414b = false;
            this.f35415c = 0;
            this.f35416d = 0;
            this.f35417e = -1;
            this.f35418f = -1;
            this.f35419g = 0;
            this.f35420h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f35415c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f35418f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f35416d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f35417e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f35419g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f35420h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f35414b = hasValue;
            if (hasValue) {
                this.a = CoordinatorLayout.v(context, attributeSet, AppBarLayout.ScrollingViewBehavior.class.getName());
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.a;
            if (behavior != null) {
                behavior.g(this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.f35414b = false;
            this.f35415c = 0;
            this.f35416d = 0;
            this.f35417e = -1;
            this.f35418f = -1;
            this.f35419g = 0;
            this.f35420h = 0;
            this.q = new Rect();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
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
            this.f35414b = false;
            this.f35415c = 0;
            this.f35416d = 0;
            this.f35417e = -1;
            this.f35418f = -1;
            this.f35419g = 0;
            this.f35420h = 0;
            this.q = new Rect();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ViewGroup.LayoutParams layoutParams) {
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
            this.f35414b = false;
            this.f35415c = 0;
            this.f35416d = 0;
            this.f35417e = -1;
            this.f35418f = -1;
            this.f35419g = 0;
            this.f35420h = 0;
            this.q = new Rect();
        }
    }
}
