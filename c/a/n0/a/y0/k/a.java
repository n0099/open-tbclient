package c.a.n0.a.y0.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.u.e.o.k;
import c.a.n0.a.y0.k.e.e;
import c.a.n0.a.y0.k.e.f;
import c.a.n0.a.y0.k.e.g;
import c.a.n0.a.y0.k.e.h;
import c.a.n0.a.y0.k.e.i;
import c.a.n0.a.y0.k.e.j;
import c.a.n0.a.y0.k.e.l;
import c.a.n0.a.y0.k.e.m;
import c.a.n0.a.y0.k.e.n;
import c.a.n0.a.y0.k.e.o;
import c.a.n0.a.y0.k.e.p;
import c.a.n0.a.y0.k.e.q;
import c.a.n0.a.y0.k.e.r;
import c.a.n0.a.y0.k.e.t;
import c.a.n0.a.y0.k.e.u;
import c.a.n0.a.y0.k.e.v;
import c.a.n0.a.y0.k.g.a;
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
public final class a extends c.a.n0.a.y0.b<c.a.n0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9546i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0462a f9547h;

    /* renamed from: c.a.n0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0460a implements a.InterfaceC0462a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9548a;

        public C0460a(a aVar) {
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
            this.f9548a = aVar;
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f9548a.f9443b == null) {
                return;
            }
            this.f9548a.f9443b.onCallback(this.f9548a, "onStateChange", Integer.valueOf(i2));
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f9548a.f9443b == null) {
                return;
            }
            this.f9548a.f9443b.onCallback(this.f9548a, "onInfo", Integer.valueOf(i2));
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f9548a.f9443b != null) {
                    this.f9548a.f9443b.onCallback(this.f9548a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                k.e().k(str, false);
            }
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f9548a.f9443b == null) {
                return;
            }
            this.f9548a.f9443b.onCallback(this.f9548a, "onNetStatus", str);
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.f9548a.f9443b != null) {
                    this.f9548a.f9443b.onCallback(this.f9548a, "onPlayed", null);
                }
                k.e().k(str, true);
            }
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f9548a.f9443b == null) {
                return;
            }
            this.f9548a.f9443b.onCallback(this.f9548a, "onVideoSizeChanged", null);
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f9548a.f9443b == null) {
                return;
            }
            this.f9548a.f9443b.onCallback(this.f9548a, "onEnded", null);
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f9548a.f9443b == null) {
                return;
            }
            this.f9548a.f9443b.onCallback(this.f9548a, "onError", Integer.valueOf(i2));
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f9548a.f9443b == null) {
                return;
            }
            this.f9548a.f9443b.onCallback(this.f9548a, "onPrepared", null);
        }

        @Override // c.a.n0.a.y0.k.g.a.InterfaceC0462a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                k.e().p(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1263484223, "Lc/a/n0/a/y0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1263484223, "Lc/a/n0/a/y0/k/a;");
                return;
            }
        }
        f9546i = c.a.n0.a.k.f6803a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.y0.k.g.a aVar) {
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
                super((c.a.n0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        C0460a c0460a = new C0460a(this);
        this.f9547h = c0460a;
        aVar.h0(c0460a);
        k.e().b(aVar);
        this.f9442a.a(new c.a.n0.a.y0.k.e.a());
        this.f9442a.a(new c.a.n0.a.y0.k.e.b());
        this.f9442a.a(new c.a.n0.a.y0.k.e.c());
        this.f9442a.a(new f());
        this.f9442a.a(new e());
        this.f9442a.a(new c.a.n0.a.y0.k.e.d());
        this.f9442a.a(new g());
        this.f9442a.a(new h());
        this.f9442a.a(new i());
        this.f9442a.a(new j());
        this.f9442a.a(new l());
        this.f9442a.a(new m());
        this.f9442a.a(new n());
        this.f9442a.a(new o());
        this.f9442a.a(new q());
        this.f9442a.a(new r());
        this.f9442a.a(new u());
        this.f9442a.a(new v());
        this.f9442a.a(new p());
        this.f9442a.a(new c.a.n0.a.y0.k.e.k());
        this.f9442a.a(new t());
    }

    @Override // c.a.n0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (f9546i) {
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
            if (command != null && TextUtils.equals(command.what, m.f9554b)) {
                boolean z = f9546i;
                return false;
            }
            int a2 = ((c.a.n0.a.y0.k.g.a) this.f9444c).a();
            if (f9546i && a2 != 1) {
                String str = "isRejectCommand: authorize type => " + ((c.a.n0.a.y0.k.g.a) this.f9444c).a() + " command=> " + (command == null ? "" : command.what);
            }
            return a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
