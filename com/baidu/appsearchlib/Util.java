package com.baidu.appsearchlib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class Util {
    public static /* synthetic */ Interceptable $ic;
    public static String openudid;
    public static PackageInfo packageInfo;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-431111436, "Lcom/baidu/appsearchlib/Util;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-431111436, "Lcom/baidu/appsearchlib/Util;");
        }
    }

    public Util() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getCurrentVersion(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            PackageInfo packageInfo2 = getPackageInfo(context);
            return packageInfo2 == null ? "0" : packageInfo2.versionName;
        }
        return (String) invokeL.objValue;
    }

    public static String getDeviceId(Context context) {
        InterceptResult invokeL;
        String deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (!isEmpty(openudid)) {
                return openudid;
            }
            StringBuilder sb = new StringBuilder();
            try {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!isEmpty(deviceId)) {
                sb.append(deviceId);
                return sb.toString();
            }
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (!isEmpty(macAddress)) {
                sb.append(macAddress);
                return sb.toString();
            }
            String sb2 = sb.toString();
            openudid = sb2;
            return sb2;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0009: SGET  (r1v3 int A[REMOVE]) =  android.os.Build.VERSION.SDK_INT int)] */
    public static String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Build.VERSION.SDK_INT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static PackageInfo getPackageInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            PackageInfo packageInfo2 = packageInfo;
            if (packageInfo2 != null) {
                return packageInfo2;
            }
            try {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static String getPlatformCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String str = Build.MODEL;
            return str != null ? str : "unknown";
        }
        return (String) invokeV.objValue;
    }

    public static long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? System.currentTimeMillis() / 1000 : invokeV.longValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0009: INVOKE  (r1v3 long A[REMOVE]) =  type: STATIC call: com.baidu.appsearchlib.Util.getTime():long)] */
    public static String getTimeStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getTime());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean isEmpty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? str == null || str.equals("") : invokeL.booleanValue;
    }
}
