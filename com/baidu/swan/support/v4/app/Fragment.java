package com.baidu.swan.support.v4.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.be4;
import com.repackage.de4;
import com.repackage.ee4;
import com.repackage.fe4;
import com.repackage.je4;
import com.repackage.se4;
import com.repackage.ve4;
import com.repackage.xe4;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes2.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static /* synthetic */ Interceptable $ic;
    public static final ve4<String, Class<?>> Z;
    public static final Object g0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public ViewGroup H;
    public View I;
    public View J;
    public boolean K;
    public boolean L;
    public je4 M;
    public boolean N;
    public boolean O;
    public Object P;
    public Object Q;
    public Object R;
    public Object S;
    public Object T;
    public Object U;
    public Boolean V;
    public Boolean W;
    public SharedElementCallback X;
    public SharedElementCallback Y;
    public int a;
    public View b;
    public int c;
    public Bundle d;
    public SparseArray<Parcelable> e;
    public int f;
    public String g;
    public Bundle h;
    public Fragment i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public fe4 s;
    public de4 t;
    public fe4 u;
    public Fragment v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    /* loaded from: classes2.dex */
    public static class InstantiationException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a extends be4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Fragment a;

        public a(Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fragment;
        }

        @Override // com.repackage.be4
        @Nullable
        public View a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                View view2 = this.a.I;
                if (view2 != null) {
                    return view2.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }
            return (View) invokeI.objValue;
        }

        @Override // com.repackage.be4
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.I != null : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(726904892, "Lcom/baidu/swan/support/v4/app/Fragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(726904892, "Lcom/baidu/swan/support/v4/app/Fragment;");
                return;
            }
        }
        Z = new ve4<>();
        g0 = new Object();
    }

    public Fragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f = -1;
        this.j = -1;
        this.E = true;
        this.L = true;
        this.P = null;
        Object obj = g0;
        this.Q = obj;
        this.R = null;
        this.S = obj;
        this.T = null;
        this.U = obj;
        this.X = null;
        this.Y = null;
    }

    public static Fragment X(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? Y(context, str, null) : (Fragment) invokeLL.objValue;
    }

    public static Fragment Y(Context context, String str, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, bundle)) == null) {
            try {
                Class<?> cls = Z.get(str);
                if (cls == null) {
                    cls = context.getClassLoader().loadClass(str);
                    Z.put(str, cls);
                }
                Fragment fragment = (Fragment) cls.newInstance();
                if (bundle != null) {
                    bundle.setClassLoader(fragment.getClass().getClassLoader());
                    fragment.h = bundle;
                }
                return fragment;
            } catch (ClassNotFoundException e) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
            } catch (IllegalAccessException e2) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
            } catch (java.lang.InstantiationException e3) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
            }
        }
        return (Fragment) invokeLLL.objValue;
    }

    public static boolean p0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                Class<?> cls = Z.get(str);
                if (cls == null) {
                    cls = context.getClassLoader().loadClass(str);
                    Z.put(str, cls);
                }
                return Fragment.class.isAssignableFrom(cls);
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public Object A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object obj = this.S;
            return obj == g0 ? u() : obj;
        }
        return invokeV.objValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.F = true;
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.F = true;
        }
    }

    public Object D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object obj = this.Q;
            return obj == g0 ? s() : obj;
        }
        return invokeV.objValue;
    }

    public void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Deprecated
    public void E0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, activity, attributeSet, bundle) == null) {
            this.F = true;
        }
    }

    public Object F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.T : invokeV.objValue;
    }

    public void F0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, attributeSet, bundle) == null) {
            this.F = true;
            de4 de4Var = this.t;
            Activity activity = de4Var == null ? null : de4Var.getActivity();
            if (activity != null) {
                this.F = false;
                E0(activity, attributeSet, bundle);
            }
        }
    }

    public Object G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Object obj = this.U;
            return obj == g0 ? F() : obj;
        }
        return invokeV.objValue;
    }

    public boolean G0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String H(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? getResources().getString(i) : (String) invokeI.objValue;
    }

    public void H0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, menu) == null) {
        }
    }

    public final String I(@StringRes int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, objArr)) == null) ? getResources().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public void I0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, menu) == null) {
        }
    }

    public final Fragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i : (Fragment) invokeV.objValue;
    }

    public void J0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048592, this, i, strArr, iArr) == null) {
        }
    }

    public final int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : invokeV.intValue;
    }

    public void K0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.F = true;
            if (this.N) {
                return;
            }
            this.N = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, true, false);
            }
            je4 je4Var = this.M;
            if (je4Var != null) {
                je4Var.f();
            }
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.F = true;
        }
    }

    public void N0(View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, view2, bundle) == null) {
        }
    }

    public final CharSequence O(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) ? getResources().getText(i) : (CharSequence) invokeI.objValue;
    }

    public void O0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            this.F = true;
        }
    }

    public void P0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.V();
            }
            this.F = false;
            q0(bundle);
            if (this.F) {
                fe4 fe4Var2 = this.u;
                if (fe4Var2 != null) {
                    fe4Var2.n();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.L : invokeV.booleanValue;
    }

    public void Q0(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, configuration) == null) {
            onConfigurationChanged(configuration);
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.o(configuration);
            }
        }
    }

    public boolean R0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, menuItem)) == null) {
            if (this.z) {
                return false;
            }
            if (u0(menuItem)) {
                return true;
            }
            fe4 fe4Var = this.u;
            return fe4Var != null && fe4Var.p(menuItem);
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public View S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.I : (View) invokeV.objValue;
    }

    public void S0(Bundle bundle) {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bundle) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.V();
            }
            this.F = false;
            v0(bundle);
            if (!this.F) {
                throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
            } else if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            } else {
                if (this.u == null) {
                    e0();
                }
                this.u.b0(parcelable, null);
                this.u.q();
            }
        }
    }

    public boolean T0(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, menu, menuInflater)) == null) {
            boolean z = false;
            if (this.z) {
                return false;
            }
            if (this.D && this.E) {
                x0(menu, menuInflater);
                z = true;
            }
            fe4 fe4Var = this.u;
            return fe4Var != null ? z | fe4Var.r(menu, menuInflater) : z;
        }
        return invokeLL.booleanValue;
    }

    public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048607, this, layoutInflater, viewGroup, bundle)) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.V();
            }
            return y0(layoutInflater, viewGroup, bundle);
        }
        return (View) invokeLLL.objValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.f = -1;
            this.g = null;
            this.l = false;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = 0;
            this.s = null;
            this.u = null;
            this.t = null;
            this.w = 0;
            this.x = 0;
            this.y = null;
            this.z = false;
            this.A = false;
            this.C = false;
            this.M = null;
            this.N = false;
            this.O = false;
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.s();
            }
            this.F = false;
            z0();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.t();
            }
            this.F = false;
            B0();
            if (this.F) {
                je4 je4Var = this.M;
                if (je4Var != null) {
                    je4Var.c();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            onLowMemory();
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.u();
            }
        }
    }

    public boolean Y0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, menuItem)) == null) {
            if (this.z) {
                return false;
            }
            if (this.D && this.E && G0(menuItem)) {
                return true;
            }
            fe4 fe4Var = this.u;
            return fe4Var != null && fe4Var.v(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void Z0(Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, menu) == null) || this.z) {
            return;
        }
        if (this.D && this.E) {
            H0(menu);
        }
        fe4 fe4Var = this.u;
        if (fe4Var != null) {
            fe4Var.w(menu);
        }
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.x();
            }
            this.F = false;
            onPause();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public boolean b1(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, menu)) == null) {
            boolean z = false;
            if (this.z) {
                return false;
            }
            if (this.D && this.E) {
                I0(menu);
                z = true;
            }
            fe4 fe4Var = this.u;
            return fe4Var != null ? z | fe4Var.y(menu) : z;
        }
        return invokeL.booleanValue;
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.z();
            }
            if (this.N) {
                this.N = false;
                if (!this.O) {
                    this.O = true;
                    this.M = this.t.i(this.g, false, false);
                }
                je4 je4Var = this.M;
                if (je4Var != null) {
                    if (!this.C) {
                        je4Var.g();
                    } else {
                        je4Var.e();
                    }
                }
            }
        }
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.V();
                this.u.E();
            }
            this.F = false;
            onResume();
            if (this.F) {
                fe4 fe4Var2 = this.u;
                if (fe4Var2 != null) {
                    fe4Var2.A();
                    this.u.E();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            fe4 fe4Var = new fe4();
            this.u = fe4Var;
            fe4Var.j(this.t, new a(this), this);
        }
    }

    public void e1(Bundle bundle) {
        Parcelable e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            K0(bundle);
            fe4 fe4Var = this.u;
            if (fe4Var == null || (e0 = fe4Var.e0()) == null) {
                return;
            }
            bundle.putParcelable("android:support:fragments", e0);
        }
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, obj)) == null) ? super.equals(obj) : invokeL.booleanValue;
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.V();
                this.u.E();
            }
            this.F = false;
            L0();
            if (this.F) {
                fe4 fe4Var2 = this.u;
                if (fe4Var2 != null) {
                    fe4Var2.B();
                }
                je4 je4Var = this.M;
                if (je4Var != null) {
                    je4Var.d();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.t != null && this.l : invokeV.booleanValue;
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            fe4 fe4Var = this.u;
            if (fe4Var != null) {
                fe4Var.C();
            }
            this.F = false;
            M0();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final FragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            de4 de4Var = this.t;
            if (de4Var == null) {
                return null;
            }
            return (FragmentActivity) de4Var.getActivity();
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            de4 de4Var = this.t;
            if (de4Var == null) {
                return null;
            }
            return de4Var.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            de4 de4Var = this.t;
            if (de4Var != null) {
                return de4Var.getContext().getResources();
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return (Resources) invokeV.objValue;
    }

    public final void h1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            SparseArray<Parcelable> sparseArray = this.e;
            if (sparseArray != null) {
                this.J.restoreHierarchyState(sparseArray);
                this.e = null;
            }
            this.F = false;
            O0(bundle);
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048629, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mFragmentId=#");
            printWriter.print(Integer.toHexString(this.w));
            printWriter.print(" mContainerId=#");
            printWriter.print(Integer.toHexString(this.x));
            printWriter.print(" mTag=");
            printWriter.println(this.y);
            printWriter.print(str);
            printWriter.print("mState=");
            printWriter.print(this.a);
            printWriter.print(" mIndex=");
            printWriter.print(this.f);
            printWriter.print(" mWho=");
            printWriter.print(this.g);
            printWriter.print(" mBackStackNesting=");
            printWriter.println(this.r);
            printWriter.print(str);
            printWriter.print("mAdded=");
            printWriter.print(this.l);
            printWriter.print(" mRemoving=");
            printWriter.print(this.m);
            printWriter.print(" mResumed=");
            printWriter.print(this.n);
            printWriter.print(" mFromLayout=");
            printWriter.print(this.o);
            printWriter.print(" mInLayout=");
            printWriter.println(this.p);
            printWriter.print(str);
            printWriter.print("mHidden=");
            printWriter.print(this.z);
            printWriter.print(" mDetached=");
            printWriter.print(this.A);
            printWriter.print(" mMenuVisible=");
            printWriter.print(this.E);
            printWriter.print(" mHasMenu=");
            printWriter.println(this.D);
            printWriter.print(str);
            printWriter.print("mRetainInstance=");
            printWriter.print(this.B);
            printWriter.print(" mRetaining=");
            printWriter.print(this.C);
            printWriter.print(" mUserVisibleHint=");
            printWriter.println(this.L);
            if (this.s != null) {
                printWriter.print(str);
                printWriter.print("mFragmentManager=");
                printWriter.println(this.s);
            }
            if (this.t != null) {
                printWriter.print(str);
                printWriter.print("mHost=");
                printWriter.println(this.t);
            }
            if (this.v != null) {
                printWriter.print(str);
                printWriter.print("mParentFragment=");
                printWriter.println(this.v);
            }
            if (this.h != null) {
                printWriter.print(str);
                printWriter.print("mArguments=");
                printWriter.println(this.h);
            }
            if (this.d != null) {
                printWriter.print(str);
                printWriter.print("mSavedFragmentState=");
                printWriter.println(this.d);
            }
            if (this.e != null) {
                printWriter.print(str);
                printWriter.print("mSavedViewState=");
                printWriter.println(this.e);
            }
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mTarget=");
                printWriter.print(this.i);
                printWriter.print(" mTargetRequestCode=");
                printWriter.println(this.k);
            }
            if (this.G != 0) {
                printWriter.print(str);
                printWriter.print("mNextAnim=");
                printWriter.println(this.G);
            }
            if (this.H != null) {
                printWriter.print(str);
                printWriter.print("mContainer=");
                printWriter.println(this.H);
            }
            if (this.I != null) {
                printWriter.print(str);
                printWriter.print("mView=");
                printWriter.println(this.I);
            }
            if (this.J != null) {
                printWriter.print(str);
                printWriter.print("mInnerView=");
                printWriter.println(this.I);
            }
            if (this.b != null) {
                printWriter.print(str);
                printWriter.print("mAnimatingAway=");
                printWriter.println(this.b);
                printWriter.print(str);
                printWriter.print("mStateAfterAnimating=");
                printWriter.println(this.c);
            }
            if (this.M != null) {
                printWriter.print(str);
                printWriter.println("Loader Manager:");
                je4 je4Var = this.M;
                je4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.u != null) {
                printWriter.print(str);
                printWriter.println("Child " + this.u + ":");
                fe4 fe4Var = this.u;
                fe4Var.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void i1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bundle) == null) {
            if (this.f < 0) {
                this.h = bundle;
                return;
            }
            throw new IllegalStateException("Fragment already active");
        }
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public final void j1(int i, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048632, this, i, fragment) == null) {
            this.f = i;
            if (fragment != null) {
                this.g = fragment.g + ":" + this.f;
                return;
            }
            this.g = "android:fragment:" + this.f;
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            Boolean bool = this.W;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public void k1(Fragment fragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048634, this, fragment, i) == null) {
            this.i = fragment;
            this.k = i;
        }
    }

    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (!this.L && z && this.a < 4) {
                this.s.W(this);
            }
            this.L = z;
            this.K = !z;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            Boolean bool = this.V;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.r > 0 : invokeV.booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, configuration) == null) {
            this.F = true;
        }
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, contextMenu, view2, contextMenuInfo) == null) {
            getActivity().onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.F = true;
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.F = true;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.F = true;
        }
    }

    public final Bundle p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.h : (Bundle) invokeV.objValue;
    }

    public void q0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, bundle) == null) {
            this.F = true;
        }
    }

    public final ee4 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (this.u == null) {
                e0();
                int i = this.a;
                if (i >= 5) {
                    this.u.A();
                } else if (i >= 4) {
                    this.u.B();
                } else if (i >= 2) {
                    this.u.n();
                } else if (i >= 1) {
                    this.u.q();
                }
            }
            return this.u;
        }
        return (ee4) invokeV.objValue;
    }

    public void r0(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048647, this, i, i2, intent) == null) {
        }
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048648, this, strArr, i) == null) {
            de4 de4Var = this.t;
            if (de4Var != null) {
                de4Var.q(this, strArr, i);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public Object s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.P : invokeV.objValue;
    }

    @Deprecated
    public void s0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, activity) == null) {
            this.F = true;
        }
    }

    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, intent) == null) {
            de4 de4Var = this.t;
            if (de4Var != null) {
                de4Var.s(this, intent, -1);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048652, this, intent, i) == null) {
            de4 de4Var = this.t;
            if (de4Var != null) {
                de4Var.s(this, intent, i);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void t0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, context) == null) {
            this.F = true;
            de4 de4Var = this.t;
            Activity activity = de4Var == null ? null : de4Var.getActivity();
            if (activity != null) {
                this.F = false;
                s0(activity);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            se4.a(this, sb);
            if (this.f >= 0) {
                sb.append(" #");
                sb.append(this.f);
            }
            if (this.w != 0) {
                sb.append(" id=0x");
                sb.append(Integer.toHexString(this.w));
            }
            if (this.y != null) {
                sb.append(" ");
                sb.append(this.y);
            }
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public Object u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.R : invokeV.objValue;
    }

    public boolean u0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final ee4 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.s : (ee4) invokeV.objValue;
    }

    public void v0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, bundle) == null) {
            this.F = true;
        }
    }

    public LayoutInflater w(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, bundle)) == null) {
            LayoutInflater n = this.t.n();
            r();
            fe4 fe4Var = this.u;
            fe4Var.J();
            xe4.a(n, fe4Var);
            return n;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public Animation w0(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048660, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return null;
        }
        return (Animation) invokeCommon.objValue;
    }

    public void x0(Menu menu, MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048661, this, menu, menuInflater) == null) {
        }
    }

    @Nullable
    public View y0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048662, this, layoutInflater, viewGroup, bundle)) == null) {
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            this.F = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, this.N, false);
            }
            je4 je4Var = this.M;
            if (je4Var != null) {
                je4Var.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mState;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.Creator<SavedState> {
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
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(950584780, "Lcom/baidu/swan/support/v4/app/Fragment$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(950584780, "Lcom/baidu/swan/support/v4/app/Fragment$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public SavedState(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mState = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeBundle(this.mState);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            Bundle readBundle = parcel.readBundle();
            this.mState = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }
    }
}
