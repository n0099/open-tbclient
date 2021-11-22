package b.a.x0.m;

import com.baidu.android.imsdk.internal.Constants;
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

    /* renamed from: a  reason: collision with root package name */
    public int f30628a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30629b;

    /* renamed from: c  reason: collision with root package name */
    public String f30630c;

    /* renamed from: d  reason: collision with root package name */
    public String f30631d;

    /* renamed from: e  reason: collision with root package name */
    public String f30632e;

    /* renamed from: f  reason: collision with root package name */
    public String f30633f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30634g;

    /* renamed from: h  reason: collision with root package name */
    public String f30635h;

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
            }
        }
    }

    public JSONObject a() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        JSONException e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", this.f30628a);
                    jSONObject.put("doReport", this.f30629b);
                    jSONObject.put("name", this.f30630c);
                    jSONObject.put("code", this.f30631d);
                    jSONObject.put("msg", this.f30632e);
                    jSONObject.put("data", this.f30633f);
                    jSONObject.put("isShowSpecialToast", this.f30634g);
                    jSONObject.put("specialToast", this.f30635h);
                } catch (JSONException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return jSONObject;
                }
            } catch (JSONException e4) {
                jSONObject = null;
                e2 = e4;
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "type:" + this.f30628a + "name:" + this.f30630c + "code:" + this.f30631d + "msg:" + this.f30632e + "data" + this.f30633f + "doReport : " + this.f30629b;
        }
        return (String) invokeV.objValue;
    }
}
