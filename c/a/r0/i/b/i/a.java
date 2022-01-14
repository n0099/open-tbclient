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
    public String f10737b;

    /* renamed from: c  reason: collision with root package name */
    public String f10738c;

    /* renamed from: d  reason: collision with root package name */
    public String f10739d;

    /* renamed from: e  reason: collision with root package name */
    public String f10740e;

    /* renamed from: f  reason: collision with root package name */
    public String f10741f;

    /* renamed from: g  reason: collision with root package name */
    public String f10742g;

    /* renamed from: h  reason: collision with root package name */
    public String f10743h;

    /* renamed from: i  reason: collision with root package name */
    public String f10744i;

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
        this.f10739d = "";
        this.f10740e = "";
        this.f10741f = "";
        this.f10742g = "";
        this.f10743h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10738c = V.H();
        this.f10737b = V.T();
        this.f10741f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10742g = V.W();
        this.f10743h = V.e0();
        this.f10744i = V.V();
        this.f10739d = V.v1();
        this.f10740e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10738c);
                jSONObject.put("source", this.f10737b);
                jSONObject.put("needDown", this.f10741f);
                jSONObject.put("scheme", this.f10742g);
                jSONObject.put("extPage", this.f10743h);
                jSONObject.put("launchId", this.f10744i);
                jSONObject.put("appVersion", this.f10739d);
                jSONObject.put("thirdVersion", this.f10740e);
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
        this.f10739d = "";
        this.f10740e = "";
        this.f10741f = "";
        this.f10742g = "";
        this.f10743h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10738c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10737b = jSONObject.optString("source");
        this.f10741f = jSONObject.optString("needDown");
        this.f10742g = jSONObject.optString("scheme");
        this.f10743h = jSONObject.optString("extPage");
        this.f10744i = jSONObject.optString("launchId", null);
        this.f10739d = jSONObject.optString("appVersion");
        this.f10740e = jSONObject.optString("thirdVersion");
    }
}
