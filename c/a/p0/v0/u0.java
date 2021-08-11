package c.a.p0.v0;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.i0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class u0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f26861a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f26862b;

    /* renamed from: c  reason: collision with root package name */
    public q f26863c;

    /* renamed from: d  reason: collision with root package name */
    public Context f26864d;

    /* renamed from: e  reason: collision with root package name */
    public int f26865e;

    /* renamed from: f  reason: collision with root package name */
    public int f26866f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26867g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26868h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26869i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.i0.b f26870j;
    public final Handler.Callback k;
    public final Handler l;
    public a.b m;

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f26871e;

        public a(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26871e = u0Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if ((i2 == 1 || i2 == 2) && this.f26871e.g()) {
                    this.f26871e.l.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.f26871e.s();
                    return true;
                } else if (i3 == 2) {
                    this.f26871e.r();
                    return true;
                } else if (i3 != 3) {
                    return false;
                } else {
                    this.f26871e.q();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ u0 f26872a;

        public b(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26872a = u0Var;
        }

        @Override // c.a.p0.i0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (e(i3)) {
                    this.f26872a.k(true);
                    this.f26872a.f();
                }
                if (this.f26872a.f26863c != null) {
                    this.f26872a.f26863c.o1(false);
                }
            }
        }

        @Override // c.a.p0.i0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (e(i3)) {
                    this.f26872a.k(false);
                    this.f26872a.m();
                }
                if (this.f26872a.f26863c != null) {
                    this.f26872a.f26863c.o1(true);
                }
            }
        }

        @Override // c.a.p0.i0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.p0.i0.a.b
        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }

        public final boolean e(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) ? Math.abs(f2) >= 1.0f : invokeF.booleanValue;
        }
    }

    public u0(Context context, q qVar, c.a.p0.v0.o2.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, qVar, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26865e = 0;
        this.f26866f = 0;
        this.f26868h = true;
        this.f26869i = true;
        this.k = new a(this);
        this.l = new Handler(this.k);
        this.m = new b(this);
        this.f26864d = context;
        this.f26863c = qVar;
        this.f26862b = qVar.e0();
        this.f26861a = qVar.g0();
        this.f26867g = UtilHelper.canUseStyleImmersiveSticky();
        c();
        c.a.p0.i0.b bVar = new c.a.p0.i0.b(context);
        this.f26870j = bVar;
        bVar.d(this.m);
    }

    public final void c() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (qVar = this.f26863c) == null || qVar.m0() == null) {
            return;
        }
        View m0 = this.f26863c.m0();
        if (this.f26867g && m0.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = m0.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            m0.setLayoutParams(layoutParams);
            l(true);
            return;
        }
        l(false);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.removeCallbacksAndMessages(null);
        }
    }

    public c.a.p0.i0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26870j : (c.a.p0.i0.b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f26868h && this.f26869i && this.f26861a != null && this.f26865e >= this.f26866f) {
            n();
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(this.f26861a) : invokeV.booleanValue;
    }

    public final boolean h(View view) {
        InterceptResult invokeL;
        Animation animation;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) ? (view == null || (animation = view.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true : invokeL.booleanValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f26868h = z;
        }
    }

    public final void j(boolean z, boolean z2) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (qVar = this.f26863c) == null) {
            return;
        }
        qVar.j1(z, z2);
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public final void l(boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (qVar = this.f26863c) == null || qVar.m0() == null) {
            return;
        }
        View m0 = this.f26863c.m0();
        if (this.f26867g && z && m0.getVisibility() != 0) {
            m0.setVisibility(0);
        } else if (z || m0.getVisibility() == 8) {
        } else {
            m0.setVisibility(8);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f26868h && this.f26869i && this.f26861a != null) {
            o();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.removeMessages(1);
            if (this.l.hasMessages(2)) {
                return;
            }
            this.l.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.l.removeMessages(2);
            if (this.l.hasMessages(1)) {
                return;
            }
            this.l.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void p(boolean z, boolean z2) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f26861a == null || (qVar = this.f26863c) == null || qVar.k0() == null || !this.f26863c.k0().c()) {
            return;
        }
        j(false, true);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p(false, true);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p(false, false);
        }
    }

    public void s() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f26861a == null || (qVar = this.f26863c) == null || qVar.k0() == null || this.f26863c.k0().c()) {
            return;
        }
        j(true, true);
    }
}
