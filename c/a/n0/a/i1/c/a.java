package c.a.n0.a.i1.c;

import android.text.TextUtils;
import c.a.n0.a.a2.e;
import c.a.n0.a.h0.u.g;
import c.a.n0.a.k;
import c.a.n0.a.v2.d0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6299a;

    /* renamed from: b  reason: collision with root package name */
    public String f6300b;

    /* renamed from: c  reason: collision with root package name */
    public String f6301c;

    /* renamed from: d  reason: collision with root package name */
    public String f6302d;

    /* renamed from: e  reason: collision with root package name */
    public String f6303e;

    /* renamed from: f  reason: collision with root package name */
    public String f6304f;

    /* renamed from: g  reason: collision with root package name */
    public String f6305g;

    /* renamed from: h  reason: collision with root package name */
    public String f6306h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6307i;

    /* renamed from: j  reason: collision with root package name */
    public String f6308j;
    public int k;
    public int l;
    public String m;
    public int n;
    public int o;
    public String p;
    public boolean q;
    public boolean r;
    public String s;
    public String t;
    public String u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1744716888, "Lc/a/n0/a/i1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1744716888, "Lc/a/n0/a/i1/c/a;");
                return;
            }
        }
        v = k.f6803a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6299a = "";
        this.f6300b = "";
        this.f6301c = "";
        this.f6302d = "";
        this.f6303e = "";
        this.f6304f = "";
        this.f6305g = "";
        this.f6306h = "";
        this.f6307i = false;
        this.f6308j = "";
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.q = false;
    }

    public static a b(JSONObject jSONObject, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, aVar)) == null) {
            a aVar2 = new a();
            if (jSONObject != null) {
                aVar2.f6299a = jSONObject.optString("audioId", aVar.f6299a);
                aVar2.f6300b = jSONObject.optString("slaveId", aVar.f6300b);
                aVar2.f6301c = jSONObject.optString("src", aVar.f6301c);
                aVar2.q = e.i() != null && c.a.n0.a.k2.b.E(aVar2.f6301c);
                aVar2.f6302d = jSONObject.optString("title", aVar.f6302d);
                aVar2.f6303e = jSONObject.optString("epname", aVar.f6303e);
                aVar2.f6304f = jSONObject.optString("singer", aVar.f6304f);
                aVar2.f6305g = jSONObject.optString("coverImgUrl", aVar.f6305g);
                aVar2.f6306h = jSONObject.optString("lrcURL", aVar.f6306h);
                aVar2.f6307i = jSONObject.optBoolean("showFloatView", aVar.f6307i);
                aVar2.f6308j = jSONObject.optString("floatPosition", aVar.f6308j);
                aVar2.k = jSONObject.optInt("startTime", aVar.k);
                aVar2.l = jSONObject.optInt("position", aVar.l);
                aVar2.p = jSONObject.optString("cb", aVar.p);
                aVar2.m = jSONObject.optString("param", aVar.m);
                aVar2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String Y = g.N().Y();
                if (!TextUtils.isEmpty(Y)) {
                    aVar2.s = Y;
                }
                String b2 = d0.b();
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f6301c)) {
                    aVar2.t = b2;
                }
                String j2 = c.a.n0.a.l2.b.l().j(aVar2.f6301c);
                if (!TextUtils.isEmpty(j2)) {
                    aVar2.u = j2;
                    if (v) {
                        String str = "addCookiesToHeader cookie: " + j2;
                    }
                }
            }
            return aVar2;
        }
        return (a) invokeLL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("src", str);
                jSONObject.putOpt("title", this.f6302d);
                jSONObject.putOpt("epname", this.f6303e);
                jSONObject.putOpt("singer", this.f6304f);
                jSONObject.putOpt("coverImgUrl", this.f6305g);
                jSONObject.putOpt("lrcURL", this.f6306h);
                jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
                jSONObject.putOpt("appid", e.V());
                jSONObject.putOpt("user-agent", this.s);
                jSONObject.putOpt(TiebaStatic.Params.REFER, this.t);
                jSONObject.putOpt("Cookie", this.u);
            } catch (JSONException e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "playerId : " + this.f6299a + "; slaveId : " + this.f6300b + "; url : " + this.f6301c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
        }
        return (String) invokeV.objValue;
    }
}
