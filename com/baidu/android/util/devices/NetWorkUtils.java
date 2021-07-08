package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.apollon.statistics.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
@Deprecated
/* loaded from: classes.dex */
public class NetWorkUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_5G = "5g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final String TAG = "NetWorkUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class NetType {
        public static final /* synthetic */ NetType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetType NONE;
        public static final NetType UNKOWN;
        public static final NetType WIFI;
        public static final NetType _2G;
        public static final NetType _3G;
        public static final NetType _4G;
        public static final NetType _5G;
        public transient /* synthetic */ FieldHolder $fh;
        public final String type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(674851156, "Lcom/baidu/android/util/devices/NetWorkUtils$NetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(674851156, "Lcom/baidu/android/util/devices/NetWorkUtils$NetType;");
                    return;
                }
            }
            NONE = new NetType("NONE", 0, "no");
            WIFI = new NetType(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1, "wifi");
            _2G = new NetType("_2G", 2, "2g");
            _3G = new NetType("_3G", 3, "3g");
            _4G = new NetType("_4G", 4, "4g");
            _5G = new NetType("_5G", 5, "5g");
            NetType netType = new NetType("UNKOWN", 6, "unknow");
            UNKOWN = netType;
            $VALUES = new NetType[]{NONE, WIFI, _2G, _3G, _4G, _5G, netType};
        }

        public NetType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = str2;
        }

        public static NetType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetType) Enum.valueOf(NetType.class, str) : (NetType) invokeL.objValue;
        }

        public static NetType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetType[]) $VALUES.clone() : (NetType[]) invokeV.objValue;
        }
    }

    public NetWorkUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Deprecated
    public static NetworkInfo getActiveNetworkInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? getActiveNetworkInfo() : (NetworkInfo) invokeL.objValue;
    }

    @Deprecated
    public static String getBSSID(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? getBSSID() : (String) invokeL.objValue;
    }

    @Deprecated
    public static int getIPAddress(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? getIPAddress() : invokeL.intValue;
    }

    @Deprecated
    public static String getMacAddress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? getMacAddress() : (String) invokeL.objValue;
    }

    public static String getMobileNetworkType(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65545, null, i2, str)) == null) {
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2g";
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
                    return "3g";
                case 13:
                case 18:
                case 19:
                    return "4g";
                case 20:
                    return "5g";
                default:
                    return (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) ? "unknown" : "4g";
            }
        }
        return (String) invokeIL.objValue;
    }

    @Deprecated
    public static String getNetworkClass(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? getNetworkClass() : (String) invokeL.objValue;
    }

    @Deprecated
    public static int getNetworkId(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? getNetworkId() : invokeL.intValue;
    }

    @Deprecated
    public static String getNetworkInfo(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? getNetworkInfo() : (String) invokeL.objValue;
    }

    @Deprecated
    public static NetType getNetworkType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? getNetworkType() : (NetType) invokeL.objValue;
    }

    @Deprecated
    public static String getWifiInfo(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? getWifiInfo() : (String) invokeL.objValue;
    }

    @Deprecated
    public static String getWifiName(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) ? getWifiName() : (String) invokeL.objValue;
    }

    public static InetAddress intToInetAddress(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i2)) == null) {
            try {
                return InetAddress.getByAddress(new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)});
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
        return (InetAddress) invokeI.objValue;
    }

    @Deprecated
    public static boolean isHighNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) ? isHighNetworkConnected() : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isMobileNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, context)) == null) ? isMobileNetworkConnected() : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) ? isNetworkConnected() : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isWapNetWorkConnected(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, context)) == null) ? isWapNetWorkConnected() : invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isWifiNetworkConnected(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, context)) == null) ? isWifiNetworkConnected() : invokeL.booleanValue;
    }

    public static NetworkInfo getActiveNetworkInfo() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (AppRuntime.getAppContext() == null) {
                return null;
            }
            try {
                connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
            } catch (SecurityException unused) {
                connectivityManager = null;
            }
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public static String getBSSID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo == null ? "NULL" : connectionInfo.getBSSID();
        }
        return (String) invokeV.objValue;
    }

    public static int getIPAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return 0;
            }
            return connectionInfo.getIpAddress();
        }
        return invokeV.intValue;
    }

    @SuppressLint({"HardwareIds"})
    public static String getMacAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo == null ? "NULL" : connectionInfo.getMacAddress();
        }
        return (String) invokeV.objValue;
    }

    public static String getNetworkClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? "no" : activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getType() == 0 ? getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName()) : "unknown";
        }
        return (String) invokeV.objValue;
    }

    public static int getNetworkId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                return 0;
            }
            return connectionInfo.getNetworkId();
        }
        return invokeV.intValue;
    }

    @Deprecated
    public static String getNetworkInfo() {
        InterceptResult invokeV;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) AppRuntime.getAppContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return "no";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WiFi";
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype != 20) {
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return g.f3986b;
                        case 13:
                            return "4G";
                        default:
                            return "unknown";
                    }
                }
                return "5G";
            }
            return "unknown";
        }
        return (String) invokeV.objValue;
    }

    public static NetType getNetworkType() {
        InterceptResult invokeV;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            String networkClass = getNetworkClass();
            int hashCode = networkClass.hashCode();
            if (hashCode == -840472412) {
                if (networkClass.equals("unknow")) {
                    c2 = 6;
                }
                c2 = 65535;
            } else if (hashCode == 1653) {
                if (networkClass.equals("2g")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode == 1684) {
                if (networkClass.equals("3g")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 1715) {
                if (networkClass.equals("4g")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 1746) {
                if (networkClass.equals("5g")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else if (hashCode != 3521) {
                if (hashCode == 3649301 && networkClass.equals("wifi")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else {
                if (networkClass.equals("no")) {
                    c2 = 5;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 != 4) {
                                if (c2 != 5) {
                                    return NetType.UNKOWN;
                                }
                                return NetType.NONE;
                            }
                            return NetType.WIFI;
                        }
                        return NetType._5G;
                    }
                    return NetType._4G;
                }
                return NetType._3G;
            }
            return NetType._2G;
        }
        return (NetType) invokeV.objValue;
    }

    public static String getWifiInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo == null ? "NULL" : connectionInfo.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String getWifiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            WifiInfo connectionInfo = ((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo == null ? "NULL" : connectionInfo.getSSID();
        }
        return (String) invokeV.objValue;
    }

    public static boolean isHighNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            String networkClass = getNetworkClass();
            return "wifi".equals(networkClass) || "5g".equals(networkClass) || "4g".equals(networkClass) || "3g".equals(networkClass);
        }
        return invokeV.booleanValue;
    }

    public static boolean isMobileNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return invokeV.booleanValue;
    }

    public static boolean isWapNetWorkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) ? new ConnectManager(AppRuntime.getAppContext().getApplicationContext()).isWapNetwork() : invokeV.booleanValue;
    }

    public static boolean isWifiNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
        }
        return invokeV.booleanValue;
    }
}
