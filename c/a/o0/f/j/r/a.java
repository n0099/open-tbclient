package c.a.o0.f.j.r;

import c.a.o0.a.a2.e;
import c.a.o0.a.f1.e.b;
import c.a.o0.a.j2.k;
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
    public String f10770a;

    /* renamed from: b  reason: collision with root package name */
    public String f10771b;

    /* renamed from: c  reason: collision with root package name */
    public String f10772c;

    /* renamed from: d  reason: collision with root package name */
    public String f10773d;

    /* renamed from: e  reason: collision with root package name */
    public String f10774e;

    /* renamed from: f  reason: collision with root package name */
    public String f10775f;

    /* renamed from: g  reason: collision with root package name */
    public String f10776g;

    /* renamed from: h  reason: collision with root package name */
    public String f10777h;

    /* renamed from: i  reason: collision with root package name */
    public String f10778i;

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
        this.f10770a = "swan";
        this.f10773d = "";
        this.f10774e = "";
        this.f10775f = "";
        this.f10776g = "";
        this.f10777h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10770a = k.m(L.G());
        this.f10772c = L.H();
        this.f10771b = L.T();
        this.f10775f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10776g = L.W();
        this.f10777h = L.e0();
        this.f10778i = L.V();
        this.f10773d = L.u1();
        this.f10774e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10770a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10772c);
                jSONObject.put("source", this.f10771b);
                jSONObject.put("needDown", this.f10775f);
                jSONObject.put("scheme", this.f10776g);
                jSONObject.put("extPage", this.f10777h);
                jSONObject.put("launchId", this.f10778i);
                jSONObject.put("appVersion", this.f10773d);
                jSONObject.put("thirdVersion", this.f10774e);
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
        this.f10770a = "swan";
        this.f10773d = "";
        this.f10774e = "";
        this.f10775f = "";
        this.f10776g = "";
        this.f10777h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10770a = jSONObject.optString("from", "swan");
        this.f10772c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10771b = jSONObject.optString("source");
        this.f10775f = jSONObject.optString("needDown");
        this.f10776g = jSONObject.optString("scheme");
        this.f10777h = jSONObject.optString("extPage");
        this.f10778i = jSONObject.optString("launchId", null);
        this.f10773d = jSONObject.optString("appVersion");
        this.f10774e = jSONObject.optString("thirdVersion");
    }
}
