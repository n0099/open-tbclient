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
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
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
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.framework.appbar.AppBarLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb0;
import com.baidu.tieba.qa0;
import com.baidu.tieba.qb0;
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
/* loaded from: classes2.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static /* synthetic */ Interceptable $ic;
    public static final String u;
    public static final Class[] v;
    public static final ThreadLocal w;
    public static final Comparator x;
    public static final Pools.Pool y;
    public transient /* synthetic */ FieldHolder $fh;
    public final List a;
    public final pb0 b;
    public final List c;
    public final List d;
    public Paint e;
    public final int[] f;
    public final int[] g;
    public boolean h;
    public boolean i;
    public int[] j;
    public View k;
    public View l;
    public f m;
    public boolean n;
    public WindowInsetsCompat o;
    public boolean p;
    public Drawable q;
    public ViewGroup.OnHierarchyChangeListener r;
    public OnApplyWindowInsetsListener s;
    public final NestedScrollingParentHelper t;

    /* loaded from: classes2.dex */
    public interface b {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface c {
        Class value();
    }

    public static int L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i == 0) {
                return 17;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public static int M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            if ((i & 7) == 0) {
                i |= GravityCompat.START;
            }
            return (i & 112) == 0 ? i | 48 : i;
        }
        return invokeI.intValue;
    }

    public static int N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i == 0 ? BadgeDrawable.TOP_END : i : invokeI.intValue;
    }

    public static int c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65546, null, i, i2, i3)) == null) ? i < i2 ? i2 : i > i3 ? i3 : i : invokeIII.intValue;
    }

    /* loaded from: classes2.dex */
    public class SavedState extends AbsSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray behaviorStates;

        /* loaded from: classes2.dex */
        public final class a implements Parcelable.ClassLoaderCreator {
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
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: c */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new SavedState[i];
                }
                return (SavedState[]) invokeI.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, classLoader)) == null) {
                    return new SavedState(parcel, classLoader);
                }
                return (SavedState) invokeLL.objValue;
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
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray(readInt);
            for (int i3 = 0; i3 < readInt; i3++) {
                this.behaviorStates.append(iArr[i3], readParcelableArray[i3]);
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

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                SparseArray sparseArray = this.behaviorStates;
                if (sparseArray != null) {
                    i2 = sparseArray.size();
                } else {
                    i2 = 0;
                }
                parcel.writeInt(i2);
                int[] iArr = new int[i2];
                Parcelable[] parcelableArr = new Parcelable[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    iArr[i3] = this.behaviorStates.keyAt(i3);
                    parcelableArr[i3] = (Parcelable) this.behaviorStates.valueAt(i3);
                }
                parcel.writeIntArray(iArr);
                parcel.writeParcelableArray(parcelableArr, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public abstract class Behavior {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Deprecated
        public void B(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, view2, view3) == null) {
            }
        }

        public boolean D(CoordinatorLayout coordinatorLayout, View view2, MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, coordinatorLayout, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view2, Rect rect) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, coordinatorLayout, view2, rect)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public int c(CoordinatorLayout coordinatorLayout, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, coordinatorLayout, view2)) == null) {
                return -16777216;
            }
            return invokeLL.intValue;
        }

        public float d(CoordinatorLayout coordinatorLayout, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, coordinatorLayout, view2)) == null) {
                return 0.0f;
            }
            return invokeLL.floatValue;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, coordinatorLayout, view2, view3)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public WindowInsetsCompat f(CoordinatorLayout coordinatorLayout, View view2, WindowInsetsCompat windowInsetsCompat) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, coordinatorLayout, view2, windowInsetsCompat)) == null) ? windowInsetsCompat : (WindowInsetsCompat) invokeLLL.objValue;
        }

        public void g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, eVar) == null) {
            }
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, coordinatorLayout, view2, view3)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public void i(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, coordinatorLayout, view2, view3) == null) {
            }
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        public boolean k(CoordinatorLayout coordinatorLayout, View view2, MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, coordinatorLayout, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, View view2, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048591, this, coordinatorLayout, view2, i)) == null) {
                return false;
            }
            return invokeLLI.booleanValue;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view2, int i, int i2, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{coordinatorLayout, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, View view2, View view3, float f, float f2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{coordinatorLayout, view2, view3, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public boolean o(CoordinatorLayout coordinatorLayout, View view2, View view3, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{coordinatorLayout, view2, view3, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Deprecated
        public void p(CoordinatorLayout coordinatorLayout, View view2, View view3, int i, int i2, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{coordinatorLayout, view2, view3, Integer.valueOf(i), Integer.valueOf(i2), iArr}) == null) {
            }
        }

        @Deprecated
        public void r(CoordinatorLayout coordinatorLayout, View view2, View view3, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{coordinatorLayout, view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        @Deprecated
        public void u(CoordinatorLayout coordinatorLayout, View view2, View view3, View view4, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{coordinatorLayout, view2, view3, view4, Integer.valueOf(i)}) == null) {
            }
        }

        public boolean w(CoordinatorLayout coordinatorLayout, View view2, Rect rect, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{coordinatorLayout, view2, rect, Boolean.valueOf(z)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public void x(CoordinatorLayout coordinatorLayout, View view2, Parcelable parcelable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048603, this, coordinatorLayout, view2, parcelable) == null) {
            }
        }

        @Deprecated
        public boolean z(CoordinatorLayout coordinatorLayout, View view2, View view3, View view4, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{coordinatorLayout, view2, view3, view4, Integer.valueOf(i)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
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

        public Behavior(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, coordinatorLayout, view2)) == null) {
                if (d(coordinatorLayout, view2) > 0.0f) {
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public Parcelable y(CoordinatorLayout coordinatorLayout, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, coordinatorLayout, view2)) == null) {
                return View.BaseSavedState.EMPTY_STATE;
            }
            return (Parcelable) invokeLL.objValue;
        }

        public boolean A(CoordinatorLayout coordinatorLayout, View view2, View view3, View view4, int i, int i2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{coordinatorLayout, view2, view3, view4, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
                if (i2 == 0) {
                    return z(coordinatorLayout, view2, view3, view4, i);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        public void v(CoordinatorLayout coordinatorLayout, View view2, View view3, View view4, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{coordinatorLayout, view2, view3, view4, Integer.valueOf(i), Integer.valueOf(i2)}) == null) && i2 == 0) {
                u(coordinatorLayout, view2, view3, view4, i);
            }
        }

        public void C(CoordinatorLayout coordinatorLayout, View view2, View view3, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, coordinatorLayout, view2, view3, i) == null) && i == 0) {
                B(coordinatorLayout, view2, view3);
            }
        }

        public void q(CoordinatorLayout coordinatorLayout, View view2, View view3, int i, int i2, int[] iArr, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{coordinatorLayout, view2, view3, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3)}) == null) && i3 == 0) {
                p(coordinatorLayout, view2, view3, i, i2, iArr);
            }
        }

        @Deprecated
        public void s(CoordinatorLayout coordinatorLayout, View view2, View view3, int i, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{coordinatorLayout, view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && i5 == 0) {
                r(coordinatorLayout, view2, view3, i, i2, i3, i4);
            }
        }

        public void t(CoordinatorLayout coordinatorLayout, View view2, View view3, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{coordinatorLayout, view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr}) == null) {
                iArr[0] = iArr[0] + i3;
                iArr[1] = iArr[1] + i4;
                s(coordinatorLayout, view2, view3, i, i2, i3, i4, i5);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coordinatorLayout;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, windowInsetsCompat)) == null) {
                this.a.Q(windowInsetsCompat);
                return windowInsetsCompat;
            }
            return (WindowInsetsCompat) invokeLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoordinatorLayout a;

        public d(CoordinatorLayout coordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coordinatorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coordinatorLayout;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) && (onHierarchyChangeListener = this.a.r) != null) {
                onHierarchyChangeListener.onChildViewAdded(view2, view3);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
                this.a.B(2);
                ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a.r;
                if (onHierarchyChangeListener != null) {
                    onHierarchyChangeListener.onChildViewRemoved(view2, view3);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends ViewGroup.MarginLayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Behavior a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i, int i2) {
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
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, AttributeSet attributeSet) {
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
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qa0.LiveCoordinatorLayout_Layout);
            this.c = obtainStyledAttributes.getInteger(0, 0);
            this.f = obtainStyledAttributes.getResourceId(1, -1);
            this.d = obtainStyledAttributes.getInteger(2, 0);
            this.e = obtainStyledAttributes.getInteger(6, -1);
            this.g = obtainStyledAttributes.getInt(5, 0);
            this.h = obtainStyledAttributes.getInt(4, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(3);
            this.b = hasValue;
            if (hasValue) {
                this.a = CoordinatorLayout.E(context, attributeSet, AppBarLayout.ScrollingViewBehavior.class.getName());
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.a;
            if (behavior != null) {
                behavior.g(this);
            }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.MarginLayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                    return;
                }
            }
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.k == null && this.f != -1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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

        public Behavior e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return (Behavior) invokeV.objValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.p;
            }
            return invokeV.booleanValue;
        }

        public Rect g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.q;
            }
            return (Rect) invokeV.objValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.p = false;
            }
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.m = false;
            }
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            InterceptResult invokeLLL;
            Behavior behavior;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, coordinatorLayout, view2, view3)) == null) {
                if (view3 != this.l && !r(view3, ViewCompat.getLayoutDirection(coordinatorLayout)) && ((behavior = this.a) == null || !behavior.e(coordinatorLayout, view2, view3))) {
                    return false;
                }
                return true;
            }
            return invokeLLL.booleanValue;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, coordinatorLayout, view2)) == null) {
                if (this.f == -1) {
                    this.l = null;
                    this.k = null;
                    return null;
                }
                if (this.k == null || !s(view2, coordinatorLayout)) {
                    m(view2, coordinatorLayout);
                }
                return this.k;
            }
            return (View) invokeLL.objValue;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view2) {
            InterceptResult invokeLL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, coordinatorLayout, view2)) == null) {
                boolean z2 = this.m;
                if (z2) {
                    return true;
                }
                Behavior behavior = this.a;
                if (behavior != null) {
                    z = behavior.a(coordinatorLayout, view2);
                } else {
                    z = false;
                }
                boolean z3 = z | z2;
                this.m = z3;
                return z3;
            }
            return invokeLL.booleanValue;
        }

        public void q(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (i != 0) {
                    if (i == 1) {
                        this.o = z;
                        return;
                    }
                    return;
                }
                this.n = z;
            }
        }

        public final boolean r(View view2, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, view2, i)) == null) {
                int absoluteGravity = GravityCompat.getAbsoluteGravity(((e) view2.getLayoutParams()).g, i);
                if (absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.h, i) & absoluteGravity) == absoluteGravity) {
                    return true;
                }
                return false;
            }
            return invokeLI.booleanValue;
        }

        public boolean i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        return false;
                    }
                    return this.o;
                }
                return this.n;
            }
            return invokeI.booleanValue;
        }

        public void k(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                q(i, false);
            }
        }

        public void n(Behavior behavior) {
            Behavior behavior2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, behavior) == null) && (behavior2 = this.a) != behavior) {
                if (behavior2 != null) {
                    behavior2.j();
                }
                this.a = behavior;
                this.b = true;
                if (behavior != null) {
                    behavior.g(this);
                }
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

        public final void m(View view2, CoordinatorLayout coordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, view2, coordinatorLayout) == null) {
                View findViewById = coordinatorLayout.findViewById(this.f);
                this.k = findViewById;
                if (findViewById != null) {
                    if (findViewById == coordinatorLayout) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.l = null;
                            this.k = null;
                            return;
                        }
                        return;
                    }
                    for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                        if (parent == view2) {
                            if (coordinatorLayout.isInEditMode()) {
                                this.l = null;
                                this.k = null;
                                return;
                            }
                            return;
                        }
                        if (parent instanceof View) {
                            findViewById = (View) parent;
                        }
                    }
                    this.l = findViewById;
                } else if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                }
            }
        }

        public final boolean s(View view2, CoordinatorLayout coordinatorLayout) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, view2, coordinatorLayout)) == null) {
                if (this.k.getId() != this.f) {
                    return false;
                }
                View view3 = this.k;
                for (ViewParent parent = view3.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                    if (parent != null && parent != view2) {
                        if (parent instanceof View) {
                            view3 = (View) parent;
                        }
                    } else {
                        this.l = null;
                        this.k = null;
                        return false;
                    }
                }
                this.l = view3;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements ViewTreeObserver.OnPreDrawListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoordinatorLayout a;

        public f(CoordinatorLayout coordinatorLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coordinatorLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coordinatorLayout;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.B(0);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g() {
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view2, View view3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, view3)) == null) {
                float z = ViewCompat.getZ(view2);
                float z2 = ViewCompat.getZ(view3);
                if (z > z2) {
                    return -1;
                }
                if (z < z2) {
                    return 1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        String str;
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
        if (r0 != null) {
            str = r0.getName();
        } else {
            str = null;
        }
        u = str;
        if (Build.VERSION.SDK_INT >= 21) {
            x = new g();
        } else {
            x = null;
        }
        v = new Class[]{Context.class, AttributeSet.class};
        w = new ThreadLocal();
        y = new Pools.SynchronizedPool(12);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Parcelable y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            SparseArray sparseArray = new SparseArray();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final WindowInsetsCompat Q(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, windowInsetsCompat)) == null) {
            if (!ObjectsCompat.equals(this.o, windowInsetsCompat)) {
                this.o = windowInsetsCompat;
                boolean z2 = true;
                if (windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.p = z;
                setWillNotDraw((z || getBackground() != null) ? false : false);
                e(windowInsetsCompat);
                requestLayout();
            }
            return windowInsetsCompat;
        }
        return (WindowInsetsCompat) invokeL.objValue;
    }

    public final WindowInsetsCompat e(WindowInsetsCompat windowInsetsCompat) {
        InterceptResult invokeL;
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, windowInsetsCompat)) == null) {
            if (windowInsetsCompat.isConsumed()) {
                return windowInsetsCompat;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
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

    public void f(View view2) {
        List g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, view2) == null) && (g2 = this.b.g(view2)) != null && !g2.isEmpty()) {
            for (int i = 0; i < g2.size(); i++) {
                View view3 = (View) g2.get(i);
                Behavior e2 = ((e) view3.getLayoutParams()).e();
                if (e2 != null) {
                    e2.h(this, view3, view2);
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.p && this.q != null) {
                WindowInsetsCompat windowInsetsCompat = this.o;
                if (windowInsetsCompat != null) {
                    i = windowInsetsCompat.getSystemWindowInsetTop();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    this.q.setBounds(0, 0, getWidth(), i);
                    this.q.draw(canvas);
                }
            }
        }
    }

    public final void t(List list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, list) == null) {
            list.clear();
            boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
            int childCount = getChildCount();
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                if (isChildrenDrawingOrderEnabled) {
                    i = getChildDrawingOrder(childCount, i2);
                } else {
                    i = i2;
                }
                list.add(getChildAt(i));
            }
            Comparator comparator = x;
            if (comparator != null) {
                Collections.sort(list, comparator);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040447);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new pb0();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.f = new int[2];
        this.g = new int[2];
        this.t = new NestedScrollingParentHelper(this);
        if (i == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qa0.LiveCoordinatorLayout, 0, R.style.obfuscated_res_0x7f100121);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qa0.LiveCoordinatorLayout, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, qa0.LiveCoordinatorLayout, attributeSet, obtainStyledAttributes, 0, R.style.obfuscated_res_0x7f100121);
            } else {
                saveAttributeDataForStyleable(context, qa0.LiveCoordinatorLayout, attributeSet, obtainStyledAttributes, i, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.j = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.j.length;
            for (int i4 = 0; i4 < length; i4++) {
                int[] iArr = this.j;
                iArr[i4] = (int) (iArr[i4] * f2);
            }
        }
        this.q = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        R();
        super.setOnHierarchyChangeListener(new d(this));
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public final void z(View view2, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048655, this, view2, rect, i) == null) && ViewCompat.isLaidOut(view2) && view2.getWidth() > 0 && view2.getHeight() > 0) {
            e eVar = (e) view2.getLayoutParams();
            Behavior e2 = eVar.e();
            Rect a2 = a();
            Rect a3 = a();
            a3.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            if (e2 != null && e2.b(this, view2, a2)) {
                if (!a3.contains(a2)) {
                    return;
                }
            } else {
                a2.set(a3);
            }
            I(a3);
            if (a2.isEmpty()) {
                I(a2);
                return;
            }
            int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.h, i);
            boolean z3 = true;
            if ((absoluteGravity & 48) == 48 && (i6 = (a2.top - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - eVar.j) < (i7 = rect.top)) {
                P(view2, i7 - i6);
                z = true;
            } else {
                z = false;
            }
            if ((absoluteGravity & 80) == 80 && (height = ((getHeight() - a2.bottom) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) + eVar.j) < (i5 = rect.bottom)) {
                P(view2, height - i5);
                z = true;
            }
            if (!z) {
                P(view2, 0);
            }
            if ((absoluteGravity & 3) == 3 && (i3 = (a2.left - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - eVar.i) < (i4 = rect.left)) {
                O(view2, i4 - i3);
                z2 = true;
            } else {
                z2 = false;
            }
            if ((absoluteGravity & 5) == 5 && (width = ((getWidth() - a2.right) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin) + eVar.i) < (i2 = rect.right)) {
                O(view2, width - i2);
            } else {
                z3 = z2;
            }
            if (!z3) {
                O(view2, 0);
            }
            I(a2);
        }
    }

    public static Behavior E(Context context, AttributeSet attributeSet, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, attributeSet, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(".")) {
                str = context.getPackageName() + str;
            } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(u)) {
                str = u + IStringUtil.EXTENSION_SEPARATOR + str;
            }
            try {
                Map map = (Map) w.get();
                if (map == null) {
                    map = new HashMap();
                    w.set(map);
                }
                Constructor<?> constructor = (Constructor) map.get(str);
                if (constructor == null) {
                    constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(v);
                    constructor.setAccessible(true);
                    map.put(str, constructor);
                }
                return (Behavior) constructor.newInstance(context, attributeSet);
            } catch (Exception unused) {
                return null;
            }
        }
        return (Behavior) invokeLLL.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            e eVar = (e) view2.getLayoutParams();
            Behavior behavior = eVar.a;
            if (behavior != null) {
                float d2 = behavior.d(this, view2);
                if (d2 > 0.0f) {
                    if (this.e == null) {
                        this.e = new Paint();
                    }
                    this.e.setColor(eVar.a.c(this, view2));
                    this.e.setAlpha(c(Math.round(d2 * 255.0f), 0, 255));
                    int save = canvas.save();
                    if (view2.isOpaque()) {
                        canvas.clipRect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom(), Region.Op.DIFFERENCE);
                    }
                    canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.e);
                    canvas.restoreToCount(save);
                }
            }
            return super.drawChild(canvas, view2, j);
        }
        return invokeCommon.booleanValue;
    }

    public static void I(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, rect) == null) {
            rect.setEmpty();
            y.release(rect);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, layoutParams)) == null) {
            if ((layoutParams instanceof e) && super.checkLayoutParams(layoutParams)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: i */
    public e generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, attributeSet)) == null) {
            return new e(getContext(), attributeSet);
        }
        return (e) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: j */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, layoutParams)) == null) {
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

    public List l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, view2)) == null) {
            List h = this.b.h(view2);
            this.d.clear();
            if (h != null) {
                this.d.addAll(h);
            }
            return this.d;
        }
        return (List) invokeL.objValue;
    }

    public List m(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, view2)) == null) {
            List g2 = this.b.g(view2);
            this.d.clear();
            if (g2 != null) {
                this.d.addAll(g2);
            }
            return this.d;
        }
        return (List) invokeL.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                K(true);
            }
            boolean F = F(motionEvent, 0);
            if (actionMasked == 1 || actionMasked == 3) {
                K(true);
            }
            return F;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, view2) == null) {
            onStopNestedScroll(view2, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            super.requestDisallowInterceptTouchEvent(z);
            if (z && !this.h) {
                K(false);
                this.h = true;
            }
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            super.setFitsSystemWindows(z);
            R();
        }
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, onHierarchyChangeListener) == null) {
            this.r = onHierarchyChangeListener;
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            setStatusBarBackground(new ColorDrawable(i));
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            if (i != 0) {
                drawable = ContextCompat.getDrawable(getContext(), i);
            } else {
                drawable = null;
            }
            setStatusBarBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            super.setVisibility(i);
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
            Drawable drawable = this.q;
            if (drawable != null && drawable.isVisible() != z) {
                this.q.setVisible(z, false);
            }
        }
    }

    public final boolean u(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, view2)) == null) {
            return this.b.j(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, drawable)) == null) {
            if (!super.verifyDrawable(drawable) && drawable != this.q) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Rect a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            Rect rect = (Rect) y.acquire();
            if (rect == null) {
                return new Rect();
            }
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.i && this.m != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.m);
            }
            this.n = false;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.i) {
                if (this.m == null) {
                    this.m = new f(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.m);
            }
            this.n = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.q;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | drawable.setState(drawableState);
            }
            if (z) {
                invalidate();
            }
        }
    }

    public final List getDependencySortedChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            G();
            return Collections.unmodifiableList(this.a);
        }
        return (List) invokeV.objValue;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.o;
        }
        return (WindowInsetsCompat) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.t.getNestedScrollAxes();
        }
        return invokeV.intValue;
    }

    public Drawable getStatusBarBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.q;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: h */
    public e generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return new e(-2, -2);
        }
        return (e) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            super.onDetachedFromWindow();
            K(false);
            if (this.n && this.m != null) {
                getViewTreeObserver().removeOnPreDrawListener(this.m);
            }
            View view2 = this.l;
            if (view2 != null) {
                onStopNestedScroll(view2);
            }
            this.i = false;
        }
    }

    public void A(View view2, int i) {
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            e eVar = (e) view2.getLayoutParams();
            if (eVar.k != null) {
                Rect a2 = a();
                Rect a3 = a();
                Rect a4 = a();
                n(eVar.k, a2);
                boolean z = false;
                k(view2, false, a3);
                int measuredWidth = view2.getMeasuredWidth();
                int measuredHeight = view2.getMeasuredHeight();
                p(view2, i, a2, a4, eVar, measuredWidth, measuredHeight);
                z = (a4.left == a3.left && a4.top == a3.top) ? true : true;
                d(eVar, a4, measuredWidth, measuredHeight);
                int i2 = a4.left - a3.left;
                int i3 = a4.top - a3.top;
                if (i2 != 0) {
                    ViewCompat.offsetLeftAndRight(view2, i2);
                }
                if (i3 != 0) {
                    ViewCompat.offsetTopAndBottom(view2, i3);
                }
                if (z && (e2 = eVar.e()) != null) {
                    e2.h(this, view2, eVar.k);
                }
                I(a2);
                I(a3);
                I(a4);
            }
        }
    }

    public final void B(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int size = this.a.size();
            Rect a2 = a();
            Rect a3 = a();
            Rect a4 = a();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = (View) this.a.get(i2);
                e eVar = (e) view2.getLayoutParams();
                if (i != 0 || view2.getVisibility() != 8) {
                    for (int i3 = 0; i3 < i2; i3++) {
                        if (eVar.l == ((View) this.a.get(i3))) {
                            A(view2, layoutDirection);
                        }
                    }
                    k(view2, true, a3);
                    if (eVar.g != 0 && !a3.isEmpty()) {
                        int absoluteGravity = GravityCompat.getAbsoluteGravity(eVar.g, layoutDirection);
                        int i4 = absoluteGravity & 112;
                        if (i4 != 48) {
                            if (i4 == 80) {
                                a2.bottom = Math.max(a2.bottom, getHeight() - a3.top);
                            }
                        } else {
                            a2.top = Math.max(a2.top, a3.bottom);
                        }
                        int i5 = absoluteGravity & 7;
                        if (i5 != 3) {
                            if (i5 == 5) {
                                a2.right = Math.max(a2.right, getWidth() - a3.left);
                            }
                        } else {
                            a2.left = Math.max(a2.left, a3.right);
                        }
                    }
                    if (eVar.h != 0 && view2.getVisibility() == 0) {
                        z(view2, a2, layoutDirection);
                    }
                    if (i != 2) {
                        r(view2, a4);
                        if (!a4.equals(a3)) {
                            H(view2, a3);
                        }
                    }
                    for (int i6 = i2 + 1; i6 < size; i6++) {
                        View view3 = (View) this.a.get(i6);
                        e eVar2 = (e) view3.getLayoutParams();
                        Behavior e2 = eVar2.e();
                        if (e2 != null && e2.e(this, view3, view2)) {
                            if (i == 0 && eVar2.f()) {
                                eVar2.j();
                            } else {
                                if (i != 2) {
                                    z = e2.h(this, view3, view2);
                                } else {
                                    e2.i(this, view3, view2);
                                    z = true;
                                }
                                if (i == 1) {
                                    eVar2.o(z);
                                }
                            }
                        }
                    }
                }
            }
            I(a2);
            I(a3);
            I(a4);
        }
    }

    public void C(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
            e eVar = (e) view2.getLayoutParams();
            if (eVar.a()) {
                return;
            }
            View view3 = eVar.k;
            if (view3 != null) {
                x(view2, view3, i);
                return;
            }
            int i2 = eVar.e;
            if (i2 >= 0) {
                y(view2, i2, i);
            } else {
                w(view2, i);
            }
        }
    }

    public void H(View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, rect) == null) {
            ((e) view2.getLayoutParams()).p(rect);
        }
    }

    public final void O(View view2, int i) {
        e eVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048585, this, view2, i) == null) && (i2 = (eVar = (e) view2.getLayoutParams()).i) != i) {
            ViewCompat.offsetLeftAndRight(view2, i - i2);
            eVar.i = i;
        }
    }

    public final void P(View view2, int i) {
        e eVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048586, this, view2, i) == null) && (i2 = (eVar = (e) view2.getLayoutParams()).j) != i) {
            ViewCompat.offsetTopAndBottom(view2, i - i2);
            eVar.j = i;
        }
    }

    public void n(View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, view2, rect) == null) {
            qb0.a(this, view2, rect);
        }
    }

    public void r(View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, view2, rect) == null) {
            rect.set(((e) view2.getLayoutParams()).g());
        }
    }

    public void D(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            measureChildWithMargins(view2, i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            onNestedScroll(view2, i, i2, i3, i4, 0);
        }
    }

    public final boolean F(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, motionEvent, i)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            List list = this.c;
            t(list);
            int size = list.size();
            MotionEvent motionEvent2 = null;
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = (View) list.get(i2);
                e eVar = (e) view2.getLayoutParams();
                Behavior e2 = eVar.e();
                if ((z || z2) && actionMasked != 0) {
                    if (e2 != null) {
                        if (motionEvent2 == null) {
                            long uptimeMillis = SystemClock.uptimeMillis();
                            motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        }
                        if (i != 0) {
                            if (i == 1) {
                                e2.D(this, view2, motionEvent2);
                            }
                        } else {
                            e2.k(this, view2, motionEvent2);
                        }
                    }
                } else {
                    if (!z && e2 != null) {
                        if (i != 0) {
                            if (i == 1) {
                                z = e2.D(this, view2, motionEvent);
                            }
                        } else {
                            z = e2.k(this, view2, motionEvent);
                        }
                        if (z) {
                            this.k = view2;
                        }
                    }
                    boolean c2 = eVar.c();
                    boolean h = eVar.h(this, view2);
                    if (h && !c2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (h && !z2) {
                        break;
                    }
                }
            }
            list.clear();
            return z;
        }
        return invokeLI.booleanValue;
    }

    public final void w(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048652, this, view2, i) == null) {
            e eVar = (e) view2.getLayoutParams();
            Rect a2 = a();
            a2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
            if (this.o != null && ViewCompat.getFitsSystemWindows(this) && !ViewCompat.getFitsSystemWindows(view2)) {
                a2.left += this.o.getSystemWindowInsetLeft();
                a2.top += this.o.getSystemWindowInsetTop();
                a2.right -= this.o.getSystemWindowInsetRight();
                a2.bottom -= this.o.getSystemWindowInsetBottom();
            }
            Rect a3 = a();
            GravityCompat.apply(M(eVar.c), view2.getMeasuredWidth(), view2.getMeasuredHeight(), a2, a3, i);
            view2.layout(a3.left, a3.top, a3.right, a3.bottom);
            I(a2);
            I(a3);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.clear();
            this.b.c();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                e s = s(childAt);
                s.d(this, childAt);
                this.b.b(childAt);
                for (int i2 = 0; i2 < childCount; i2++) {
                    if (i2 != i) {
                        View childAt2 = getChildAt(i2);
                        if (s.b(this, childAt, childAt2)) {
                            if (!this.b.d(childAt2)) {
                                this.b.b(childAt2);
                            }
                            this.b.a(childAt2, childAt);
                        }
                    }
                }
            }
            this.a.addAll(this.b.i());
            Collections.reverse(this.a);
        }
    }

    public final void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                Behavior e2 = ((e) childAt.getLayoutParams()).e();
                if (e2 != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    if (z) {
                        e2.k(this, childAt, obtain);
                    } else {
                        e2.D(this, childAt, obtain);
                    }
                    obtain.recycle();
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                ((e) getChildAt(i2).getLayoutParams()).l();
            }
            this.k = null;
            this.h = false;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            SparseArray sparseArray = savedState.behaviorStates;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior e2 = s(childAt).e();
                if (id != -1 && e2 != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                    e2.x(this, childAt, parcelable2);
                }
            }
        }
    }

    public final int q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048637, this, i)) == null) {
            int[] iArr = this.j;
            if (iArr == null) {
                Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "No keylines defined for " + this + " - attempted index lookup " + i);
                return 0;
            } else if (i >= 0 && i < iArr.length) {
                return iArr[i];
            } else {
                Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "Keyline index " + i + " out of range for " + this);
                return 0;
            }
        }
        return invokeI.intValue;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048644, this, drawable) == null) && (drawable2 = this.q) != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.q = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.q, ViewCompat.getLayoutDirection(this));
                Drawable drawable4 = this.q;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable4.setVisible(z, false);
                this.q.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (ViewCompat.getFitsSystemWindows(this)) {
            if (this.s == null) {
                this.s = new a(this);
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, this.s);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                } else if (u(getChildAt(i))) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z != this.n) {
                if (z) {
                    b();
                } else {
                    J();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onAttachedToWindow();
            K(false);
            if (this.n) {
                if (this.m == null) {
                    this.m = new f(this);
                }
                getViewTreeObserver().addOnPreDrawListener(this.m);
            }
            if (this.o == null && ViewCompat.getFitsSystemWindows(this)) {
                ViewCompat.requestApplyInsets(this);
            }
            this.i = true;
        }
    }

    public final void d(e eVar, Rect rect, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048591, this, eVar, rect, i, i2) == null) {
            int width = getWidth();
            int height = getHeight();
            int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
            int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
            rect.set(max, max2, i + max, i2 + max2);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view2, View view3, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048632, this, view2, view3, i, i2)) == null) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    Behavior e2 = eVar.e();
                    if (e2 != null) {
                        boolean A = e2.A(this, childAt, view2, view3, i, i2);
                        z |= A;
                        eVar.q(i2, A);
                    } else {
                        eVar.q(i2, false);
                    }
                }
            }
            return z;
        }
        return invokeLLII.booleanValue;
    }

    public void k(View view2, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{view2, Boolean.valueOf(z), rect}) == null) {
            if (!view2.isLayoutRequested() && view2.getVisibility() != 8) {
                if (z) {
                    n(view2, rect);
                    return;
                } else {
                    rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                    return;
                }
            }
            rect.setEmpty();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(0) && (e2 = eVar.e()) != null) {
                        z |= e2.o(this, childAt, view2, f2, f3);
                    }
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void o(View view2, int i, Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048613, this, view2, i, rect, rect2) == null) {
            e eVar = (e) view2.getLayoutParams();
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            p(view2, i, rect, rect2, eVar, measuredWidth, measuredHeight);
            d(eVar, rect2, measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            int size = this.a.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) this.a.get(i5);
                if (view2.getVisibility() != 8 && ((e2 = ((e) view2.getLayoutParams()).e()) == null || !e2.l(this, view2, layoutDirection))) {
                    C(view2, layoutDirection);
                }
            }
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
    public void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        Behavior e2;
        e eVar;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048619, this, i, i2) == null) {
            G();
            g();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int layoutDirection = ViewCompat.getLayoutDirection(this);
            if (layoutDirection == 1) {
                z = true;
            } else {
                z = false;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            int i13 = paddingLeft + paddingRight;
            int i14 = paddingTop + paddingBottom;
            int suggestedMinimumWidth = getSuggestedMinimumWidth();
            int suggestedMinimumHeight = getSuggestedMinimumHeight();
            if (this.o != null && ViewCompat.getFitsSystemWindows(this)) {
                z2 = true;
            } else {
                z2 = false;
            }
            int size3 = this.a.size();
            int i15 = suggestedMinimumWidth;
            int i16 = suggestedMinimumHeight;
            int i17 = 0;
            int i18 = 0;
            while (i18 < size3) {
                View view2 = (View) this.a.get(i18);
                if (view2.getVisibility() == 8) {
                    i11 = i18;
                    i8 = size3;
                    i9 = paddingLeft;
                } else {
                    e eVar2 = (e) view2.getLayoutParams();
                    int i19 = eVar2.e;
                    if (i19 >= 0 && mode != 0) {
                        int q = q(i19);
                        int absoluteGravity = GravityCompat.getAbsoluteGravity(N(eVar2.c), layoutDirection) & 7;
                        i3 = i17;
                        if ((absoluteGravity == 3 && !z) || (absoluteGravity == 5 && z)) {
                            i4 = Math.max(0, (size - paddingRight) - q);
                        } else if ((absoluteGravity == 5 && !z) || (absoluteGravity == 3 && z)) {
                            i4 = Math.max(0, q - paddingLeft);
                        }
                        if (!z2 && !ViewCompat.getFitsSystemWindows(view2)) {
                            i5 = View.MeasureSpec.makeMeasureSpec(size - (this.o.getSystemWindowInsetLeft() + this.o.getSystemWindowInsetRight()), mode);
                            i6 = View.MeasureSpec.makeMeasureSpec(size2 - (this.o.getSystemWindowInsetTop() + this.o.getSystemWindowInsetBottom()), mode2);
                        } else {
                            i5 = i;
                            i6 = i2;
                        }
                        e2 = eVar2.e();
                        if (e2 == null) {
                            eVar = eVar2;
                            i10 = i3;
                            i11 = i18;
                            i7 = i16;
                            i9 = paddingLeft;
                            i12 = i15;
                            i8 = size3;
                        } else {
                            eVar = eVar2;
                            i7 = i16;
                            i8 = size3;
                            i9 = paddingLeft;
                            i10 = i3;
                            i11 = i18;
                            i12 = i15;
                        }
                        D(view2, i5, i4, i6, 0);
                        e eVar3 = eVar;
                        int max = Math.max(i12, i13 + view2.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar3).leftMargin + ((ViewGroup.MarginLayoutParams) eVar3).rightMargin);
                        int max2 = Math.max(i7, i14 + view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin);
                        i17 = View.combineMeasuredStates(i10, view2.getMeasuredState());
                        i15 = max;
                        i16 = max2;
                    } else {
                        i3 = i17;
                    }
                    i4 = 0;
                    if (!z2) {
                    }
                    i5 = i;
                    i6 = i2;
                    e2 = eVar2.e();
                    if (e2 == null) {
                    }
                    D(view2, i5, i4, i6, 0);
                    e eVar32 = eVar;
                    int max3 = Math.max(i12, i13 + view2.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar32).leftMargin + ((ViewGroup.MarginLayoutParams) eVar32).rightMargin);
                    int max22 = Math.max(i7, i14 + view2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar32).topMargin + ((ViewGroup.MarginLayoutParams) eVar32).bottomMargin);
                    i17 = View.combineMeasuredStates(i10, view2.getMeasuredState());
                    i15 = max3;
                    i16 = max22;
                }
                i18 = i11 + 1;
                paddingLeft = i9;
                size3 = i8;
            }
            int i20 = i17;
            setMeasuredDimension(View.resolveSizeAndState(i15, i, (-16777216) & i20), View.resolveSizeAndState(i16, i2, i20 << 16));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view2, float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(0) && (e2 = eVar.e()) != null) {
                        z2 |= e2.n(this, childAt, view2, f2, f3, z);
                    }
                }
            }
            if (z2) {
                B(1);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), iArr}) == null) {
            onNestedPreScroll(view2, i, i2, iArr, 0);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view2, View view3, int i, int i2) {
        Behavior e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048628, this, view2, view3, i, i2) == null) {
            this.t.onNestedScrollAccepted(view2, view3, i, i2);
            this.l = view3;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i2) && (e2 = eVar.e()) != null) {
                    e2.v(this, childAt, view2, view3, i, i2);
                }
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr, int i3) {
        Behavior e2;
        int min;
        int min2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), iArr, Integer.valueOf(i3)}) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(i3) && (e2 = eVar.e()) != null) {
                        int[] iArr2 = this.f;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                        e2.q(this, childAt, view2, i, i2, iArr2, i3);
                        int[] iArr3 = this.f;
                        if (i > 0) {
                            min = Math.max(i4, iArr3[0]);
                        } else {
                            min = Math.min(i4, iArr3[0]);
                        }
                        i4 = min;
                        int[] iArr4 = this.f;
                        if (i2 > 0) {
                            min2 = Math.max(i5, iArr4[1]);
                        } else {
                            min2 = Math.min(i5, iArr4[1]);
                        }
                        i5 = min2;
                        z = true;
                    }
                }
            }
            iArr[0] = i4;
            iArr[1] = i5;
            if (z) {
                B(1);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            onNestedScroll(view2, i, i2, i3, i4, 0, this.g);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Behavior e2;
        int min;
        int min2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr}) == null) {
            int childCount = getChildCount();
            boolean z = false;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    e eVar = (e) childAt.getLayoutParams();
                    if (eVar.i(i5) && (e2 = eVar.e()) != null) {
                        int[] iArr2 = this.f;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                        e2.t(this, childAt, view2, i, i2, i3, i4, i5, iArr2);
                        int[] iArr3 = this.f;
                        if (i3 > 0) {
                            min = Math.max(i6, iArr3[0]);
                        } else {
                            min = Math.min(i6, iArr3[0]);
                        }
                        i6 = min;
                        if (i4 > 0) {
                            min2 = Math.max(i7, this.f[1]);
                        } else {
                            min2 = Math.min(i7, this.f[1]);
                        }
                        i7 = min2;
                        z = true;
                    }
                }
            }
            iArr[0] = iArr[0] + i6;
            iArr[1] = iArr[1] + i7;
            if (z) {
                B(1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view2, View view3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048627, this, view2, view3, i) == null) {
            onNestedScrollAccepted(view2, view3, i, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view2, View view3, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048631, this, view2, view3, i)) == null) {
            return onStartNestedScroll(view2, view3, i, 0);
        }
        return invokeLLI.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view2, Rect rect, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048639, this, view2, rect, z)) == null) {
            Behavior e2 = ((e) view2.getLayoutParams()).e();
            if (e2 != null && e2.w(this, view2, rect, z)) {
                return true;
            }
            return super.requestChildRectangleOnScreen(view2, rect, z);
        }
        return invokeLLZ.booleanValue;
    }

    public boolean v(View view2, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048650, this, view2, i, i2)) == null) {
            Rect a2 = a();
            n(view2, a2);
            try {
                return a2.contains(i, i2);
            } finally {
                I(a2);
            }
        }
        return invokeLII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048634, this, view2, i) == null) {
            this.t.onStopNestedScroll(view2, i);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.i(i)) {
                    Behavior e2 = eVar.e();
                    if (e2 != null) {
                        e2.C(this, childAt, view2, i);
                    }
                    eVar.k(i);
                    eVar.j();
                }
            }
            this.l = null;
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
        boolean z;
        Behavior e2;
        boolean D;
        MotionEvent motionEvent2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, motionEvent)) == null) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.k == null) {
                z = F(motionEvent, 1);
            } else {
                z = false;
            }
            View view2 = this.k;
            if (view2 != null && (e2 = ((e) view2.getLayoutParams()).e()) != null) {
                D = e2.D(this, this.k, motionEvent);
                motionEvent2 = null;
                if (this.k != null) {
                    D |= super.onTouchEvent(motionEvent);
                } else if (z) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    super.onTouchEvent(motionEvent2);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                if (actionMasked != 1 || actionMasked == 3) {
                    K(false);
                }
                return D;
            }
            D = false;
            motionEvent2 = null;
            if (this.k != null) {
            }
            if (motionEvent2 != null) {
            }
            if (actionMasked != 1) {
            }
            K(false);
            return D;
        }
        return invokeL.booleanValue;
    }

    public e s(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, view2)) == null) {
            e eVar = (e) view2.getLayoutParams();
            if (!eVar.b) {
                if (view2 instanceof b) {
                    Behavior behavior = ((b) view2).getBehavior();
                    if (behavior == null) {
                        Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "Attached behavior class is null");
                    }
                    eVar.n(behavior);
                    eVar.b = true;
                } else {
                    c cVar = null;
                    for (Class<?> cls = view2.getClass(); cls != null; cls = cls.getSuperclass()) {
                        cVar = (c) cls.getAnnotation(c.class);
                        if (cVar != null) {
                            break;
                        }
                    }
                    if (cVar != null) {
                        try {
                            eVar.n((Behavior) cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                        } catch (Exception e2) {
                            Log.e(androidx.coordinatorlayout.widget.CoordinatorLayout.TAG, "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                        }
                    }
                    eVar.b = true;
                }
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public final void p(View view2, int i, Rect rect, Rect rect2, e eVar, int i2, int i3) {
        int width;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{view2, Integer.valueOf(i), rect, rect2, eVar, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            int absoluteGravity = GravityCompat.getAbsoluteGravity(L(eVar.c), i);
            int absoluteGravity2 = GravityCompat.getAbsoluteGravity(M(eVar.d), i);
            int i4 = absoluteGravity & 7;
            int i5 = absoluteGravity & 112;
            int i6 = absoluteGravity2 & 7;
            int i7 = absoluteGravity2 & 112;
            if (i6 != 1) {
                if (i6 != 5) {
                    width = rect.left;
                } else {
                    width = rect.right;
                }
            } else {
                width = rect.left + (rect.width() / 2);
            }
            if (i7 != 16) {
                if (i7 != 80) {
                    height = rect.top;
                } else {
                    height = rect.bottom;
                }
            } else {
                height = rect.top + (rect.height() / 2);
            }
            if (i4 != 1) {
                if (i4 != 5) {
                    width -= i2;
                }
            } else {
                width -= i2 / 2;
            }
            if (i5 != 16) {
                if (i5 != 80) {
                    height -= i3;
                }
            } else {
                height -= i3 / 2;
            }
            rect2.set(width, height, i2 + width, i3 + height);
        }
    }

    public final void x(View view2, View view3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048653, this, view2, view3, i) == null) {
            Rect a2 = a();
            Rect a3 = a();
            try {
                n(view3, a2);
                o(view2, i, a2, a3);
                view2.layout(a3.left, a3.top, a3.right, a3.bottom);
            } finally {
                I(a2);
                I(a3);
            }
        }
    }

    public final void y(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048654, this, view2, i, i2) == null) {
            e eVar = (e) view2.getLayoutParams();
            int absoluteGravity = GravityCompat.getAbsoluteGravity(N(eVar.c), i2);
            int i3 = absoluteGravity & 7;
            int i4 = absoluteGravity & 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            if (i2 == 1) {
                i = width - i;
            }
            int q = q(i) - measuredWidth;
            int i5 = 0;
            if (i3 != 1) {
                if (i3 == 5) {
                    q += measuredWidth;
                }
            } else {
                q += measuredWidth / 2;
            }
            if (i4 != 16) {
                if (i4 == 80) {
                    i5 = measuredHeight + 0;
                }
            } else {
                i5 = 0 + (measuredHeight / 2);
            }
            int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin, Math.min(q, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
            int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin));
            view2.layout(max, max2, measuredWidth + max, measuredHeight + max2);
        }
    }
}
