package c.a.a1.m;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1336b;

    /* renamed from: c  reason: collision with root package name */
    public String f1337c;

    /* renamed from: d  reason: collision with root package name */
    public String f1338d;

    /* renamed from: e  reason: collision with root package name */
    public String f1339e;

    /* renamed from: f  reason: collision with root package name */
    public String f1340f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1341g;

    /* renamed from: h  reason: collision with root package name */
    public String f1342h;

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
                    jSONObject.put("doReport", this.f1336b);
                    jSONObject.put("name", this.f1337c);
                    jSONObject.put("code", this.f1338d);
                    jSONObject.put("msg", this.f1339e);
                    jSONObject.put("data", this.f1340f);
                    jSONObject.put("isShowSpecialToast", this.f1341g);
                    jSONObject.put("specialToast", this.f1342h);
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
            return "type:" + this.a + "name:" + this.f1337c + "code:" + this.f1338d + "msg:" + this.f1339e + "data" + this.f1340f + "doReport : " + this.f1336b;
        }
        return (String) invokeV.objValue;
    }
}
