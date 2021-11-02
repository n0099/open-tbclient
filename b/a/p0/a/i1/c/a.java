package b.a.p0.a.i1.c;

import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.v2.d0;
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
    public String f5908a;

    /* renamed from: b  reason: collision with root package name */
    public String f5909b;

    /* renamed from: c  reason: collision with root package name */
    public String f5910c;

    /* renamed from: d  reason: collision with root package name */
    public String f5911d;

    /* renamed from: e  reason: collision with root package name */
    public String f5912e;

    /* renamed from: f  reason: collision with root package name */
    public String f5913f;

    /* renamed from: g  reason: collision with root package name */
    public String f5914g;

    /* renamed from: h  reason: collision with root package name */
    public String f5915h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5916i;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781550793, "Lb/a/p0/a/i1/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781550793, "Lb/a/p0/a/i1/c/a;");
                return;
            }
        }
        v = k.f6397a;
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
        this.f5908a = "";
        this.f5909b = "";
        this.f5910c = "";
        this.f5911d = "";
        this.f5912e = "";
        this.f5913f = "";
        this.f5914g = "";
        this.f5915h = "";
        this.f5916i = false;
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
                aVar2.f5908a = jSONObject.optString("audioId", aVar.f5908a);
                aVar2.f5909b = jSONObject.optString("slaveId", aVar.f5909b);
                aVar2.f5910c = jSONObject.optString("src", aVar.f5910c);
                aVar2.q = e.i() != null && b.a.p0.a.k2.b.E(aVar2.f5910c);
                aVar2.f5911d = jSONObject.optString("title", aVar.f5911d);
                aVar2.f5912e = jSONObject.optString("epname", aVar.f5912e);
                aVar2.f5913f = jSONObject.optString("singer", aVar.f5913f);
                aVar2.f5914g = jSONObject.optString("coverImgUrl", aVar.f5914g);
                aVar2.f5915h = jSONObject.optString("lrcURL", aVar.f5915h);
                aVar2.f5916i = jSONObject.optBoolean("showFloatView", aVar.f5916i);
                aVar2.j = jSONObject.optString("floatPosition", aVar.j);
                aVar2.k = jSONObject.optInt("startTime", aVar.k);
                aVar2.l = jSONObject.optInt("position", aVar.l);
                aVar2.p = jSONObject.optString("cb", aVar.p);
                aVar2.m = jSONObject.optString("param", aVar.m);
                aVar2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String X = g.M().X();
                if (!TextUtils.isEmpty(X)) {
                    aVar2.s = X;
                }
                String b2 = d0.b();
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f5910c)) {
                    aVar2.t = b2;
                }
                String j = b.a.p0.a.l2.b.l().j(aVar2.f5910c);
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
                jSONObject.putOpt("title", this.f5911d);
                jSONObject.putOpt("epname", this.f5912e);
                jSONObject.putOpt("singer", this.f5913f);
                jSONObject.putOpt("coverImgUrl", this.f5914g);
                jSONObject.putOpt("lrcURL", this.f5915h);
                jSONObject.putOpt("isLocal", Boolean.valueOf(this.q));
                jSONObject.putOpt("appid", e.U());
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
            return "playerId : " + this.f5908a + "; slaveId : " + this.f5909b + "; url : " + this.f5910c + "; startTime : " + this.k + "; pos : " + this.l + "; canPlay : " + this.r;
        }
        return (String) invokeV.objValue;
    }
}
