package com.baidu.nadcore.player.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.b0.b;
import c.a.b0.e.a;
import c.a.b0.h0.t;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes8.dex */
public class BdNetUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948085979, "Lcom/baidu/nadcore/player/utils/BdNetUtils$NetStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1948085979, "Lcom/baidu/nadcore/player/utils/BdNetUtils$NetStatus;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-190732442, "Lcom/baidu/nadcore/player/utils/BdNetUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-190732442, "Lcom/baidu/nadcore/player/utils/BdNetUtils;");
                return;
            }
        }
        NetStatus netStatus = NetStatus.NET_DOWN;
    }

    public static NetStatus a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            NetworkInfo b2 = b();
            if (b2 == null) {
                return NetStatus.NET_DOWN;
            }
            if (1 == b2.getType()) {
                return NetStatus.NET_WIFI;
            }
            return NetStatus.NET_MOBILE;
        }
        return (NetStatus) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return ((ConnectivityManager) a.b().getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception unused) {
                return null;
            }
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            NetworkInfo b2 = b();
            if (b2 == null) {
                return false;
            }
            return !"wifi".equals(b2.getTypeName().toLowerCase(Locale.getDefault()));
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? b() == null : invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? b() != null : invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            NetworkInfo b2 = b();
            if (b2 == null) {
                return false;
            }
            return "wifi".equals(b2.getTypeName().toLowerCase(Locale.getDefault()));
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c() || g() : invokeV.booleanValue;
    }

    public static void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            StringBuilder sb = new StringBuilder(context.getString(t.nad_player_message_network_3g));
            if (!TextUtils.isEmpty(str)) {
                sb.append("，\n");
                sb.append(context.getString(t.nad_video_net_tip_size_toast));
                sb.append(str);
                sb.append("MB");
            }
            b.a().a(context, sb.toString());
        }
    }
}
