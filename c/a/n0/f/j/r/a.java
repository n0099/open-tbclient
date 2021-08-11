package c.a.n0.f.j.r;

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
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f10524a;

    /* renamed from: b  reason: collision with root package name */
    public String f10525b;

    /* renamed from: c  reason: collision with root package name */
    public String f10526c;

    /* renamed from: d  reason: collision with root package name */
    public String f10527d;

    /* renamed from: e  reason: collision with root package name */
    public String f10528e;

    /* renamed from: f  reason: collision with root package name */
    public String f10529f;

    /* renamed from: g  reason: collision with root package name */
    public String f10530g;

    /* renamed from: h  reason: collision with root package name */
    public String f10531h;

    /* renamed from: i  reason: collision with root package name */
    public String f10532i;

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
        this.f10524a = "swan";
        this.f10527d = "";
        this.f10528e = "";
        this.f10529f = "";
        this.f10530g = "";
        this.f10531h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10524a = k.m(L.G());
        this.f10526c = L.H();
        this.f10525b = L.T();
        this.f10529f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10530g = L.W();
        this.f10531h = L.e0();
        this.f10532i = L.V();
        this.f10527d = L.u1();
        this.f10528e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10524a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10526c);
                jSONObject.put("source", this.f10525b);
                jSONObject.put("needDown", this.f10529f);
                jSONObject.put("scheme", this.f10530g);
                jSONObject.put("extPage", this.f10531h);
                jSONObject.put("launchId", this.f10532i);
                jSONObject.put("appVersion", this.f10527d);
                jSONObject.put("thirdVersion", this.f10528e);
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
        this.f10524a = "swan";
        this.f10527d = "";
        this.f10528e = "";
        this.f10529f = "";
        this.f10530g = "";
        this.f10531h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10524a = jSONObject.optString("from", "swan");
        this.f10526c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10525b = jSONObject.optString("source");
        this.f10529f = jSONObject.optString("needDown");
        this.f10530g = jSONObject.optString("scheme");
        this.f10531h = jSONObject.optString("extPage");
        this.f10532i = jSONObject.optString("launchId", null);
        this.f10527d = jSONObject.optString("appVersion");
        this.f10528e = jSONObject.optString("thirdVersion");
    }
}
