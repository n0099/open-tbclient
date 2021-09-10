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
    public String f10798a;

    /* renamed from: b  reason: collision with root package name */
    public String f10799b;

    /* renamed from: c  reason: collision with root package name */
    public String f10800c;

    /* renamed from: d  reason: collision with root package name */
    public String f10801d;

    /* renamed from: e  reason: collision with root package name */
    public String f10802e;

    /* renamed from: f  reason: collision with root package name */
    public String f10803f;

    /* renamed from: g  reason: collision with root package name */
    public String f10804g;

    /* renamed from: h  reason: collision with root package name */
    public String f10805h;

    /* renamed from: i  reason: collision with root package name */
    public String f10806i;

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
        this.f10798a = "swan";
        this.f10801d = "";
        this.f10802e = "";
        this.f10803f = "";
        this.f10804g = "";
        this.f10805h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10798a = k.m(L.G());
        this.f10800c = L.H();
        this.f10799b = L.T();
        this.f10803f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10804g = L.W();
        this.f10805h = L.e0();
        this.f10806i = L.V();
        this.f10801d = L.u1();
        this.f10802e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10798a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10800c);
                jSONObject.put("source", this.f10799b);
                jSONObject.put("needDown", this.f10803f);
                jSONObject.put("scheme", this.f10804g);
                jSONObject.put("extPage", this.f10805h);
                jSONObject.put("launchId", this.f10806i);
                jSONObject.put("appVersion", this.f10801d);
                jSONObject.put("thirdVersion", this.f10802e);
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
        this.f10798a = "swan";
        this.f10801d = "";
        this.f10802e = "";
        this.f10803f = "";
        this.f10804g = "";
        this.f10805h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10798a = jSONObject.optString("from", "swan");
        this.f10800c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10799b = jSONObject.optString("source");
        this.f10803f = jSONObject.optString("needDown");
        this.f10804g = jSONObject.optString("scheme");
        this.f10805h = jSONObject.optString("extPage");
        this.f10806i = jSONObject.optString("launchId", null);
        this.f10801d = jSONObject.optString("appVersion");
        this.f10802e = jSONObject.optString("thirdVersion");
    }
}
