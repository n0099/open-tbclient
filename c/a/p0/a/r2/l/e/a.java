package c.a.p0.a.r2.l.e;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e0.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.s;
import java.nio.charset.StandardCharsets;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static WifiConfiguration a(c.a.p0.a.r2.l.d.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            int b2 = b.b(aVar);
            if (f(aVar.a)) {
                WifiConfiguration wifiConfiguration = new WifiConfiguration();
                wifiConfiguration.SSID = "\"" + aVar.a + "\"";
                if (!TextUtils.isEmpty(aVar.f7872b)) {
                    wifiConfiguration.BSSID = aVar.f7872b;
                }
                if (b2 == 0) {
                    b.d(wifiConfiguration, 0);
                } else if (b2 == 1) {
                    b.d(wifiConfiguration, 1);
                    String[] strArr = wifiConfiguration.wepKeys;
                    strArr[0] = "\"" + aVar.f7874d + "\"";
                } else if (b2 == 2) {
                    b.d(wifiConfiguration, 2);
                    wifiConfiguration.preSharedKey = "\"" + aVar.f7874d + "\"";
                } else if (b2 == 3) {
                    b.d(wifiConfiguration, 3);
                    WifiEnterpriseConfig wifiEnterpriseConfig = new WifiEnterpriseConfig();
                    wifiEnterpriseConfig.setEapMethod(0);
                    wifiEnterpriseConfig.setIdentity(aVar.f7873c);
                    wifiEnterpriseConfig.setPassword(aVar.f7874d);
                    wifiConfiguration.enterpriseConfig = wifiEnterpriseConfig;
                }
                return wifiConfiguration;
            }
            return null;
        }
        return (WifiConfiguration) invokeL.objValue;
    }

    public static WifiConfiguration b(Context context, WifiManager wifiManager, WifiInfo wifiInfo) {
        InterceptResult invokeLLL;
        List<WifiConfiguration> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, wifiManager, wifiInfo)) == null) {
            if (wifiInfo != null && f(wifiInfo.getSSID()) && (d2 = d(context, wifiManager)) != null) {
                for (WifiConfiguration wifiConfiguration : d2) {
                    if (TextUtils.equals(e(wifiConfiguration.SSID), e(wifiInfo.getSSID()))) {
                        return wifiConfiguration;
                    }
                }
            }
            return null;
        }
        return (WifiConfiguration) invokeLLL.objValue;
    }

    public static WifiConfiguration c(Context context, WifiManager wifiManager, c.a.p0.a.r2.l.d.a aVar) {
        InterceptResult invokeLLL;
        List<WifiConfiguration> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, wifiManager, aVar)) == null) {
            if (aVar != null && f(aVar.a) && (d2 = d(context, wifiManager)) != null) {
                for (WifiConfiguration wifiConfiguration : d2) {
                    if (TextUtils.equals(e(wifiConfiguration.SSID), aVar.a)) {
                        return wifiConfiguration;
                    }
                }
            }
            return null;
        }
        return (WifiConfiguration) invokeLLL.objValue;
    }

    public static List<WifiConfiguration> d(Context context, WifiManager wifiManager) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, wifiManager)) == null) {
            if (wifiManager == null) {
                return null;
            }
            try {
                if (ContextCompat.checkSelfPermission(context, s.f56842g) != 0) {
                    return null;
                }
                return wifiManager.getConfiguredNetworks();
            } catch (Exception e2) {
                d.b("SwanWifiUtils", Log.getStackTraceString(e2));
                return null;
            }
        }
        return (List) invokeLL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (length = str.length()) <= 1 || str.charAt(0) != '\"') {
                return str;
            }
            int i2 = length - 1;
            return str.charAt(i2) == '\"' ? str.substring(1, i2) : str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str) || str.equals("<unknown ssid>")) {
                return false;
            }
            return StandardCharsets.UTF_8.newEncoder().canEncode(str);
        }
        return invokeL.booleanValue;
    }
}
