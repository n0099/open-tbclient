package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            int i3 = -101;
            if (i2 != -101) {
                i3 = -1;
                if (i2 != -1) {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return 2;
                        case 13:
                        case 18:
                        case 19:
                            return 3;
                        default:
                            return i2;
                    }
                }
            }
            return i3;
        }
        return invokeI.intValue;
    }

    public static NetworkInfo a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return null;
            }
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            NetworkInfo a = a(context);
            return a != null && a.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            NetworkInfo a = a(context);
            return a != null && a.getType() == 0;
        }
        return invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return true;
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
            } catch (Throwable th) {
                CtAuth.warn("NetUtil", "isMobileEnable error ", th);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int h2 = h(context);
            return h2 != -101 ? (h2 == -1 || h2 == 0) ? StringUtil.NULL_STRING : h2 != 1 ? h2 != 2 ? h2 != 3 ? Integer.toString(h2) : "4G" : "3G" : "2G" : CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
        }
        return (String) invokeL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String e2 = e(context);
            return (e2 != null && e2.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING) && d(context)) ? "BOTH" : e2;
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            String f2 = f(context);
            if (!TextUtils.isEmpty(f2) && !f2.equals(StringUtil.NULL_STRING)) {
                if (f2.equals("2G")) {
                    return "10";
                }
                if (f2.equals("3G")) {
                    return "11";
                }
                if (f2.equals("4G")) {
                    return "12";
                }
                if (f2.equals(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING)) {
                    return "13";
                }
                if (f2.equals("BOTH")) {
                    return "14";
                }
            }
            return "15";
        }
        return (String) invokeL.objValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            int i2 = 0;
            try {
                NetworkInfo a = a(context);
                if (a != null && a.isAvailable() && a.isConnected()) {
                    int type = a.getType();
                    if (type == 1) {
                        i2 = -101;
                    } else if (type == 0) {
                        try {
                            i2 = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (i2 == 0) {
                            i2 = a.getSubtype();
                        }
                    }
                } else {
                    i2 = -1;
                }
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return a(i2);
        }
        return invokeL.intValue;
    }
}
