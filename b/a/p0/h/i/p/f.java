package b.a.p0.h.i.p;

import android.content.Context;
import android.text.TextUtils;
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
public abstract class f {
    public static /* synthetic */ Interceptable $ic = null;
    public static String k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "sid_eid";
    public static String p = "exps";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10530a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10531b;

    /* renamed from: c  reason: collision with root package name */
    public String f10532c;

    /* renamed from: d  reason: collision with root package name */
    public String f10533d;

    /* renamed from: e  reason: collision with root package name */
    public String f10534e;

    /* renamed from: f  reason: collision with root package name */
    public String f10535f;

    /* renamed from: g  reason: collision with root package name */
    public String f10536g;

    /* renamed from: h  reason: collision with root package name */
    public String f10537h;

    /* renamed from: i  reason: collision with root package name */
    public d f10538i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1751194121, "Lb/a/p0/h/i/p/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1751194121, "Lb/a/p0/h/i/p/f;");
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
        this.f10530a = "https://mobads.baidu.com/cpro/ui/mads.php";
        this.f10535f = "1";
        this.f10536g = "2";
        this.f10537h = "8.800201";
        this.f10531b = context;
        this.f10538i = dVar;
        if (dVar != null) {
            this.f10532c = dVar.b();
            this.f10533d = this.f10538i.e();
            this.f10534e = this.f10538i.g();
        }
        if (b.a.p0.h.i.s.h.o()) {
            return;
        }
        this.j = b.a.p0.h.i.s.h.b();
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
                hashMap.put(IAdRequestParam.QUERY_WIDTH, String.valueOf(Math.round(b.a.p0.h.i.s.h.i(this.f10531b) / b.a.p0.h.i.s.h.d(this.f10531b))));
                hashMap.put(IAdRequestParam.QUERY_HEIGHT, String.valueOf(Math.round(b.a.p0.h.i.s.h.h(this.f10531b) / b.a.p0.h.i.s.h.d(this.f10531b))));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(NetworkUtils.c(false));
                hashMap.put("net", sb.toString());
                hashMap.put("n", this.f10535f);
                hashMap.put("pk", this.f10534e);
                hashMap.put("appid", this.f10533d);
                hashMap.put("sw", "" + b.a.p0.h.i.s.h.i(this.f10531b));
                hashMap.put(IAdRequestParam.SCREEN_HEIGHT, "" + b.a.p0.h.i.s.h.h(this.f10531b));
                hashMap.put(IAdRequestParam.SN, "" + f());
                hashMap.put("os", "android");
                hashMap.put(com.alipay.sdk.cons.b.k, b.a.p0.h.i.n.a.b().c());
                hashMap.put("apid", "" + this.f10532c);
                hashMap.put(IAdRequestParam.CHID, "0");
                String s = b.a.p0.h.i.n.a.b().s();
                if (s.equals("0")) {
                    s = "";
                }
                hashMap.put("imei", s);
                hashMap.put("cuid", b.a.p0.h.i.n.a.b().e());
                hashMap.put(IAdRequestParam.OSV, b.a.p0.h.i.s.h.f());
                hashMap.put(IAdRequestParam.PHONE_TYPE, b.a.p0.h.i.s.h.e());
                hashMap.put(IAdRequestParam.APV, b.a.p0.h.i.s.h.l());
                String c2 = b.a.p0.h.i.s.h.c(d(), "BAIDUID");
                hashMap.put("baiduid", (TextUtils.isEmpty(c2) || c2.split(":").length <= 0) ? "" : c2.split(":")[0]);
                hashMap.put("p_ver", this.f10537h);
                hashMap.put(IAdRequestParam.RPT, this.f10536g);
                hashMap.put("tab", "2");
                hashMap.put(IAdRequestParam.REQ_ID, "");
                hashMap.put("scene", b.a.p0.h.i.n.a.b().k());
                String e2 = e();
                hashMap.put(p, e2);
                hashMap.put("eqid", b.a.p0.h.i.n.a.b().m());
                JSONObject t = b.a.p0.h.i.n.a.b().t();
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
                if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.j)) {
                    hashMap.put(n, this.j);
                }
                hashMap.put("con_name", b.a.p0.h.i.n.a.b().a());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b.a.p0.h.i.n.a.b().l(Domains.BAIDU) : (String) invokeV.objValue;
    }

    public abstract String e();

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                String s = b.a.p0.h.i.n.a.b().s();
                return TextUtils.isEmpty(s) ? NetworkUtils.e(this.f10531b) : s;
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
            return b.a.p0.h.i.s.e.a(this.f10530a, b2);
        }
        return (String) invokeV.objValue;
    }
}
