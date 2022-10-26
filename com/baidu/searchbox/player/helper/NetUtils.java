package com.baidu.searchbox.player.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes2.dex */
public class NetUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NETWORK_TYPE_CELL_2G = "2g";
    public static final String NETWORK_TYPE_CELL_3G = "3g";
    public static final String NETWORK_TYPE_CELL_4G = "4g";
    public static final String NETWORK_TYPE_CELL_5G = "5g";
    public static final String NETWORK_TYPE_CELL_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_CELL_UN_CONNECTED = "no";
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final int NET_TYPE_2G = 3;
    public static final int NET_TYPE_3G = 2;
    public static final int NET_TYPE_4G = 1;
    public static final int NET_TYPE_5G = 5;
    public static final int NET_TYPE_UNKNOWN = 4;
    public static final int NET_TYPE_WIFI = 0;
    public static final String TYPE_3G = "3g";
    public static final String TYPE_WIFI = "wifi";
    public static NetStatus mOldStatus;
    public static NetStatus mStatus;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public final class NetStatus {
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

        public NetStatus(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (NetStatus) Enum.valueOf(NetStatus.class, str);
            }
            return (NetStatus) invokeL.objValue;
        }

        public static NetStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (NetStatus[]) $VALUES.clone();
            }
            return (NetStatus[]) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static NetStatus getNetStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
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

    public static NetworkInfo getNetworkInfo() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            Context appContext = BDPlayerConfig.getAppContext();
            if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
                return null;
            }
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public static boolean isNet3G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return !"wifi".equals(networkInfo.getTypeName().toLowerCase(Locale.getDefault()));
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetDown() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (getNetworkInfo() == null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            return "wifi".equals(networkInfo.getTypeName().toLowerCase(Locale.getDefault()));
        }
        return invokeV.booleanValue;
    }

    public static String appendCDNStatParams(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, null, str, i, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (!str.contains("vd1.bdstatic.com") && !str.contains("vd2.bdstatic.com") && !str.contains("vd3.bdstatic.com") && !str.contains("vd4.bdstatic.com") && !VideoAsyncHostHelper.isVideoUrlNeedAsyncRequest(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("pdx=")) {
                int indexOf = sb.indexOf("pdx=");
                if (indexOf >= 0) {
                    int i2 = indexOf + 4;
                    sb.replace(i2, getNumEndIndex(sb.toString(), i2), "0");
                }
                int indexOf2 = sb.indexOf("nt=");
                if (indexOf2 >= 0) {
                    int i3 = indexOf2 + 3;
                    sb.replace(i3, getNumEndIndex(sb.toString(), i3), String.valueOf(getNetTypeParams()));
                }
                int indexOf3 = sb.indexOf("dt=");
                if (indexOf3 >= 0) {
                    int i4 = indexOf3 + 3;
                    sb.replace(i4, getNumEndIndex(sb.toString(), i4), String.valueOf(i));
                }
                int indexOf4 = sb.indexOf("ds_stc=");
                if (indexOf4 >= 0) {
                    int i5 = indexOf4 + 7;
                    sb.replace(i5, findParamEndIndex(sb.toString(), i5), String.valueOf(str2));
                }
            } else {
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
                sb.append(i);
                sb.append("&");
                sb.append("ds_stc=");
                sb.append(str2);
            }
            return sb.toString();
        }
        return (String) invokeLIL.objValue;
    }

    public static int findParamEndIndex(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            int i2 = i;
            while (i < str.length() && !"&".equals(String.valueOf(str.charAt(i)))) {
                i2++;
                i++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static int getNumEndIndex(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, str, i)) == null) {
            int i2 = i;
            while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                i2++;
                i++;
            }
            return i2;
        }
        return invokeLI.intValue;
    }

    public static String getMobileNetworkType(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, str)) == null) {
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
                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("LTE_CA")) {
                        return "4g";
                    }
                    return "unknown";
            }
        }
        return (String) invokeIL.objValue;
    }

    public static int getNetTypeParams() {
        InterceptResult invokeV;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String networkClass = getNetworkClass();
            int hashCode = networkClass.hashCode();
            if (hashCode != 1653) {
                if (hashCode != 1684) {
                    if (hashCode != 1715) {
                        if (hashCode != 1746) {
                            if (hashCode == 3649301 && networkClass.equals("wifi")) {
                                c = 0;
                            }
                            c = 65535;
                        } else {
                            if (networkClass.equals("5g")) {
                                c = 4;
                            }
                            c = 65535;
                        }
                    } else {
                        if (networkClass.equals("4g")) {
                            c = 1;
                        }
                        c = 65535;
                    }
                } else {
                    if (networkClass.equals("3g")) {
                        c = 2;
                    }
                    c = 65535;
                }
            } else {
                if (networkClass.equals("2g")) {
                    c = 3;
                }
                c = 65535;
            }
            if (c == 0) {
                return 0;
            }
            if (c == 1) {
                return 1;
            }
            if (c == 2) {
                return 2;
            }
            if (c == 3) {
                return 3;
            }
            if (c != 4) {
                return 4;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public static String getNetworkClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            NetworkInfo networkInfo = getNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                if (networkInfo.getType() == 1) {
                    return "wifi";
                }
                if (networkInfo.getType() == 0) {
                    return getMobileNetworkType(networkInfo.getSubtype(), networkInfo.getSubtypeName());
                }
                return "unknown";
            }
            return "no";
        }
        return (String) invokeV.objValue;
    }

    public static void setNetStatus(NetStatus netStatus) {
        NetStatus netStatus2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, netStatus) == null) && (netStatus2 = mStatus) != netStatus) {
            mOldStatus = netStatus2;
            mStatus = netStatus;
        }
    }
}
