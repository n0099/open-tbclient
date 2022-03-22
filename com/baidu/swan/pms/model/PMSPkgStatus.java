package com.baidu.swan.pms.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class PMSPkgStatus {
    public static final /* synthetic */ PMSPkgStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PMSPkgStatus ERROR;
    public static final PMSPkgStatus FINISH;
    public static final PMSPkgStatus WAIT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1815927964, "Lcom/baidu/swan/pms/model/PMSPkgStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1815927964, "Lcom/baidu/swan/pms/model/PMSPkgStatus;");
                return;
            }
        }
        WAIT = new PMSPkgStatus("WAIT", 0);
        FINISH = new PMSPkgStatus("FINISH", 1);
        PMSPkgStatus pMSPkgStatus = new PMSPkgStatus("ERROR", 2);
        ERROR = pMSPkgStatus;
        $VALUES = new PMSPkgStatus[]{WAIT, FINISH, pMSPkgStatus};
    }

    public PMSPkgStatus(String str, int i) {
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

    public static PMSPkgStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PMSPkgStatus) Enum.valueOf(PMSPkgStatus.class, str) : (PMSPkgStatus) invokeL.objValue;
    }

    public static PMSPkgStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PMSPkgStatus[]) $VALUES.clone() : (PMSPkgStatus[]) invokeV.objValue;
    }
}
