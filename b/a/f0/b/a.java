package b.a.f0.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b.a.f0.a.c.g;
import b.a.f0.b.g.h;
import b.a.f0.b.g.j;
import b.a.f0.d.a.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.nad.jni.NADNativeHelper;
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
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
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
    public final Handler f2891a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.f0.b.c f2892b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f2893c;

    /* renamed from: d  reason: collision with root package name */
    public int f2894d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f2895e;

    /* renamed from: b.a.f0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0068a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2896e;

        public RunnableC0068a(a aVar) {
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
            this.f2896e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2896e.f2895e = true;
                g.f2888a.e("Afd", "执行超时回调");
                h l = b.a.f0.b.g.f.l();
                if (this.f2896e.f2892b == null) {
                    return;
                }
                if (l == null) {
                    this.f2896e.f2892b.a(new Throwable("no ad"));
                    return;
                }
                l.C = 2;
                this.f2896e.f2892b.b(l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.f0.a.b.a f2897a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f2898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f2899c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f2900d;

        public b(a aVar, b.a.f0.a.b.a aVar2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2900d = aVar;
            this.f2897a = aVar2;
            this.f2898b = j;
            this.f2899c = j2;
        }

        @Override // b.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f2888a;
                gVar.e("Afd", "update接口 " + th.getMessage());
                this.f2900d.k(this.f2897a, this.f2898b, this.f2899c, th.getMessage(), "update");
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f2900d.k(this.f2897a, this.f2898b, this.f2899c, BasicPushStatus.SUCCESS_CODE, "update");
                try {
                    b.a.f0.b.g.a.b(str, this.f2897a.l());
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
        public final /* synthetic */ b.a.f0.a.b.a f2901a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f2902b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f2903c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f2904d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.f0.b.c f2905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f2906f;

        public c(a aVar, b.a.f0.a.b.a aVar2, long j, long j2, String str, b.a.f0.b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, Long.valueOf(j), Long.valueOf(j2), str, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2906f = aVar;
            this.f2901a = aVar2;
            this.f2902b = j;
            this.f2903c = j2;
            this.f2904d = str;
            this.f2905e = cVar;
        }

        @Override // b.a.f0.d.a.i
        public void a(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                g gVar = g.f2888a;
                gVar.e("Afd", "query接口 " + th.getMessage());
                this.f2906f.k(this.f2901a, this.f2902b, this.f2903c, th.getMessage(), "query");
                if (!this.f2906f.f2895e) {
                    if (this.f2906f.f2891a != null) {
                        this.f2906f.f2891a.removeCallbacksAndMessages(null);
                        this.f2906f.f2891a.post(this.f2906f.f2893c);
                        return;
                    }
                    return;
                }
                g gVar2 = g.f2888a;
                StringBuilder sb = new StringBuilder();
                sb.append("query接口 error 超时：");
                sb.append(System.currentTimeMillis() - this.f2902b);
                sb.append(" cause : ");
                sb.append(th);
                gVar2.e("Afd", sb.toString() == null ? "unknow" : th.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.f0.d.a.i
        /* renamed from: b */
        public void onResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f2906f.k(this.f2901a, this.f2902b, this.f2903c, BasicPushStatus.SUCCESS_CODE, "query");
                if (!this.f2906f.f2895e) {
                    this.f2906f.f2891a.removeCallbacksAndMessages(null);
                    try {
                        List<h> b2 = b.a.f0.b.g.a.b(str, this.f2904d);
                        if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                            this.f2905e.b(b2.get(0));
                        } else {
                            this.f2905e.a(new Throwable("no ad"));
                        }
                        return;
                    } catch (ParseError e2) {
                        e2.printStackTrace();
                        this.f2905e.a(e2);
                        return;
                    }
                }
                g gVar = g.f2888a;
                gVar.e("Afd", "query接口 response 超时：" + (System.currentTimeMillis() - this.f2902b));
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
        this.f2891a = new Handler(Looper.getMainLooper());
        this.f2893c = new RunnableC0068a(this);
        this.f2894d = 5000;
        this.f2895e = false;
    }

    public final void g(Request.c cVar, b.a.f0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, aVar) == null) {
            cVar.j("ver", aVar.C());
            cVar.j("sv", "2.2.1");
            cVar.j("uid", aVar.w());
            cVar.j(TiebaStatic.Params.BDID, aVar.k());
            cVar.j("cuid", aVar.f());
            cVar.j(SearchJsBridge.COOKIE_MOD, aVar.q());
            cVar.j(SearchJsBridge.COOKIE_OV, aVar.g());
            cVar.j("imei", aVar.B());
            cVar.j("ua", aVar.n());
            cVar.j("fmt", "json");
            cVar.j("coot", aVar.i());
            if (aVar.x() != null && aVar.x().length > 1) {
                cVar.j("lgt", aVar.x()[0]);
                cVar.j(SuggestAddrField.KEY_LAT, aVar.x()[1]);
            }
            cVar.j("apna", aVar.packageName());
            cVar.j("eid", aVar.y());
            cVar.j("st", "1");
            cVar.j("ot", "2");
            cVar.j("nt", String.valueOf(new b.a.f0.d.a.f(aVar.o()).d()));
            cVar.j("ct", "2");
            cVar.j("is_https", "1");
            cVar.j(IAdRequestParam.ANDROID_ID, aVar.a());
            cVar.j("from", aVar.from());
            cVar.j("cfrom", aVar.b());
            cVar.k("User-Agent", aVar.h());
            if (TextUtils.isEmpty(aVar.m())) {
                return;
            }
            cVar.j("oaid", aVar.m());
        }
    }

    public final void h(Request.c cVar, String str, String str2, b.a.f0.a.b.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{cVar, str, str2, aVar, Long.valueOf(j)}) == null) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("k", "cmd");
                jSONObject.put("v", str2);
                jSONArray.put(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                List<h> p = b.a.f0.b.g.f.p();
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                boolean equals = TextUtils.equals(str, aVar.l());
                if (p != null && p.size() > 0) {
                    for (h hVar : p) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("k", hVar.f2951c);
                        if (!TextUtils.isEmpty(hVar.f2951c)) {
                            int e2 = b.a.f0.b.g.f.e(hVar);
                            String str3 = "onAdSuccess: " + e2;
                            if (e2 == 0) {
                                if (equals && hVar.h()) {
                                    arrayList.add(hVar.f2951c);
                                }
                                if (!equals && hVar.f()) {
                                    arrayList.add(hVar.f2951c);
                                }
                            }
                        }
                        jSONObject3.put(r.f41000a, String.valueOf(hVar.w));
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
                jSONObject6.put("v", String.valueOf(j));
                jSONArray.put(jSONObject6);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("k", "uid");
                jSONObject7.put("v", aVar.w());
                jSONArray.put(jSONObject7);
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("k", "ext_info");
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("update_mark", NADNativeHelper.b());
                jSONObject9.put("boot_mark", NADNativeHelper.a());
                jSONObject8.put("v", jSONObject9);
                jSONArray.put(jSONObject8);
                cVar.j("ext", jSONArray.toString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final Request.c i(b.a.f0.a.b.a aVar, String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, str, str2, Long.valueOf(j)})) == null) {
            String a2 = b.a.f0.a.a.a.a();
            StringBuilder sb = new StringBuilder();
            sb.append(a2);
            sb.append(TextUtils.equals(str, "update") ? "?action=update" : "?action=query");
            Request.c cVar = new Request.c(aVar.o(), sb.toString());
            cVar.j("ac", TextUtils.equals(str, "update") ? "10" : "1");
            cVar.j("pid", str2);
            cVar.j("product_id ", aVar.p());
            g(cVar, aVar);
            h(cVar, str2, str, aVar, j);
            return cVar;
        }
        return (Request.c) invokeCommon.objValue;
    }

    public void j(b.a.f0.a.b.a aVar, String str, b.a.f0.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, aVar, str, cVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            b.a.f0.b.g.c.a(String.valueOf(currentTimeMillis));
            Request.c i2 = i(aVar, "query", str, currentTimeMillis);
            i2.o(true);
            long currentTimeMillis2 = System.currentTimeMillis();
            i2.m();
            i2.l().e(new c(this, aVar, currentTimeMillis, currentTimeMillis2, str, cVar));
            this.f2892b = cVar;
            this.f2895e = false;
            int t = aVar.t() - b.a.f0.b.g.g.f();
            this.f2894d = t;
            Handler handler = this.f2891a;
            if (handler != null) {
                handler.postDelayed(this.f2893c, t);
            }
        }
    }

    public final void k(b.a.f0.a.b.a aVar, long j, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{aVar, Long.valueOf(j), Long.valueOf(j2), str, str2}) == null) {
            Als.f(String.valueOf(j), aVar.l(), str, j2 - j, System.currentTimeMillis() - j2, str2);
        }
    }

    public void l(b.a.f0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String optString = aVar.j().optString("na_cpc_update_pid");
            if (TextUtils.isEmpty(optString)) {
                optString = aVar.l();
            }
            Request.c i2 = i(aVar, "update", optString, currentTimeMillis);
            long currentTimeMillis2 = System.currentTimeMillis();
            i2.m();
            i2.l().e(new b(this, aVar, currentTimeMillis, currentTimeMillis2));
        }
    }
}
