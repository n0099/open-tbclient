package c.a.n0.g.c.i;

import c.a.n0.a.a2.e;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.k;
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
    public String f10643a;

    /* renamed from: b  reason: collision with root package name */
    public String f10644b;

    /* renamed from: c  reason: collision with root package name */
    public String f10645c;

    /* renamed from: d  reason: collision with root package name */
    public String f10646d;

    /* renamed from: e  reason: collision with root package name */
    public String f10647e;

    /* renamed from: f  reason: collision with root package name */
    public String f10648f;

    /* renamed from: g  reason: collision with root package name */
    public String f10649g;

    /* renamed from: h  reason: collision with root package name */
    public String f10650h;

    /* renamed from: i  reason: collision with root package name */
    public String f10651i;

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
        this.f10643a = "swan";
        this.f10646d = "";
        this.f10647e = "";
        this.f10648f = "";
        this.f10649g = "";
        this.f10650h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10643a = k.m(L.G());
        this.f10645c = L.H();
        this.f10644b = L.T();
        this.f10648f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10649g = L.W();
        this.f10650h = L.e0();
        this.f10651i = L.V();
        this.f10646d = L.u1();
        this.f10647e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10643a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10645c);
                jSONObject.put("source", this.f10644b);
                jSONObject.put("needDown", this.f10648f);
                jSONObject.put("scheme", this.f10649g);
                jSONObject.put("extPage", this.f10650h);
                jSONObject.put("launchId", this.f10651i);
                jSONObject.put("appVersion", this.f10646d);
                jSONObject.put("thirdVersion", this.f10647e);
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
        this.f10643a = "swan";
        this.f10646d = "";
        this.f10647e = "";
        this.f10648f = "";
        this.f10649g = "";
        this.f10650h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10643a = jSONObject.optString("from", "swan");
        this.f10645c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10644b = jSONObject.optString("source");
        this.f10648f = jSONObject.optString("needDown");
        this.f10649g = jSONObject.optString("scheme");
        this.f10650h = jSONObject.optString("extPage");
        this.f10651i = jSONObject.optString("launchId", null);
        this.f10646d = jSONObject.optString("appVersion");
        this.f10647e = jSONObject.optString("thirdVersion");
    }
}
