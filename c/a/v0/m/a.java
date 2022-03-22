package c.a.v0.m;

import com.baidu.android.imsdk.internal.Constants;
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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f21727b;

    /* renamed from: c  reason: collision with root package name */
    public String f21728c;

    /* renamed from: d  reason: collision with root package name */
    public String f21729d;

    /* renamed from: e  reason: collision with root package name */
    public String f21730e;

    /* renamed from: f  reason: collision with root package name */
    public String f21731f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21732g;

    /* renamed from: h  reason: collision with root package name */
    public String f21733h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                    jSONObject.put("doReport", this.f21727b);
                    jSONObject.put("name", this.f21728c);
                    jSONObject.put("code", this.f21729d);
                    jSONObject.put("msg", this.f21730e);
                    jSONObject.put("data", this.f21731f);
                    jSONObject.put("isShowSpecialToast", this.f21732g);
                    jSONObject.put("specialToast", this.f21733h);
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
            return "type:" + this.a + "name:" + this.f21728c + "code:" + this.f21729d + "msg:" + this.f21730e + "data" + this.f21731f + "doReport : " + this.f21727b;
        }
        return (String) invokeV.objValue;
    }
}
