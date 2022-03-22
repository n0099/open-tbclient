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
import c.a.n0.r.a.a.j;
import c.a.n0.r.a.a.l;
import c.a.n0.r.a.a.m;
import c.a.n0.r.a.a.n;
import c.a.n0.r.a.a.r;
import c.a.n0.r.a.c.c;
import c.a.n0.r.a.c.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes4.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static /* synthetic */ Interceptable $ic;
    public static final f<String, Class<?>> Z;
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
    public r M;
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

    /* renamed from: b  reason: collision with root package name */
    public View f29696b;

    /* renamed from: c  reason: collision with root package name */
    public int f29697c;

    /* renamed from: d  reason: collision with root package name */
    public Bundle f29698d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<Parcelable> f29699e;

    /* renamed from: f  reason: collision with root package name */
    public int f29700f;

    /* renamed from: g  reason: collision with root package name */
    public String f29701g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f29702h;
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
    public n s;
    public l t;
    public n u;
    public Fragment v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a extends j {
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

        @Override // c.a.n0.r.a.a.j
        @Nullable
        public View a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                View view = this.a.I;
                if (view != null) {
                    return view.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }
            return (View) invokeI.objValue;
        }

        @Override // c.a.n0.r.a.a.j
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
        Z = new f<>();
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
        this.f29700f = -1;
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

    public static Fragment V(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? X(context, str, null) : (Fragment) invokeLL.objValue;
    }

    public static Fragment X(Context context, String str, @Nullable Bundle bundle) {
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
                    fragment.f29702h = bundle;
                }
                return fragment;
            } catch (ClassNotFoundException e2) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
            } catch (IllegalAccessException e3) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
            } catch (java.lang.InstantiationException e4) {
                throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e4);
            }
        }
        return (Fragment) invokeLLL.objValue;
    }

    public static boolean o0(Context context, String str) {
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
            Object obj = this.Q;
            return obj == g0 ? r() : obj;
        }
        return invokeV.objValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.F = true;
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.F = true;
        }
    }

    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    public Object D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.T : invokeV.objValue;
    }

    @Deprecated
    public void D0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, attributeSet, bundle) == null) {
            this.F = true;
        }
    }

    public void E0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, context, attributeSet, bundle) == null) {
            this.F = true;
            l lVar = this.t;
            Activity activity = lVar == null ? null : lVar.getActivity();
            if (activity != null) {
                this.F = false;
                D0(activity, attributeSet, bundle);
            }
        }
    }

    public Object F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Object obj = this.U;
            return obj == g0 ? D() : obj;
        }
        return invokeV.objValue;
    }

    public boolean F0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String G(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? getResources().getString(i) : (String) invokeI.objValue;
    }

    public void G0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, menu) == null) {
        }
    }

    public final String H(@StringRes int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, objArr)) == null) ? getResources().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public void H0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, menu) == null) {
        }
    }

    public final Fragment I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : (Fragment) invokeV.objValue;
    }

    public void I0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i, strArr, iArr) == null) {
        }
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k : invokeV.intValue;
    }

    public void J0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
        }
    }

    public final CharSequence K(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) ? getResources().getText(i) : (CharSequence) invokeI.objValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.F = true;
            if (this.N) {
                return;
            }
            this.N = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.f29701g, true, false);
            }
            r rVar = this.M;
            if (rVar != null) {
                rVar.f();
            }
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.F = true;
        }
    }

    public void M0(View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, view, bundle) == null) {
        }
    }

    public void N0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            this.F = true;
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.L : invokeV.booleanValue;
    }

    public void O0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.V();
            }
            this.F = false;
            p0(bundle);
            if (this.F) {
                n nVar2 = this.u;
                if (nVar2 != null) {
                    nVar2.n();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void P0(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, configuration) == null) {
            onConfigurationChanged(configuration);
            n nVar = this.u;
            if (nVar != null) {
                nVar.o(configuration);
            }
        }
    }

    @Nullable
    public View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.I : (View) invokeV.objValue;
    }

    public boolean Q0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, menuItem)) == null) {
            if (this.z) {
                return false;
            }
            if (t0(menuItem)) {
                return true;
            }
            n nVar = this.u;
            return nVar != null && nVar.p(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void R0(Bundle bundle) {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.V();
            }
            this.F = false;
            u0(bundle);
            if (!this.F) {
                throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
            } else if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            } else {
                if (this.u == null) {
                    Y();
                }
                this.u.b0(parcelable, null);
                this.u.q();
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.f29700f = -1;
            this.f29701g = null;
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

    public boolean S0(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, menu, menuInflater)) == null) {
            boolean z = false;
            if (this.z) {
                return false;
            }
            if (this.D && this.E) {
                w0(menu, menuInflater);
                z = true;
            }
            n nVar = this.u;
            return nVar != null ? z | nVar.r(menu, menuInflater) : z;
        }
        return invokeLL.booleanValue;
    }

    public View T0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.V();
            }
            return x0(layoutInflater, viewGroup, bundle);
        }
        return (View) invokeLLL.objValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.s();
            }
            this.F = false;
            y0();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.t();
            }
            this.F = false;
            A0();
            if (this.F) {
                r rVar = this.M;
                if (rVar != null) {
                    rVar.c();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            onLowMemory();
            n nVar = this.u;
            if (nVar != null) {
                nVar.u();
            }
        }
    }

    public boolean X0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, menuItem)) == null) {
            if (this.z) {
                return false;
            }
            if (this.D && this.E && F0(menuItem)) {
                return true;
            }
            n nVar = this.u;
            return nVar != null && nVar.v(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            n nVar = new n();
            this.u = nVar;
            nVar.j(this.t, new a(this), this);
        }
    }

    public void Y0(Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, menu) == null) || this.z) {
            return;
        }
        if (this.D && this.E) {
            G0(menu);
        }
        n nVar = this.u;
        if (nVar != null) {
            nVar.w(menu);
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.x();
            }
            this.F = false;
            onPause();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public boolean a1(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, menu)) == null) {
            boolean z = false;
            if (this.z) {
                return false;
            }
            if (this.D && this.E) {
                H0(menu);
                z = true;
            }
            n nVar = this.u;
            return nVar != null ? z | nVar.y(menu) : z;
        }
        return invokeL.booleanValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.z();
            }
            if (this.N) {
                this.N = false;
                if (!this.O) {
                    this.O = true;
                    this.M = this.t.i(this.f29701g, false, false);
                }
                r rVar = this.M;
                if (rVar != null) {
                    if (!this.C) {
                        rVar.g();
                    } else {
                        rVar.e();
                    }
                }
            }
        }
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.V();
                this.u.E();
            }
            this.F = false;
            onResume();
            if (this.F) {
                n nVar2 = this.u;
                if (nVar2 != null) {
                    nVar2.A();
                    this.u.E();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
    }

    public void d1(Bundle bundle) {
        Parcelable e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bundle) == null) {
            J0(bundle);
            n nVar = this.u;
            if (nVar == null || (e0 = nVar.e0()) == null) {
                return;
            }
            bundle.putParcelable("android:support:fragments", e0);
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.t != null && this.l : invokeV.booleanValue;
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            n nVar = this.u;
            if (nVar != null) {
                nVar.V();
                this.u.E();
            }
            this.F = false;
            K0();
            if (this.F) {
                n nVar2 = this.u;
                if (nVar2 != null) {
                    nVar2.B();
                }
                r rVar = this.M;
                if (rVar != null) {
                    rVar.d();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
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
            n nVar = this.u;
            if (nVar != null) {
                nVar.C();
            }
            this.F = false;
            L0();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final void g1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            SparseArray<Parcelable> sparseArray = this.f29699e;
            if (sparseArray != null) {
                this.J.restoreHierarchyState(sparseArray);
                this.f29699e = null;
            }
            this.F = false;
            N0(bundle);
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final FragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            l lVar = this.t;
            if (lVar == null) {
                return null;
            }
            return (FragmentActivity) lVar.getActivity();
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            l lVar = this.t;
            if (lVar == null) {
                return null;
            }
            return lVar.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            l lVar = this.t;
            if (lVar != null) {
                return lVar.getContext().getResources();
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return (Resources) invokeV.objValue;
    }

    public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048626, this, str, fileDescriptor, printWriter, strArr) == null) {
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
            printWriter.print(this.f29700f);
            printWriter.print(" mWho=");
            printWriter.print(this.f29701g);
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
            if (this.f29702h != null) {
                printWriter.print(str);
                printWriter.print("mArguments=");
                printWriter.println(this.f29702h);
            }
            if (this.f29698d != null) {
                printWriter.print(str);
                printWriter.print("mSavedFragmentState=");
                printWriter.println(this.f29698d);
            }
            if (this.f29699e != null) {
                printWriter.print(str);
                printWriter.print("mSavedViewState=");
                printWriter.println(this.f29699e);
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
            if (this.f29696b != null) {
                printWriter.print(str);
                printWriter.print("mAnimatingAway=");
                printWriter.println(this.f29696b);
                printWriter.print(str);
                printWriter.print("mStateAfterAnimating=");
                printWriter.println(this.f29697c);
            }
            if (this.M != null) {
                printWriter.print(str);
                printWriter.println("Loader Manager:");
                r rVar = this.M;
                rVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.u != null) {
                printWriter.print(str);
                printWriter.println("Child " + this.u + ":");
                n nVar = this.u;
                nVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public void h1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, bundle) == null) {
            if (this.f29700f < 0) {
                this.f29702h = bundle;
                return;
            }
            throw new IllegalStateException("Fragment already active");
        }
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public final void i1(int i, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048630, this, i, fragment) == null) {
            this.f29700f = i;
            if (fragment != null) {
                this.f29701g = fragment.f29701g + ":" + this.f29700f;
                return;
            }
            this.f29701g = "android:fragment:" + this.f29700f;
        }
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public void j1(Fragment fragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048632, this, fragment, i) == null) {
            this.i = fragment;
            this.k = i;
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

    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.r > 0 : invokeV.booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, configuration) == null) {
            this.F = true;
        }
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048638, this, contextMenu, view, contextMenuInfo) == null) {
            getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.F = true;
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.F = true;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.F = true;
        }
    }

    public final Bundle p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f29702h : (Bundle) invokeV.objValue;
    }

    public void p0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bundle) == null) {
            this.F = true;
        }
    }

    public final m q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.u == null) {
                Y();
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
        return (m) invokeV.objValue;
    }

    public void q0(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048645, this, i, i2, intent) == null) {
        }
    }

    public Object r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.P : invokeV.objValue;
    }

    @Deprecated
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, activity) == null) {
            this.F = true;
        }
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048648, this, strArr, i) == null) {
            l lVar = this.t;
            if (lVar != null) {
                lVar.q(this, strArr, i);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public Object s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.R : invokeV.objValue;
    }

    public void s0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, context) == null) {
            this.F = true;
            l lVar = this.t;
            Activity activity = lVar == null ? null : lVar.getActivity();
            if (activity != null) {
                this.F = false;
                r0(activity);
            }
        }
    }

    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, intent) == null) {
            l lVar = this.t;
            if (lVar != null) {
                lVar.s(this, intent, -1);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048652, this, intent, i) == null) {
            l lVar = this.t;
            if (lVar != null) {
                lVar.s(this, intent, i);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public boolean t0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            c.a(this, sb);
            if (this.f29700f >= 0) {
                sb.append(" #");
                sb.append(this.f29700f);
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

    public final m u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.s : (m) invokeV.objValue;
    }

    public void u0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, bundle) == null) {
            this.F = true;
        }
    }

    public LayoutInflater v(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048657, this, bundle)) == null) {
            LayoutInflater n = this.t.n();
            q();
            n nVar = this.u;
            nVar.J();
            c.a.n0.r.a.d.a.a(n, nVar);
            return n;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public Animation v0(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048658, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return null;
        }
        return (Animation) invokeCommon.objValue;
    }

    public Object w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            Object obj = this.S;
            return obj == g0 ? s() : obj;
        }
        return invokeV.objValue;
    }

    public void w0(Menu menu, MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048660, this, menu, menuInflater) == null) {
        }
    }

    @Nullable
    public View x0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048661, this, layoutInflater, viewGroup, bundle)) == null) {
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            this.F = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.f29701g, this.N, false);
            }
            r rVar = this.M;
            if (rVar != null) {
                rVar.b();
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mState;

        /* loaded from: classes4.dex */
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
