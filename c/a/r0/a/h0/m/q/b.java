package c.a.r0.a.h0.m.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.d2.i;
import c.a.r0.a.d2.j;
import c.a.r0.a.k;
import c.a.r0.a.z2.w;
import c.a.r0.q.j.g;
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
public final class b extends c.a.r0.a.h0.m.q.a implements g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f6704f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<c.a.r0.a.y1.b.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ C0387b f6705e;

        public a(b bVar, C0387b c0387b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, c0387b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6705e = c0387b;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.r0.a.y1.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                this.f6705e.onFail(cVar.N());
            }
        }
    }

    /* renamed from: c.a.r0.a.h0.m.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0387b implements g.a, c.a.r0.a.z2.g1.c<i.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final g.a f6706e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f6707f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6708g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f6709h;

        public C0387b(b bVar, g.a aVar) {
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
            this.f6709h = bVar;
            this.f6708g = false;
            this.f6706e = aVar;
            this.f6707f = aVar != null;
            if (b.f6704f) {
                bVar.N("IpcHttpCallbackWrapper", "wrappedCallback=" + aVar);
            }
        }

        @Override // c.a.r0.q.j.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f6704f) {
                        b bVar = this.f6709h;
                        bVar.N("IpcHttpCallbackWrapper#onStatRecord", "valid=" + e2 + " url=" + str + " statRecord=" + jSONObject);
                    }
                    if (e2) {
                        this.f6706e.a(str, str2, jSONObject);
                    }
                }
            }
        }

        @Override // c.a.r0.q.j.g.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f6704f) {
                        b bVar = this.f6709h;
                        bVar.N("IpcHttpCallbackWrapper#onSuccess", "valid=" + e2 + " statusCode=" + i2 + " response=" + str);
                    }
                    if (e2) {
                        c();
                        this.f6706e.b(str, i2);
                    }
                }
            }
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    this.f6708g = true;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: d */
        public void onCallback(i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f6704f) {
                        b bVar = this.f6709h;
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
                    if (this.f6707f) {
                        z = this.f6708g ? false : true;
                    }
                }
                return z;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.q.j.g.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, exc) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f6704f) {
                        b bVar = this.f6709h;
                        bVar.N("IpcHttpCallbackWrapper#onFail", "valid=" + e2 + " exception=" + exc);
                    }
                    if (e2) {
                        c();
                        g.a aVar = this.f6706e;
                        if (exc == null) {
                            exc = new Exception("onFail");
                        }
                        aVar.onFail(exc);
                    }
                }
            }
        }

        @Override // c.a.r0.q.j.g.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    boolean e2 = e();
                    if (b.f6704f) {
                        b bVar = this.f6709h;
                        bVar.N("IpcHttpCallbackWrapper#onStart", "valid=" + e2);
                    }
                    if (e2) {
                        this.f6706e.onStart();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-35146713, "Lc/a/r0/a/h0/m/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-35146713, "Lc/a/r0/a/h0/m/q/b;");
                return;
            }
        }
        f6704f = k.a;
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
                super((c.a.r0.a.d2.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void L(@NonNull String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, map, map2, jSONObject, aVar}) == null) {
            if (f6704f) {
                M("ipcHttp");
            }
            String jSONObject2 = jSONObject == null ? "" : jSONObject.toString();
            C0387b c0387b = new C0387b(this, aVar);
            c.a.r0.a.y1.b.c z = c.a.r0.a.y1.b.d.P("pms_http_with_ipc").z("pms_http_with_ipc_key_action", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            c.a.r0.a.y1.b.c u = z.z("pms_http_with_ipc_key_url", str2).z("pms_http_with_ipc_keyjson_body", TextUtils.isEmpty(jSONObject2) ? "" : jSONObject2).u("pms_http_with_ipc_key_url_param_map", c.a.r0.a.h0.m.q.a.I(map)).u("pms_http_with_ipc_key_header_param_map", c.a.r0.a.h0.m.q.a.I(map2));
            u.K(true);
            u.G(c0387b);
            u.F(new a(this, c0387b));
            if (f6704f) {
                N("ipcHttp", "session=" + u);
            }
            u.call(e.l0);
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            boolean z = f6704f;
        }
    }

    public final void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            M(str + ": " + str2);
        }
    }

    @Override // c.a.r0.a.h0.m.q.a, c.a.r0.q.j.g
    public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, str, map, map2, jSONObject, aVar) == null) {
            if (f6704f) {
                M("buildJsonPostRequest");
            }
            L("pms_http_with_ipc_action_build_json_post_request", str, map, map2, jSONObject, aVar);
        }
    }

    @Override // c.a.r0.a.h0.m.q.a, c.a.r0.q.j.g
    public void j(String str, Map<String, String> map, Map<String, String> map2, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, map, map2, aVar) == null) {
            if (f6704f) {
                M("buildGetRequest");
            }
            String b2 = c.a.r0.a.u1.l.d.b();
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
