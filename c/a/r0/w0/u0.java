package c.a.r0.w0;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.j0.a;
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
    public ViewGroup f27846a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f27847b;

    /* renamed from: c  reason: collision with root package name */
    public q f27848c;

    /* renamed from: d  reason: collision with root package name */
    public Context f27849d;

    /* renamed from: e  reason: collision with root package name */
    public int f27850e;

    /* renamed from: f  reason: collision with root package name */
    public int f27851f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27852g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27853h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27854i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.j0.b f27855j;
    public final Handler.Callback k;
    public final Handler l;
    public a.b m;

    /* loaded from: classes4.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f27856e;

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
            this.f27856e = u0Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if ((i2 == 1 || i2 == 2) && this.f27856e.g()) {
                    this.f27856e.l.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.f27856e.s();
                    return true;
                } else if (i3 == 2) {
                    this.f27856e.r();
                    return true;
                } else if (i3 != 3) {
                    return false;
                } else {
                    this.f27856e.q();
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
        public final /* synthetic */ u0 f27857a;

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
            this.f27857a = u0Var;
        }

        @Override // c.a.r0.j0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (e(i3)) {
                    this.f27857a.k(true);
                    this.f27857a.f();
                }
                if (this.f27857a.f27848c != null) {
                    this.f27857a.f27848c.o1(false);
                }
            }
        }

        @Override // c.a.r0.j0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (e(i3)) {
                    this.f27857a.k(false);
                    this.f27857a.m();
                }
                if (this.f27857a.f27848c != null) {
                    this.f27857a.f27848c.o1(true);
                }
            }
        }

        @Override // c.a.r0.j0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // c.a.r0.j0.a.b
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

    public u0(Context context, q qVar, c.a.r0.w0.o2.h hVar) {
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
        this.f27850e = 0;
        this.f27851f = 0;
        this.f27853h = true;
        this.f27854i = true;
        this.k = new a(this);
        this.l = new Handler(this.k);
        this.m = new b(this);
        this.f27849d = context;
        this.f27848c = qVar;
        this.f27847b = qVar.e0();
        this.f27846a = qVar.g0();
        this.f27852g = UtilHelper.canUseStyleImmersiveSticky();
        c();
        c.a.r0.j0.b bVar = new c.a.r0.j0.b(context);
        this.f27855j = bVar;
        bVar.d(this.m);
    }

    public final void c() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (qVar = this.f27848c) == null || qVar.m0() == null) {
            return;
        }
        View m0 = this.f27848c.m0();
        if (this.f27852g && m0.getLayoutParams() != null) {
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

    public c.a.r0.j0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27855j : (c.a.r0.j0.b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f27853h && this.f27854i && this.f27846a != null && this.f27850e >= this.f27851f) {
            n();
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(this.f27846a) : invokeV.booleanValue;
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
            this.f27853h = z;
        }
    }

    public final void j(boolean z, boolean z2) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (qVar = this.f27848c) == null) {
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
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (qVar = this.f27848c) == null || qVar.m0() == null) {
            return;
        }
        View m0 = this.f27848c.m0();
        if (this.f27852g && z && m0.getVisibility() != 0) {
            m0.setVisibility(0);
        } else if (z || m0.getVisibility() == 8) {
        } else {
            m0.setVisibility(8);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f27853h && this.f27854i && this.f27846a != null) {
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
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f27846a == null || (qVar = this.f27848c) == null || qVar.k0() == null || !this.f27848c.k0().c()) {
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f27846a == null || (qVar = this.f27848c) == null || qVar.k0() == null || this.f27848c.k0().c()) {
            return;
        }
        j(true, true);
    }
}
