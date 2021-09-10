package c.a.p0.g.c.i;

import c.a.p0.a.a2.e;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.j2.k;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10917a;

    /* renamed from: b  reason: collision with root package name */
    public String f10918b;

    /* renamed from: c  reason: collision with root package name */
    public String f10919c;

    /* renamed from: d  reason: collision with root package name */
    public String f10920d;

    /* renamed from: e  reason: collision with root package name */
    public String f10921e;

    /* renamed from: f  reason: collision with root package name */
    public String f10922f;

    /* renamed from: g  reason: collision with root package name */
    public String f10923g;

    /* renamed from: h  reason: collision with root package name */
    public String f10924h;

    /* renamed from: i  reason: collision with root package name */
    public String f10925i;

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
        this.f10917a = "swan";
        this.f10920d = "";
        this.f10921e = "";
        this.f10922f = "";
        this.f10923g = "";
        this.f10924h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10917a = k.m(L.G());
        this.f10919c = L.H();
        this.f10918b = L.T();
        this.f10922f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10923g = L.W();
        this.f10924h = L.e0();
        this.f10925i = L.V();
        this.f10920d = L.u1();
        this.f10921e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10917a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10919c);
                jSONObject.put("source", this.f10918b);
                jSONObject.put("needDown", this.f10922f);
                jSONObject.put("scheme", this.f10923g);
                jSONObject.put("extPage", this.f10924h);
                jSONObject.put("launchId", this.f10925i);
                jSONObject.put("appVersion", this.f10920d);
                jSONObject.put("thirdVersion", this.f10921e);
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
        this.f10917a = "swan";
        this.f10920d = "";
        this.f10921e = "";
        this.f10922f = "";
        this.f10923g = "";
        this.f10924h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10917a = jSONObject.optString("from", "swan");
        this.f10919c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10918b = jSONObject.optString("source");
        this.f10922f = jSONObject.optString("needDown");
        this.f10923g = jSONObject.optString("scheme");
        this.f10924h = jSONObject.optString("extPage");
        this.f10925i = jSONObject.optString("launchId", null);
        this.f10920d = jSONObject.optString("appVersion");
        this.f10921e = jSONObject.optString("thirdVersion");
    }
}
