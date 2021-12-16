package c.a.y0.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27446b;

    /* renamed from: c  reason: collision with root package name */
    public String f27447c;

    /* renamed from: d  reason: collision with root package name */
    public String f27448d;

    /* renamed from: e  reason: collision with root package name */
    public String f27449e;

    /* renamed from: f  reason: collision with root package name */
    public String f27450f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f27451g;

    /* renamed from: h  reason: collision with root package name */
    public String f27452h;

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
                    jSONObject.put("doReport", this.f27446b);
                    jSONObject.put("name", this.f27447c);
                    jSONObject.put("code", this.f27448d);
                    jSONObject.put("msg", this.f27449e);
                    jSONObject.put("data", this.f27450f);
                    jSONObject.put("isShowSpecialToast", this.f27451g);
                    jSONObject.put("specialToast", this.f27452h);
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
            return "type:" + this.a + "name:" + this.f27447c + "code:" + this.f27448d + "msg:" + this.f27449e + "data" + this.f27450f + "doReport : " + this.f27446b;
        }
        return (String) invokeV.objValue;
    }
}
