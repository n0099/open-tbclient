package c.a.p0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.f.i.r.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.Domains;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static String k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "sid_eid";
    public static String p = "exps";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10651a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10652b;

    /* renamed from: c  reason: collision with root package name */
    public String f10653c;

    /* renamed from: d  reason: collision with root package name */
    public String f10654d;

    /* renamed from: e  reason: collision with root package name */
    public String f10655e;

    /* renamed from: f  reason: collision with root package name */
    public String f10656f;

    /* renamed from: g  reason: collision with root package name */
    public String f10657g;

    /* renamed from: h  reason: collision with root package name */
    public String f10658h;

    /* renamed from: i  reason: collision with root package name */
    public c f10659i;

    /* renamed from: j  reason: collision with root package name */
    public String f10660j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-226904562, "Lc/a/p0/f/i/o/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-226904562, "Lc/a/p0/f/i/o/e;");
        }
    }

    public e(Context context, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10651a = "https://mobads.baidu.com/cpro/ui/mads.php";
        this.f10656f = "1";
        this.f10657g = "2";
        this.f10658h = "8.800201";
        this.f10652b = context;
        this.f10659i = cVar;
        if (cVar != null) {
            this.f10653c = cVar.b();
            this.f10654d = this.f10659i.e();
            this.f10655e = this.f10659i.g();
        }
        if (h.o()) {
            return;
        }
        this.f10660j = h.b();
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
                hashMap.put(IAdRequestParam.QUERY_WIDTH, String.valueOf(Math.round(h.i(this.f10652b) / h.d(this.f10652b))));
                hashMap.put(IAdRequestParam.QUERY_HEIGHT, String.valueOf(Math.round(h.h(this.f10652b) / h.d(this.f10652b))));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(NetworkUtils.c(false));
                hashMap.put("net", sb.toString());
                hashMap.put("n", this.f10656f);
                hashMap.put("pk", this.f10655e);
                hashMap.put("appid", this.f10654d);
                hashMap.put("sw", "" + h.i(this.f10652b));
                hashMap.put(IAdRequestParam.SCREEN_HEIGHT, "" + h.h(this.f10652b));
                hashMap.put(IAdRequestParam.SN, "" + f());
                hashMap.put("os", "android");
                hashMap.put("apid", "" + this.f10653c);
                hashMap.put(IAdRequestParam.CHID, "0");
                String s = c.a.p0.f.i.m.a.b().s();
                if (s.equals("0")) {
                    s = "";
                }
                hashMap.put("imei", s);
                hashMap.put("cuid", c.a.p0.f.i.m.a.b().c());
                hashMap.put(IAdRequestParam.OSV, h.f());
                hashMap.put(IAdRequestParam.PHONE_TYPE, h.e());
                hashMap.put(IAdRequestParam.APV, h.l());
                String c2 = h.c(d(), "BAIDUID");
                hashMap.put("baiduid", (TextUtils.isEmpty(c2) || c2.split(":").length <= 0) ? "" : c2.split(":")[0]);
                hashMap.put("p_ver", this.f10658h);
                hashMap.put(IAdRequestParam.RPT, this.f10657g);
                hashMap.put("tab", "2");
                hashMap.put(IAdRequestParam.REQ_ID, "");
                hashMap.put("scene", c.a.p0.f.i.m.a.b().k());
                String e2 = e();
                hashMap.put(p, e2);
                hashMap.put("eqid", c.a.p0.f.i.m.a.b().m());
                JSONObject t = c.a.p0.f.i.m.a.b().t();
                if (t != null) {
                    if (t.has(l) && (jSONObject = t.getJSONObject(l)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (n.equals(next)) {
                                    hashMap.put(m, optString);
                                    this.f10660j = optString;
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
                if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.f10660j)) {
                    hashMap.put(n, this.f10660j);
                }
                hashMap.put("con_name", c.a.p0.f.i.m.a.b().a());
            } catch (Exception unused) {
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f10660j : (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? c.a.p0.f.i.m.a.b().l(Domains.BAIDU) : (String) invokeV.objValue;
    }

    public abstract String e();

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                String s = c.a.p0.f.i.m.a.b().s();
                return TextUtils.isEmpty(s) ? NetworkUtils.e(this.f10652b) : s;
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
            return c.a.p0.f.i.r.e.a(this.f10651a, b2);
        }
        return (String) invokeV.objValue;
    }
}
