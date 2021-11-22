package b.a.r0.x0;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.k0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f27968a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f27969b;

    /* renamed from: c  reason: collision with root package name */
    public q f27970c;

    /* renamed from: d  reason: collision with root package name */
    public Context f27971d;

    /* renamed from: e  reason: collision with root package name */
    public int f27972e;

    /* renamed from: f  reason: collision with root package name */
    public int f27973f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27974g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27975h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27976i;
    public b.a.r0.k0.b j;
    public final Handler.Callback k;
    public final Handler l;
    public a.b m;

    /* loaded from: classes6.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ v0 f27977e;

        public a(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27977e = v0Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if ((i2 == 1 || i2 == 2) && this.f27977e.g()) {
                    this.f27977e.l.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i3 = message.what;
                if (i3 == 1) {
                    this.f27977e.s();
                    return true;
                } else if (i3 == 2) {
                    this.f27977e.r();
                    return true;
                } else if (i3 != 3) {
                    return false;
                } else {
                    this.f27977e.q();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ v0 f27978a;

        public b(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27978a = v0Var;
        }

        @Override // b.a.r0.k0.a.b
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (e(i3)) {
                    this.f27978a.k(true);
                    this.f27978a.f();
                }
                if (this.f27978a.f27970c != null) {
                    this.f27978a.f27970c.n1(false);
                }
            }
        }

        @Override // b.a.r0.k0.a.b
        public void b(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                if (e(i3)) {
                    this.f27978a.k(false);
                    this.f27978a.m();
                }
                if (this.f27978a.f27970c != null) {
                    this.f27978a.f27970c.n1(true);
                }
            }
        }

        @Override // b.a.r0.k0.a.b
        public void c(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            }
        }

        @Override // b.a.r0.k0.a.b
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

    public v0(Context context, q qVar, b.a.r0.x0.z2.h hVar) {
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
        this.f27972e = 0;
        this.f27973f = 0;
        this.f27975h = true;
        this.f27976i = true;
        this.k = new a(this);
        this.l = new Handler(this.k);
        this.m = new b(this);
        this.f27971d = context;
        this.f27970c = qVar;
        this.f27969b = qVar.d0();
        this.f27968a = qVar.f0();
        this.f27974g = UtilHelper.canUseStyleImmersiveSticky();
        c();
        b.a.r0.k0.b bVar = new b.a.r0.k0.b(context);
        this.j = bVar;
        bVar.d(this.m);
    }

    public final void c() {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (qVar = this.f27970c) == null || qVar.l0() == null) {
            return;
        }
        View l0 = this.f27970c.l0();
        if (this.f27974g && l0.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = l0.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            l0.setLayoutParams(layoutParams);
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

    public b.a.r0.k0.b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (b.a.r0.k0.b) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f27975h && this.f27976i && this.f27968a != null && this.f27972e >= this.f27973f) {
            n();
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(this.f27968a) : invokeV.booleanValue;
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
            this.f27975h = z;
        }
    }

    public final void j(boolean z, boolean z2) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (qVar = this.f27970c) == null) {
            return;
        }
        qVar.i1(z, z2);
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public final void l(boolean z) {
        q qVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (qVar = this.f27970c) == null || qVar.l0() == null) {
            return;
        }
        View l0 = this.f27970c.l0();
        if (this.f27974g && z && l0.getVisibility() != 0) {
            l0.setVisibility(0);
        } else if (z || l0.getVisibility() == 8) {
        } else {
            l0.setVisibility(8);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f27975h && this.f27976i && this.f27968a != null) {
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
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f27968a == null || (qVar = this.f27970c) == null || qVar.j0() == null || !this.f27970c.j0().c()) {
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
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f27968a == null || (qVar = this.f27970c) == null || qVar.j0() == null || this.f27970c.j0().c()) {
            return;
        }
        j(true, true);
    }
}
