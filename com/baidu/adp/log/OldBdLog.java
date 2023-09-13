package com.baidu.adp.log;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class OldBdLog {
    public static final /* synthetic */ OldBdLog[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final OldBdLog INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbLog instance;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-34751099, "Lcom/baidu/adp/log/OldBdLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-34751099, "Lcom/baidu/adp/log/OldBdLog;");
                return;
            }
        }
        OldBdLog oldBdLog = new OldBdLog("INSTANCE", 0);
        INSTANCE = oldBdLog;
        $VALUES = new OldBdLog[]{oldBdLog};
    }

    public static TbLog getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return INSTANCE.instance;
        }
        return (TbLog) invokeV.objValue;
    }

    public static OldBdLog[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (OldBdLog[]) $VALUES.clone();
        }
        return (OldBdLog[]) invokeV.objValue;
    }

    public OldBdLog(String str, int i) {
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
                return;
            }
        }
        this.instance = new TbLog("bdLog");
    }

    public static OldBdLog valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (OldBdLog) Enum.valueOf(OldBdLog.class, str);
        }
        return (OldBdLog) invokeL.objValue;
    }
}
