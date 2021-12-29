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
    public String f10980b;

    /* renamed from: c  reason: collision with root package name */
    public String f10981c;

    /* renamed from: d  reason: collision with root package name */
    public String f10982d;

    /* renamed from: e  reason: collision with root package name */
    public String f10983e;

    /* renamed from: f  reason: collision with root package name */
    public String f10984f;

    /* renamed from: g  reason: collision with root package name */
    public String f10985g;

    /* renamed from: h  reason: collision with root package name */
    public String f10986h;

    /* renamed from: i  reason: collision with root package name */
    public String f10987i;

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
        this.f10982d = "";
        this.f10983e = "";
        this.f10984f = "";
        this.f10985g = "";
        this.f10986h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10981c = V.H();
        this.f10980b = V.T();
        this.f10984f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10985g = V.W();
        this.f10986h = V.e0();
        this.f10987i = V.V();
        this.f10982d = V.v1();
        this.f10983e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10981c);
                jSONObject.put("source", this.f10980b);
                jSONObject.put("needDown", this.f10984f);
                jSONObject.put("scheme", this.f10985g);
                jSONObject.put("extPage", this.f10986h);
                jSONObject.put("launchId", this.f10987i);
                jSONObject.put("appVersion", this.f10982d);
                jSONObject.put("thirdVersion", this.f10983e);
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
        this.f10982d = "";
        this.f10983e = "";
        this.f10984f = "";
        this.f10985g = "";
        this.f10986h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10981c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10980b = jSONObject.optString("source");
        this.f10984f = jSONObject.optString("needDown");
        this.f10985g = jSONObject.optString("scheme");
        this.f10986h = jSONObject.optString("extPage");
        this.f10987i = jSONObject.optString("launchId", null);
        this.f10982d = jSONObject.optString("appVersion");
        this.f10983e = jSONObject.optString("thirdVersion");
    }
}
