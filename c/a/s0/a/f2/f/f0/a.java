package c.a.s0.a.f2.f.f0;

import c.a.s0.a.d2.h;
import c.a.s0.a.d2.i;
import c.a.s0.a.d2.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends m implements c.a.s0.a.z2.g1.c<i.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f6160f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6161g;

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
        this.f6160f = 0;
        this.f6161g = false;
    }

    public static void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            c.a.s0.a.y1.b.c P = c.a.s0.a.y1.b.d.P("swan_kill_to_client");
            P.J(str);
            P.call();
        }
    }

    public static void K(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i2) == null) {
            if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
                a B = c.a.s0.a.d2.d.J().B();
                B.f6160f = i2;
                B.H(str);
                return;
            }
            c.a.s0.a.y1.b.c w = c.a.s0.a.y1.b.d.P("swan_forbidden_kill_on_server").z("mAppId", str).w("ipc_forbidden_flag", i2);
            w.K(true);
            w.call();
        }
    }

    public abstract void H(String str);

    public void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f6161g) {
            return;
        }
        c.a.s0.a.d2.b bVar = new c.a.s0.a.d2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
        this.f6161g = true;
    }
}
