package c.a.p0.i.b.i;

import c.a.p0.a.d2.e;
import c.a.p0.a.f1.e.b;
import c.a.p0.a.n2.n;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f9936b;

    /* renamed from: c  reason: collision with root package name */
    public String f9937c;

    /* renamed from: d  reason: collision with root package name */
    public String f9938d;

    /* renamed from: e  reason: collision with root package name */
    public String f9939e;

    /* renamed from: f  reason: collision with root package name */
    public String f9940f;

    /* renamed from: g  reason: collision with root package name */
    public String f9941g;

    /* renamed from: h  reason: collision with root package name */
    public String f9942h;

    /* renamed from: i  reason: collision with root package name */
    public String f9943i;

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
        this.f9938d = "";
        this.f9939e = "";
        this.f9940f = "";
        this.f9941g = "";
        this.f9942h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f9937c = V.H();
        this.f9936b = V.T();
        this.f9940f = V.s0().getString("aiapp_extra_need_download", "");
        this.f9941g = V.W();
        this.f9942h = V.e0();
        this.f9943i = V.V();
        this.f9938d = V.v1();
        this.f9939e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f9937c);
                jSONObject.put("source", this.f9936b);
                jSONObject.put("needDown", this.f9940f);
                jSONObject.put("scheme", this.f9941g);
                jSONObject.put("extPage", this.f9942h);
                jSONObject.put("launchId", this.f9943i);
                jSONObject.put("appVersion", this.f9938d);
                jSONObject.put("thirdVersion", this.f9939e);
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
        this.f9938d = "";
        this.f9939e = "";
        this.f9940f = "";
        this.f9941g = "";
        this.f9942h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f9937c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f9936b = jSONObject.optString("source");
        this.f9940f = jSONObject.optString("needDown");
        this.f9941g = jSONObject.optString("scheme");
        this.f9942h = jSONObject.optString("extPage");
        this.f9943i = jSONObject.optString("launchId", null);
        this.f9938d = jSONObject.optString("appVersion");
        this.f9939e = jSONObject.optString("thirdVersion");
    }
}
