package com.baidu.im.liteubc.utils;

import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class NetworkUtils$NetType {
    public static final /* synthetic */ NetworkUtils$NetType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NetworkUtils$NetType NONE;
    public static final NetworkUtils$NetType UNKOWN;
    public static final NetworkUtils$NetType WIFI;
    public static final NetworkUtils$NetType _2G;
    public static final NetworkUtils$NetType _3G;
    public static final NetworkUtils$NetType _4G;
    public static final NetworkUtils$NetType _5G;
    public transient /* synthetic */ FieldHolder $fh;
    public final String type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-744665661, "Lcom/baidu/im/liteubc/utils/NetworkUtils$NetType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-744665661, "Lcom/baidu/im/liteubc/utils/NetworkUtils$NetType;");
                return;
            }
        }
        NONE = new NetworkUtils$NetType(HlsPlaylistParser.METHOD_NONE, 0, "no");
        WIFI = new NetworkUtils$NetType("WIFI", 1, "wifi");
        _2G = new NetworkUtils$NetType("_2G", 2, "2g");
        _3G = new NetworkUtils$NetType("_3G", 3, "3g");
        _4G = new NetworkUtils$NetType("_4G", 4, "4g");
        _5G = new NetworkUtils$NetType("_5G", 5, "5g");
        NetworkUtils$NetType networkUtils$NetType = new NetworkUtils$NetType("UNKOWN", 6, DownloadStatisticConstants.UBC_VALUE_UNKNOW);
        UNKOWN = networkUtils$NetType;
        $VALUES = new NetworkUtils$NetType[]{NONE, WIFI, _2G, _3G, _4G, _5G, networkUtils$NetType};
    }

    public NetworkUtils$NetType(String str, int i, String str2) {
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

    public static NetworkUtils$NetType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (NetworkUtils$NetType) Enum.valueOf(NetworkUtils$NetType.class, str);
        }
        return (NetworkUtils$NetType) invokeL.objValue;
    }

    public static NetworkUtils$NetType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (NetworkUtils$NetType[]) $VALUES.clone();
        }
        return (NetworkUtils$NetType[]) invokeV.objValue;
    }
}
