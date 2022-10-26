package com.baidu.swan.game.ad.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes3.dex */
public class NetworkUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public final class NetType {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1681725560, "Lcom/baidu/swan/game/ad/utils/NetworkUtils$NetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1681725560, "Lcom/baidu/swan/game/ad/utils/NetworkUtils$NetType;");
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (NetType) Enum.valueOf(NetType.class, str);
            }
            return (NetType) invokeL.objValue;
        }

        public static NetType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (NetType[]) $VALUES.clone();
            }
            return (NetType[]) invokeV.objValue;
        }
    }

    public static NetworkInfo a(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null || (connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity")) == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            NetworkInfo a = a(AppRuntime.getAppContext());
            if (a != null && a.isConnectedOrConnecting()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            NetworkInfo a = a(AppRuntime.getAppContext());
            if (a != null && a.isAvailable() && a.getType() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, str)) == null) {
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

    public static int c(boolean z) {
        InterceptResult invokeZ;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            String d = d();
            int hashCode = d.hashCode();
            if (hashCode != -284840886) {
                if (hashCode != 1653) {
                    if (hashCode != 1684) {
                        if (hashCode != 1715) {
                            if (hashCode != 1746) {
                                if (hashCode == 3649301 && d.equals("wifi")) {
                                    c = 0;
                                }
                                c = 65535;
                            } else {
                                if (d.equals("5g")) {
                                    c = 4;
                                }
                                c = 65535;
                            }
                        } else {
                            if (d.equals("4g")) {
                                c = 3;
                            }
                            c = 65535;
                        }
                    } else {
                        if (d.equals("3g")) {
                            c = 2;
                        }
                        c = 65535;
                    }
                } else {
                    if (d.equals("2g")) {
                        c = 1;
                    }
                    c = 65535;
                }
            } else {
                if (d.equals("unknown")) {
                    c = 5;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c == 1) {
                    return 2;
                }
                if (c == 2) {
                    return 3;
                }
                if (c == 3) {
                    return 4;
                }
                if (c == 4) {
                    return 5;
                }
                if (c != 5) {
                    return 0;
                }
                return !z ? 1 : 0;
            } else if (z) {
                return 1;
            } else {
                return 100;
            }
        }
        return invokeZ.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            NetworkInfo a = a(AppRuntime.getAppContext());
            if (a != null && a.isConnected()) {
                if (a.getType() == 1) {
                    return "wifi";
                }
                if (a.getType() == 0) {
                    return b(a.getSubtype(), a.getSubtypeName());
                }
                return "unknown";
            }
            return "no";
        }
        return (String) invokeV.objValue;
    }

    public static String e(Context context) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                str = ApiReplaceUtil.getMacAddress(((WifiManager) AppRuntime.getAppContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo());
            } catch (Exception unused) {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
