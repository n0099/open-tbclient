package c.a.o0.h.a.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
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

    public static JSONObject b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65537, null, i2, i3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", i2);
                jSONObject.put("height", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeII.objValue;
    }
}
