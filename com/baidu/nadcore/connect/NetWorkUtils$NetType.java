package com.baidu.nadcore.connect;

import com.baidu.poly.widget.PolyActivity;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class NetWorkUtils$NetType {
    public static final /* synthetic */ NetWorkUtils$NetType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NetWorkUtils$NetType NONE;
    public static final NetWorkUtils$NetType UNKOWN;
    public static final NetWorkUtils$NetType WIFI;
    public static final NetWorkUtils$NetType _2G;
    public static final NetWorkUtils$NetType _3G;
    public static final NetWorkUtils$NetType _4G;
    public static final NetWorkUtils$NetType _5G;
    public transient /* synthetic */ FieldHolder $fh;
    public final String type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1749081555, "Lcom/baidu/nadcore/connect/NetWorkUtils$NetType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1749081555, "Lcom/baidu/nadcore/connect/NetWorkUtils$NetType;");
                return;
            }
        }
        NONE = new NetWorkUtils$NetType(PolyActivity.NONE_PANEL_TYPE, 0, "no");
        WIFI = new NetWorkUtils$NetType(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1, "wifi");
        _2G = new NetWorkUtils$NetType("_2G", 2, "2g");
        _3G = new NetWorkUtils$NetType("_3G", 3, "3g");
        _4G = new NetWorkUtils$NetType("_4G", 4, "4g");
        _5G = new NetWorkUtils$NetType("_5G", 5, "5g");
        NetWorkUtils$NetType netWorkUtils$NetType = new NetWorkUtils$NetType("UNKOWN", 6, "unknow");
        UNKOWN = netWorkUtils$NetType;
        $VALUES = new NetWorkUtils$NetType[]{NONE, WIFI, _2G, _3G, _4G, _5G, netWorkUtils$NetType};
    }

    public NetWorkUtils$NetType(String str, int i2, String str2) {
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

    public static NetWorkUtils$NetType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetWorkUtils$NetType) Enum.valueOf(NetWorkUtils$NetType.class, str) : (NetWorkUtils$NetType) invokeL.objValue;
    }

    public static NetWorkUtils$NetType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetWorkUtils$NetType[]) $VALUES.clone() : (NetWorkUtils$NetType[]) invokeV.objValue;
    }
}
