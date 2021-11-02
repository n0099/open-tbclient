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
import b.a.p0.o.a.a.j;
import b.a.p0.o.a.a.l;
import b.a.p0.o.a.a.m;
import b.a.p0.o.a.a.n;
import b.a.p0.o.a.a.r;
import b.a.p0.o.a.c.c;
import b.a.p0.o.a.c.f;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static /* synthetic */ Interceptable $ic;
    public static final f<String, Class<?>> i0;
    public static final Object j0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public String C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public int K;
    public ViewGroup L;
    public View M;
    public View N;
    public boolean O;
    public boolean P;
    public r Q;
    public boolean R;
    public boolean S;
    public Object T;
    public Object U;
    public Object V;
    public Object W;
    public Object X;
    public Object Y;
    public Boolean Z;
    public Boolean a0;
    public SharedElementCallback b0;
    public SharedElementCallback c0;

    /* renamed from: e  reason: collision with root package name */
    public int f44861e;

    /* renamed from: f  reason: collision with root package name */
    public View f44862f;

    /* renamed from: g  reason: collision with root package name */
    public int f44863g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f44864h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<Parcelable> f44865i;
    public int j;
    public String k;
    public Bundle l;
    public Fragment m;
    public int n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public n w;
    public l x;
    public n y;
    public Fragment z;

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (Throwable) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f44866a;

        public a(Fragment fragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44866a = fragment;
        }

        @Override // b.a.p0.o.a.a.j
        @Nullable
        public View a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                View view = this.f44866a.M;
                if (view != null) {
                    return view.findViewById(i2);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }
            return (View) invokeI.objValue;
        }

        @Override // b.a.p0.o.a.a.j
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f44866a.M != null : invokeV.booleanValue;
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
        i0 = new f<>();
        j0 = new Object();
    }

    public Fragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f44861e = 0;
        this.j = -1;
        this.n = -1;
        this.I = true;
        this.P = true;
        this.T = null;
        Object obj = j0;
        this.U = obj;
        this.V = null;
        this.W = obj;
        this.X = null;
        this.Y = obj;
        this.b0 = null;
        this.c0 = null;
    }

    public static Fragment e0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? i0(context, str, null) : (Fragment) invokeLL.objValue;
    }

    public static Fragment i0(Context context, String str, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, bundle)) == null) {
            try {
                Class<?> cls = i0.get(str);
                if (cls == null) {
                    cls = context.getClassLoader().loadClass(str);
                    i0.put(str, cls);
                }
                Fragment fragment = (Fragment) cls.newInstance();
                if (bundle != null) {
                    bundle.setClassLoader(fragment.getClass().getClassLoader());
                    fragment.l = bundle;
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
                Class<?> cls = i0.get(str);
                if (cls == null) {
                    cls = context.getClassLoader().loadClass(str);
                    i0.put(str, cls);
                }
                return Fragment.class.isAssignableFrom(cls);
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
        }
    }

    public Object B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.Y;
            return obj == j0 ? y() : obj;
        }
        return invokeV.objValue;
    }

    @Deprecated
    public void B0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, attributeSet, bundle) == null) {
            this.J = true;
        }
    }

    public void C0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, attributeSet, bundle) == null) {
            this.J = true;
            l lVar = this.x;
            Activity activity = lVar == null ? null : lVar.getActivity();
            if (activity != null) {
                this.J = false;
                B0(activity, attributeSet, bundle);
            }
        }
    }

    public boolean D0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void E0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, menu) == null) {
        }
    }

    public void F0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, menu) == null) {
        }
    }

    public void G0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, strArr, iArr) == null) {
        }
    }

    public void H0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
        }
    }

    public void I0(View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view, bundle) == null) {
        }
    }

    public void J0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            this.J = true;
        }
    }

    public void K0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.V();
            }
            this.J = false;
            p0(bundle);
            if (this.J) {
                n nVar2 = this.y;
                if (nVar2 != null) {
                    nVar2.n();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public void L0(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
            onConfigurationChanged(configuration);
            n nVar = this.y;
            if (nVar != null) {
                nVar.o(configuration);
            }
        }
    }

    public boolean M0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, menuItem)) == null) {
            if (this.D) {
                return false;
            }
            if (t0(menuItem)) {
                return true;
            }
            n nVar = this.y;
            return nVar != null && nVar.p(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void N0(Bundle bundle) {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.V();
            }
            this.J = false;
            onCreate(bundle);
            if (!this.J) {
                throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
            } else if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            } else {
                if (this.y == null) {
                    j0();
                }
                this.y.b0(parcelable, null);
                this.y.q();
            }
        }
    }

    public boolean O0(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, menu, menuInflater)) == null) {
            boolean z = false;
            if (this.D) {
                return false;
            }
            if (this.H && this.I) {
                v0(menu, menuInflater);
                z = true;
            }
            n nVar = this.y;
            return nVar != null ? z | nVar.r(menu, menuInflater) : z;
        }
        return invokeLL.booleanValue;
    }

    public final String P(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? getResources().getString(i2) : (String) invokeI.objValue;
    }

    public View P0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.V();
            }
            return w0(layoutInflater, viewGroup, bundle);
        }
        return (View) invokeLLL.objValue;
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.s();
            }
            this.J = false;
            onDestroy();
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public final String R(@StringRes int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048595, this, i2, objArr)) == null) ? getResources().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.t();
            }
            this.J = false;
            y0();
            if (this.J) {
                r rVar = this.Q;
                if (rVar != null) {
                    rVar.c();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            onLowMemory();
            n nVar = this.y;
            if (nVar != null) {
                nVar.u();
            }
        }
    }

    public final Fragment T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m : (Fragment) invokeV.objValue;
    }

    public boolean T0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, menuItem)) == null) {
            if (this.D) {
                return false;
            }
            if (this.H && this.I && D0(menuItem)) {
                return true;
            }
            n nVar = this.y;
            return nVar != null && nVar.v(menuItem);
        }
        return invokeL.booleanValue;
    }

    public final int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o : invokeV.intValue;
    }

    public void U0(Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, menu) == null) || this.D) {
            return;
        }
        if (this.H && this.I) {
            E0(menu);
        }
        n nVar = this.y;
        if (nVar != null) {
            nVar.w(menu);
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.x();
            }
            this.J = false;
            onPause();
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public boolean W0(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, menu)) == null) {
            boolean z = false;
            if (this.D) {
                return false;
            }
            if (this.H && this.I) {
                F0(menu);
                z = true;
            }
            n nVar = this.y;
            return nVar != null ? z | nVar.y(menu) : z;
        }
        return invokeL.booleanValue;
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.z();
            }
            if (this.R) {
                this.R = false;
                if (!this.S) {
                    this.S = true;
                    this.Q = this.x.i(this.k, false, false);
                }
                r rVar = this.Q;
                if (rVar != null) {
                    if (!this.G) {
                        rVar.g();
                    } else {
                        rVar.e();
                    }
                }
            }
        }
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.V();
                this.y.E();
            }
            this.J = false;
            onResume();
            if (this.J) {
                n nVar2 = this.y;
                if (nVar2 != null) {
                    nVar2.A();
                    this.y.E();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
    }

    public final CharSequence Z(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) ? getResources().getText(i2) : (CharSequence) invokeI.objValue;
    }

    public void Z0(Bundle bundle) {
        Parcelable e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bundle) == null) {
            H0(bundle);
            n nVar = this.y;
            if (nVar == null || (e0 = nVar.e0()) == null) {
                return;
            }
            bundle.putParcelable("android:support:fragments", e0);
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.P : invokeV.booleanValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.V();
                this.y.E();
            }
            this.J = false;
            onStart();
            if (this.J) {
                n nVar2 = this.y;
                if (nVar2 != null) {
                    nVar2.B();
                }
                r rVar = this.Q;
                if (rVar != null) {
                    rVar.d();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            n nVar = this.y;
            if (nVar != null) {
                nVar.C();
            }
            this.J = false;
            onStop();
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    @Nullable
    public View c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.M : (View) invokeV.objValue;
    }

    public final void c1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, bundle) == null) {
            SparseArray<Parcelable> sparseArray = this.f44865i;
            if (sparseArray != null) {
                this.N.restoreHierarchyState(sparseArray);
                this.f44865i = null;
            }
            this.J = false;
            J0(bundle);
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            this.j = -1;
            this.k = null;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = false;
            this.t = false;
            this.u = false;
            this.v = 0;
            this.w = null;
            this.y = null;
            this.x = null;
            this.A = 0;
            this.B = 0;
            this.C = null;
            this.D = false;
            this.E = false;
            this.G = false;
            this.Q = null;
            this.R = false;
            this.S = false;
        }
    }

    public void d1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            if (this.j < 0) {
                this.l = bundle;
                return;
            }
            throw new IllegalStateException("Fragment already active");
        }
    }

    public final void e1(int i2, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048615, this, i2, fragment) == null) {
            this.j = i2;
            if (fragment != null) {
                this.k = fragment.k + ":" + this.j;
                return;
            }
            this.k = "android:fragment:" + this.j;
        }
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, obj)) == null) ? super.equals(obj) : invokeL.booleanValue;
    }

    public void f1(Fragment fragment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048617, this, fragment, i2) == null) {
            this.m = fragment;
            this.o = i2;
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048618, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mFragmentId=#");
            printWriter.print(Integer.toHexString(this.A));
            printWriter.print(" mContainerId=#");
            printWriter.print(Integer.toHexString(this.B));
            printWriter.print(" mTag=");
            printWriter.println(this.C);
            printWriter.print(str);
            printWriter.print("mState=");
            printWriter.print(this.f44861e);
            printWriter.print(" mIndex=");
            printWriter.print(this.j);
            printWriter.print(" mWho=");
            printWriter.print(this.k);
            printWriter.print(" mBackStackNesting=");
            printWriter.println(this.v);
            printWriter.print(str);
            printWriter.print("mAdded=");
            printWriter.print(this.p);
            printWriter.print(" mRemoving=");
            printWriter.print(this.q);
            printWriter.print(" mResumed=");
            printWriter.print(this.r);
            printWriter.print(" mFromLayout=");
            printWriter.print(this.s);
            printWriter.print(" mInLayout=");
            printWriter.println(this.t);
            printWriter.print(str);
            printWriter.print("mHidden=");
            printWriter.print(this.D);
            printWriter.print(" mDetached=");
            printWriter.print(this.E);
            printWriter.print(" mMenuVisible=");
            printWriter.print(this.I);
            printWriter.print(" mHasMenu=");
            printWriter.println(this.H);
            printWriter.print(str);
            printWriter.print("mRetainInstance=");
            printWriter.print(this.F);
            printWriter.print(" mRetaining=");
            printWriter.print(this.G);
            printWriter.print(" mUserVisibleHint=");
            printWriter.println(this.P);
            if (this.w != null) {
                printWriter.print(str);
                printWriter.print("mFragmentManager=");
                printWriter.println(this.w);
            }
            if (this.x != null) {
                printWriter.print(str);
                printWriter.print("mHost=");
                printWriter.println(this.x);
            }
            if (this.z != null) {
                printWriter.print(str);
                printWriter.print("mParentFragment=");
                printWriter.println(this.z);
            }
            if (this.l != null) {
                printWriter.print(str);
                printWriter.print("mArguments=");
                printWriter.println(this.l);
            }
            if (this.f44864h != null) {
                printWriter.print(str);
                printWriter.print("mSavedFragmentState=");
                printWriter.println(this.f44864h);
            }
            if (this.f44865i != null) {
                printWriter.print(str);
                printWriter.print("mSavedViewState=");
                printWriter.println(this.f44865i);
            }
            if (this.m != null) {
                printWriter.print(str);
                printWriter.print("mTarget=");
                printWriter.print(this.m);
                printWriter.print(" mTargetRequestCode=");
                printWriter.println(this.o);
            }
            if (this.K != 0) {
                printWriter.print(str);
                printWriter.print("mNextAnim=");
                printWriter.println(this.K);
            }
            if (this.L != null) {
                printWriter.print(str);
                printWriter.print("mContainer=");
                printWriter.println(this.L);
            }
            if (this.M != null) {
                printWriter.print(str);
                printWriter.print("mView=");
                printWriter.println(this.M);
            }
            if (this.N != null) {
                printWriter.print(str);
                printWriter.print("mInnerView=");
                printWriter.println(this.M);
            }
            if (this.f44862f != null) {
                printWriter.print(str);
                printWriter.print("mAnimatingAway=");
                printWriter.println(this.f44862f);
                printWriter.print(str);
                printWriter.print("mStateAfterAnimating=");
                printWriter.println(this.f44863g);
            }
            if (this.Q != null) {
                printWriter.print(str);
                printWriter.println("Loader Manager:");
                r rVar = this.Q;
                rVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.y != null) {
                printWriter.print(str);
                printWriter.println("Child " + this.y + ":");
                n nVar = this.y;
                nVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            if (!this.P && z && this.f44861e < 4) {
                this.w.W(this);
            }
            this.P = z;
            this.O = !z;
        }
    }

    public final FragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            l lVar = this.x;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            l lVar = this.x;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            l lVar = this.x;
            if (lVar != null) {
                return lVar.getContext().getResources();
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return (Resources) invokeV.objValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Boolean bool = this.a0;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            n nVar = new n();
            this.y = nVar;
            nVar.j(this.x, new a(this), this);
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.x != null && this.p : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            Boolean bool = this.Z;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public final Bundle n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.l : (Bundle) invokeV.objValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.v > 0 : invokeV.booleanValue;
    }

    public final m o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.y == null) {
                j0();
                int i2 = this.f44861e;
                if (i2 >= 5) {
                    this.y.A();
                } else if (i2 >= 4) {
                    this.y.B();
                } else if (i2 >= 2) {
                    this.y.n();
                } else if (i2 >= 1) {
                    this.y.q();
                }
            }
            return this.y;
        }
        return (m) invokeV.objValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, configuration) == null) {
            this.J = true;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) {
            this.J = true;
        }
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048635, this, contextMenu, view, contextMenuInfo) == null) {
            getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.J = true;
            if (!this.S) {
                this.S = true;
                this.Q = this.x.i(this.k, this.R, false);
            }
            r rVar = this.Q;
            if (rVar != null) {
                rVar.b();
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.J = true;
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.J = true;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.J = true;
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.J = true;
            if (this.R) {
                return;
            }
            this.R = true;
            if (!this.S) {
                this.S = true;
                this.Q = this.x.i(this.k, true, false);
            }
            r rVar = this.Q;
            if (rVar != null) {
                rVar.f();
            }
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.J = true;
        }
    }

    public Object p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.T : invokeV.objValue;
    }

    public void p0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bundle) == null) {
            this.J = true;
        }
    }

    public Object q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.V : invokeV.objValue;
    }

    public void q0(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048645, this, i2, i3, intent) == null) {
        }
    }

    @Deprecated
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, activity) == null) {
            this.J = true;
        }
    }

    public final void requestPermissions(@NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048647, this, strArr, i2) == null) {
            l lVar = this.x;
            if (lVar != null) {
                lVar.q(this, strArr, i2);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public final m s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.w : (m) invokeV.objValue;
    }

    public void s0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, context) == null) {
            this.J = true;
            l lVar = this.x;
            Activity activity = lVar == null ? null : lVar.getActivity();
            if (activity != null) {
                this.J = false;
                r0(activity);
            }
        }
    }

    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, intent) == null) {
            l lVar = this.x;
            if (lVar != null) {
                lVar.s(this, intent, -1);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startActivityForResult(Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048651, this, intent, i2) == null) {
            l lVar = this.x;
            if (lVar != null) {
                lVar.s(this, intent, i2);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public LayoutInflater t(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, bundle)) == null) {
            LayoutInflater n = this.x.n();
            o();
            n nVar = this.y;
            nVar.J();
            b.a.p0.o.a.d.a.a(n, nVar);
            return n;
        }
        return (LayoutInflater) invokeL.objValue;
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
            if (this.j >= 0) {
                sb.append(" #");
                sb.append(this.j);
            }
            if (this.A != 0) {
                sb.append(" id=0x");
                sb.append(Integer.toHexString(this.A));
            }
            if (this.C != null) {
                sb.append(" ");
                sb.append(this.C);
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public Object u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            Object obj = this.W;
            return obj == j0 ? q() : obj;
        }
        return invokeV.objValue;
    }

    public Animation u0(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
            return null;
        }
        return (Animation) invokeCommon.objValue;
    }

    public void v0(Menu menu, MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, menu, menuInflater) == null) {
        }
    }

    @Nullable
    public View w0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048658, this, layoutInflater, viewGroup, bundle)) == null) {
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    public Object x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            Object obj = this.U;
            return obj == j0 ? p() : obj;
        }
        return invokeV.objValue;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
        }
    }

    public Object y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.X : invokeV.objValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            this.J = true;
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            this.J = true;
        }
    }

    /* loaded from: classes8.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mState;

        /* loaded from: classes8.dex */
        public static class a implements Parcelable.Creator<SavedState> {
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
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
