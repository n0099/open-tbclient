package c.a.n0.h.a.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static String k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "sid_eid";
    public static String p = "exps";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public Context f8380b;

    /* renamed from: c  reason: collision with root package name */
    public String f8381c;

    /* renamed from: d  reason: collision with root package name */
    public String f8382d;

    /* renamed from: e  reason: collision with root package name */
    public String f8383e;

    /* renamed from: f  reason: collision with root package name */
    public String f8384f;

    /* renamed from: g  reason: collision with root package name */
    public String f8385g;

    /* renamed from: h  reason: collision with root package name */
    public String f8386h;
    public d i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1966557480, "Lc/a/n0/h/a/h/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1966557480, "Lc/a/n0/h/a/h/f;");
        }
    }

    public f(Context context, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "https://mobads.baidu.com/cpro/ui/mads.php";
        this.f8384f = "1";
        this.f8385g = "2";
        this.f8386h = "8.800201";
        this.f8380b = context;
        this.i = dVar;
        if (dVar != null) {
            this.f8381c = dVar.b();
            this.f8382d = this.i.e();
            this.f8383e = this.i.g();
        }
        if (c.a.n0.h.a.k.h.o()) {
            return;
        }
        this.j = c.a.n0.h.a.k.h.b();
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
                hashMap.put("lw", String.valueOf(Math.round(c.a.n0.h.a.k.h.i(this.f8380b) / c.a.n0.h.a.k.h.d(this.f8380b))));
                hashMap.put("lh", String.valueOf(Math.round(c.a.n0.h.a.k.h.h(this.f8380b) / c.a.n0.h.a.k.h.d(this.f8380b))));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(NetworkUtils.c(false));
                hashMap.put("net", sb.toString());
                hashMap.put("n", this.f8384f);
                hashMap.put(PushConstants.URI_PACKAGE_NAME, this.f8383e);
                hashMap.put("appid", this.f8382d);
                hashMap.put(TbConfig.SW_APID, "" + c.a.n0.h.a.k.h.i(this.f8380b));
                hashMap.put("sh", "" + c.a.n0.h.a.k.h.h(this.f8380b));
                hashMap.put("sn", "" + f());
                hashMap.put("os", "android");
                hashMap.put("pa", c.a.n0.h.a.f.a.b().c());
                hashMap.put("apid", "" + this.f8381c);
                hashMap.put("chid", "0");
                String s = c.a.n0.h.a.f.a.b().s();
                if (s.equals("0")) {
                    s = "";
                }
                hashMap.put("imei", s);
                hashMap.put("cuid", c.a.n0.h.a.f.a.b().e());
                hashMap.put("osv", c.a.n0.h.a.k.h.f());
                hashMap.put("tp", c.a.n0.h.a.k.h.e());
                hashMap.put("app_ver", c.a.n0.h.a.k.h.l());
                String c2 = c.a.n0.h.a.k.h.c(d(), "BAIDUID");
                hashMap.put("baiduid", (TextUtils.isEmpty(c2) || c2.split(":").length <= 0) ? "" : c2.split(":")[0]);
                hashMap.put("p_ver", this.f8386h);
                hashMap.put("rpt", this.f8385g);
                hashMap.put("tab", "2");
                hashMap.put("req_id", "");
                hashMap.put("scene", c.a.n0.h.a.f.a.b().k());
                String e2 = e();
                hashMap.put(p, e2);
                hashMap.put(TiebaStatic.Params.EQID, c.a.n0.h.a.f.a.b().m());
                JSONObject t = c.a.n0.h.a.f.a.b().t();
                if (t != null) {
                    if (t.has(l) && (jSONObject = t.getJSONObject(l)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (n.equals(next)) {
                                    hashMap.put(m, optString);
                                    this.j = optString;
                                } else {
                                    hashMap.put(k + next, optString);
                                }
                            }
                        }
                    }
                    if (t.has(o) && (optJSONArray = t.optJSONArray(o)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (!TextUtils.isEmpty(e2)) {
                            sb2.append(e2 + ",");
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString2 = optJSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb2.append(optString2);
                                if (i >= 0 && i < optJSONArray.length() - 1) {
                                    sb2.append(",");
                                }
                            }
                        }
                        if (sb2.length() > 0) {
                            hashMap.put(p, sb2.toString());
                        }
                    }
                }
                if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.j)) {
                    hashMap.put(n, this.j);
                }
                hashMap.put("con_name", c.a.n0.h.a.f.a.b().a());
            } catch (Exception unused) {
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.n0.h.a.f.a.b().l(".baidu.com") : (String) invokeV.objValue;
    }

    public abstract String e();

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                String s = c.a.n0.h.a.f.a.b().s();
                return TextUtils.isEmpty(s) ? NetworkUtils.e(this.f8380b) : s;
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
            return c.a.n0.h.a.k.e.a(this.a, b2);
        }
        return (String) invokeV.objValue;
    }
}
