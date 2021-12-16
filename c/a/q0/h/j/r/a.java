package c.a.q0.h.j.r;

import c.a.q0.a.d2.e;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.n2.n;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f10162b;

    /* renamed from: c  reason: collision with root package name */
    public String f10163c;

    /* renamed from: d  reason: collision with root package name */
    public String f10164d;

    /* renamed from: e  reason: collision with root package name */
    public String f10165e;

    /* renamed from: f  reason: collision with root package name */
    public String f10166f;

    /* renamed from: g  reason: collision with root package name */
    public String f10167g;

    /* renamed from: h  reason: collision with root package name */
    public String f10168h;

    /* renamed from: i  reason: collision with root package name */
    public String f10169i;

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
        this.f10164d = "";
        this.f10165e = "";
        this.f10166f = "";
        this.f10167g = "";
        this.f10168h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10163c = V.H();
        this.f10162b = V.T();
        this.f10166f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10167g = V.W();
        this.f10168h = V.e0();
        this.f10169i = V.V();
        this.f10164d = V.v1();
        this.f10165e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10163c);
                jSONObject.put("source", this.f10162b);
                jSONObject.put("needDown", this.f10166f);
                jSONObject.put("scheme", this.f10167g);
                jSONObject.put("extPage", this.f10168h);
                jSONObject.put("launchId", this.f10169i);
                jSONObject.put("appVersion", this.f10164d);
                jSONObject.put("thirdVersion", this.f10165e);
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
        this.f10164d = "";
        this.f10165e = "";
        this.f10166f = "";
        this.f10167g = "";
        this.f10168h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10163c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10162b = jSONObject.optString("source");
        this.f10166f = jSONObject.optString("needDown");
        this.f10167g = jSONObject.optString("scheme");
        this.f10168h = jSONObject.optString("extPage");
        this.f10169i = jSONObject.optString("launchId", null);
        this.f10164d = jSONObject.optString("appVersion");
        this.f10165e = jSONObject.optString("thirdVersion");
    }
}
