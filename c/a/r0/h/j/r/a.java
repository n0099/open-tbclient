package c.a.r0.h.j.r;

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
    public String f10796b;

    /* renamed from: c  reason: collision with root package name */
    public String f10797c;

    /* renamed from: d  reason: collision with root package name */
    public String f10798d;

    /* renamed from: e  reason: collision with root package name */
    public String f10799e;

    /* renamed from: f  reason: collision with root package name */
    public String f10800f;

    /* renamed from: g  reason: collision with root package name */
    public String f10801g;

    /* renamed from: h  reason: collision with root package name */
    public String f10802h;

    /* renamed from: i  reason: collision with root package name */
    public String f10803i;

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
        this.f10798d = "";
        this.f10799e = "";
        this.f10800f = "";
        this.f10801g = "";
        this.f10802h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10797c = V.H();
        this.f10796b = V.T();
        this.f10800f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10801g = V.W();
        this.f10802h = V.e0();
        this.f10803i = V.V();
        this.f10798d = V.v1();
        this.f10799e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10797c);
                jSONObject.put("source", this.f10796b);
                jSONObject.put("needDown", this.f10800f);
                jSONObject.put("scheme", this.f10801g);
                jSONObject.put("extPage", this.f10802h);
                jSONObject.put("launchId", this.f10803i);
                jSONObject.put("appVersion", this.f10798d);
                jSONObject.put("thirdVersion", this.f10799e);
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
        this.f10798d = "";
        this.f10799e = "";
        this.f10800f = "";
        this.f10801g = "";
        this.f10802h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10797c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10796b = jSONObject.optString("source");
        this.f10800f = jSONObject.optString("needDown");
        this.f10801g = jSONObject.optString("scheme");
        this.f10802h = jSONObject.optString("extPage");
        this.f10803i = jSONObject.optString("launchId", null);
        this.f10798d = jSONObject.optString("appVersion");
        this.f10799e = jSONObject.optString("thirdVersion");
    }
}
