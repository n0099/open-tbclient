package c.a.p0.f.j.r;

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
    public String f10806a;

    /* renamed from: b  reason: collision with root package name */
    public String f10807b;

    /* renamed from: c  reason: collision with root package name */
    public String f10808c;

    /* renamed from: d  reason: collision with root package name */
    public String f10809d;

    /* renamed from: e  reason: collision with root package name */
    public String f10810e;

    /* renamed from: f  reason: collision with root package name */
    public String f10811f;

    /* renamed from: g  reason: collision with root package name */
    public String f10812g;

    /* renamed from: h  reason: collision with root package name */
    public String f10813h;

    /* renamed from: i  reason: collision with root package name */
    public String f10814i;

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
        this.f10806a = "swan";
        this.f10809d = "";
        this.f10810e = "";
        this.f10811f = "";
        this.f10812g = "";
        this.f10813h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10806a = k.m(L.G());
        this.f10808c = L.H();
        this.f10807b = L.T();
        this.f10811f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10812g = L.W();
        this.f10813h = L.e0();
        this.f10814i = L.V();
        this.f10809d = L.u1();
        this.f10810e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10806a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10808c);
                jSONObject.put("source", this.f10807b);
                jSONObject.put("needDown", this.f10811f);
                jSONObject.put("scheme", this.f10812g);
                jSONObject.put("extPage", this.f10813h);
                jSONObject.put("launchId", this.f10814i);
                jSONObject.put("appVersion", this.f10809d);
                jSONObject.put("thirdVersion", this.f10810e);
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
        this.f10806a = "swan";
        this.f10809d = "";
        this.f10810e = "";
        this.f10811f = "";
        this.f10812g = "";
        this.f10813h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10806a = jSONObject.optString("from", "swan");
        this.f10808c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10807b = jSONObject.optString("source");
        this.f10811f = jSONObject.optString("needDown");
        this.f10812g = jSONObject.optString("scheme");
        this.f10813h = jSONObject.optString("extPage");
        this.f10814i = jSONObject.optString("launchId", null);
        this.f10809d = jSONObject.optString("appVersion");
        this.f10810e = jSONObject.optString("thirdVersion");
    }
}
