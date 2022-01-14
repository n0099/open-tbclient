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
    public String f10654b;

    /* renamed from: c  reason: collision with root package name */
    public String f10655c;

    /* renamed from: d  reason: collision with root package name */
    public String f10656d;

    /* renamed from: e  reason: collision with root package name */
    public String f10657e;

    /* renamed from: f  reason: collision with root package name */
    public String f10658f;

    /* renamed from: g  reason: collision with root package name */
    public String f10659g;

    /* renamed from: h  reason: collision with root package name */
    public String f10660h;

    /* renamed from: i  reason: collision with root package name */
    public String f10661i;

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
        this.f10656d = "";
        this.f10657e = "";
        this.f10658f = "";
        this.f10659g = "";
        this.f10660h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.a = n.n(V.G());
        this.f10655c = V.H();
        this.f10654b = V.T();
        this.f10658f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10659g = V.W();
        this.f10660h = V.e0();
        this.f10661i = V.V();
        this.f10656d = V.v1();
        this.f10657e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10655c);
                jSONObject.put("source", this.f10654b);
                jSONObject.put("needDown", this.f10658f);
                jSONObject.put("scheme", this.f10659g);
                jSONObject.put("extPage", this.f10660h);
                jSONObject.put("launchId", this.f10661i);
                jSONObject.put("appVersion", this.f10656d);
                jSONObject.put("thirdVersion", this.f10657e);
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
        this.f10656d = "";
        this.f10657e = "";
        this.f10658f = "";
        this.f10659g = "";
        this.f10660h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.a = jSONObject.optString("from", "swan");
        this.f10655c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10654b = jSONObject.optString("source");
        this.f10658f = jSONObject.optString("needDown");
        this.f10659g = jSONObject.optString("scheme");
        this.f10660h = jSONObject.optString("extPage");
        this.f10661i = jSONObject.optString("launchId", null);
        this.f10656d = jSONObject.optString("appVersion");
        this.f10657e = jSONObject.optString("thirdVersion");
    }
}
