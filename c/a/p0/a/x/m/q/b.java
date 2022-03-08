package c.a.p0.a.x.m.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.w;
import c.a.p0.a.t1.i;
import c.a.p0.a.t1.j;
import c.a.p0.q.i.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b extends c.a.p0.a.x.m.q.a implements g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8679f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<c.a.p0.a.o1.b.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0561b f8680e;

        public a(b bVar, C0561b c0561b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c0561b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8680e = c0561b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.o1.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f8680e.onFail(cVar.N());
            }
        }
    }

    /* renamed from: c.a.p0.a.x.m.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0561b implements g.a, c.a.p0.a.p2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final g.a f8681e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f8682f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8683g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f8684h;

        public C0561b(b bVar, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8684h = bVar;
            this.f8683g = false;
            this.f8681e = aVar;
            this.f8682f = aVar != null;
            if (b.f8679f) {
                bVar.N("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // c.a.p0.q.i.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f8679f) {
                        b bVar = this.f8684h;
                        bVar.N("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e2 + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (e2) {
                        this.f8681e.a(str, str2, jSONObject);
                    }
                }
            }
        }

        @Override // c.a.p0.q.i.g.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f8679f) {
                        b bVar = this.f8684h;
                        bVar.N("IpcHttpCallbackWrapper#onSuccess", "valid=" + e2 + " statusCode=" + i2 + " response=" + str);
                    }
                    if (e2) {
                        c();
                        this.f8681e.b(str, i2);
                    }
                }
            }
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    this.f8683g = true;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: d */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f8679f) {
                        b bVar = this.f8684h;
                        bVar.N("IpcHttpCallbackWrapper#onCallback", "valid=" + e2 + " msg=" + aVar);
                    }
                    if (e2) {
                        String o = aVar.o("pms_http_with_ipc_key_action", "");
                        char c2 = 65535;
                        switch (o.hashCode()) {
                            case -2080875416:
                                if (o.equals("pms_http_with_ipc_action_success")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -898655015:
                                if (o.equals("pms_http_with_ipc_action_fail")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case -480804291:
                                if (o.equals("pms_http_with_ipc_action_on_start")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 1737801345:
                                if (o.equals("pms_http_with_ipc_action_stat_record")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            a(aVar.n("pms_http_with_ipc_key_url"), aVar.n("pms_http_with_ipc_key_response"), w.d(aVar.n("pms_http_with_ipc_key_stat_record")));
                        } else if (c2 == 1) {
                            b(aVar.n("pms_http_with_ipc_key_response"), aVar.i("pms_http_with_ipc_key_status_code"));
                        } else if (c2 == 2) {
                            onFail(new Exception(aVar.n("pms_http_with_ipc_key_error")));
                        } else if (c2 == 3) {
                            onStart();
                        }
                    }
                }
            }
        }

        public synchronized boolean e() {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    if (this.f8682f) {
                        z = this.f8683g ? false : true;
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.q.i.g.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f8679f) {
                        b bVar = this.f8684h;
                        bVar.N("IpcHttpCallbackWrapper#onFail", "valid=" + e2 + " exception=" + exc);
                    }
                    if (e2) {
                        c();
                        g.a aVar = this.f8681e;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // c.a.p0.q.i.g.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f8679f) {
                        b bVar = this.f8684h;
                        bVar.N("IpcHttpCallbackWrapper#onStart", "valid=" + e2);
                    }
                    if (e2) {
                        this.f8681e.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2008909753, "Lc/a/p0/a/x/m/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2008909753, "Lc/a/p0/a/x/m/q/b;");
                return;
            }
        }
        f8679f = c.a.p0.a.a.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(j jVar) {
        super(jVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.t1.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void L(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, map, map2, jSONObject, aVar}) == null) {
            if (f8679f) {
                M("ipcHttp");
            }
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            C0561b c0561b = new C0561b(this, aVar);
            c.a.p0.a.o1.b.c z = c.a.p0.a.o1.b.d.P("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            c.a.p0.a.o1.b.c u = z.z("pms_http_with_ipc_key_url", str2).z("pms_http_with_ipc_keyjson_body", TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2).u("pms_http_with_ipc_key_url_param_map", c.a.p0.a.x.m.q.a.I(map)).u("pms_http_with_ipc_key_header_param_map", c.a.p0.a.x.m.q.a.I(map2));
            u.K(true);
            u.G(c0561b);
            u.F(new a(this, c0561b));
            if (f8679f) {
                N("ipcHttp", "session=" + u);
            }
            u.call(e.l0);
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            boolean z = f8679f;
        }
    }

    public final void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            M(str + ": " + str2);
        }
    }

    @Override // c.a.p0.a.x.m.q.a, c.a.p0.q.i.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (f8679f) {
                M("buildJsonPostRequest");
            }
            L("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // c.a.p0.a.x.m.q.a, c.a.p0.q.i.g
    public void j(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (f8679f) {
                M("buildGetRequest");
            }
            String b2 = c.a.p0.a.k1.l.d.b();
            if (b2 != null) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("launchid", b2);
            }
            L("pms_http_with_ipc_action_build_get_request", str, map, map2, null, aVar);
        }
    }
}
