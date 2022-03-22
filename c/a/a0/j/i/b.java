package c.a.a0.j.i;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.provider.FontsContractCompat;
import c.a.a0.g.g.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, str, str2, str3, str4)) == null) {
            JSONObject jSONObject = new JSONObject();
            c.a.a0.x.b.e(jSONObject, "downStatus", str);
            try {
                d2 = Double.parseDouble(str2) * 100.0d;
            } catch (Exception unused) {
                d2 = 0.0d;
            }
            c.a.a0.x.b.d(jSONObject, "process", Math.round(d2));
            c.a.a0.x.b.e(jSONObject, "uri", str3);
            c.a.a0.x.b.e(jSONObject, FontsContractCompat.Columns.FILE_ID, str4);
            return jSONObject.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static void b(@Nullable d dVar, boolean z, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{dVar, Boolean.valueOf(z), map}) == null) || dVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        c.a.a0.x.c.e(map, "status", z ? "0" : "202");
        c.a.a0.x.c.e(map, "message", z ? "调用成功" : "");
        dVar.a(z, map);
    }

    public static void c(@Nullable d dVar, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65538, null, dVar, str, str2, str3, str4) == null) || dVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WebChromeClient.KEY_ARG_CALLBACK, str);
        JSONObject jSONObject = new JSONObject();
        c.a.a0.x.b.e(jSONObject, "uri", str2);
        c.a.a0.x.b.e(jSONObject, FontsContractCompat.Columns.FILE_ID, str3);
        c.a.a0.x.b.e(jSONObject, "downStatus", str4);
        hashMap.put("data", jSONObject.toString());
        b(dVar, true, hashMap);
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TextUtils.isEmpty(str) ? "" : c.a.a0.x.b.b(str).optString("bt_info") : (String) invokeL.objValue;
    }
}
