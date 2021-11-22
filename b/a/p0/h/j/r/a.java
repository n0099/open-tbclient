package b.a.p0.h.j.r;

import b.a.p0.a.d2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.n2.n;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10683a;

    /* renamed from: b  reason: collision with root package name */
    public String f10684b;

    /* renamed from: c  reason: collision with root package name */
    public String f10685c;

    /* renamed from: d  reason: collision with root package name */
    public String f10686d;

    /* renamed from: e  reason: collision with root package name */
    public String f10687e;

    /* renamed from: f  reason: collision with root package name */
    public String f10688f;

    /* renamed from: g  reason: collision with root package name */
    public String f10689g;

    /* renamed from: h  reason: collision with root package name */
    public String f10690h;

    /* renamed from: i  reason: collision with root package name */
    public String f10691i;

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
        this.f10683a = "swan";
        this.f10686d = "";
        this.f10687e = "";
        this.f10688f = "";
        this.f10689g = "";
        this.f10690h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.f10683a = n.n(V.G());
        this.f10685c = V.H();
        this.f10684b = V.T();
        this.f10688f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10689g = V.W();
        this.f10690h = V.e0();
        this.f10691i = V.V();
        this.f10686d = V.v1();
        this.f10687e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10683a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10685c);
                jSONObject.put("source", this.f10684b);
                jSONObject.put("needDown", this.f10688f);
                jSONObject.put("scheme", this.f10689g);
                jSONObject.put("extPage", this.f10690h);
                jSONObject.put("launchId", this.f10691i);
                jSONObject.put("appVersion", this.f10686d);
                jSONObject.put("thirdVersion", this.f10687e);
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
        this.f10683a = "swan";
        this.f10686d = "";
        this.f10687e = "";
        this.f10688f = "";
        this.f10689g = "";
        this.f10690h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10683a = jSONObject.optString("from", "swan");
        this.f10685c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10684b = jSONObject.optString("source");
        this.f10688f = jSONObject.optString("needDown");
        this.f10689g = jSONObject.optString("scheme");
        this.f10690h = jSONObject.optString("extPage");
        this.f10691i = jSONObject.optString("launchId", null);
        this.f10686d = jSONObject.optString("appVersion");
        this.f10687e = jSONObject.optString("thirdVersion");
    }
}
