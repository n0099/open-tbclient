package c.a.o0.a.i1.c;

import android.text.TextUtils;
import c.a.o0.a.a2.e;
import c.a.o0.a.h0.u.g;
import c.a.o0.a.k;
import c.a.o0.a.v2.d0;
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
    public String f6545a;

    /* renamed from: b  reason: collision with root package name */
    public String f6546b;

    /* renamed from: c  reason: collision with root package name */
    public String f6547c;

    /* renamed from: d  reason: collision with root package name */
    public String f6548d;

    /* renamed from: e  reason: collision with root package name */
    public String f6549e;

    /* renamed from: f  reason: collision with root package name */
    public String f6550f;

    /* renamed from: g  reason: collision with root package name */
    public String f6551g;

    /* renamed from: h  reason: collision with root package name */
    public String f6552h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6553i;

    /* renamed from: j  reason: collision with root package name */
    public String f6554j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1873799607, "Lc/a/o0/a/i1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1873799607, "Lc/a/o0/a/i1/c/a;");
                return;
            }
        }
        v = k.f7049a;
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
        this.f6545a = "";
        this.f6546b = "";
        this.f6547c = "";
        this.f6548d = "";
        this.f6549e = "";
        this.f6550f = "";
        this.f6551g = "";
        this.f6552h = "";
        this.f6553i = false;
        this.f6554j = "";
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
                aVar2.f6545a = jSONObject.optString("audioId", aVar.f6545a);
                aVar2.f6546b = jSONObject.optString("slaveId", aVar.f6546b);
                aVar2.f6547c = jSONObject.optString("src", aVar.f6547c);
                aVar2.q = e.i() != null && c.a.o0.a.k2.b.E(aVar2.f6547c);
                aVar2.f6548d = jSONObject.optString("title", aVar.f6548d);
                aVar2.f6549e = jSONObject.optString("epname", aVar.f6549e);
                aVar2.f6550f = jSONObject.optString("singer", aVar.f6550f);
                aVar2.f6551g = jSONObject.optString("coverImgUrl", aVar.f6551g);
                aVar2.f6552h = jSONObject.optString("lrcURL", aVar.f6552h);
                aVar2.f6553i = jSONObject.optBoolean("showFloatView", aVar.f6553i);
                aVar2.f6554j = jSONObject.optString("floatPosition", aVar.f6554j);
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
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f6547c)) {
                    aVar2.t = b2;
                }
                String j2 = c.a.o0.a.l2.b.l().j(aVar2.f6547c);
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
                jSONObject.putOpt("title", this.f6548d);
                jSONObject.putOpt("epname", this.f6549e);
                jSONObject.putOpt("singer", this.f6550f);
                jSONObject.putOpt("coverImgUrl", this.f6551g);
                jSONObject.putOpt("lrcURL", this.f6552h);
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
            return "playerId : " + this.f6545a + "; slaveId : " + this.f6546b + "; url : " + this.f6547c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
        }
        return (String) invokeV.objValue;
    }
}
