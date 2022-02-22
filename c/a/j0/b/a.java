package c.a.j0.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.d0.h.h;
import c.a.d0.u.n;
import c.a.j0.b.f.f;
import c.a.j0.b.f.g;
import c.a.j0.b.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.qq.e.comm.constants.Constants;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.j0.b.b f4250b;

    /* renamed from: c  reason: collision with root package name */
    public int f4251c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f4252d;

    /* renamed from: c.a.j0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0204a extends c.a.d0.u.p.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f4253b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f4254c;

        public C0204a(a aVar, String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f4253b = j2;
            this.f4254c = j3;
        }

        @Override // c.a.d0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                BaseVM.m(this.a, this.f4253b, this.f4254c, exc.getMessage(), "update");
            }
        }

        @Override // c.a.d0.u.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i2) throws Exception {
            f(headers, str, i2);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i2) == null) {
                BaseVM.m(this.a, this.f4253b, this.f4254c, BasicPushStatus.SUCCESS_CODE, "update");
                try {
                    c.a.j0.b.f.a.b(str, this.a);
                } catch (ParseError e2) {
                    e2.printStackTrace();
                }
            }
        }

        public String f(Headers headers, String str, int i2) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.d0.u.p.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f4255b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f4256c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.j0.b.b f4257d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4258e;

        public b(a aVar, String str, long j2, long j3, c.a.j0.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j2), Long.valueOf(j3), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4258e = aVar;
            this.a = str;
            this.f4255b = j2;
            this.f4256c = j3;
            this.f4257d = bVar;
        }

        @Override // c.a.d0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                BaseVM.m(this.a, this.f4255b, this.f4256c, exc.getMessage(), "query");
                if (this.f4258e.f4252d || this.f4258e.a == null) {
                    return;
                }
                this.f4258e.a.removeCallbacksAndMessages(null);
                this.f4258e.a.post(new c(this.f4258e, this.a));
            }
        }

        @Override // c.a.d0.u.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i2) throws Exception {
            f(headers, str, i2);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i2) == null) {
                BaseVM.m(this.a, this.f4255b, this.f4256c, BasicPushStatus.SUCCESS_CODE, "query");
                if (this.f4258e.f4252d) {
                    return;
                }
                this.f4258e.a.removeCallbacksAndMessages(null);
                try {
                    List<g> b2 = c.a.j0.b.f.a.b(str, this.a);
                    if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                        this.f4257d.b(b2.get(0));
                    } else {
                        this.f4257d.a(new Throwable("no ad"));
                    }
                } catch (ParseError e2) {
                    e2.printStackTrace();
                    this.f4257d.a(e2);
                }
            }
        }

        public String f(Headers headers, String str, int i2) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f4259e;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4259e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4259e.f4252d = true;
                g l = c.a.j0.b.f.e.l();
                if (this.f4259e.f4250b == null) {
                    return;
                }
                if (l == null) {
                    this.f4259e.f4250b.a(new Throwable("no ad"));
                    return;
                }
                l.C = 2;
                this.f4259e.f4250b.b(l);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.f4251c = 5000;
        this.f4252d = false;
    }

    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || c.a.j0.a.b.d.a().d() == null || !c.a.j0.a.b.d.a().d().has("client_ext") || (optJSONObject = c.a.j0.a.b.d.a().d().optJSONObject("client_ext")) == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject.put(next, optJSONObject.opt(next));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void f(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            h a = c.a.d0.h.a.a();
            hashMap.put("ver", a.q());
            hashMap.put("sv", "1.0");
            hashMap.put("uid", a.m());
            hashMap.put(TiebaStatic.Params.BDID, a.g());
            hashMap.put("cuid", a.b());
            hashMap.put(SearchJsBridge.COOKIE_MOD, a.j());
            hashMap.put(SearchJsBridge.COOKIE_OV, a.c());
            hashMap.put("imei", a.p());
            hashMap.put("ua", a.i());
            hashMap.put("fmt", "json");
            hashMap.put("apna", a.packageName());
            hashMap.put("eid", a.d());
            hashMap.put("st", "1");
            hashMap.put("ot", "2");
            hashMap.put("nt", String.valueOf(new n().c()));
            hashMap.put("ct", "2");
            hashMap.put("is_https", "1");
            hashMap.put(HttpRequest.ANDROID_ID, a.a());
            hashMap.put("from", c.a.j0.a.b.d.a().from());
            hashMap.put("cfrom", c.a.j0.a.b.d.a().a());
            hashMap.put("User-Agent", c.a.d0.h.a.e());
            if (TextUtils.isEmpty(a.h())) {
                return;
            }
            hashMap.put("oaid", a.h());
        }
    }

    public final void g(@NonNull HashMap<String, String> hashMap, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hashMap, str, str2, Long.valueOf(j2)}) != null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            new JSONObject();
            if (c.a.b.f().h()) {
                jSONObject.put("k", "cmd");
                jSONObject.put("v", str2);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("k", AdExtParam.KEY_NAD_CORE_VERSION);
            jSONObject2.put("v", "4.5.0.13");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            List<g> p = c.a.j0.b.f.e.p();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            TextUtils.equals(str, c.a.j0.a.b.d.a().e());
            int i2 = 1;
            if (p != null && p.size() > 0) {
                for (g gVar : p) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("k", gVar.f4292c);
                    if (!TextUtils.isEmpty(gVar.f4292c)) {
                        int e2 = c.a.j0.b.f.e.e(gVar);
                        String str3 = "onAdSuccess: " + e2;
                        if (e2 == 0) {
                            if (gVar.h()) {
                                c.a.d0.x.a.b(arrayList2, gVar.f4292c);
                            }
                            if (gVar.f()) {
                                c.a.d0.x.a.b(arrayList, gVar.f4292c);
                            }
                        } else {
                            i2 |= e2;
                        }
                    }
                    jSONObject4.put("r", String.valueOf(gVar.w));
                    if (gVar.h()) {
                        jSONArray2.put(jSONObject4);
                    }
                }
            }
            jSONObject3.put("d", jSONArray2);
            jSONObject3.put("s", i.d());
            jSONArray.put(new JSONObject());
            if (TextUtils.equals(str2, "query")) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("k", "ukey");
                jSONObject5.put("v", TextUtils.join(",", arrayList));
                jSONArray.put(jSONObject5);
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("k", "xz_ukey");
                jSONObject6.put("v", TextUtils.join(",", arrayList2));
                jSONArray.put(jSONObject6);
                if (arrayList2.isEmpty()) {
                    BaseVM.h(i2);
                }
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("k", "logid");
            jSONObject7.put("v", String.valueOf(j2));
            jSONArray.put(jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("k", "uid");
            jSONObject8.put("v", c.a.d0.h.a.a().m());
            jSONArray.put(jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("k", "ext_info");
            JSONObject jSONObject10 = new JSONObject();
            jSONObject10.put("ipdx", c.a.d0.p.a.a().a());
            jSONObject10.put("update_mark", NADNativeHelper.b());
            jSONObject10.put("boot_mark", NADNativeHelper.a());
            try {
                e(jSONObject10);
                jSONObject10.put(Constants.KEYS.AD_INFO, jSONObject3);
                jSONObject9.put("v", jSONObject10.toString());
                jSONObject9.put(AdExtParam.KEY_IADEX, c.a.d0.h.a.d().f());
                jSONArray.put(jSONObject9);
                hashMap.put("ext", jSONArray.toString());
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (JSONException e4) {
            e = e4;
        }
    }

    public final String h(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, map)) == null) {
            if (map != null && map.size() != 0) {
                URI create = URI.create(str);
                StringBuilder sb = new StringBuilder(TextUtils.isEmpty(create.getQuery()) ? "" : create.getQuery());
                if (sb.length() > 0) {
                    sb.append(Typography.amp);
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(Typography.amp);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                try {
                    return new URI(create.getScheme(), create.getAuthority(), create.getPath(), sb.toString(), create.getFragment()).toString();
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public final c.a.d0.u.s.d i(String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j2)})) == null) {
            String a = c.a.j0.a.a.a.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            String sb2 = sb.toString();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ac", TextUtils.equals(str, "update") ? String.valueOf(f.p()) : "1");
            hashMap.put("pid", str2);
            hashMap.put("product_id ", c.a.d0.h.a.a().l());
            f(hashMap);
            g(hashMap, str2, str, j2);
            c.a.d0.u.s.d dVar = new c.a.d0.u.s.d();
            dVar.k(h(sb2, hashMap));
            dVar.c();
            return dVar;
        }
        return (c.a.d0.u.s.d) invokeCommon.objValue;
    }

    public void j(String str, c.a.j0.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.j0.b.f.b.a(String.valueOf(currentTimeMillis));
            c.a.d0.u.s.d i2 = i("query", str, currentTimeMillis);
            i2.f3206f = this.f4251c;
            JSONObject d2 = c.a.j0.a.b.d.a().d();
            if (d2 != null && d2.has("query_response_thread")) {
                i2.h(d2.optInt("query_response_thread", 0) == 0);
            }
            c.a.d0.u.g.b().a().a(i2, new b(this, str, currentTimeMillis, System.currentTimeMillis(), bVar));
            this.f4250b = bVar;
            this.f4252d = false;
            this.f4251c = c.a.j0.a.b.d.a().f() - f.n();
            Handler handler = this.a;
            if (handler != null) {
                handler.postDelayed(new c(this, str), this.f4251c);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String optString = c.a.j0.a.b.d.a().d().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = c.a.j0.a.b.d.a().e();
            }
            String str = optString;
            c.a.d0.u.g.b().a().a(i("update", str, currentTimeMillis), new C0204a(this, str, currentTimeMillis, System.currentTimeMillis()));
        }
    }
}
