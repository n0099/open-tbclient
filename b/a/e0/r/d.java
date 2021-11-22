package b.a.e0.r;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f2692a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, str3)) == null) {
            JSONObject b2 = b(str3);
            try {
                b2.put("orderId", str);
                b2.put("payInfo", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return b2.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static JSONObject b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("returnData", f2692a);
                jSONObject.put("msg", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? b(str).toString() : (String) invokeL.objValue;
    }

    public static String d(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            JSONObject b2 = b(str3);
            try {
                b2.put("orderId", str);
                b2.put("payUrl", str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return b2.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle) == null) {
            if (bundle != null) {
                f2692a = bundle.getString("returnData");
            } else {
                f2692a = "";
            }
        }
    }
}
