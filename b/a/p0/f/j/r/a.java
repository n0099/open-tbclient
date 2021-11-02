package b.a.p0.f.j.r;

import b.a.p0.a.a2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.j2.k;
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
    public String f10012a;

    /* renamed from: b  reason: collision with root package name */
    public String f10013b;

    /* renamed from: c  reason: collision with root package name */
    public String f10014c;

    /* renamed from: d  reason: collision with root package name */
    public String f10015d;

    /* renamed from: e  reason: collision with root package name */
    public String f10016e;

    /* renamed from: f  reason: collision with root package name */
    public String f10017f;

    /* renamed from: g  reason: collision with root package name */
    public String f10018g;

    /* renamed from: h  reason: collision with root package name */
    public String f10019h;

    /* renamed from: i  reason: collision with root package name */
    public String f10020i;

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
        this.f10012a = "swan";
        this.f10015d = "";
        this.f10016e = "";
        this.f10017f = "";
        this.f10018g = "";
        this.f10019h = "";
        if (e.P() == null) {
            return;
        }
        b.a K = e.P().K();
        this.f10012a = k.m(K.F());
        this.f10014c = K.G();
        this.f10013b = K.S();
        this.f10017f = K.q0().getString("aiapp_extra_need_download", "");
        this.f10018g = K.V();
        this.f10019h = K.d0();
        this.f10020i = K.U();
        this.f10015d = K.s1();
        this.f10016e = K.t1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10012a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10014c);
                jSONObject.put("source", this.f10013b);
                jSONObject.put("needDown", this.f10017f);
                jSONObject.put("scheme", this.f10018g);
                jSONObject.put("extPage", this.f10019h);
                jSONObject.put("launchId", this.f10020i);
                jSONObject.put("appVersion", this.f10015d);
                jSONObject.put("thirdVersion", this.f10016e);
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
        this.f10012a = "swan";
        this.f10015d = "";
        this.f10016e = "";
        this.f10017f = "";
        this.f10018g = "";
        this.f10019h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10012a = jSONObject.optString("from", "swan");
        this.f10014c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10013b = jSONObject.optString("source");
        this.f10017f = jSONObject.optString("needDown");
        this.f10018g = jSONObject.optString("scheme");
        this.f10019h = jSONObject.optString("extPage");
        this.f10020i = jSONObject.optString("launchId", null);
        this.f10015d = jSONObject.optString("appVersion");
        this.f10016e = jSONObject.optString("thirdVersion");
    }
}
