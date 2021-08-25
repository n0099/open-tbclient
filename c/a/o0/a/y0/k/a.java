package c.a.o0.a.y0.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.u.e.o.k;
import c.a.o0.a.y0.k.e.e;
import c.a.o0.a.y0.k.e.f;
import c.a.o0.a.y0.k.e.g;
import c.a.o0.a.y0.k.e.h;
import c.a.o0.a.y0.k.e.i;
import c.a.o0.a.y0.k.e.j;
import c.a.o0.a.y0.k.e.l;
import c.a.o0.a.y0.k.e.m;
import c.a.o0.a.y0.k.e.n;
import c.a.o0.a.y0.k.e.o;
import c.a.o0.a.y0.k.e.p;
import c.a.o0.a.y0.k.e.q;
import c.a.o0.a.y0.k.e.r;
import c.a.o0.a.y0.k.e.t;
import c.a.o0.a.y0.k.e.u;
import c.a.o0.a.y0.k.e.v;
import c.a.o0.a.y0.k.g.a;
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
public final class a extends c.a.o0.a.y0.b<c.a.o0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9792i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final a.InterfaceC0470a f9793h;

    /* renamed from: c.a.o0.a.y0.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0468a implements a.InterfaceC0470a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f9794a;

        public C0468a(a aVar) {
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
            this.f9794a = aVar;
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f9794a.f9689b == null) {
                return;
            }
            this.f9794a.f9689b.onCallback(this.f9794a, "onStateChange", Integer.valueOf(i2));
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f9794a.f9689b == null) {
                return;
            }
            this.f9794a.f9689b.onCallback(this.f9794a, "onInfo", Integer.valueOf(i2));
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f9794a.f9689b != null) {
                    this.f9794a.f9689b.onCallback(this.f9794a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                k.e().k(str, false);
            }
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f9794a.f9689b == null) {
                return;
            }
            this.f9794a.f9689b.onCallback(this.f9794a, "onNetStatus", str);
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.f9794a.f9689b != null) {
                    this.f9794a.f9689b.onCallback(this.f9794a, "onPlayed", null);
                }
                k.e().k(str, true);
            }
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f9794a.f9689b == null) {
                return;
            }
            this.f9794a.f9689b.onCallback(this.f9794a, "onVideoSizeChanged", null);
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f9794a.f9689b == null) {
                return;
            }
            this.f9794a.f9689b.onCallback(this.f9794a, "onEnded", null);
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void onError(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || this.f9794a.f9689b == null) {
                return;
            }
            this.f9794a.f9689b.onCallback(this.f9794a, "onError", Integer.valueOf(i2));
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f9794a.f9689b == null) {
                return;
            }
            this.f9794a.f9689b.onCallback(this.f9794a, "onPrepared", null);
        }

        @Override // c.a.o0.a.y0.k.g.a.InterfaceC0470a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1134401504, "Lc/a/o0/a/y0/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1134401504, "Lc/a/o0/a/y0/k/a;");
                return;
            }
        }
        f9792i = c.a.o0.a.k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.o0.a.y0.k.g.a aVar) {
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
                super((c.a.o0.a.y0.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        C0468a c0468a = new C0468a(this);
        this.f9793h = c0468a;
        aVar.h0(c0468a);
        k.e().b(aVar);
        this.f9688a.a(new c.a.o0.a.y0.k.e.a());
        this.f9688a.a(new c.a.o0.a.y0.k.e.b());
        this.f9688a.a(new c.a.o0.a.y0.k.e.c());
        this.f9688a.a(new f());
        this.f9688a.a(new e());
        this.f9688a.a(new c.a.o0.a.y0.k.e.d());
        this.f9688a.a(new g());
        this.f9688a.a(new h());
        this.f9688a.a(new i());
        this.f9688a.a(new j());
        this.f9688a.a(new l());
        this.f9688a.a(new m());
        this.f9688a.a(new n());
        this.f9688a.a(new o());
        this.f9688a.a(new q());
        this.f9688a.a(new r());
        this.f9688a.a(new u());
        this.f9688a.a(new v());
        this.f9688a.a(new p());
        this.f9688a.a(new c.a.o0.a.y0.k.e.k());
        this.f9688a.a(new t());
    }

    @Override // c.a.o0.a.y0.b, com.baidu.webkit.sdk.plugin.ZeusPlugin
    public void sendCommand(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, command) == null) {
            if (w(command)) {
                if (f9792i) {
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
            if (command != null && TextUtils.equals(command.what, m.f9800b)) {
                boolean z = f9792i;
                return false;
            }
            int a2 = ((c.a.o0.a.y0.k.g.a) this.f9690c).a();
            if (f9792i && a2 != 1) {
                String str = "isRejectCommand: authorize type => " + ((c.a.o0.a.y0.k.g.a) this.f9690c).a() + " command=> " + (command == null ? "" : command.what);
            }
            return a2 == 2;
        }
        return invokeL.booleanValue;
    }
}
