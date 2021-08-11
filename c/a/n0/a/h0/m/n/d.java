package c.a.n0.a.h0.m.n;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.a2.i;
import c.a.n0.a.a2.l;
import c.a.n0.a.f1.e.f.c;
import c.a.n0.a.k;
import c.a.n0.a.v2.q0;
import c.a.n0.n.i.g;
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
public final class d extends c.a.n0.a.h0.m.n.a implements g, c.a.n0.a.v2.e1.b<i.a> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5970f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5971a;

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
            this.f5971a = dVar;
        }

        @Override // c.a.n0.a.h0.m.n.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.f5971a.c(str, map, map2, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f5972a;

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
            this.f5972a = dVar;
        }

        @Override // c.a.n0.a.h0.m.n.d.e
        public void a(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(1048576, this, str, map, map2, jSONObject, aVar) == null) {
                this.f5972a.a(str, map, map2, jSONObject, aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5973e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5974f;

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
            this.f5974f = dVar;
            this.f5973e = str;
        }

        @Override // c.a.n0.n.i.g.a
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                this.f5974f.D(this.f5973e, "pms_http_with_ipc_action_stat_record", new c.a().y("pms_http_with_ipc_key_url", str).y("pms_http_with_ipc_key_response", str2).y("pms_http_with_ipc_key_stat_record", jSONObject.toString()));
            }
        }

        @Override // c.a.n0.n.i.g.a
        public void b(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
                this.f5974f.D(this.f5973e, "pms_http_with_ipc_action_success", new c.a().y("pms_http_with_ipc_key_response", str).v("pms_http_with_ipc_key_status_code", i2));
            }
        }

        @Override // c.a.n0.n.i.g.a
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                d dVar = this.f5974f;
                String str = this.f5973e;
                dVar.E(str, "http: " + exc);
                if (d.f5970f) {
                    exc.printStackTrace();
                }
            }
        }

        @Override // c.a.n0.n.i.g.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f5974f.D(this.f5973e, "pms_http_with_ipc_action_on_start", null);
            }
        }
    }

    /* renamed from: c.a.n0.a.h0.m.n.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0223d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5975e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5976f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a f5977g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f5978h;

        public RunnableC0223d(d dVar, String str, String str2, c.a aVar) {
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
            this.f5978h = dVar;
            this.f5975e = str;
            this.f5976f = str2;
            this.f5977g = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!c.a.n0.a.v1.b.c.g(this.f5975e, "pms_http_with_ipc")) {
                    if (d.f5970f) {
                        this.f5978h.H("callbackIpcSession", "return by topic pms_http_with_ipc");
                        return;
                    }
                    return;
                }
                c.a.n0.a.v1.b.b y = c.a.n0.a.v1.b.c.O(this.f5975e).y("pms_http_with_ipc_key_action", this.f5976f);
                c.a aVar = this.f5977g;
                if (aVar != null) {
                    y.r(aVar.C());
                }
                if (d.f5970f) {
                    d dVar = this.f5978h;
                    dVar.H("callbackIpcSession", "ipcSession= " + y);
                }
                y.L();
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1986998476, "Lc/a/n0/a/h0/m/n/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1986998476, "Lc/a/n0/a/h0/m/n/d;");
                return;
            }
        }
        f5970f = k.f6803a;
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
                super((c.a.n0.a.a2.d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        c.a.n0.a.a2.b bVar = new c.a.n0.a.a2.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
    }

    public final void D(String str, String str2, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, aVar) == null) {
            if (f5970f) {
                H("callbackIpcSession", "session=" + str + " action=" + str2 + " msg=" + aVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            q0.b0(new RunnableC0223d(this, str, str2, aVar));
        }
    }

    public final void E(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            D(str, "pms_http_with_ipc_action_fail", new c.a().y("pms_http_with_ipc_key_error", str2));
        }
    }

    public final void F(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (f5970f) {
                H("handleIpcMsg", "msg=" + aVar);
            }
            if (aVar == null || !c.a.n0.a.v1.b.c.f(aVar.C(), "pms_http_with_ipc")) {
                return;
            }
            String n = aVar.n("ipc_session_id");
            if (f5970f) {
                H("handleIpcMsg", "session=" + n);
            }
            if (TextUtils.isEmpty(n)) {
                return;
            }
            String n2 = aVar.n("pms_http_with_ipc_key_action");
            if (f5970f) {
                H("handleIpcMsg", "action=" + n2);
            }
            if (TextUtils.isEmpty(n2)) {
                E(n, "empty action");
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
                k(n, aVar, new a(this));
            } else if (c2 != 1) {
                E(n, "no such action:" + n2);
            } else {
                k(n, aVar, new b(this));
            }
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            boolean z = f5970f;
        }
    }

    public final void H(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            G(str + ": " + str2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.v2.e1.b
    /* renamed from: I */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            F(aVar);
        }
    }

    public final void k(String str, @NonNull i.a aVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, aVar, eVar) == null) {
            if (f5970f) {
                H("buildRequestForIpc", "session=" + str + " msg=" + aVar + " adapter=" + eVar);
            }
            if (c.a.n0.a.v1.b.c.g(str, "pms_http_with_ipc")) {
                String n = aVar.n("pms_http_with_ipc_key_url");
                Map<String, String> e2 = c.a.n0.a.h0.m.n.a.e(aVar.f("pms_http_with_ipc_key_url_param_map"));
                Map<String, String> e3 = c.a.n0.a.h0.m.n.a.e(aVar.f("pms_http_with_ipc_key_header_param_map"));
                String n2 = aVar.n("pms_http_with_ipc_keyjson_body");
                JSONObject jSONObject = null;
                try {
                    if (!TextUtils.isEmpty(n2)) {
                        jSONObject = new JSONObject(n2);
                    }
                } catch (JSONException e4) {
                    if (f5970f) {
                        e4.printStackTrace();
                    }
                }
                try {
                    eVar.a(n, e2, e3, jSONObject, new c(this, str));
                } catch (Exception e5) {
                    E(str, "catch: " + e5);
                    if (f5970f) {
                        e5.printStackTrace();
                    }
                }
            }
        }
    }
}
