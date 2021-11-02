package b.a.p0.a.c2.f.g0;

import b.a.p0.a.a2.h;
import b.a.p0.a.a2.i;
import b.a.p0.a.a2.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends m implements b.a.p0.a.v2.e1.b<i.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f4241f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4242g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4241f = 0;
        this.f4242g = false;
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            b.a.p0.a.v1.b.b E = b.a.p0.a.v1.b.c.E("swan_kill_to_client");
            E.I(str);
            E.call();
        }
    }

    public static void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i2) == null) {
            if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
                a B = b.a.p0.a.a2.d.g().B();
                B.f4241f = i2;
                B.e(str);
                return;
            }
            b.a.p0.a.v1.b.b v = b.a.p0.a.v1.b.c.E("swan_forbidden_kill_on_server").y("mAppId", str).v("ipc_forbidden_flag", i2);
            v.J(true);
            v.call();
        }
    }

    public abstract void e(String str);

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f4242g) {
            return;
        }
        b.a.p0.a.a2.b bVar = new b.a.p0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
        this.f4242g = true;
    }
}
