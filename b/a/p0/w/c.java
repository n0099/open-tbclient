package b.a.p0.w;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, jSONObject, str, str2)) == null) ? jSONObject == null ? str2 : jSONObject.optString(str, str2) : (String) invokeLLL.objValue;
    }

    public static JSONObject b(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, jSONObject)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                if (TextUtils.isEmpty(a(jSONObject, "pre_source", null))) {
                    jSONObject.put("pre_source", str);
                }
                if (TextUtils.isEmpty(a(jSONObject, "pre_appid", null))) {
                    jSONObject.put("pre_appid", AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA);
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
