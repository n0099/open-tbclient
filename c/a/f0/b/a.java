package c.a.f0.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import c.a.f0.a.c.g;
import c.a.f0.b.g.h;
import c.a.f0.b.g.j;
import c.a.f0.d.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.Request;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f3354a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.f0.b.c f3355b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f3356c;

    /* renamed from: d  reason: collision with root package name */
    public int f3357d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3358e;

    /* renamed from: c.a.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0071a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f3359e;

        public RunnableC0071a(a aVar) {
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
            this.f3359e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3359e.f3358e = true;
                g.f3351a.e("Afd", "执行超时回调");
                h l = c.a.f0.b.g.f.l();
                if (this.f3359e.f3355b == null) {
                    return;
                }
                if (l == null) {
                    this.f3359e.f3355b.a(new Throwable("no ad"));
                    return;
                }
                l.C = 2;
                this.f3359e.f3355b.b(l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.a.b.a f3360a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f3361b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f3362c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f3363d;

        public b(a aVar, c.a.f0.a.b.a aVar2, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3363d = aVar;
            this.f3360a = aVar2;
            this.f3361b = j2;
            this.f3362c = j3;
        }

        @Override // c.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f3351a;
                gVar.e("Afd", "update接口 " + th.getMessage());
                this.f3363d.k(this.f3360a, this.f3361b, this.f3362c, th.getMessage(), "update");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f3363d.k(this.f3360a, this.f3361b, this.f3362c, "200", "update");
                try {
                    c.a.f0.b.g.a.b(str, this.f3360a.m());
                } catch (ParseError e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.a.b.a f3364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f3365b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f3366c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3367d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.f0.b.c f3368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3369f;

        public c(a aVar, c.a.f0.a.b.a aVar2, long j2, long j3, String str, c.a.f0.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Long.valueOf(j2), Long.valueOf(j3), str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3369f = aVar;
            this.f3364a = aVar2;
            this.f3365b = j2;
            this.f3366c = j3;
            this.f3367d = str;
            this.f3368e = cVar;
        }

        @Override // c.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f3351a;
                gVar.e("Afd", "query接口 " + th.getMessage());
                this.f3369f.k(this.f3364a, this.f3365b, this.f3366c, th.getMessage(), "query");
                if (!this.f3369f.f3358e) {
                    if (this.f3369f.f3354a != null) {
                        this.f3369f.f3354a.removeCallbacksAndMessages(null);
                        this.f3369f.f3354a.post(this.f3369f.f3356c);
                        return;
                    }
                    return;
                }
                g gVar2 = g.f3351a;
                StringBuilder sb = new StringBuilder();
                sb.append("query接口 error 超时：");
                sb.append(System.currentTimeMillis() - this.f3365b);
                sb.append(" cause : ");
                sb.append(th);
                gVar2.e("Afd", sb.toString() == null ? "unknow" : th.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f3369f.k(this.f3364a, this.f3365b, this.f3366c, "200", "query");
                if (!this.f3369f.f3358e) {
                    this.f3369f.f3354a.removeCallbacksAndMessages(null);
                    try {
                        List<h> b2 = c.a.f0.b.g.a.b(str, this.f3367d);
                        if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                            this.f3368e.b(b2.get(0));
                        } else {
                            this.f3368e.a(new Throwable("no ad"));
                        }
                        return;
                    } catch (ParseError e2) {
                        e2.printStackTrace();
                        this.f3368e.a(e2);
                        return;
                    }
                }
                g gVar = g.f3351a;
                gVar.e("Afd", "query接口 response 超时：" + (System.currentTimeMillis() - this.f3365b));
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
        this.f3354a = new Handler(Looper.getMainLooper());
        this.f3356c = new RunnableC0071a(this);
        this.f3357d = 5000;
        this.f3358e = false;
    }

    public final void g(Request.c cVar, c.a.f0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, aVar) == null) {
            cVar.j("ver", aVar.D());
            cVar.j("sv", "1.0");
            cVar.j("uid", aVar.x());
            cVar.j(TiebaStatic.Params.BDID, aVar.l());
            cVar.j("cuid", aVar.f());
            cVar.j(SearchJsBridge.COOKIE_MOD, aVar.r());
            cVar.j(SearchJsBridge.COOKIE_OV, aVar.g());
            cVar.j("imei", aVar.C());
            cVar.j("ua", aVar.o());
            cVar.j("fmt", "json");
            cVar.j("coot", aVar.j());
            if (aVar.y() != null && aVar.y().length > 1) {
                cVar.j("lgt", aVar.y()[0]);
                cVar.j(SuggestAddrField.KEY_LAT, aVar.y()[1]);
            }
            cVar.j("apna", aVar.i());
            cVar.j("eid", aVar.z());
            cVar.j("st", "1");
            cVar.j("ot", "2");
            cVar.j("nt", String.valueOf(new c.a.f0.d.a.f(aVar.p()).d()));
            cVar.j("ct", "2");
            cVar.j("is_https", "1");
            cVar.j(IAdRequestParam.ANDROID_ID, aVar.a());
            cVar.j("from", aVar.from());
            cVar.j("cfrom", aVar.b());
            cVar.k("User-Agent", aVar.h());
            if (TextUtils.isEmpty(aVar.n())) {
                return;
            }
            cVar.j("oaid", aVar.n());
        }
    }

    public final void h(Request.c cVar, String str, String str2, c.a.f0.a.b.a aVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{cVar, str, str2, aVar, Long.valueOf(j2)}) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", "cmd");
                jSONObject.put("v", str2);
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                List<h> p = c.a.f0.b.g.f.p();
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                boolean equals = TextUtils.equals(str, aVar.m());
                if (p != null && p.size() > 0) {
                    for (h hVar : p) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("k", hVar.f3415c);
                        if (!TextUtils.isEmpty(hVar.f3415c)) {
                            int e2 = c.a.f0.b.g.f.e(hVar);
                            String str3 = "onAdSuccess: " + e2;
                            if (e2 == 0) {
                                if (equals && hVar.h()) {
                                    arrayList.add(hVar.f3415c);
                                }
                                if (!equals && hVar.f()) {
                                    arrayList.add(hVar.f3415c);
                                }
                            }
                        }
                        jSONObject3.put(r.f42280a, String.valueOf(hVar.w));
                        jSONArray2.put(jSONObject3);
                    }
                }
                jSONObject2.put("d", jSONArray2);
                jSONObject2.put("s", j.b());
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
                jSONObject7.put("v", aVar.x());
                jSONArray.put(jSONObject7);
                cVar.j("ext", jSONArray.toString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final Request.c i(c.a.f0.a.b.a aVar, String str, String str2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, str2, Long.valueOf(j2)})) == null) {
            String a2 = c.a.f0.a.a.a.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            Request.c cVar = new Request.c(aVar.p(), sb.toString());
            cVar.j("ac", TextUtils.equals(str, "update") ? "10" : "1");
            cVar.j("pid", str2);
            cVar.j("product_id ", aVar.q());
            g(cVar, aVar);
            h(cVar, str2, str, aVar, j2);
            return cVar;
        }
        return (Request.c) invokeCommon.objValue;
    }

    public void j(c.a.f0.a.b.a aVar, String str, c.a.f0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, aVar, str, cVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.f0.b.g.c.a(String.valueOf(currentTimeMillis));
            Request.c i2 = i(aVar, "query", str, currentTimeMillis);
            i2.o(true);
            long currentTimeMillis2 = System.currentTimeMillis();
            i2.m();
            i2.l().e(new c(this, aVar, currentTimeMillis, currentTimeMillis2, str, cVar));
            this.f3355b = cVar;
            this.f3358e = false;
            int u = aVar.u() - c.a.f0.b.g.g.f();
            this.f3357d = u;
            Handler handler = this.f3354a;
            if (handler != null) {
                handler.postDelayed(this.f3356c, u);
            }
        }
    }

    public final void k(c.a.f0.a.b.a aVar, long j2, long j3, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{aVar, Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
            Als.f(String.valueOf(j2), aVar.m(), str, j3 - j2, System.currentTimeMillis() - j3, str2);
        }
    }

    public void l(c.a.f0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String optString = aVar.k().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = aVar.m();
            }
            Request.c i2 = i(aVar, "update", optString, currentTimeMillis);
            long currentTimeMillis2 = System.currentTimeMillis();
            i2.m();
            i2.l().e(new b(this, aVar, currentTimeMillis, currentTimeMillis2));
        }
    }
}
