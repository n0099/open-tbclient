package com.baidu.live.business.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class NetWorkUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1613327346, "Lcom/baidu/live/business/util/NetWorkUtils$NetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1613327346, "Lcom/baidu/live/business/util/NetWorkUtils$NetType;");
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

    @SuppressLint({"MissingPermission"})
    public static NetworkInfo a(Context context) {
        InterceptResult invokeL;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (SecurityException e2) {
                e2.printStackTrace();
                connectivityManager = null;
            }
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        }
        return (NetworkInfo) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            NetworkInfo a2 = a(context);
            return a2 != null && a2.isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }
}
