package b.a.p0.g.c.i;

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
    public String f10131a;

    /* renamed from: b  reason: collision with root package name */
    public String f10132b;

    /* renamed from: c  reason: collision with root package name */
    public String f10133c;

    /* renamed from: d  reason: collision with root package name */
    public String f10134d;

    /* renamed from: e  reason: collision with root package name */
    public String f10135e;

    /* renamed from: f  reason: collision with root package name */
    public String f10136f;

    /* renamed from: g  reason: collision with root package name */
    public String f10137g;

    /* renamed from: h  reason: collision with root package name */
    public String f10138h;

    /* renamed from: i  reason: collision with root package name */
    public String f10139i;

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
        this.f10131a = "swan";
        this.f10134d = "";
        this.f10135e = "";
        this.f10136f = "";
        this.f10137g = "";
        this.f10138h = "";
        if (e.P() == null) {
            return;
        }
        b.a K = e.P().K();
        this.f10131a = k.m(K.F());
        this.f10133c = K.G();
        this.f10132b = K.S();
        this.f10136f = K.q0().getString("aiapp_extra_need_download", "");
        this.f10137g = K.V();
        this.f10138h = K.d0();
        this.f10139i = K.U();
        this.f10134d = K.s1();
        this.f10135e = K.t1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10131a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10133c);
                jSONObject.put("source", this.f10132b);
                jSONObject.put("needDown", this.f10136f);
                jSONObject.put("scheme", this.f10137g);
                jSONObject.put("extPage", this.f10138h);
                jSONObject.put("launchId", this.f10139i);
                jSONObject.put("appVersion", this.f10134d);
                jSONObject.put("thirdVersion", this.f10135e);
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
        this.f10131a = "swan";
        this.f10134d = "";
        this.f10135e = "";
        this.f10136f = "";
        this.f10137g = "";
        this.f10138h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10131a = jSONObject.optString("from", "swan");
        this.f10133c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10132b = jSONObject.optString("source");
        this.f10136f = jSONObject.optString("needDown");
        this.f10137g = jSONObject.optString("scheme");
        this.f10138h = jSONObject.optString("extPage");
        this.f10139i = jSONObject.optString("launchId", null);
        this.f10134d = jSONObject.optString("appVersion");
        this.f10135e = jSONObject.optString("thirdVersion");
    }
}
