package c.a.f0.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.a0.h.h;
import c.a.a0.u.n;
import c.a.f0.b.f.f;
import c.a.f0.b.f.g;
import c.a.f0.b.f.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nad.jni.NADNativeHelper;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.sofire.d.D;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.f0.b.b f2898b;

    /* renamed from: c  reason: collision with root package name */
    public int f2899c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f2900d;

    /* renamed from: c.a.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0139a extends c.a.a0.u.p.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f2901b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f2902c;

        public C0139a(a aVar, String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f2901b = j;
            this.f2902c = j2;
        }

        @Override // c.a.a0.u.p.a
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                BaseVM.m(this.a, this.f2901b, this.f2902c, exc.getMessage(), "update");
            }
        }

        @Override // c.a.a0.u.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.m(this.a, this.f2901b, this.f2902c, BasicPushStatus.SUCCESS_CODE, "update");
                try {
                    c.a.f0.b.f.a.b(str, this.a);
                } catch (ParseError e2) {
                    e2.printStackTrace();
                }
            }
        }

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b extends c.a.a0.u.p.c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f2903b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f2904c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.b.b f2905d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2906e;

        public b(a aVar, String str, long j, long j2, c.a.f0.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j), Long.valueOf(j2), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2906e = aVar;
            this.a = str;
            this.f2903b = j;
            this.f2904c = j2;
            this.f2905d = bVar;
        }

        @Override // c.a.a0.u.p.a
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                BaseVM.m(this.a, this.f2903b, this.f2904c, exc.getMessage(), "query");
                if (this.f2906e.f2900d || this.f2906e.a == null) {
                    return;
                }
                this.f2906e.a.removeCallbacksAndMessages(null);
                this.f2906e.a.post(new c(this.f2906e, this.a));
            }
        }

        @Override // c.a.a0.u.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i) throws Exception {
            f(headers, str, i);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.a0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i) == null) {
                BaseVM.m(this.a, this.f2903b, this.f2904c, BasicPushStatus.SUCCESS_CODE, "query");
                if (this.f2906e.f2900d) {
                    return;
                }
                this.f2906e.a.removeCallbacksAndMessages(null);
                try {
                    List<g> b2 = c.a.f0.b.f.a.b(str, this.a);
                    if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                        this.f2905d.b(b2.get(0));
                    } else {
                        this.f2905d.a(new Throwable("no ad"));
                    }
                } catch (ParseError e2) {
                    e2.printStackTrace();
                    this.f2905d.a(e2);
                }
            }
        }

        public String f(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f2900d = true;
                g m = c.a.f0.b.f.e.m();
                if (this.a.f2898b == null) {
                    return;
                }
                if (m == null) {
                    this.a.f2898b.a(new Throwable("no ad"));
                    return;
                }
                m.C = 2;
                this.a.f2898b.b(m);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(Looper.getMainLooper());
        this.f2899c = 5000;
        this.f2900d = false;
    }

    public final void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || c.a.f0.a.b.d.a().d() == null || !c.a.f0.a.b.d.a().d().has("client_ext") || (optJSONObject = c.a.f0.a.b.d.a().d().optJSONObject("client_ext")) == null) {
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
            h a = c.a.a0.h.a.a();
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
            hashMap.put(Config.EXCEPTION_CRASH_TYPE, "2");
            hashMap.put("is_https", "1");
            hashMap.put(HttpRequest.ANDROID_ID, a.a());
            hashMap.put("from", c.a.f0.a.b.d.a().from());
            hashMap.put("cfrom", c.a.f0.a.b.d.a().a());
            hashMap.put("User-Agent", c.a.a0.h.a.e());
            if (TextUtils.isEmpty(a.h())) {
                return;
            }
            hashMap.put("oaid", a.h());
        }
    }

    public final void g(@NonNull HashMap<String, String> hashMap, String str, String str2, long j) {
        Iterator<g> it;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{hashMap, str, str2, Long.valueOf(j)}) != null) {
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
            jSONObject2.put("v", "5.1.0.0");
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            List<g> r = c.a.f0.b.f.e.r();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            TextUtils.equals(str, c.a.f0.a.b.d.a().e());
            int i = 0;
            if (r != null && r.size() > 0) {
                Iterator<g> it2 = r.iterator();
                while (it2.hasNext()) {
                    g next = it2.next();
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("k", next.f2931c);
                    if (TextUtils.isEmpty(next.f2931c)) {
                        it = it2;
                    } else {
                        int e2 = c.a.f0.b.f.e.e(next);
                        StringBuilder sb = new StringBuilder();
                        it = it2;
                        sb.append("onAdSuccess: ");
                        sb.append(e2);
                        Log.e("Afd", sb.toString());
                        if (e2 == 0) {
                            if (next.h()) {
                                c.a.a0.x.a.b(arrayList2, next.f2931c);
                            }
                            if (next.f()) {
                                c.a.a0.x.a.b(arrayList, next.f2931c);
                            }
                        } else if (next.h()) {
                            i |= e2;
                        }
                    }
                    jSONObject4.put("r", String.valueOf(next.w));
                    if (next.h()) {
                        jSONArray2.put(jSONObject4);
                    }
                    it2 = it;
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
                    if (i == 0) {
                        i = 1;
                    }
                    BaseVM.f28308c = String.valueOf(i);
                } else {
                    BaseVM.f28308c = "";
                }
            }
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("k", "logid");
            jSONObject7.put("v", String.valueOf(j));
            jSONArray.put(jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("k", "uid");
            jSONObject8.put("v", c.a.a0.h.a.a().m());
            jSONArray.put(jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("k", "ext_info");
            JSONObject jSONObject10 = new JSONObject();
            jSONObject10.put("ipdx", c.a.a0.p.a.a().a());
            jSONObject10.put("update_mark", NADNativeHelper.b());
            jSONObject10.put("boot_mark", NADNativeHelper.a());
            try {
                e(jSONObject10);
                jSONObject10.put(Constants.KEYS.AD_INFO, jSONObject3);
                jSONObject9.put("v", jSONObject10.toString());
                jSONObject9.put(AdExtParam.KEY_IADEX, c.a.a0.h.a.d().f());
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
                    sb.append('&');
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append('&');
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

    public final c.a.a0.u.s.d i(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            String a = c.a.f0.a.a.a.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            String sb2 = sb.toString();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, TextUtils.equals(str, "update") ? String.valueOf(f.p()) : "1");
            hashMap.put("pid", str2);
            hashMap.put("product_id ", c.a.a0.h.a.a().l());
            f(hashMap);
            g(hashMap, str2, str, j);
            c.a.a0.u.s.d dVar = new c.a.a0.u.s.d();
            dVar.k(h(sb2, hashMap));
            dVar.c();
            return dVar;
        }
        return (c.a.a0.u.s.d) invokeCommon.objValue;
    }

    public void j(String str, c.a.f0.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.f0.b.f.b.a(String.valueOf(currentTimeMillis));
            c.a.a0.u.s.d i = i("query", str, currentTimeMillis);
            i.f1647f = this.f2899c;
            JSONObject d2 = c.a.f0.a.b.d.a().d();
            if (d2 != null && d2.has("query_response_thread")) {
                i.h(d2.optInt("query_response_thread", 0) == 0);
            }
            c.a.a0.u.g.b().a().a(i, new b(this, str, currentTimeMillis, System.currentTimeMillis(), bVar));
            this.f2898b = bVar;
            this.f2900d = false;
            this.f2899c = c.a.f0.a.b.d.a().f() - f.n();
            Handler handler = this.a;
            if (handler != null) {
                handler.postDelayed(new c(this, str), this.f2899c);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String optString = c.a.f0.a.b.d.a().d().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = c.a.f0.a.b.d.a().e();
            }
            String str = optString;
            c.a.a0.u.g.b().a().a(i("update", str, currentTimeMillis), new C0139a(this, str, currentTimeMillis, System.currentTimeMillis()));
        }
    }
}
