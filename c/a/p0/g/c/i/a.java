package c.a.p0.g.c.i;

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
    public String f10925a;

    /* renamed from: b  reason: collision with root package name */
    public String f10926b;

    /* renamed from: c  reason: collision with root package name */
    public String f10927c;

    /* renamed from: d  reason: collision with root package name */
    public String f10928d;

    /* renamed from: e  reason: collision with root package name */
    public String f10929e;

    /* renamed from: f  reason: collision with root package name */
    public String f10930f;

    /* renamed from: g  reason: collision with root package name */
    public String f10931g;

    /* renamed from: h  reason: collision with root package name */
    public String f10932h;

    /* renamed from: i  reason: collision with root package name */
    public String f10933i;

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
        this.f10925a = "swan";
        this.f10928d = "";
        this.f10929e = "";
        this.f10930f = "";
        this.f10931g = "";
        this.f10932h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10925a = k.m(L.G());
        this.f10927c = L.H();
        this.f10926b = L.T();
        this.f10930f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10931g = L.W();
        this.f10932h = L.e0();
        this.f10933i = L.V();
        this.f10928d = L.u1();
        this.f10929e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10925a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10927c);
                jSONObject.put("source", this.f10926b);
                jSONObject.put("needDown", this.f10930f);
                jSONObject.put("scheme", this.f10931g);
                jSONObject.put("extPage", this.f10932h);
                jSONObject.put("launchId", this.f10933i);
                jSONObject.put("appVersion", this.f10928d);
                jSONObject.put("thirdVersion", this.f10929e);
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
        this.f10925a = "swan";
        this.f10928d = "";
        this.f10929e = "";
        this.f10930f = "";
        this.f10931g = "";
        this.f10932h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10925a = jSONObject.optString("from", "swan");
        this.f10927c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10926b = jSONObject.optString("source");
        this.f10930f = jSONObject.optString("needDown");
        this.f10931g = jSONObject.optString("scheme");
        this.f10932h = jSONObject.optString("extPage");
        this.f10933i = jSONObject.optString("launchId", null);
        this.f10928d = jSONObject.optString("appVersion");
        this.f10929e = jSONObject.optString("thirdVersion");
    }
}
