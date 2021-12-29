package c.a.r0.h.i.p;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.dxmpay.wallet.core.Domains;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class f {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: k  reason: collision with root package name */
    public static String f10772k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "sid_eid";
    public static String p = "exps";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10773b;

    /* renamed from: c  reason: collision with root package name */
    public String f10774c;

    /* renamed from: d  reason: collision with root package name */
    public String f10775d;

    /* renamed from: e  reason: collision with root package name */
    public String f10776e;

    /* renamed from: f  reason: collision with root package name */
    public String f10777f;

    /* renamed from: g  reason: collision with root package name */
    public String f10778g;

    /* renamed from: h  reason: collision with root package name */
    public String f10779h;

    /* renamed from: i  reason: collision with root package name */
    public d f10780i;

    /* renamed from: j  reason: collision with root package name */
    public String f10781j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-335156788, "Lc/a/r0/h/i/p/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-335156788, "Lc/a/r0/h/i/p/f;");
        }
    }

    public f(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "https://mobads.baidu.com/cpro/ui/mads.php";
        this.f10777f = "1";
        this.f10778g = "2";
        this.f10779h = "8.800201";
        this.f10773b = context;
        this.f10780i = dVar;
        if (dVar != null) {
            this.f10774c = dVar.b();
            this.f10775d = this.f10780i.e();
            this.f10776e = this.f10780i.g();
        }
        if (c.a.r0.h.i.s.h.o()) {
            return;
        }
        this.f10781j = c.a.r0.h.i.s.h.b();
    }

    public abstract HashMap<String, String> a();

    public final HashMap<String, String> b() {
        InterceptResult invokeV;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                hashMap.put("lw", String.valueOf(Math.round(c.a.r0.h.i.s.h.i(this.f10773b) / c.a.r0.h.i.s.h.d(this.f10773b))));
                hashMap.put("lh", String.valueOf(Math.round(c.a.r0.h.i.s.h.h(this.f10773b) / c.a.r0.h.i.s.h.d(this.f10773b))));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(NetworkUtils.c(false));
                hashMap.put("net", sb.toString());
                hashMap.put("n", this.f10777f);
                hashMap.put(PushConstants.URI_PACKAGE_NAME, this.f10776e);
                hashMap.put("appid", this.f10775d);
                hashMap.put(TbConfig.SW_APID, "" + c.a.r0.h.i.s.h.i(this.f10773b));
                hashMap.put("sh", "" + c.a.r0.h.i.s.h.h(this.f10773b));
                hashMap.put("sn", "" + f());
                hashMap.put(UrlOcrConfig.IdCardKey.OS, "android");
                hashMap.put(com.alipay.sdk.cons.b.f31824k, c.a.r0.h.i.n.a.b().c());
                hashMap.put("apid", "" + this.f10774c);
                hashMap.put("chid", "0");
                String s = c.a.r0.h.i.n.a.b().s();
                if (s.equals("0")) {
                    s = "";
                }
                hashMap.put("imei", s);
                hashMap.put("cuid", c.a.r0.h.i.n.a.b().e());
                hashMap.put("osv", c.a.r0.h.i.s.h.f());
                hashMap.put("tp", c.a.r0.h.i.s.h.e());
                hashMap.put("app_ver", c.a.r0.h.i.s.h.l());
                String c2 = c.a.r0.h.i.s.h.c(d(), "BAIDUID");
                hashMap.put("baiduid", (TextUtils.isEmpty(c2) || c2.split(":").length <= 0) ? "" : c2.split(":")[0]);
                hashMap.put("p_ver", this.f10779h);
                hashMap.put("rpt", this.f10778g);
                hashMap.put("tab", "2");
                hashMap.put("req_id", "");
                hashMap.put("scene", c.a.r0.h.i.n.a.b().k());
                String e2 = e();
                hashMap.put(p, e2);
                hashMap.put("eqid", c.a.r0.h.i.n.a.b().m());
                JSONObject t = c.a.r0.h.i.n.a.b().t();
                if (t != null) {
                    if (t.has(l) && (jSONObject = t.getJSONObject(l)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (n.equals(next)) {
                                    hashMap.put(m, optString);
                                    this.f10781j = optString;
                                } else {
                                    hashMap.put(f10772k + next, optString);
                                }
                            }
                        }
                    }
                    if (t.has(o) && (optJSONArray = t.optJSONArray(o)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (!TextUtils.isEmpty(e2)) {
                            sb2.append(e2 + ",");
                        }
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString2 = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb2.append(optString2);
                                if (i2 >= 0 && i2 < optJSONArray.length() - 1) {
                                    sb2.append(",");
                                }
                            }
                        }
                        if (sb2.length() > 0) {
                            hashMap.put(p, sb2.toString());
                        }
                    }
                }
                if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.f10781j)) {
                    hashMap.put(n, this.f10781j);
                }
                hashMap.put("con_name", c.a.r0.h.i.n.a.b().a());
            } catch (Exception unused) {
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10781j : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.r0.h.i.n.a.b().l(Domains.BAIDU) : (String) invokeV.objValue;
    }

    public abstract String e();

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                String s = c.a.r0.h.i.n.a.b().s();
                return TextUtils.isEmpty(s) ? NetworkUtils.e(this.f10773b) : s;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HashMap<String, String> b2 = b();
            b2.putAll(a());
            return c.a.r0.h.i.s.e.a(this.a, b2);
        }
        return (String) invokeV.objValue;
    }
}
