package c.a.n0.a.v1.f.f0;

import c.a.n0.a.t1.h;
import c.a.n0.a.t1.i;
import c.a.n0.a.t1.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a extends m implements c.a.n0.a.p2.g1.c<i.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f6680b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6681c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6680b = 0;
        this.f6681c = false;
    }

    public static void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            c.a.n0.a.o1.b.c P = c.a.n0.a.o1.b.d.P("swan_kill_to_client");
            P.J(str);
            P.call();
        }
    }

    public static void K(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i) == null) {
            if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
                a B = c.a.n0.a.t1.d.J().B();
                B.f6680b = i;
                B.H(str);
                return;
            }
            c.a.n0.a.o1.b.c w = c.a.n0.a.o1.b.d.P("swan_forbidden_kill_on_server").z("mAppId", str).w("ipc_forbidden_flag", i);
            w.K(true);
            w.call();
        }
    }

    public abstract void H(String str);

    public void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f6681c) {
            return;
        }
        c.a.n0.a.t1.b bVar = new c.a.n0.a.t1.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
        this.f6681c = true;
    }
}
