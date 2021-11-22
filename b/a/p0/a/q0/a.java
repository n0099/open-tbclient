package b.a.p0.a.q0;

import android.text.TextUtils;
import b.a.p0.a.d2.e;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        String optString;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            e a0 = e.a0();
            JSONObject jSONObject = new JSONObject();
            if (a0 != null) {
                jSONObject = a0.V().M();
            }
            return (jSONObject == null || (optString = jSONObject.optString("keyfeed")) == null || (indexOf = optString.indexOf("_")) < 0 || !TextUtils.equals("miniapp", optString.substring(0, indexOf))) ? "" : optString.substring(indexOf + 1);
        }
        return (String) invokeV.objValue;
    }

    public static Map<String, Object> b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_key", str);
            hashMap.put("op_type", str2);
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("nid", a2);
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static Map<String, Object> c(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_key", str);
            hashMap.put(QuickPersistConfigConst.KEY_SPLASH_SORT, Integer.valueOf(i2));
            hashMap.put("op_type", "add");
            return hashMap;
        }
        return (Map) invokeLI.objValue;
    }
}
