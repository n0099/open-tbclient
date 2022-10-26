package com.baidu.searchbox.live.interfaces.pay;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class PayChannelType {
    public static final /* synthetic */ PayChannelType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PayChannelType NUOMI;
    public static final PayChannelType WALLET;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-427211949, "Lcom/baidu/searchbox/live/interfaces/pay/PayChannelType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-427211949, "Lcom/baidu/searchbox/live/interfaces/pay/PayChannelType;");
                return;
            }
        }
        WALLET = new PayChannelType("WALLET", 0);
        PayChannelType payChannelType = new PayChannelType("NUOMI", 1);
        NUOMI = payChannelType;
        $VALUES = new PayChannelType[]{WALLET, payChannelType};
    }

    public PayChannelType(String str, int i) {
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

    public static PayChannelType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PayChannelType) Enum.valueOf(PayChannelType.class, str);
        }
        return (PayChannelType) invokeL.objValue;
    }

    public static PayChannelType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PayChannelType[]) $VALUES.clone();
        }
        return (PayChannelType[]) invokeV.objValue;
    }
}
