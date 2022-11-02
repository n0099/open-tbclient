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
import com.baidu.tieba.ai4;
import com.baidu.tieba.bi4;
import com.baidu.tieba.fi4;
import com.baidu.tieba.ni4;
import com.baidu.tieba.qi4;
import com.baidu.tieba.si4;
import com.baidu.tieba.xh4;
import com.baidu.tieba.zh4;
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
/* loaded from: classes3.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener {
    public static /* synthetic */ Interceptable $ic;
    public static final qi4<String, Class<?>> Z;
    public static final Object a0;
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
    public fi4 M;
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
    public bi4 s;
    public zh4 t;
    public bi4 u;
    public Fragment v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    public void C0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
        }
    }

    public boolean F0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, menuItem)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void G0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, menu) == null) {
        }
    }

    public void H0(Menu menu) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, menu) == null) {
        }
    }

    public void J0(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i, strArr, iArr) == null) {
        }
    }

    public void K0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
        }
    }

    public void N0(View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view2, bundle) == null) {
        }
    }

    public void q0(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048646, this, i, i2, intent) == null) {
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

    public Animation v0(int i, boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048657, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            return null;
        }
        return (Animation) invokeCommon.objValue;
    }

    public void w0(Menu menu, MenuInflater menuInflater) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048658, this, menu, menuInflater) == null) {
        }
    }

    @Nullable
    public View x0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048660, this, layoutInflater, viewGroup, bundle)) == null) {
            return null;
        }
        return (View) invokeLLL.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mState;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes3.dex */
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
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new SavedState[i];
                }
                return (SavedState[]) invokeI.objValue;
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
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                parcel.writeBundle(this.mState);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class a extends xh4 {
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

        @Override // com.baidu.tieba.xh4
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

        @Override // com.baidu.tieba.xh4
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.I != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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
        Z = new qi4<>();
        a0 = new Object();
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.F = true;
        }
    }

    public Object B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Object obj = this.S;
            if (obj == a0) {
                return u();
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.F = true;
        }
    }

    public Object D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object obj = this.Q;
            if (obj == a0) {
                return t();
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public Object E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.T;
        }
        return invokeV.objValue;
    }

    public Object F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Object obj = this.U;
            if (obj == a0) {
                return E();
            }
            return obj;
        }
        return invokeV.objValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.F = true;
            if (!this.N) {
                this.N = true;
                if (!this.O) {
                    this.O = true;
                    this.M = this.t.i(this.g, true, false);
                }
                fi4 fi4Var = this.M;
                if (fi4Var != null) {
                    fi4Var.f();
                }
            }
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.F = true;
        }
    }

    public final Fragment N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.i;
        }
        return (Fragment) invokeV.objValue;
    }

    public final int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.L;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public View V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.I;
        }
        return (View) invokeV.objValue;
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            onLowMemory();
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.u();
            }
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            bi4 bi4Var = new bi4();
            this.u = bi4Var;
            bi4Var.j(this.t, new a(this), this);
        }
    }

    public final FragmentActivity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            zh4 zh4Var = this.t;
            if (zh4Var == null) {
                return null;
            }
            return (FragmentActivity) zh4Var.getActivity();
        }
        return (FragmentActivity) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            zh4 zh4Var = this.t;
            if (zh4Var == null) {
                return null;
            }
            return zh4Var.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.t != null && this.l) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public final boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            Boolean bool = this.W;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (this.r > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            Boolean bool = this.V;
            if (bool == null) {
                return true;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.F = true;
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.F = true;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            this.F = true;
        }
    }

    public final Bundle p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.h;
        }
        return (Bundle) invokeV.objValue;
    }

    public Object t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.P;
        }
        return invokeV.objValue;
    }

    public Object u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.R;
        }
        return invokeV.objValue;
    }

    public final ai4 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.s;
        }
        return (ai4) invokeV.objValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            this.F = true;
            if (!this.O) {
                this.O = true;
                this.M = this.t.i(this.g, this.N, false);
            }
            fi4 fi4Var = this.M;
            if (fi4Var != null) {
                fi4Var.b();
            }
        }
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
        Object obj = a0;
        this.Q = obj;
        this.R = null;
        this.S = obj;
        this.T = null;
        this.U = obj;
        this.X = null;
        this.Y = null;
    }

    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.s();
            }
            this.F = false;
            y0();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.t();
            }
            this.F = false;
            A0();
            if (this.F) {
                fi4 fi4Var = this.M;
                if (fi4Var != null) {
                    fi4Var.c();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
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

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.x();
            }
            this.F = false;
            onPause();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.z();
            }
            if (this.N) {
                this.N = false;
                if (!this.O) {
                    this.O = true;
                    this.M = this.t.i(this.g, false, false);
                }
                fi4 fi4Var = this.M;
                if (fi4Var != null) {
                    if (!this.C) {
                        fi4Var.g();
                    } else {
                        fi4Var.e();
                    }
                }
            }
        }
    }

    public final Resources getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            zh4 zh4Var = this.t;
            if (zh4Var != null) {
                return zh4Var.getContext().getResources();
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return (Resources) invokeV.objValue;
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.C();
            }
            this.F = false;
            M0();
            if (this.F) {
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public final ai4 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (this.u == null) {
                g0();
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
        return (ai4) invokeV.objValue;
    }

    public static Fragment d0(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            return e0(context, str, null);
        }
        return (Fragment) invokeLL.objValue;
    }

    public final String H(@StringRes int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, objArr)) == null) {
            return getResources().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }

    public boolean U0(Menu menu, MenuInflater menuInflater) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, menu, menuInflater)) == null) {
            boolean z = false;
            if (this.z) {
                return false;
            }
            if (this.D && this.E) {
                w0(menu, menuInflater);
                z = true;
            }
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                return z | bi4Var.r(menu, menuInflater);
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public void l1(Fragment fragment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048632, this, fragment, i) == null) {
            this.i = fragment;
            this.k = i;
        }
    }

    public static Fragment e0(Context context, String str, @Nullable Bundle bundle) {
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

    public final void k1(int i, Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048629, this, i, fragment) == null) {
            this.f = i;
            if (fragment != null) {
                this.g = fragment.g + ":" + this.f;
                return;
            }
            this.g = "android:fragment:" + this.f;
        }
    }

    public final void requestPermissions(@NonNull String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048648, this, strArr, i) == null) {
            zh4 zh4Var = this.t;
            if (zh4Var != null) {
                zh4Var.p(this, strArr, i);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048651, this, intent, i) == null) {
            zh4 zh4Var = this.t;
            if (zh4Var != null) {
                zh4Var.r(this, intent, i);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    @Deprecated
    public void D0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, attributeSet, bundle) == null) {
            this.F = true;
        }
    }

    public void E0(Context context, AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, attributeSet, bundle) == null) {
            this.F = true;
            zh4 zh4Var = this.t;
            if (zh4Var == null) {
                activity = null;
            } else {
                activity = zh4Var.getActivity();
            }
            if (activity != null) {
                this.F = false;
                D0(activity, attributeSet, bundle);
            }
        }
    }

    public View V0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, layoutInflater, viewGroup, bundle)) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.V();
            }
            return x0(layoutInflater, viewGroup, bundle);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view2, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048639, this, contextMenu, view2, contextMenuInfo) == null) {
            getActivity().onCreateContextMenu(contextMenu, view2, contextMenuInfo);
        }
    }

    public final String G(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            return getResources().getString(i);
        }
        return (String) invokeI.objValue;
    }

    public void O0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            this.F = true;
        }
    }

    public void R0(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, configuration) == null) {
            onConfigurationChanged(configuration);
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.o(configuration);
            }
        }
    }

    public final CharSequence S(@StringRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            return getResources().getText(i);
        }
        return (CharSequence) invokeI.objValue;
    }

    public boolean S0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, menuItem)) == null) {
            if (!this.z) {
                if (t0(menuItem)) {
                    return true;
                }
                bi4 bi4Var = this.u;
                if (bi4Var != null && bi4Var.p(menuItem)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean Z0(MenuItem menuItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, menuItem)) == null) {
            if (!this.z) {
                if (this.D && this.E && F0(menuItem)) {
                    return true;
                }
                bi4 bi4Var = this.u;
                if (bi4Var != null && bi4Var.v(menuItem)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a1(Menu menu) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, menu) == null) && !this.z) {
            if (this.D && this.E) {
                G0(menu);
            }
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.w(menu);
            }
        }
    }

    public boolean c1(Menu menu) {
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
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                return z | bi4Var.y(menu);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, obj)) == null) {
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public void f1(Bundle bundle) {
        Parcelable e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            K0(bundle);
            bi4 bi4Var = this.u;
            if (bi4Var != null && (e0 = bi4Var.e0()) != null) {
                bundle.putParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG, e0);
            }
        }
    }

    public void j1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            if (this.f < 0) {
                this.h = bundle;
                return;
            }
            throw new IllegalStateException("Fragment already active");
        }
    }

    public void m1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            if (!this.L && z && this.a < 4) {
                this.s.W(this);
            }
            this.L = z;
            this.K = !z;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, configuration) == null) {
            this.F = true;
        }
    }

    public void p0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, bundle) == null) {
            this.F = true;
        }
    }

    @Deprecated
    public void r0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, activity) == null) {
            this.F = true;
        }
    }

    public void s0(Context context) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, context) == null) {
            this.F = true;
            zh4 zh4Var = this.t;
            if (zh4Var == null) {
                activity = null;
            } else {
                activity = zh4Var.getActivity();
            }
            if (activity != null) {
                this.F = false;
                r0(activity);
            }
        }
    }

    public void u0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, bundle) == null) {
            this.F = true;
        }
    }

    public LayoutInflater y(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, bundle)) == null) {
            LayoutInflater m = this.t.m();
            q();
            bi4 bi4Var = this.u;
            bi4Var.J();
            si4.a(m, bi4Var);
            return m;
        }
        return (LayoutInflater) invokeL.objValue;
    }

    public void P0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.V();
            }
            this.F = false;
            p0(bundle);
            if (this.F) {
                bi4 bi4Var2 = this.u;
                if (bi4Var2 != null) {
                    bi4Var2.n();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    public final void i1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, bundle) == null) {
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

    public void startActivity(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, intent) == null) {
            zh4 zh4Var = this.t;
            if (zh4Var != null) {
                zh4Var.r(this, intent, -1);
                return;
            }
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
    }

    public void T0(Bundle bundle) {
        Parcelable parcelable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.V();
            }
            this.F = false;
            u0(bundle);
            if (this.F) {
                if (bundle != null && (parcelable = bundle.getParcelable(androidx.fragment.app.FragmentActivity.FRAGMENTS_TAG)) != null) {
                    if (this.u == null) {
                        g0();
                    }
                    this.u.b0(parcelable, null);
                    this.u.q();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.V();
                this.u.E();
            }
            this.F = false;
            onResume();
            if (this.F) {
                bi4 bi4Var2 = this.u;
                if (bi4Var2 != null) {
                    bi4Var2.A();
                    this.u.E();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            bi4 bi4Var = this.u;
            if (bi4Var != null) {
                bi4Var.V();
                this.u.E();
            }
            this.F = false;
            L0();
            if (this.F) {
                bi4 bi4Var2 = this.u;
                if (bi4Var2 != null) {
                    bi4Var2.B();
                }
                fi4 fi4Var = this.M;
                if (fi4Var != null) {
                    fi4Var.d();
                    return;
                }
                return;
            }
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            StringBuilder sb = new StringBuilder(128);
            ni4.a(this, sb);
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

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048630, this, str, fileDescriptor, printWriter, strArr) == null) {
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
                fi4 fi4Var = this.M;
                fi4Var.h(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
            if (this.u != null) {
                printWriter.print(str);
                printWriter.println("Child " + this.u + ":");
                bi4 bi4Var = this.u;
                bi4Var.b(str + GlideException.IndentedAppendable.INDENT, fileDescriptor, printWriter, strArr);
            }
        }
    }
}
