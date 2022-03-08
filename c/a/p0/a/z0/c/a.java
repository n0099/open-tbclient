package c.a.p0.a.z0.c;

import android.text.TextUtils;
import c.a.p0.a.p2.d0;
import c.a.p0.a.t1.e;
import c.a.p0.a.x.u.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
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
    public String f9258b;

    /* renamed from: c  reason: collision with root package name */
    public String f9259c;

    /* renamed from: d  reason: collision with root package name */
    public String f9260d;

    /* renamed from: e  reason: collision with root package name */
    public String f9261e;

    /* renamed from: f  reason: collision with root package name */
    public String f9262f;

    /* renamed from: g  reason: collision with root package name */
    public String f9263g;

    /* renamed from: h  reason: collision with root package name */
    public String f9264h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9265i;

    /* renamed from: j  reason: collision with root package name */
    public String f9266j;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-118053432, "Lc/a/p0/a/z0/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-118053432, "Lc/a/p0/a/z0/c/a;");
                return;
            }
        }
        v = c.a.p0.a.a.a;
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
        this.f9258b = "";
        this.f9259c = "";
        this.f9260d = "";
        this.f9261e = "";
        this.f9262f = "";
        this.f9263g = "";
        this.f9264h = "";
        this.f9265i = false;
        this.f9266j = "";
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
                aVar2.f9258b = jSONObject.optString("slaveId", aVar.f9258b);
                aVar2.f9259c = jSONObject.optString("src", aVar.f9259c);
                aVar2.q = e.L() != null && c.a.p0.a.e2.b.E(aVar2.f9259c);
                aVar2.f9260d = jSONObject.optString("title", aVar.f9260d);
                aVar2.f9261e = jSONObject.optString("epname", aVar.f9261e);
                aVar2.f9262f = jSONObject.optString("singer", aVar.f9262f);
                aVar2.f9263g = jSONObject.optString("coverImgUrl", aVar.f9263g);
                aVar2.f9264h = jSONObject.optString("lrcURL", aVar.f9264h);
                aVar2.f9265i = jSONObject.optBoolean("showFloatView", aVar.f9265i);
                aVar2.f9266j = jSONObject.optString("floatPosition", aVar.f9266j);
                aVar2.k = jSONObject.optInt(FetchLog.START_TIME, aVar.k);
                aVar2.l = jSONObject.optInt("position", aVar.l);
                aVar2.p = jSONObject.optString("cb", aVar.p);
                aVar2.m = jSONObject.optString("param", aVar.m);
                aVar2.r = TextUtils.isEmpty(jSONObject.optString("src"));
                String g0 = g.U().g0();
                if (!TextUtils.isEmpty(g0)) {
                    aVar2.s = g0;
                }
                String b2 = d0.b();
                if (!TextUtils.isEmpty(b2) && d0.c(aVar2.f9259c)) {
                    aVar2.t = b2;
                }
                String j2 = c.a.p0.a.f2.b.l().j(aVar2.f9259c);
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
                jSONObject.putOpt("title", this.f9260d);
                jSONObject.putOpt("epname", this.f9261e);
                jSONObject.putOpt("singer", this.f9262f);
                jSONObject.putOpt("coverImgUrl", this.f9263g);
                jSONObject.putOpt("lrcURL", this.f9264h);
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
            return "AudioBGPlayerParams{ playerId=" + this.a + " slaveId=" + this.f9258b + " url=" + this.f9259c + " startTime=" + this.k + " pos=" + this.l + " canPlay=" + this.r + " }";
        }
        return (String) invokeV.objValue;
    }
}
