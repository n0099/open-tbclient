package com.baidu.swan.apps.core.launchtips.monitor.network;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes11.dex */
public final class NetworkStatus {
    public static final /* synthetic */ NetworkStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NetworkStatus NETWORK_BAD;
    public static final NetworkStatus NETWORK_GOOD;
    public static final NetworkStatus NETWORK_OFFLINE;
    public static final NetworkStatus NETWORK_UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mDesc;
    public final int mQuality;
    public final String mStatus;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-78004622, "Lcom/baidu/swan/apps/core/launchtips/monitor/network/NetworkStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-78004622, "Lcom/baidu/swan/apps/core/launchtips/monitor/network/NetworkStatus;");
                return;
            }
        }
        NETWORK_GOOD = new NetworkStatus("NETWORK_GOOD", 0, 1, "good", "网络：正常；");
        NETWORK_BAD = new NetworkStatus("NETWORK_BAD", 1, 2, "bad", "网络：弱网；");
        NETWORK_OFFLINE = new NetworkStatus("NETWORK_OFFLINE", 2, 3, "offline", "网络：离线；");
        NetworkStatus networkStatus = new NetworkStatus("NETWORK_UNKNOWN", 3, -1, "unknown", "网络：未知；");
        NETWORK_UNKNOWN = networkStatus;
        $VALUES = new NetworkStatus[]{NETWORK_GOOD, NETWORK_BAD, NETWORK_OFFLINE, networkStatus};
    }

    public NetworkStatus(String str, int i2, int i3, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str4 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mQuality = i3;
        this.mStatus = str2;
        this.mDesc = str3;
    }

    public static NetworkStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetworkStatus) Enum.valueOf(NetworkStatus.class, str) : (NetworkStatus) invokeL.objValue;
    }

    public static NetworkStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetworkStatus[]) $VALUES.clone() : (NetworkStatus[]) invokeV.objValue;
    }

    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDesc : (String) invokeV.objValue;
    }

    public int getQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mQuality : invokeV.intValue;
    }

    public String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mStatus : (String) invokeV.objValue;
    }
}
