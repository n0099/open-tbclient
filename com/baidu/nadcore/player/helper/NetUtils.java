package com.baidu.nadcore.player.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.Nullable;
import com.baidu.tieba.ap0;
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
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(980206172, "Lcom/baidu/nadcore/player/helper/NetUtils$NetStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(980206172, "Lcom/baidu/nadcore/player/helper/NetUtils$NetStatus;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(603600935, "Lcom/baidu/nadcore/player/helper/NetUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(603600935, "Lcom/baidu/nadcore/player/helper/NetUtils;");
                return;
            }
        }
        NetStatus netStatus = NetStatus.NET_DOWN;
    }

    public static NetStatus a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            NetworkInfo b = b();
            if (b != null) {
                if (1 == b.getType()) {
                    return NetStatus.NET_WIFI;
                }
                return NetStatus.NET_MOBILE;
            }
            return NetStatus.NET_DOWN;
        }
        return (NetStatus) invokeV.objValue;
    }

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo b() {
        InterceptResult invokeV;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Context b = ap0.b();
            if (b == null || (connectivityManager = (ConnectivityManager) b.getSystemService("connectivity")) == null) {
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

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            NetworkInfo b = b();
            if (b == null) {
                return false;
            }
            return "wifi".equals(b.getTypeName().toLowerCase(Locale.getDefault()));
        }
        return invokeV.booleanValue;
    }
}
