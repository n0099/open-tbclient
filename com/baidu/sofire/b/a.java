package com.baidu.sofire.b;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static int b = -1;
    public static String c = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65536, null, i) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", i);
                jSONObject.put("1", Base64.encodeToString(c.getBytes(), 0));
                a = jSONObject.toString();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
        }
    }
}
