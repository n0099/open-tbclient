package com.baidu.searchbox.player.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NetUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final int NET_TYPE_2G = 3;
    public static final int NET_TYPE_3G = 2;
    public static final int NET_TYPE_4G = 1;
    public static final int NET_TYPE_UNKNOWN = 4;
    public static final int NET_TYPE_WIFI = 0;
    public static final String TYPE_3G = "3g";
    public static final String TYPE_WIFI = "wifi";
    public static NetStatus mOldStatus;
    public static NetStatus mStatus;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class NetStatus {
        public static final /* synthetic */ NetStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetStatus NET_DOWN;
        public static final NetStatus NET_MOBILE;
        public static final NetStatus NET_WIFI;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2030751759, "Lcom/baidu/searchbox/player/helper/NetUtils$NetStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2030751759, "Lcom/baidu/searchbox/player/helper/NetUtils$NetStatus;");
                    return;
                }
            }
            NET_DOWN = new NetStatus("NET_DOWN", 0);
            NET_WIFI = new NetStatus("NET_WIFI", 1);
            NetStatus netStatus = new NetStatus("NET_MOBILE", 2);
            NET_MOBILE = netStatus;
            $VALUES = new NetStatus[]{NET_DOWN, NET_WIFI, netStatus};
        }

        public NetStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NetStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetStatus) Enum.valueOf(NetStatus.class, str) : (NetStatus) invokeL.objValue;
        }

        public static NetStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetStatus[]) $VALUES.clone() : (NetStatus[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-102155878, "Lcom/baidu/searchbox/player/helper/NetUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-102155878, "Lcom/baidu/searchbox/player/helper/NetUtils;");
                return;
            }
        }
        NetStatus netStatus = NetStatus.NET_DOWN;
        mOldStatus = netStatus;
        mStatus = netStatus;
    }

    public NetUtils() {
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

    @PublicMethod
    public static String appendCDNStatParams(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("vd1.bdstatic.com") || str.contains("vd2.bdstatic.com") || str.contains("vd3.bdstatic.com") || str.contains("vd4.bdstatic.com")) {
                StringBuilder sb = new StringBuilder(str);
                if (!str.contains("?")) {
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append("pdx=");
                sb.append("0");
                sb.append("&");
                sb.append("nt=");
                sb.append(getNetTypeParams());
                sb.append("&");
                sb.append("dt=");
                sb.append(i2);
                return sb.toString();
            }
            return str;
        }
        return (String) invokeLI.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @PublicMethod
    public static String getMobileNetworkType(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i2, str)) == null) {
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
                    break;
                default:
                    if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("LTE_CA")) {
                        return "unknown";
                    }
                    break;
            }
            return "4g";
        }
        return (String) invokeIL.objValue;
    }

    @PublicMethod
    public static NetStatus getNetStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo != null) {
                if (1 == networkInfo.getType()) {
                    return NetStatus.NET_WIFI;
                }
                return NetStatus.NET_MOBILE;
            }
            return NetStatus.NET_DOWN;
        }
        return (NetStatus) invokeV.objValue;
    }

    public static int getNetTypeParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String networkClass = getNetworkClass();
            if ("wifi".equals(networkClass)) {
                return 0;
            }
            if ("4g".equals(networkClass)) {
                return 1;
            }
            if ("3g".equals(networkClass)) {
                return 2;
            }
            return "2g".equals(networkClass) ? 3 : 4;
        }
        return invokeV.intValue;
    }

    @PublicMethod
    public static String getNetworkClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            NetworkInfo networkInfo = getNetworkInfo();
            return (networkInfo == null || !networkInfo.isConnected()) ? "no" : networkInfo.getType() == 1 ? "wifi" : networkInfo.getType() == 0 ? getMobileNetworkType(networkInfo.getSubtype(), networkInfo.getSubtypeName()) : "unknown";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    @PublicMethod
    public static NetworkInfo getNetworkInfo() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            Context appContext = BDPlayerConfig.getAppContext();
            if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeV.objValue;
    }

    @PublicMethod
    public static boolean isNet3G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return !"wifi".equals(networkInfo.getTypeName().toLowerCase());
        }
        return invokeV.booleanValue;
    }

    @PublicMethod
    public static boolean isNetDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? getNetworkInfo() == null : invokeV.booleanValue;
    }

    @PublicMethod
    public static boolean isNetWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return "wifi".equals(networkInfo.getTypeName().toLowerCase());
        }
        return invokeV.booleanValue;
    }

    public static void setNetStatus(NetStatus netStatus) {
        NetStatus netStatus2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, netStatus) == null) || (netStatus2 = mStatus) == netStatus) {
            return;
        }
        mOldStatus = netStatus2;
        mStatus = netStatus;
    }
}
