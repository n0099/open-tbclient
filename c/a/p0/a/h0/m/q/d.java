package c.a.p0.a.h0.m.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.i;
import c.a.p0.a.d2.l;
import c.a.p0.a.f1.e.f.c;
import c.a.p0.a.k;
import c.a.p0.a.z2.q0;
import c.a.p0.q.j.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d extends c.a.p0.a.h0.m.q.a implements g, c.a.p0.a.z2.g1.c<i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5815f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a.h0.m.q.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.j(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a.h0.m.q.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.a.a(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5817f;

        public c(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5817f = dVar;
            this.f5816e = str;
        }

        @Override // c.a.p0.q.j.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                this.f5817f.O(this.f5816e, "pms_http_with_ipc_action_stat_record", new c.a().z("pms_http_with_ipc_key_url", str).z("pms_http_with_ipc_key_response", str2).z("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
            }
        }

        @Override // c.a.p0.q.j.g.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                this.f5817f.O(this.f5816e, "pms_http_with_ipc_action_success", new c.a().z("pms_http_with_ipc_key_response", str).w("pms_http_with_ipc_key_status_code", i2));
            }
        }

        @Override // c.a.p0.q.j.g.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                d dVar = this.f5817f;
                String str = this.f5816e;
                dVar.P(str, "http: " + exc);
                if (d.f5815f) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // c.a.p0.q.j.g.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f5817f.O(this.f5816e, "pms_http_with_ipc_action_on_start", null);
            }
        }
    }

    /* renamed from: c.a.p0.a.h0.m.q.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0295d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5818e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5819f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a f5820g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f5821h;

        public RunnableC0295d(d dVar, String str, String str2, c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5821h = dVar;
            this.f5818e = str;
            this.f5819f = str2;
            this.f5820g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.p0.a.y1.b.d.J(this.f5818e, "pms_http_with_ipc")) {
                    if (d.f5815f) {
                        this.f5821h.S("callbackIpcSession", "return by topic pms_http_with_ipc");
                        return;
                    }
                    return;
                }
                c.a.p0.a.y1.b.c z = c.a.p0.a.y1.b.d.Z(this.f5818e).z("pms_http_with_ipc_key_action", this.f5819f);
                c.a aVar = this.f5820g;
                if (aVar != null) {
                    z.s(aVar.D());
                }
                if (d.f5815f) {
                    d dVar = this.f5821h;
                    dVar.S("callbackIpcSession", "ipcSession= " + z);
                }
                z.call();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(975970599, "Lc/a/p0/a/h0/m/q/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(975970599, "Lc/a/p0/a/h0/m/q/d;");
                return;
            }
        }
        f5815f = k.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(l lVar) {
        super(lVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.d2.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.a.p0.a.d2.b bVar = new c.a.p0.a.d2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
    }

    public final void N(String str, @NonNull i.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, aVar, eVar) == null) {
            if (f5815f) {
                S("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (c.a.p0.a.y1.b.d.J(str, "pms_http_with_ipc")) {
                String n = aVar.n("pms_http_with_ipc_key_url");
                Map<String, String> H = c.a.p0.a.h0.m.q.a.H(aVar.f("pms_http_with_ipc_key_url_param_map"));
                Map<String, String> H2 = c.a.p0.a.h0.m.q.a.H(aVar.f("pms_http_with_ipc_key_header_param_map"));
                String n2 = aVar.n("pms_http_with_ipc_keyjson_body");
                JSONObject jSONObject = null;
                try {
                    if (!TextUtils.isEmpty(n2)) {
                        jSONObject = new JSONObject(n2);
                    }
                } catch (JSONException e2) {
                    if (f5815f) {
                        e2.printStackTrace();
                    }
                }
                try {
                    eVar.a(n, H, H2, jSONObject, new c(this, str));
                } catch (Exception e3) {
                    P(str, "catch: " + e3);
                    if (f5815f) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public final void O(String str, String str2, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, aVar) == null) {
            if (f5815f) {
                S("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            q0.e0(new RunnableC0295d(this, str, str2, aVar));
        }
    }

    public final void P(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            O(str, "pms_http_with_ipc_action_fail", new c.a().z("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void Q(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (f5815f) {
                S("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar == null || !c.a.p0.a.y1.b.d.I(aVar.D(), "pms_http_with_ipc")) {
                return;
            }
            String n = aVar.n("ipc_session_id");
            if (f5815f) {
                S("handleIpcMsg", "session=" + n);
            }
            if (TextUtils.isEmpty(n)) {
                return;
            }
            String n2 = aVar.n("pms_http_with_ipc_key_action");
            if (f5815f) {
                S("handleIpcMsg", "action=" + n2);
            }
            if (TextUtils.isEmpty(n2)) {
                P(n, "empty action");
                return;
            }
            char c2 = 65535;
            int hashCode = n2.hashCode();
            if (hashCode != 646251642) {
                if (hashCode == 1779116731 && n2.equals("pms_http_with_ipc_action_build_json_post_request")) {
                    c2 = 1;
                }
            } else if (n2.equals("pms_http_with_ipc_action_build_get_request")) {
                c2 = 0;
            }
            if (c2 == 0) {
                N(n, aVar, new a(this));
            } else if (c2 != 1) {
                P(n, "no such action:" + n2);
            } else {
                N(n, aVar, new b(this));
            }
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            boolean z = f5815f;
        }
    }

    public final void S(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            R(str + ": " + str2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.z2.g1.c
    /* renamed from: T */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            Q(aVar);
        }
    }
}
