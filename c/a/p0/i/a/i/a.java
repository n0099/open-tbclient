package c.a.p0.i.a.i;

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
    public String f10204b;

    /* renamed from: c  reason: collision with root package name */
    public String f10205c;

    /* renamed from: d  reason: collision with root package name */
    public String f10206d;

    /* renamed from: e  reason: collision with root package name */
    public String f10207e;

    /* renamed from: f  reason: collision with root package name */
    public String f10208f;

    /* renamed from: g  reason: collision with root package name */
    public String f10209g;

    /* renamed from: h  reason: collision with root package name */
    public String f10210h;

    /* renamed from: i  reason: collision with root package name */
    public String f10211i;

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
        this.f10206d = "";
        this.f10207e = "";
        this.f10208f = "";
        this.f10209g = "";
        this.f10210h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10205c = V.H();
        this.f10204b = V.T();
        this.f10208f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10209g = V.W();
        this.f10210h = V.e0();
        this.f10211i = V.V();
        this.f10206d = V.v1();
        this.f10207e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10205c);
                jSONObject.put("source", this.f10204b);
                jSONObject.put("needDown", this.f10208f);
                jSONObject.put("scheme", this.f10209g);
                jSONObject.put("extPage", this.f10210h);
                jSONObject.put("launchId", this.f10211i);
                jSONObject.put("appVersion", this.f10206d);
                jSONObject.put("thirdVersion", this.f10207e);
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
        this.f10206d = "";
        this.f10207e = "";
        this.f10208f = "";
        this.f10209g = "";
        this.f10210h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10205c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10204b = jSONObject.optString("source");
        this.f10208f = jSONObject.optString("needDown");
        this.f10209g = jSONObject.optString("scheme");
        this.f10210h = jSONObject.optString("extPage");
        this.f10211i = jSONObject.optString("launchId", null);
        this.f10206d = jSONObject.optString("appVersion");
        this.f10207e = jSONObject.optString("thirdVersion");
    }
}
