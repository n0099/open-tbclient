package com.baidu.searchbox.bddownload.core.cause;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class EndCause {
    public static final /* synthetic */ EndCause[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final EndCause ADJUSTMENT;
    public static final EndCause CANCELED;
    public static final EndCause COMPLETED;
    public static final EndCause ERROR;
    public static final EndCause FILE_BUSY;
    public static final EndCause PRE_ALLOCATE_FAILED;
    public static final EndCause SAME_TASK_BUSY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2069012254, "Lcom/baidu/searchbox/bddownload/core/cause/EndCause;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2069012254, "Lcom/baidu/searchbox/bddownload/core/cause/EndCause;");
                return;
            }
        }
        COMPLETED = new EndCause("COMPLETED", 0);
        ERROR = new EndCause("ERROR", 1);
        ADJUSTMENT = new EndCause("ADJUSTMENT", 2);
        CANCELED = new EndCause("CANCELED", 3);
        FILE_BUSY = new EndCause("FILE_BUSY", 4);
        SAME_TASK_BUSY = new EndCause("SAME_TASK_BUSY", 5);
        EndCause endCause = new EndCause("PRE_ALLOCATE_FAILED", 6);
        PRE_ALLOCATE_FAILED = endCause;
        $VALUES = new EndCause[]{COMPLETED, ERROR, ADJUSTMENT, CANCELED, FILE_BUSY, SAME_TASK_BUSY, endCause};
    }

    public EndCause(String str, int i) {
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

    public static EndCause valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EndCause) Enum.valueOf(EndCause.class, str) : (EndCause) invokeL.objValue;
    }

    public static EndCause[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EndCause[]) $VALUES.clone() : (EndCause[]) invokeV.objValue;
    }
}
