package c.a.o0.h.a.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65536, null, z)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("isEnded", z);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeZ.objValue;
    }

    public static JSONObject b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errCode", str);
                jSONObject.put("errMsg", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                jSONObject.put("errDes", c.a.o0.f.i.r.b.a(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
