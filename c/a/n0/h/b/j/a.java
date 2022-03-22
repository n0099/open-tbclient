package c.a.n0.h.b.j;

import c.a.n0.a.d2.n;
import c.a.n0.a.t1.e;
import c.a.n0.a.v0.e.b;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f8466b;

    /* renamed from: c  reason: collision with root package name */
    public String f8467c;

    /* renamed from: d  reason: collision with root package name */
    public String f8468d;

    /* renamed from: e  reason: collision with root package name */
    public String f8469e;

    /* renamed from: f  reason: collision with root package name */
    public String f8470f;

    /* renamed from: g  reason: collision with root package name */
    public String f8471g;

    /* renamed from: h  reason: collision with root package name */
    public String f8472h;
    public String i;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "swan";
        this.f8468d = "";
        this.f8469e = "";
        this.f8470f = "";
        this.f8471g = "";
        this.f8472h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f8467c = V.H();
        this.f8466b = V.T();
        this.f8470f = V.s0().getString("aiapp_extra_need_download", "");
        this.f8471g = V.W();
        this.f8472h = V.e0();
        this.i = V.V();
        this.f8468d = V.v1();
        this.f8469e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f8467c);
                jSONObject.put("source", this.f8466b);
                jSONObject.put("needDown", this.f8470f);
                jSONObject.put("scheme", this.f8471g);
                jSONObject.put("extPage", this.f8472h);
                jSONObject.put("launchId", this.i);
                jSONObject.put("appVersion", this.f8468d);
                jSONObject.put("thirdVersion", this.f8469e);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "swan";
        this.f8468d = "";
        this.f8469e = "";
        this.f8470f = "";
        this.f8471g = "";
        this.f8472h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f8467c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f8466b = jSONObject.optString("source");
        this.f8470f = jSONObject.optString("needDown");
        this.f8471g = jSONObject.optString("scheme");
        this.f8472h = jSONObject.optString("extPage");
        this.i = jSONObject.optString("launchId", null);
        this.f8468d = jSONObject.optString("appVersion");
        this.f8469e = jSONObject.optString("thirdVersion");
    }
}
