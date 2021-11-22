package com.baidu.swan.apps.core.launchtips.monitor.request;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class RequestStatus {
    public static final /* synthetic */ RequestStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RequestStatus STATUS_CORE_FAILED;
    public static final RequestStatus STATUS_FAILED;
    public static final RequestStatus STATUS_SEND;
    public static final RequestStatus STATUS_SERVER_FAILED;
    public static final RequestStatus STATUS_SLOW;
    public static final RequestStatus STATUS_SUCCESS;
    public static final RequestStatus STATUS_UNKNOWN;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mStatus;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1261936752, "Lcom/baidu/swan/apps/core/launchtips/monitor/request/RequestStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1261936752, "Lcom/baidu/swan/apps/core/launchtips/monitor/request/RequestStatus;");
                return;
            }
        }
        STATUS_SEND = new RequestStatus("STATUS_SEND", 0, "send");
        STATUS_SUCCESS = new RequestStatus("STATUS_SUCCESS", 1, NewBindCardEntry.BING_CARD_SUCCESS_MSG);
        STATUS_FAILED = new RequestStatus("STATUS_FAILED", 2, "failRate");
        STATUS_UNKNOWN = new RequestStatus("STATUS_UNKNOWN", 3, "unknown");
        STATUS_SLOW = new RequestStatus("STATUS_SLOW", 4, "slow");
        STATUS_CORE_FAILED = new RequestStatus("STATUS_CORE_FAILED", 5, "coreFail");
        RequestStatus requestStatus = new RequestStatus("STATUS_SERVER_FAILED", 6, "serverRate");
        STATUS_SERVER_FAILED = requestStatus;
        $VALUES = new RequestStatus[]{STATUS_SEND, STATUS_SUCCESS, STATUS_FAILED, STATUS_UNKNOWN, STATUS_SLOW, STATUS_CORE_FAILED, requestStatus};
    }

    public RequestStatus(String str, int i2, String str2) {
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
        this.mStatus = str2;
    }

    public static RequestStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RequestStatus) Enum.valueOf(RequestStatus.class, str) : (RequestStatus) invokeL.objValue;
    }

    public static RequestStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RequestStatus[]) $VALUES.clone() : (RequestStatus[]) invokeV.objValue;
    }

    public String getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mStatus : (String) invokeV.objValue;
    }
}
