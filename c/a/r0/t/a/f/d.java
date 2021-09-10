package c.a.r0.t.a.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.advert.sdk.data.WirelessNetworkType;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e2) {
                e2.getMessage();
                str = "";
            }
            return (str == null || str.equals("")) ? "-" : str;
        }
        return (String) invokeL.objValue;
    }

    public static Integer b(Context context) {
        InterceptResult invokeL;
        int value;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            Integer valueOf = Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                if (typeName.equalsIgnoreCase(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING)) {
                    return Integer.valueOf(WirelessNetworkType.WIFI.getValue());
                }
                if (typeName.equalsIgnoreCase("MOBILE")) {
                    if (TextUtils.isEmpty(Proxy.getDefaultHost())) {
                        value = (g(context) ? WirelessNetworkType.MOBILE_3G : WirelessNetworkType.MOBILE_2G).getValue();
                    } else {
                        value = WirelessNetworkType.NETWORKTYPE_WAP.getValue();
                    }
                    return Integer.valueOf(value);
                }
                return valueOf;
            }
            return Integer.valueOf(WirelessNetworkType.UNKNOWN_NETWORK.getValue());
        }
        return (Integer) invokeL.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.MODEL : (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Build.VERSION.RELEASE : (String) invokeV.objValue;
    }

    public static Integer e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? Integer.valueOf(context.getResources().getDisplayMetrics().heightPixels) : (Integer) invokeL.objValue;
    }

    public static Integer f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? Integer.valueOf(context.getResources().getDisplayMetrics().widthPixels) : (Integer) invokeL.objValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 13:
                case 14:
                case 15:
                    return true;
                case 4:
                case 7:
                case 11:
                default:
                    return false;
            }
        }
        return invokeL.booleanValue;
    }
}
