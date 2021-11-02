package b.a.p0.a.y0.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.u.e.o.k;
import b.a.p0.a.y0.k.e.e;
import b.a.p0.a.y0.k.e.f;
import b.a.p0.a.y0.k.e.g;
import b.a.p0.a.y0.k.e.h;
import b.a.p0.a.y0.k.e.i;
import b.a.p0.a.y0.k.e.j;
import b.a.p0.a.y0.k.e.l;
import b.a.p0.a.y0.k.e.m;
import b.a.p0.a.y0.k.e.n;
import b.a.p0.a.y0.k.e.o;
import b.a.p0.a.y0.k.e.p;
import b.a.p0.a.y0.k.e.q;
import b.a.p0.a.y0.k.e.r;
import b.a.p0.a.y0.k.e.t;
import b.a.p0.a.y0.k.e.u;
import b.a.p0.a.y0.k.e.v;
import b.a.p0.a.y0.k.g.a;
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
public final class a extends b.a.p0.a.y0.b<b.a.p0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9062i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0467a f9063h;

    /* renamed from: b.a.p0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0465a implements a.InterfaceC0467a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9064a;

        public C0465a(a aVar) {
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
            this.f9064a = aVar;
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f9064a.f8961b == null) {
                return;
            }
            this.f9064a.f8961b.onCallback(this.f9064a, "onStateChange", Integer.valueOf(i2));
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f9064a.f8961b == null) {
                return;
            }
            this.f9064a.f8961b.onCallback(this.f9064a, "onInfo", Integer.valueOf(i2));
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f9064a.f8961b != null) {
                    this.f9064a.f8961b.onCallback(this.f9064a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                k.e().k(str, false);
            }
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f9064a.f8961b == null) {
                return;
            }
            this.f9064a.f8961b.onCallback(this.f9064a, "onNetStatus", str);
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.f9064a.f8961b != null) {
                    this.f9064a.f8961b.onCallback(this.f9064a, "onPlayed", null);
                }
                k.e().k(str, true);
            }
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f9064a.f8961b == null) {
                return;
            }
            this.f9064a.f8961b.onCallback(this.f9064a, "onVideoSizeChanged", null);
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f9064a.f8961b == null) {
                return;
            }
            this.f9064a.f8961b.onCallback(this.f9064a, "onEnded", null);
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f9064a.f8961b == null) {
                return;
            }
            this.f9064a.f8961b.onCallback(this.f9064a, "onError", Integer.valueOf(i2));
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f9064a.f8961b == null) {
                return;
            }
            this.f9064a.f8961b.onCallback(this.f9064a, "onPrepared", null);
        }

        @Override // b.a.p0.a.y0.k.g.a.InterfaceC0467a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-494784608, "Lb/a/p0/a/y0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-494784608, "Lb/a/p0/a/y0/k/a;");
                return;
            }
        }
        f9062i = b.a.p0.a.k.f6397a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.y0.k.g.a aVar) {
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
                super((b.a.p0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        C0465a c0465a = new C0465a(this);
        this.f9063h = c0465a;
        aVar.h0(c0465a);
        k.e().b(aVar);
        this.f8960a.a(new b.a.p0.a.y0.k.e.a());
        this.f8960a.a(new b.a.p0.a.y0.k.e.b());
        this.f8960a.a(new b.a.p0.a.y0.k.e.c());
        this.f8960a.a(new f());
        this.f8960a.a(new e());
        this.f8960a.a(new b.a.p0.a.y0.k.e.d());
        this.f8960a.a(new g());
        this.f8960a.a(new h());
        this.f8960a.a(new i());
        this.f8960a.a(new j());
        this.f8960a.a(new l());
        this.f8960a.a(new m());
        this.f8960a.a(new n());
        this.f8960a.a(new o());
        this.f8960a.a(new q());
        this.f8960a.a(new r());
        this.f8960a.a(new u());
        this.f8960a.a(new v());
        this.f8960a.a(new p());
        this.f8960a.a(new b.a.p0.a.y0.k.e.k());
        this.f8960a.a(new t());
    }

    @Override // b.a.p0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (f9062i) {
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
            if (command != null && TextUtils.equals(command.what, m.f9070b)) {
                boolean z = f9062i;
                return false;
            }
            int a2 = ((b.a.p0.a.y0.k.g.a) this.f8962c).a();
            if (f9062i && a2 != 1) {
                String str = "isRejectCommand: authorize type => " + ((b.a.p0.a.y0.k.g.a) this.f8962c).a() + " command=> " + (command == null ? "" : command.what);
            }
            return a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
