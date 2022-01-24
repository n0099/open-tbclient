package c.a.r0.i.b.i;

import c.a.r0.a.d2.e;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.n2.n;
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
    public String f10879b;

    /* renamed from: c  reason: collision with root package name */
    public String f10880c;

    /* renamed from: d  reason: collision with root package name */
    public String f10881d;

    /* renamed from: e  reason: collision with root package name */
    public String f10882e;

    /* renamed from: f  reason: collision with root package name */
    public String f10883f;

    /* renamed from: g  reason: collision with root package name */
    public String f10884g;

    /* renamed from: h  reason: collision with root package name */
    public String f10885h;

    /* renamed from: i  reason: collision with root package name */
    public String f10886i;

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
        this.f10881d = "";
        this.f10882e = "";
        this.f10883f = "";
        this.f10884g = "";
        this.f10885h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10880c = V.H();
        this.f10879b = V.T();
        this.f10883f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10884g = V.W();
        this.f10885h = V.e0();
        this.f10886i = V.V();
        this.f10881d = V.v1();
        this.f10882e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10880c);
                jSONObject.put("source", this.f10879b);
                jSONObject.put("needDown", this.f10883f);
                jSONObject.put("scheme", this.f10884g);
                jSONObject.put("extPage", this.f10885h);
                jSONObject.put("launchId", this.f10886i);
                jSONObject.put("appVersion", this.f10881d);
                jSONObject.put("thirdVersion", this.f10882e);
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
        this.f10881d = "";
        this.f10882e = "";
        this.f10883f = "";
        this.f10884g = "";
        this.f10885h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10880c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10879b = jSONObject.optString("source");
        this.f10883f = jSONObject.optString("needDown");
        this.f10884g = jSONObject.optString("scheme");
        this.f10885h = jSONObject.optString("extPage");
        this.f10886i = jSONObject.optString("launchId", null);
        this.f10881d = jSONObject.optString("appVersion");
        this.f10882e = jSONObject.optString("thirdVersion");
    }
}
