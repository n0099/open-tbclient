package c.p.a.e.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f34805a;

    /* renamed from: b  reason: collision with root package name */
    public int f34806b;

    /* renamed from: c  reason: collision with root package name */
    public String f34807c;

    /* renamed from: d  reason: collision with root package name */
    public String f34808d;

    /* renamed from: e  reason: collision with root package name */
    public String f34809e;

    public b() {
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
        this.f34806b = -1;
    }

    public static b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bVar.f34809e = jSONObject.optString("device_plans", null);
                bVar.f34808d = jSONObject.optString("real_device_plan", null);
                bVar.f34807c = jSONObject.optString("error_msg", null);
                bVar.f34805a = jSONObject.optString("ah_plan_type", null);
                String optString = jSONObject.optString("error_code");
                if (TextUtils.isEmpty(optString)) {
                    bVar.f34806b = -1;
                } else {
                    bVar.f34806b = Integer.parseInt(optString);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d().toString() : (String) invokeV.objValue;
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.f34805a);
            jSONObject.put("error_code", String.valueOf(this.f34806b));
            jSONObject.put("error_msg", this.f34807c);
            jSONObject.put("real_device_plan", this.f34808d);
            jSONObject.put("device_plans", this.f34809e);
        } catch (Throwable unused) {
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            c(jSONObject);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
