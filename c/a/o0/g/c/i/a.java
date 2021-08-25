package c.a.o0.g.c.i;

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
    public String f10889a;

    /* renamed from: b  reason: collision with root package name */
    public String f10890b;

    /* renamed from: c  reason: collision with root package name */
    public String f10891c;

    /* renamed from: d  reason: collision with root package name */
    public String f10892d;

    /* renamed from: e  reason: collision with root package name */
    public String f10893e;

    /* renamed from: f  reason: collision with root package name */
    public String f10894f;

    /* renamed from: g  reason: collision with root package name */
    public String f10895g;

    /* renamed from: h  reason: collision with root package name */
    public String f10896h;

    /* renamed from: i  reason: collision with root package name */
    public String f10897i;

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
        this.f10889a = "swan";
        this.f10892d = "";
        this.f10893e = "";
        this.f10894f = "";
        this.f10895g = "";
        this.f10896h = "";
        if (e.Q() == null) {
            return;
        }
        b.a L = e.Q().L();
        this.f10889a = k.m(L.G());
        this.f10891c = L.H();
        this.f10890b = L.T();
        this.f10894f = L.r0().getString("aiapp_extra_need_download", "");
        this.f10895g = L.W();
        this.f10896h = L.e0();
        this.f10897i = L.V();
        this.f10892d = L.u1();
        this.f10893e = L.v1();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", this.f10889a);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.f10891c);
                jSONObject.put("source", this.f10890b);
                jSONObject.put("needDown", this.f10894f);
                jSONObject.put("scheme", this.f10895g);
                jSONObject.put("extPage", this.f10896h);
                jSONObject.put("launchId", this.f10897i);
                jSONObject.put("appVersion", this.f10892d);
                jSONObject.put("thirdVersion", this.f10893e);
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
        this.f10889a = "swan";
        this.f10892d = "";
        this.f10893e = "";
        this.f10894f = "";
        this.f10895g = "";
        this.f10896h = "";
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        this.f10889a = jSONObject.optString("from", "swan");
        this.f10891c = jSONObject.optString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
        this.f10890b = jSONObject.optString("source");
        this.f10894f = jSONObject.optString("needDown");
        this.f10895g = jSONObject.optString("scheme");
        this.f10896h = jSONObject.optString("extPage");
        this.f10897i = jSONObject.optString("launchId", null);
        this.f10892d = jSONObject.optString("appVersion");
        this.f10893e = jSONObject.optString("thirdVersion");
    }
}
