package b.a.p0.i.b.i;

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
    public String f10800a;

    /* renamed from: b  reason: collision with root package name */
    public String f10801b;

    /* renamed from: c  reason: collision with root package name */
    public String f10802c;

    /* renamed from: d  reason: collision with root package name */
    public String f10803d;

    /* renamed from: e  reason: collision with root package name */
    public String f10804e;

    /* renamed from: f  reason: collision with root package name */
    public String f10805f;

    /* renamed from: g  reason: collision with root package name */
    public String f10806g;

    /* renamed from: h  reason: collision with root package name */
    public String f10807h;

    /* renamed from: i  reason: collision with root package name */
    public String f10808i;

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
        this.f10800a = "swan";
        this.f10803d = "";
        this.f10804e = "";
        this.f10805f = "";
        this.f10806g = "";
        this.f10807h = "";
        if (e.a0() == null) {
            return;
        }
        b.a V = e.a0().V();
        this.f10800a = n.n(V.G());
        this.f10802c = V.H();
        this.f10801b = V.T();
        this.f10805f = V.s0().getString("aiapp_extra_need_download", "");
        this.f10806g = V.W();
        this.f10807h = V.e0();
        this.f10808i = V.V();
        this.f10803d = V.v1();
        this.f10804e = V.w1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10800a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10802c);
                jSONObject.put("source", this.f10801b);
                jSONObject.put("needDown", this.f10805f);
                jSONObject.put("scheme", this.f10806g);
                jSONObject.put("extPage", this.f10807h);
                jSONObject.put("launchId", this.f10808i);
                jSONObject.put("appVersion", this.f10803d);
                jSONObject.put("thirdVersion", this.f10804e);
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
        this.f10800a = "swan";
        this.f10803d = "";
        this.f10804e = "";
        this.f10805f = "";
        this.f10806g = "";
        this.f10807h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10800a = jSONObject.optString("from", "swan");
        this.f10802c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10801b = jSONObject.optString("source");
        this.f10805f = jSONObject.optString("needDown");
        this.f10806g = jSONObject.optString("scheme");
        this.f10807h = jSONObject.optString("extPage");
        this.f10808i = jSONObject.optString("launchId", null);
        this.f10803d = jSONObject.optString("appVersion");
        this.f10804e = jSONObject.optString("thirdVersion");
    }
}
