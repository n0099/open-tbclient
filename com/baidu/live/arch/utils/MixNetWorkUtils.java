package com.baidu.live.arch.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes2.dex */
public class MixNetWorkUtils {
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
    public static final String TAG = "MixNetWorkUtils";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1944571467, "Lcom/baidu/live/arch/utils/MixNetWorkUtils$NetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1944571467, "Lcom/baidu/live/arch/utils/MixNetWorkUtils$NetType;");
                    return;
                }
            }
            NONE = new NetType(HlsPlaylistParser.METHOD_NONE, 0, "no");
            WIFI = new NetType("WIFI", 1, "wifi");
            _2G = new NetType("_2G", 2, "2g");
            _3G = new NetType("_3G", 3, "3g");
            _4G = new NetType("_4G", 4, "4g");
            _5G = new NetType("_5G", 5, "5g");
            NetType netType = new NetType("UNKOWN", 6, "unknow");
            UNKOWN = netType;
            $VALUES = new NetType[]{NONE, WIFI, _2G, _3G, _4G, _5G, netType};
        }

        public NetType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    public MixNetWorkUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo getActiveNetworkInfo() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        Context application;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                application = getApplication();
            } catch (SecurityException unused) {
                connectivityManager = null;
            }
            if (application == null) {
                return null;
            }
            connectivityManager = (ConnectivityManager) application.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public static Context getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
            if (appInfoService != null) {
                return appInfoService.getApplication();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static String getBSSID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            WifiInfo wifiManager = getWifiManager();
            return wifiManager == null ? "NULL" : wifiManager.getBSSID();
        }
        return (String) invokeV.objValue;
    }

    public static int getIPAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            WifiInfo wifiManager = getWifiManager();
            if (wifiManager == null) {
                return 0;
            }
            return wifiManager.getIpAddress();
        }
        return invokeV.intValue;
    }

    public static String getMobileNetworkType(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65541, null, i, str)) == null) {
            switch (i) {
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

    public static String getNetworkClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? "no" : activeNetworkInfo.getType() == 1 ? "wifi" : activeNetworkInfo.getType() == 0 ? getMobileNetworkType(activeNetworkInfo.getSubtype(), activeNetworkInfo.getSubtypeName()) : "unknown";
        }
        return (String) invokeV.objValue;
    }

    public static int getNetworkId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            WifiInfo wifiManager = getWifiManager();
            if (wifiManager == null) {
                return 0;
            }
            return wifiManager.getNetworkId();
        }
        return invokeV.intValue;
    }

    public static NetType getNetworkType() {
        InterceptResult invokeV;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String networkClass = getNetworkClass();
            int hashCode = networkClass.hashCode();
            if (hashCode == -840472412) {
                if (networkClass.equals("unknow")) {
                    c = 6;
                }
                c = 65535;
            } else if (hashCode == 1653) {
                if (networkClass.equals("2g")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode == 1684) {
                if (networkClass.equals("3g")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode == 1715) {
                if (networkClass.equals("4g")) {
                    c = 2;
                }
                c = 65535;
            } else if (hashCode == 1746) {
                if (networkClass.equals("5g")) {
                    c = 3;
                }
                c = 65535;
            } else if (hashCode != 3521) {
                if (hashCode == 3649301 && networkClass.equals("wifi")) {
                    c = 4;
                }
                c = 65535;
            } else {
                if (networkClass.equals("no")) {
                    c = 5;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c != 4) {
                                if (c != 5) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            WifiInfo wifiManager = getWifiManager();
            return wifiManager == null ? "NULL" : wifiManager.toString();
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static WifiInfo getWifiManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            Context application = getApplication();
            if (application == null) {
                return null;
            }
            return ((WifiManager) application.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        }
        return (WifiInfo) invokeV.objValue;
    }

    public static String getWifiName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            WifiInfo wifiManager = getWifiManager();
            return wifiManager == null ? "NULL" : wifiManager.getSSID();
        }
        return (String) invokeV.objValue;
    }

    public static InetAddress intToInetAddress(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            try {
                return InetAddress.getByAddress(new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)});
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
        return (InetAddress) invokeI.objValue;
    }

    public static boolean isHighNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            String networkClass = getNetworkClass();
            return "wifi".equals(networkClass) || "5g".equals(networkClass) || "4g".equals(networkClass) || "3g".equals(networkClass);
        }
        return invokeV.booleanValue;
    }

    public static boolean isMobileNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return invokeV.booleanValue;
    }

    public static boolean isWifiNetworkConnected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
        }
        return invokeV.booleanValue;
    }
}
