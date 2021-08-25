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
import c.a.o0.o.a.a.i;
import c.a.o0.o.a.a.k;
import c.a.o0.o.a.a.l;
import c.a.o0.o.a.a.m;
import c.a.o0.o.a.a.q;
import c.a.o0.o.a.c.c;
import c.a.o0.o.a.c.f;
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
/* loaded from: classes6.dex */
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
    public q Q;
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
    public int f47113e;

    /* renamed from: f  reason: collision with root package name */
    public View f47114f;

    /* renamed from: g  reason: collision with root package name */
    public int f47115g;

    /* renamed from: h  reason: collision with root package name */
    public Bundle f47116h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<Parcelable> f47117i;

    /* renamed from: j  reason: collision with root package name */
    public int f47118j;
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
    public m w;
    public k x;
    public m y;
    public Fragment z;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class a extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f47119a;

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
            this.f47119a = fragment;
        }

        @Override // c.a.o0.o.a.a.i
        @Nullable
        public View a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                View view = this.f47119a.M;
                if (view != null) {
                    return view.findViewById(i2);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }
            return (View) invokeI.objValue;
        }

        @Override // c.a.o0.o.a.a.i
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47119a.M != null : invokeV.booleanValue;
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
        this.f47113e = 0;
        this.f47118j = -1;
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

    public static Fragment k0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? l0(context, str, null) : (Fragment) invokeLL.objValue;
    }

    public static Fragment l0(Context context, String str, @Nullable Bundle bundle) {
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

    public static boolean r0(Context context, String str) {
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

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.J = true;
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.J = true;
        }
    }

    public void D0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    @Deprecated
    public void E0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, attributeSet, bundle) == null) {
            this.J = true;
        }
    }

    public void F0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, attributeSet, bundle) == null) {
            this.J = true;
            k kVar = this.x;
            Activity g2 = kVar == null ? null : kVar.g();
            if (g2 != null) {
                this.J = false;
                E0(g2, attributeSet, bundle);
            }
        }
    }

    public boolean G0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void H0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, menu) == null) {
        }
    }

    public void I0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, menu) == null) {
        }
    }

    public void J0(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, strArr, iArr) == null) {
        }
    }

    public void K0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
        }
    }

    public void L0(View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, view, bundle) == null) {
        }
    }

    public void M0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            this.J = true;
        }
    }

    public void N0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.V();
            }
            this.J = false;
            s0(bundle);
            if (this.J) {
                m mVar2 = this.y;
                if (mVar2 != null) {
                    mVar2.n();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Object obj = this.U;
            return obj == j0 ? r() : obj;
        }
        return invokeV.objValue;
    }

    public void O0(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, configuration) == null) {
            onConfigurationChanged(configuration);
            m mVar = this.y;
            if (mVar != null) {
                mVar.o(configuration);
            }
        }
    }

    public boolean P0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, menuItem)) == null) {
            if (this.D) {
                return false;
            }
            if (w0(menuItem)) {
                return true;
            }
            m mVar = this.y;
            return mVar != null && mVar.p(menuItem);
        }
        return invokeL.booleanValue;
    }

    public Object Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.X : invokeV.objValue;
    }

    public void Q0(Bundle bundle) {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.V();
            }
            this.J = false;
            onCreate(bundle);
            if (!this.J) {
                throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
            } else if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            } else {
                if (this.y == null) {
                    m0();
                }
                this.y.b0(parcelable, null);
                this.y.q();
            }
        }
    }

    public boolean R0(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, menu, menuInflater)) == null) {
            boolean z = false;
            if (this.D) {
                return false;
            }
            if (this.H && this.I) {
                y0(menu, menuInflater);
                z = true;
            }
            m mVar = this.y;
            return mVar != null ? z | mVar.r(menu, menuInflater) : z;
        }
        return invokeLL.booleanValue;
    }

    public Object S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Object obj = this.Y;
            return obj == j0 ? Q() : obj;
        }
        return invokeV.objValue;
    }

    public View S0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, layoutInflater, viewGroup, bundle)) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.V();
            }
            return z0(layoutInflater, viewGroup, bundle);
        }
        return (View) invokeLLL.objValue;
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.s();
            }
            this.J = false;
            onDestroy();
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public final String U(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? z().getString(i2) : (String) invokeI.objValue;
    }

    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.t();
            }
            this.J = false;
            B0();
            if (this.J) {
                q qVar = this.Q;
                if (qVar != null) {
                    qVar.c();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final String V(@StringRes int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, objArr)) == null) ? z().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            onLowMemory();
            m mVar = this.y;
            if (mVar != null) {
                mVar.u();
            }
        }
    }

    public boolean W0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, menuItem)) == null) {
            if (this.D) {
                return false;
            }
            if (this.H && this.I && G0(menuItem)) {
                return true;
            }
            m mVar = this.y;
            return mVar != null && mVar.v(menuItem);
        }
        return invokeL.booleanValue;
    }

    public void X0(Menu menu) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, menu) == null) || this.D) {
            return;
        }
        if (this.H && this.I) {
            H0(menu);
        }
        m mVar = this.y;
        if (mVar != null) {
            mVar.w(menu);
        }
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.x();
            }
            this.J = false;
            onPause();
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public boolean Z0(Menu menu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, menu)) == null) {
            boolean z = false;
            if (this.D) {
                return false;
            }
            if (this.H && this.I) {
                I0(menu);
                z = true;
            }
            m mVar = this.y;
            return mVar != null ? z | mVar.y(menu) : z;
        }
        return invokeL.booleanValue;
    }

    public final Fragment a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.m : (Fragment) invokeV.objValue;
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.z();
            }
            if (this.R) {
                this.R = false;
                if (!this.S) {
                    this.S = true;
                    this.Q = this.x.k(this.k, false, false);
                }
                q qVar = this.Q;
                if (qVar != null) {
                    if (!this.G) {
                        qVar.g();
                    } else {
                        qVar.e();
                    }
                }
            }
        }
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.o : invokeV.intValue;
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.V();
                this.y.E();
            }
            this.J = false;
            onResume();
            if (this.J) {
                m mVar2 = this.y;
                if (mVar2 != null) {
                    mVar2.A();
                    this.y.E();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
    }

    public void c1(Bundle bundle) {
        Parcelable e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            K0(bundle);
            m mVar = this.y;
            if (mVar == null || (e0 = mVar.e0()) == null) {
                return;
            }
            bundle.putParcelable("android:support:fragments", e0);
        }
    }

    public final CharSequence d0(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) ? z().getText(i2) : (CharSequence) invokeI.objValue;
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.V();
                this.y.E();
            }
            this.J = false;
            onStart();
            if (this.J) {
                m mVar2 = this.y;
                if (mVar2 != null) {
                    mVar2.B();
                }
                q qVar = this.Q;
                if (qVar != null) {
                    qVar.d();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.P : invokeV.booleanValue;
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            m mVar = this.y;
            if (mVar != null) {
                mVar.C();
            }
            this.J = false;
            onStop();
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, obj)) == null) ? super.equals(obj) : invokeL.booleanValue;
    }

    @Nullable
    public View f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.M : (View) invokeV.objValue;
    }

    public final void f1(@NonNull String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, strArr, i2) == null) {
            k kVar = this.x;
            if (kVar != null) {
                kVar.s(this, strArr, i2);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048619, this, str, fileDescriptor, printWriter, strArr) == null) {
            printWriter.print(str);
            printWriter.print("mFragmentId=#");
            printWriter.print(Integer.toHexString(this.A));
            printWriter.print(" mContainerId=#");
            printWriter.print(Integer.toHexString(this.B));
            printWriter.print(" mTag=");
            printWriter.println(this.C);
            printWriter.print(str);
            printWriter.print("mState=");
            printWriter.print(this.f47113e);
            printWriter.print(" mIndex=");
            printWriter.print(this.f47118j);
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
            if (this.f47116h != null) {
                printWriter.print(str);
                printWriter.print("mSavedFragmentState=");
                printWriter.println(this.f47116h);
            }
            if (this.f47117i != null) {
                printWriter.print(str);
                printWriter.print("mSavedViewState=");
                printWriter.println(this.f47117i);
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
            if (this.f47114f != null) {
                printWriter.print(str);
                printWriter.print("mAnimatingAway=");
                printWriter.println(this.f47114f);
                printWriter.print(str);
                printWriter.print("mStateAfterAnimating=");
                printWriter.println(this.f47115g);
            }
            if (this.Q != null) {
                printWriter.print(str);
                printWriter.println("Loader Manager:");
                q qVar = this.Q;
                qVar.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.y != null) {
                printWriter.print(str);
                printWriter.println("Child " + this.y + ":");
                m mVar = this.y;
                mVar.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void g1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            SparseArray<Parcelable> sparseArray = this.f47117i;
            if (sparseArray != null) {
                this.N.restoreHierarchyState(sparseArray);
                this.f47117i = null;
            }
            this.J = false;
            M0(bundle);
            if (this.J) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public final FragmentActivity h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            k kVar = this.x;
            if (kVar == null) {
                return null;
            }
            return (FragmentActivity) kVar.g();
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public void h1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            if (this.f47118j < 0) {
                this.l = bundle;
                return;
            }
            throw new IllegalStateException("Fragment already active");
        }
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public final void i1(int i2, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048624, this, i2, fragment) == null) {
            this.f47118j = i2;
            if (fragment != null) {
                this.k = fragment.k + ":" + this.f47118j;
                return;
            }
            this.k = "android:fragment:" + this.f47118j;
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f47118j = -1;
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

    public void j1(Fragment fragment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048627, this, fragment, i2) == null) {
            this.m = fragment;
            this.o = i2;
        }
    }

    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            if (!this.P && z && this.f47113e < 4) {
                this.w.W(this);
            }
            this.P = z;
            this.O = !z;
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            Boolean bool = this.Z;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            m mVar = new m();
            this.y = mVar;
            mVar.j(this.x, new a(this), this);
        }
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.x != null && this.p : invokeV.booleanValue;
    }

    public final Bundle o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.l : (Bundle) invokeV.objValue;
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.E : invokeV.booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, configuration) == null) {
            this.J = true;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, bundle) == null) {
            this.J = true;
        }
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048636, this, contextMenu, view, contextMenuInfo) == null) {
            h().onCreateContextMenu(contextMenu, view, contextMenuInfo);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.J = true;
            if (!this.S) {
                this.S = true;
                this.Q = this.x.k(this.k, this.R, false);
            }
            q qVar = this.Q;
            if (qVar != null) {
                qVar.b();
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.J = true;
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.J = true;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.J = true;
        }
    }

    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.J = true;
            if (this.R) {
                return;
            }
            this.R = true;
            if (!this.S) {
                this.S = true;
                this.Q = this.x.k(this.k, true, false);
            }
            q qVar = this.Q;
            if (qVar != null) {
                qVar.f();
            }
        }
    }

    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.J = true;
        }
    }

    public final l p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (this.y == null) {
                m0();
                int i2 = this.f47113e;
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
        return (l) invokeV.objValue;
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public Context q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            k kVar = this.x;
            if (kVar == null) {
                return null;
            }
            return kVar.h();
        }
        return (Context) invokeV.objValue;
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.v > 0 : invokeV.booleanValue;
    }

    public Object r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.T : invokeV.objValue;
    }

    public void s0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, bundle) == null) {
            this.J = true;
        }
    }

    public Object t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.V : invokeV.objValue;
    }

    public void t0(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048650, this, i2, i3, intent) == null) {
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            c.a(this, sb);
            if (this.f47118j >= 0) {
                sb.append(" #");
                sb.append(this.f47118j);
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

    public final l u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.w : (l) invokeV.objValue;
    }

    @Deprecated
    public void u0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, activity) == null) {
            this.J = true;
        }
    }

    public LayoutInflater v(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, bundle)) == null) {
            LayoutInflater p = this.x.p();
            p();
            m mVar = this.y;
            mVar.J();
            c.a.o0.o.a.d.a.a(p, mVar);
            return p;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public void v0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, context) == null) {
            this.J = true;
            k kVar = this.x;
            Activity g2 = kVar == null ? null : kVar.g();
            if (g2 != null) {
                this.J = false;
                u0(g2);
            }
        }
    }

    public boolean w0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public Animation x0(int i2, boolean z, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048657, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3)})) == null) {
            return null;
        }
        return (Animation) invokeCommon.objValue;
    }

    public Object y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            Object obj = this.W;
            return obj == j0 ? t() : obj;
        }
        return invokeV.objValue;
    }

    public void y0(Menu menu, MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048659, this, menu, menuInflater) == null) {
        }
    }

    public final Resources z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            k kVar = this.x;
            if (kVar != null) {
                return kVar.h().getResources();
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return (Resources) invokeV.objValue;
    }

    @Nullable
    public View z0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048661, this, layoutInflater, viewGroup, bundle)) == null) {
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    /* loaded from: classes6.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mState;

        /* loaded from: classes6.dex */
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
