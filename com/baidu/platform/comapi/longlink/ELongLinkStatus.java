package com.baidu.platform.comapi.longlink;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class ELongLinkStatus {
    public static final /* synthetic */ ELongLinkStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ELongLinkStatus CloudRestart;
    public static final ELongLinkStatus CloudStop;
    public static final ELongLinkStatus OK;
    public static final ELongLinkStatus ResultConnectError;
    public static final ELongLinkStatus ResultSendError;
    public static final ELongLinkStatus ResultServerError;
    public static final ELongLinkStatus ResultTimeout;
    public static final ELongLinkStatus SendDataLenLimited;
    public static final ELongLinkStatus SendFormatError;
    public static final ELongLinkStatus SendInvalidReqID;
    public static final ELongLinkStatus SendLimited;
    public static final ELongLinkStatus SendUnRegistered;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1657080897, "Lcom/baidu/platform/comapi/longlink/ELongLinkStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1657080897, "Lcom/baidu/platform/comapi/longlink/ELongLinkStatus;");
                return;
            }
        }
        ELongLinkStatus eLongLinkStatus = new ELongLinkStatus("OK", 0, 0);
        OK = eLongLinkStatus;
        SendFormatError = new ELongLinkStatus("SendFormatError", 1, eLongLinkStatus.getStatusCode() + 1);
        SendUnRegistered = new ELongLinkStatus("SendUnRegistered", 2, OK.getStatusCode() + 2);
        SendLimited = new ELongLinkStatus("SendLimited", 3, OK.getStatusCode() + 3);
        SendDataLenLimited = new ELongLinkStatus("SendDataLenLimited", 4, OK.getStatusCode() + 4);
        SendInvalidReqID = new ELongLinkStatus("SendInvalidReqID", 5, OK.getStatusCode() + 5);
        ResultConnectError = new ELongLinkStatus("ResultConnectError", 6, OK.getStatusCode() + 6);
        ResultSendError = new ELongLinkStatus("ResultSendError", 7, OK.getStatusCode() + 7);
        ResultTimeout = new ELongLinkStatus("ResultTimeout", 8, OK.getStatusCode() + 8);
        ResultServerError = new ELongLinkStatus("ResultServerError", 9, OK.getStatusCode() + 9);
        CloudStop = new ELongLinkStatus("CloudStop", 10, OK.getStatusCode() + 10);
        ELongLinkStatus eLongLinkStatus2 = new ELongLinkStatus("CloudRestart", 11, OK.getStatusCode() + 11);
        CloudRestart = eLongLinkStatus2;
        $VALUES = new ELongLinkStatus[]{OK, SendFormatError, SendUnRegistered, SendLimited, SendDataLenLimited, SendInvalidReqID, ResultConnectError, ResultSendError, ResultTimeout, ResultServerError, CloudStop, eLongLinkStatus2};
    }

    public ELongLinkStatus(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
    }

    public static ELongLinkStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ELongLinkStatus) Enum.valueOf(ELongLinkStatus.class, str);
        }
        return (ELongLinkStatus) invokeL.objValue;
    }

    public void setRequestId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = i;
        }
    }

    public static ELongLinkStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ELongLinkStatus[]) $VALUES.clone();
        }
        return (ELongLinkStatus[]) invokeV.objValue;
    }

    public int getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int getStatusCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }
}
