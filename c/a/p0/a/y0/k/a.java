package c.a.p0.a.y0.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.a.u.e.n.l;
import c.a.p0.a.y0.k.e.e;
import c.a.p0.a.y0.k.e.f;
import c.a.p0.a.y0.k.e.g;
import c.a.p0.a.y0.k.e.h;
import c.a.p0.a.y0.k.e.i;
import c.a.p0.a.y0.k.e.j;
import c.a.p0.a.y0.k.e.m;
import c.a.p0.a.y0.k.e.n;
import c.a.p0.a.y0.k.e.o;
import c.a.p0.a.y0.k.e.p;
import c.a.p0.a.y0.k.e.q;
import c.a.p0.a.y0.k.e.r;
import c.a.p0.a.y0.k.e.t;
import c.a.p0.a.y0.k.e.u;
import c.a.p0.a.y0.k.e.v;
import c.a.p0.a.y0.k.g.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public final class a extends c.a.p0.a.y0.b<c.a.p0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f8836i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0538a f8837h;

    /* renamed from: c.a.p0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0536a implements a.InterfaceC0538a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0536a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f8756b == null) {
                return;
            }
            this.a.f8756b.onCallback(this.a, "onStateChange", Integer.valueOf(i2));
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.a.f8756b == null) {
                return;
            }
            this.a.f8756b.onCallback(this.a, "onInfo", Integer.valueOf(i2));
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.f8756b != null) {
                    this.a.f8756b.onCallback(this.a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                l.e().l(str, false);
            }
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.f8756b == null) {
                return;
            }
            this.a.f8756b.onCallback(this.a, "onNetStatus", str);
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.f8756b != null) {
                    this.a.f8756b.onCallback(this.a, "onPlayed", null);
                }
                l.e().l(str, true);
            }
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.f8756b == null) {
                return;
            }
            this.a.f8756b.onCallback(this.a, "onVideoSizeChanged", null);
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.f8756b == null) {
                return;
            }
            this.a.f8756b.onCallback(this.a, "onEnded", null);
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.a.f8756b == null) {
                return;
            }
            this.a.f8756b.onCallback(this.a, "onError", Integer.valueOf(i2));
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.f8756b == null) {
                return;
            }
            this.a.f8756b.onCallback(this.a, "onPrepared", null);
        }

        @Override // c.a.p0.a.y0.k.g.a.InterfaceC0538a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                l.e().q(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1005318785, "Lc/a/p0/a/y0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1005318785, "Lc/a/p0/a/y0/k/a;");
                return;
            }
        }
        f8836i = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.y0.k.g.a aVar) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        C0536a c0536a = new C0536a(this);
        this.f8837h = c0536a;
        aVar.h0(c0536a);
        l.e().b(aVar);
        this.a.a(new c.a.p0.a.y0.k.e.a());
        this.a.a(new c.a.p0.a.y0.k.e.b());
        this.a.a(new c.a.p0.a.y0.k.e.c());
        this.a.a(new f());
        this.a.a(new e());
        this.a.a(new c.a.p0.a.y0.k.e.d());
        this.a.a(new g());
        this.a.a(new h());
        this.a.a(new i());
        this.a.a(new j());
        this.a.a(new c.a.p0.a.y0.k.e.l());
        this.a.a(new m());
        this.a.a(new n());
        this.a.a(new o());
        this.a.a(new q());
        this.a.a(new r());
        this.a.a(new u());
        this.a.a(new v());
        this.a.a(new p());
        this.a.a(new c.a.p0.a.y0.k.e.k());
        this.a.a(new t());
    }

    @Override // c.a.p0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (f8836i) {
                    String str = "reject command => " + command.what;
                    return;
                }
                return;
            }
            super.sendCommand(command);
        }
    }

    public final boolean w(ZeusPlugin.Command command) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command)) == null) {
            if (command != null && TextUtils.equals(command.what, m.f8840b)) {
                boolean z = f8836i;
                return false;
            }
            int a = ((c.a.p0.a.y0.k.g.a) this.f8757c).a();
            if (f8836i && a != 1) {
                String str = "isRejectCommand: authorize type => " + ((c.a.p0.a.y0.k.g.a) this.f8757c).a() + " command=> " + (command == null ? "" : command.what);
            }
            return a == 2;
        }
        return invokeL.booleanValue;
    }
}
