package c.a.p0.a.i1.c;

import android.text.TextUtils;
import c.a.p0.a.a2.e;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.d0;
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
    public String f6581a;

    /* renamed from: b  reason: collision with root package name */
    public String f6582b;

    /* renamed from: c  reason: collision with root package name */
    public String f6583c;

    /* renamed from: d  reason: collision with root package name */
    public String f6584d;

    /* renamed from: e  reason: collision with root package name */
    public String f6585e;

    /* renamed from: f  reason: collision with root package name */
    public String f6586f;

    /* renamed from: g  reason: collision with root package name */
    public String f6587g;

    /* renamed from: h  reason: collision with root package name */
    public String f6588h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6589i;

    /* renamed from: j  reason: collision with root package name */
    public String f6590j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2002882326, "Lc/a/p0/a/i1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2002882326, "Lc/a/p0/a/i1/c/a;");
                return;
            }
        }
        v = k.f7085a;
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
        this.f6581a = "";
        this.f6582b = "";
        this.f6583c = "";
        this.f6584d = "";
        this.f6585e = "";
        this.f6586f = "";
        this.f6587g = "";
        this.f6588h = "";
        this.f6589i = false;
        this.f6590j = "";
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
                aVar2.f6581a = jSONObject.optString("audioId", aVar.f6581a);
                aVar2.f6582b = jSONObject.optString("slaveId", aVar.f6582b);
                aVar2.f6583c = jSONObject.optString("src", aVar.f6583c);
                aVar2.q = e.i() != null && c.a.p0.a.k2.b.E(aVar2.f6583c);
                aVar2.f6584d = jSONObject.optString("title", aVar.f6584d);
                aVar2.f6585e = jSONObject.optString("epname", aVar.f6585e);
                aVar2.f6586f = jSONObject.optString("singer", aVar.f6586f);
                aVar2.f6587g = jSONObject.optString("coverImgUrl", aVar.f6587g);
                aVar2.f6588h = jSONObject.optString("lrcURL", aVar.f6588h);
                aVar2.f6589i = jSONObject.optBoolean("showFloatView", aVar.f6589i);
                aVar2.f6590j = jSONObject.optString("floatPosition", aVar.f6590j);
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
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f6583c)) {
                    aVar2.t = b2;
                }
                String j2 = c.a.p0.a.l2.b.l().j(aVar2.f6583c);
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
                jSONObject.putOpt("title", this.f6584d);
                jSONObject.putOpt("epname", this.f6585e);
                jSONObject.putOpt("singer", this.f6586f);
                jSONObject.putOpt("coverImgUrl", this.f6587g);
                jSONObject.putOpt("lrcURL", this.f6588h);
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
            return "playerId : " + this.f6581a + "; slaveId : " + this.f6582b + "; url : " + this.f6583c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
        }
        return (String) invokeV.objValue;
    }
}
