package c.a.p0.h.b.j;

import c.a.p0.a.d2.n;
import c.a.p0.a.t1.e;
import c.a.p0.a.v0.e.b;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10121b;

    /* renamed from: c  reason: collision with root package name */
    public String f10122c;

    /* renamed from: d  reason: collision with root package name */
    public String f10123d;

    /* renamed from: e  reason: collision with root package name */
    public String f10124e;

    /* renamed from: f  reason: collision with root package name */
    public String f10125f;

    /* renamed from: g  reason: collision with root package name */
    public String f10126g;

    /* renamed from: h  reason: collision with root package name */
    public String f10127h;

    /* renamed from: i  reason: collision with root package name */
    public String f10128i;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "swan";
        this.f10123d = "";
        this.f10124e = "";
        this.f10125f = "";
        this.f10126g = "";
        this.f10127h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10122c = V.H();
        this.f10121b = V.T();
        this.f10125f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10126g = V.W();
        this.f10127h = V.e0();
        this.f10128i = V.V();
        this.f10123d = V.v1();
        this.f10124e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10122c);
                jSONObject.put("source", this.f10121b);
                jSONObject.put("needDown", this.f10125f);
                jSONObject.put("scheme", this.f10126g);
                jSONObject.put("extPage", this.f10127h);
                jSONObject.put("launchId", this.f10128i);
                jSONObject.put("appVersion", this.f10123d);
                jSONObject.put("thirdVersion", this.f10124e);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "swan";
        this.f10123d = "";
        this.f10124e = "";
        this.f10125f = "";
        this.f10126g = "";
        this.f10127h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10122c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10121b = jSONObject.optString("source");
        this.f10125f = jSONObject.optString("needDown");
        this.f10126g = jSONObject.optString("scheme");
        this.f10127h = jSONObject.optString("extPage");
        this.f10128i = jSONObject.optString("launchId", null);
        this.f10123d = jSONObject.optString("appVersion");
        this.f10124e = jSONObject.optString("thirdVersion");
    }
}
