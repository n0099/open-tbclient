package b.a.p0.a.j1.c;

import android.text.TextUtils;
import b.a.p0.a.d2.e;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.z2.d0;
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
    public String f6561a;

    /* renamed from: b  reason: collision with root package name */
    public String f6562b;

    /* renamed from: c  reason: collision with root package name */
    public String f6563c;

    /* renamed from: d  reason: collision with root package name */
    public String f6564d;

    /* renamed from: e  reason: collision with root package name */
    public String f6565e;

    /* renamed from: f  reason: collision with root package name */
    public String f6566f;

    /* renamed from: g  reason: collision with root package name */
    public String f6567g;

    /* renamed from: h  reason: collision with root package name */
    public String f6568h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6569i;
    public String j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-894047112, "Lb/a/p0/a/j1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-894047112, "Lb/a/p0/a/j1/c/a;");
                return;
            }
        }
        v = k.f6863a;
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
        this.f6561a = "";
        this.f6562b = "";
        this.f6563c = "";
        this.f6564d = "";
        this.f6565e = "";
        this.f6566f = "";
        this.f6567g = "";
        this.f6568h = "";
        this.f6569i = false;
        this.j = "";
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
                aVar2.f6561a = jSONObject.optString("audioId", aVar.f6561a);
                aVar2.f6562b = jSONObject.optString("slaveId", aVar.f6562b);
                aVar2.f6563c = jSONObject.optString("src", aVar.f6563c);
                aVar2.q = e.L() != null && b.a.p0.a.o2.b.E(aVar2.f6563c);
                aVar2.f6564d = jSONObject.optString("title", aVar.f6564d);
                aVar2.f6565e = jSONObject.optString("epname", aVar.f6565e);
                aVar2.f6566f = jSONObject.optString("singer", aVar.f6566f);
                aVar2.f6567g = jSONObject.optString("coverImgUrl", aVar.f6567g);
                aVar2.f6568h = jSONObject.optString("lrcURL", aVar.f6568h);
                aVar2.f6569i = jSONObject.optBoolean("showFloatView", aVar.f6569i);
                aVar2.j = jSONObject.optString("floatPosition", aVar.j);
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
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f6563c)) {
                    aVar2.t = b2;
                }
                String j = b.a.p0.a.p2.b.l().j(aVar2.f6563c);
                if (!TextUtils.isEmpty(j)) {
                    aVar2.u = j;
                    if (v) {
                        String str = "addCookiesToHeader cookie: " + j;
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
                jSONObject.putOpt("title", this.f6564d);
                jSONObject.putOpt("epname", this.f6565e);
                jSONObject.putOpt("singer", this.f6566f);
                jSONObject.putOpt("coverImgUrl", this.f6567g);
                jSONObject.putOpt("lrcURL", this.f6568h);
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
            return "AudioBGPlayerParams{ playerId=" + this.f6561a + " slaveId=" + this.f6562b + " url=" + this.f6563c + " startTime=" + this.k + " pos=" + this.l + " canPlay=" + this.r + " }";
        }
        return (String) invokeV.objValue;
    }
}
