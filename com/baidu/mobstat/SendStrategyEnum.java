package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class SendStrategyEnum {
    public static /* synthetic */ Interceptable $ic;
    public static final SendStrategyEnum APP_START;
    public static final SendStrategyEnum ONCE_A_DAY;
    public static final SendStrategyEnum SET_TIME_INTERVAL;
    public static final /* synthetic */ SendStrategyEnum[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1124872598, "Lcom/baidu/mobstat/SendStrategyEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1124872598, "Lcom/baidu/mobstat/SendStrategyEnum;");
                return;
            }
        }
        APP_START = new SendStrategyEnum("APP_START", 0);
        ONCE_A_DAY = new SendStrategyEnum("ONCE_A_DAY", 1);
        SendStrategyEnum sendStrategyEnum = new SendStrategyEnum("SET_TIME_INTERVAL", 2);
        SET_TIME_INTERVAL = sendStrategyEnum;
        a = new SendStrategyEnum[]{APP_START, ONCE_A_DAY, sendStrategyEnum};
    }

    public SendStrategyEnum(String str, int i2) {
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

    public static SendStrategyEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SendStrategyEnum) Enum.valueOf(SendStrategyEnum.class, str) : (SendStrategyEnum) invokeL.objValue;
    }

    public static SendStrategyEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SendStrategyEnum[]) a.clone() : (SendStrategyEnum[]) invokeV.objValue;
    }
}
