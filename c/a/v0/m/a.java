package c.a.v0.m;

import com.baidu.android.imsdk.internal.Constants;
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
    public int f30418a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30419b;

    /* renamed from: c  reason: collision with root package name */
    public String f30420c;

    /* renamed from: d  reason: collision with root package name */
    public String f30421d;

    /* renamed from: e  reason: collision with root package name */
    public String f30422e;

    /* renamed from: f  reason: collision with root package name */
    public String f30423f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30424g;

    /* renamed from: h  reason: collision with root package name */
    public String f30425h;

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
                    jSONObject.put("type", this.f30418a);
                    jSONObject.put("doReport", this.f30419b);
                    jSONObject.put("name", this.f30420c);
                    jSONObject.put("code", this.f30421d);
                    jSONObject.put("msg", this.f30422e);
                    jSONObject.put("data", this.f30423f);
                    jSONObject.put("isShowSpecialToast", this.f30424g);
                    jSONObject.put("specialToast", this.f30425h);
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
            return "type:" + this.f30418a + "name:" + this.f30420c + "code:" + this.f30421d + "msg:" + this.f30422e + "data" + this.f30423f + "doReport : " + this.f30419b;
        }
        return (String) invokeV.objValue;
    }
}
