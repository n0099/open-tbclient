package c.a.x0.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27053b;

    /* renamed from: c  reason: collision with root package name */
    public String f27054c;

    /* renamed from: d  reason: collision with root package name */
    public String f27055d;

    /* renamed from: e  reason: collision with root package name */
    public String f27056e;

    /* renamed from: f  reason: collision with root package name */
    public String f27057f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27058g;

    /* renamed from: h  reason: collision with root package name */
    public String f27059h;

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
                    jSONObject.put("type", this.a);
                    jSONObject.put("doReport", this.f27053b);
                    jSONObject.put("name", this.f27054c);
                    jSONObject.put("code", this.f27055d);
                    jSONObject.put("msg", this.f27056e);
                    jSONObject.put("data", this.f27057f);
                    jSONObject.put("isShowSpecialToast", this.f27058g);
                    jSONObject.put("specialToast", this.f27059h);
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
            return "type:" + this.a + "name:" + this.f27054c + "code:" + this.f27055d + "msg:" + this.f27056e + "data" + this.f27057f + "doReport : " + this.f27053b;
        }
        return (String) invokeV.objValue;
    }
}
