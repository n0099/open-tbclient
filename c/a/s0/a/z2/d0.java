package c.a.s0.a.z2;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
/* loaded from: classes6.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            c.a.s0.a.d2.e L = c.a.s0.a.d2.e.L();
            return L != null ? String.format(str, L.N(), L.U()) : "";
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String a = a("https://smartapps.cn/%s/%s/page-frame.html");
            if (c.a.s0.a.k.a) {
                String str = "getFixedReferer: " + a;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("https://") : invokeL.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            String b2 = b();
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            if (c.a.s0.a.k.a) {
                String str = "call setRefererPattern for Slave Webview; referer is " + b2;
            }
            WebSettingsGlobalBlink.setRefererPattern(b2, c.a.s0.a.a1.d.i());
        }
    }
}
