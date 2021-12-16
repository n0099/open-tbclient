package c.a.h0.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.c0.e.f;
import c.a.c0.r.n;
import c.a.h0.a.c.g;
import c.a.h0.b.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
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
    public c.a.h0.b.b f3346b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f3347c;

    /* renamed from: d  reason: collision with root package name */
    public int f3348d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3349e;

    /* renamed from: c.a.h0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0128a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3350e;

        public RunnableC0128a(a aVar) {
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
            this.f3350e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3350e.f3349e = true;
                g.a.e("Afd", "执行超时回调");
                c.a.h0.b.f.g l = c.a.h0.b.f.e.l();
                if (this.f3350e.f3346b == null) {
                    return;
                }
                if (l == null) {
                    this.f3350e.f3346b.a(new Throwable("no ad"));
                    return;
                }
                l.C = 2;
                this.f3350e.f3346b.b(l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.c0.r.p.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f3351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f3352c;

        public b(a aVar, String str, long j2, long j3) {
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
            this.f3351b = j2;
            this.f3352c = j3;
        }

        @Override // c.a.c0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                g gVar = g.a;
                gVar.e("Afd", "update接口 " + exc.getMessage());
                BaseVM.k(this.a, this.f3351b, this.f3352c, exc.getMessage(), "update");
            }
        }

        @Override // c.a.c0.r.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i2) throws Exception {
            f(headers, str, i2);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.r.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i2) == null) {
                BaseVM.k(this.a, this.f3351b, this.f3352c, BasicPushStatus.SUCCESS_CODE, "update");
                try {
                    c.a.h0.b.f.a.b(str, this.a);
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
    public class c extends c.a.c0.r.p.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f3353b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f3354c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.h0.b.b f3355d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3356e;

        public c(a aVar, String str, long j2, long j3, c.a.h0.b.b bVar) {
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
            this.f3356e = aVar;
            this.a = str;
            this.f3353b = j2;
            this.f3354c = j3;
            this.f3355d = bVar;
        }

        @Override // c.a.c0.r.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                g gVar = g.a;
                gVar.e("Afd", "query接口 " + exc.getMessage());
                BaseVM.k(this.a, this.f3353b, this.f3354c, exc.getMessage(), "query");
                if (!this.f3356e.f3349e) {
                    if (this.f3356e.a != null) {
                        this.f3356e.a.removeCallbacksAndMessages(null);
                        this.f3356e.a.post(this.f3356e.f3347c);
                        return;
                    }
                    return;
                }
                g gVar2 = g.a;
                StringBuilder sb = new StringBuilder();
                sb.append("query接口 error 超时：");
                sb.append(System.currentTimeMillis() - this.f3353b);
                sb.append(" cause : ");
                sb.append(exc);
                gVar2.e("Afd", sb.toString() == null ? "unknow" : exc.getMessage());
            }
        }

        @Override // c.a.c0.r.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i2) throws Exception {
            f(headers, str, i2);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.c0.r.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i2) == null) {
                BaseVM.k(this.a, this.f3353b, this.f3354c, BasicPushStatus.SUCCESS_CODE, "query");
                if (!this.f3356e.f3349e) {
                    this.f3356e.a.removeCallbacksAndMessages(null);
                    try {
                        List<c.a.h0.b.f.g> b2 = c.a.h0.b.f.a.b(str, this.a);
                        if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                            this.f3355d.b(b2.get(0));
                        } else {
                            this.f3355d.a(new Throwable("no ad"));
                        }
                        return;
                    } catch (ParseError e2) {
                        e2.printStackTrace();
                        this.f3355d.a(e2);
                        return;
                    }
                }
                g gVar = g.a;
                gVar.e("Afd", "query接口 response 超时：" + (System.currentTimeMillis() - this.f3353b));
            }
        }

        public String f(Headers headers, String str, int i2) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? str : (String) invokeLLI.objValue;
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
        this.f3347c = new RunnableC0128a(this);
        this.f3348d = 5000;
        this.f3349e = false;
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || c.a.h0.a.b.d.a().d() == null || !c.a.h0.a.b.d.a().d().has("client_ext") || (optJSONObject = c.a.h0.a.b.d.a().d().optJSONObject("client_ext")) == null) {
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

    public final void g(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hashMap) == null) {
            f a = c.a.c0.e.a.a();
            hashMap.put("ver", a.o());
            hashMap.put("sv", "1.0");
            hashMap.put("uid", a.l());
            hashMap.put(TiebaStatic.Params.BDID, a.f());
            hashMap.put("cuid", a.b());
            hashMap.put(SearchJsBridge.COOKIE_MOD, a.i());
            hashMap.put(SearchJsBridge.COOKIE_OV, a.c());
            hashMap.put("imei", a.n());
            hashMap.put("ua", a.h());
            hashMap.put("fmt", "json");
            hashMap.put("apna", a.packageName());
            hashMap.put("eid", a.d());
            hashMap.put("st", "1");
            hashMap.put("ot", "2");
            hashMap.put("nt", String.valueOf(new n().c()));
            hashMap.put("ct", "2");
            hashMap.put("is_https", "1");
            hashMap.put("android_id", a.a());
            hashMap.put("from", c.a.h0.a.b.d.a().from());
            hashMap.put("cfrom", c.a.h0.a.b.d.a().a());
            hashMap.put("User-Agent", c.a.c0.e.a.d());
            if (TextUtils.isEmpty(a.g())) {
                return;
            }
            hashMap.put("oaid", a.g());
        }
    }

    public final void h(@NonNull HashMap<String, String> hashMap, String str, String str2, long j2) {
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
            List<c.a.h0.b.f.g> p = c.a.h0.b.f.e.p();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            boolean equals = TextUtils.equals(str, c.a.h0.a.b.d.a().e());
            if (p != null && p.size() > 0) {
                for (c.a.h0.b.f.g gVar : p) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("k", gVar.f3387c);
                    if (!TextUtils.isEmpty(gVar.f3387c)) {
                        int e2 = c.a.h0.b.f.e.e(gVar);
                        String str3 = "onAdSuccess: " + e2;
                        if (e2 == 0) {
                            if (equals && gVar.h()) {
                                c.a.c0.u.a.b(arrayList, gVar.f3387c);
                            }
                            if (!equals && gVar.f()) {
                                c.a.c0.u.a.b(arrayList, gVar.f3387c);
                            }
                        }
                    }
                    jSONObject3.put("r", String.valueOf(gVar.w));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", i.b());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("k", Constants.KEYS.AD_INFO);
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            if (TextUtils.equals(str2, "query")) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("k", "ukey");
                jSONObject5.put("v", TextUtils.join(",", arrayList));
                jSONArray.put(jSONObject5);
            }
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("k", "logid");
            jSONObject6.put("v", String.valueOf(j2));
            jSONArray.put(jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("k", "uid");
            jSONObject7.put("v", c.a.c0.e.a.a().l());
            jSONArray.put(jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("k", "ext_info");
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("ipdx", c.a.c0.m.a.a().a());
            jSONObject9.put("update_mark", NADNativeHelper.b());
            jSONObject9.put("boot_mark", NADNativeHelper.a());
            try {
                f(jSONObject9);
                jSONObject8.put("v", jSONObject9.toString());
                jSONArray.put(jSONObject8);
                hashMap.put("ext", jSONArray.toString());
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
            }
        } catch (JSONException e4) {
            e = e4;
        }
    }

    public final String i(String str, Map<String, String> map) {
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

    public final c.a.c0.r.s.d j(String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j2)})) == null) {
            String a = c.a.h0.a.a.a.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            String sb2 = sb.toString();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ac", TextUtils.equals(str, "update") ? String.valueOf(c.a.h0.b.f.f.f()) : "1");
            hashMap.put("pid", str2);
            hashMap.put("product_id ", c.a.c0.e.a.a().k());
            g(hashMap);
            h(hashMap, str2, str, j2);
            c.a.c0.r.s.d dVar = new c.a.c0.r.s.d();
            dVar.k(i(sb2, hashMap));
            dVar.c();
            return dVar;
        }
        return (c.a.c0.r.s.d) invokeCommon.objValue;
    }

    public void k(String str, c.a.h0.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.h0.b.f.b.a(String.valueOf(currentTimeMillis));
            c.a.c0.r.s.d j2 = j("query", str, currentTimeMillis);
            j2.f1883f = this.f3348d;
            JSONObject d2 = c.a.h0.a.b.d.a().d();
            if (d2 != null && d2.has("query_response_thread")) {
                j2.h(d2.optInt("query_response_thread", 0) == 0);
            }
            c.a.c0.r.g.b().a().a(j2, new c(this, str, currentTimeMillis, System.currentTimeMillis(), bVar));
            this.f3346b = bVar;
            this.f3349e = false;
            int f2 = c.a.h0.a.b.d.a().f() - c.a.h0.b.f.f.e();
            this.f3348d = f2;
            Handler handler = this.a;
            if (handler != null) {
                handler.postDelayed(this.f3347c, f2);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String optString = c.a.h0.a.b.d.a().d().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = c.a.h0.a.b.d.a().e();
            }
            String str = optString;
            c.a.c0.r.g.b().a().a(j("update", str, currentTimeMillis), new b(this, str, currentTimeMillis, System.currentTimeMillis()));
        }
    }
}
