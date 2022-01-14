package c.a.r0.a.j1.c;

import android.text.TextUtils;
import c.a.r0.a.d2.e;
import c.a.r0.a.h0.u.g;
import c.a.r0.a.k;
import c.a.r0.a.z2.d0;
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
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f7283b;

    /* renamed from: c  reason: collision with root package name */
    public String f7284c;

    /* renamed from: d  reason: collision with root package name */
    public String f7285d;

    /* renamed from: e  reason: collision with root package name */
    public String f7286e;

    /* renamed from: f  reason: collision with root package name */
    public String f7287f;

    /* renamed from: g  reason: collision with root package name */
    public String f7288g;

    /* renamed from: h  reason: collision with root package name */
    public String f7289h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7290i;

    /* renamed from: j  reason: collision with root package name */
    public String f7291j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1146415851, "Lc/a/r0/a/j1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1146415851, "Lc/a/r0/a/j1/c/a;");
                return;
            }
        }
        v = k.a;
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
        this.a = "";
        this.f7283b = "";
        this.f7284c = "";
        this.f7285d = "";
        this.f7286e = "";
        this.f7287f = "";
        this.f7288g = "";
        this.f7289h = "";
        this.f7290i = false;
        this.f7291j = "";
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
                aVar2.a = jSONObject.optString("audioId", aVar.a);
                aVar2.f7283b = jSONObject.optString("slaveId", aVar.f7283b);
                aVar2.f7284c = jSONObject.optString("src", aVar.f7284c);
                aVar2.q = e.L() != null && c.a.r0.a.o2.b.E(aVar2.f7284c);
                aVar2.f7285d = jSONObject.optString("title", aVar.f7285d);
                aVar2.f7286e = jSONObject.optString("epname", aVar.f7286e);
                aVar2.f7287f = jSONObject.optString("singer", aVar.f7287f);
                aVar2.f7288g = jSONObject.optString("coverImgUrl", aVar.f7288g);
                aVar2.f7289h = jSONObject.optString("lrcURL", aVar.f7289h);
                aVar2.f7290i = jSONObject.optBoolean("showFloatView", aVar.f7290i);
                aVar2.f7291j = jSONObject.optString("floatPosition", aVar.f7291j);
                aVar2.k = jSONObject.optInt("startTime", aVar.k);
                aVar2.l = jSONObject.optInt("position", aVar.l);
                aVar2.p = jSONObject.optString("cb", aVar.p);
                aVar2.m = jSONObject.optString("param", aVar.m);
                aVar2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = g.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    aVar2.s = g0;
                }
                String b2 = d0.b();
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f7284c)) {
                    aVar2.t = b2;
                }
                String j2 = c.a.r0.a.p2.b.l().j(aVar2.f7284c);
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
                jSONObject.putOpt("title", this.f7285d);
                jSONObject.putOpt("epname", this.f7286e);
                jSONObject.putOpt("singer", this.f7287f);
                jSONObject.putOpt("coverImgUrl", this.f7288g);
                jSONObject.putOpt("lrcURL", this.f7289h);
                jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
                jSONObject.putOpt("appid", e.f0());
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
            return "AudioBGPlayerParams{ playerId=" + this.a + " slaveId=" + this.f7283b + " url=" + this.f7284c + " startTime=" + this.k + " pos=" + this.l + " canPlay=" + this.r + " }";
        }
        return (String) invokeV.objValue;
    }
}
