package com.baidu.nadcore.net.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes2.dex */
public class NetUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class NetworkStateEnum {
        public static final /* synthetic */ NetworkStateEnum[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetworkStateEnum NO;
        public static final NetworkStateEnum UNKNOWN;
        public static final NetworkStateEnum WIFI;
        public static final NetworkStateEnum _2G;
        public static final NetworkStateEnum _3G;
        public static final NetworkStateEnum _4G;
        public static final NetworkStateEnum _5G;
        public transient /* synthetic */ FieldHolder $fh;
        public final String name;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1677051292, "Lcom/baidu/nadcore/net/util/NetUtil$NetworkStateEnum;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1677051292, "Lcom/baidu/nadcore/net/util/NetUtil$NetworkStateEnum;");
                    return;
                }
            }
            NO = new NetworkStateEnum(HlsPlaylistParser.BOOLEAN_FALSE, 0, "no");
            WIFI = new NetworkStateEnum(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1, "wifi");
            _2G = new NetworkStateEnum("_2G", 2, "2g");
            _3G = new NetworkStateEnum("_3G", 3, "3g");
            _4G = new NetworkStateEnum("_4G", 4, "4g");
            _5G = new NetworkStateEnum("_5G", 5, "5g");
            NetworkStateEnum networkStateEnum = new NetworkStateEnum(RomUtils.UNKNOWN, 6, "unknown");
            UNKNOWN = networkStateEnum;
            $VALUES = new NetworkStateEnum[]{NO, WIFI, _2G, _3G, _4G, _5G, networkStateEnum};
        }

        public NetworkStateEnum(String str, int i, String str2) {
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
            this.name = str2;
        }

        public static NetworkStateEnum valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetworkStateEnum) Enum.valueOf(NetworkStateEnum.class, str) : (NetworkStateEnum) invokeL.objValue;
        }

        public static NetworkStateEnum[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetworkStateEnum[]) $VALUES.clone() : (NetworkStateEnum[]) invokeV.objValue;
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }
}
