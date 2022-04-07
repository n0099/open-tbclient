package com.baidu.live.asynctask;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class BdAsyncTaskParallelType {
    public static final /* synthetic */ BdAsyncTaskParallelType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BdAsyncTaskParallelType CUSTOM_PARALLEL;
    public static final BdAsyncTaskParallelType FOUR_PARALLEL;
    public static final BdAsyncTaskParallelType MAX_PARALLEL;
    public static final BdAsyncTaskParallelType SERIAL;
    public static final BdAsyncTaskParallelType THREE_PARALLEL;
    public static final BdAsyncTaskParallelType TWO_PARALLEL;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(681936478, "Lcom/baidu/live/asynctask/BdAsyncTaskParallelType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(681936478, "Lcom/baidu/live/asynctask/BdAsyncTaskParallelType;");
                return;
            }
        }
        SERIAL = new BdAsyncTaskParallelType("SERIAL", 0);
        TWO_PARALLEL = new BdAsyncTaskParallelType("TWO_PARALLEL", 1);
        THREE_PARALLEL = new BdAsyncTaskParallelType("THREE_PARALLEL", 2);
        FOUR_PARALLEL = new BdAsyncTaskParallelType("FOUR_PARALLEL", 3);
        CUSTOM_PARALLEL = new BdAsyncTaskParallelType("CUSTOM_PARALLEL", 4);
        BdAsyncTaskParallelType bdAsyncTaskParallelType = new BdAsyncTaskParallelType("MAX_PARALLEL", 5);
        MAX_PARALLEL = bdAsyncTaskParallelType;
        $VALUES = new BdAsyncTaskParallelType[]{SERIAL, TWO_PARALLEL, THREE_PARALLEL, FOUR_PARALLEL, CUSTOM_PARALLEL, bdAsyncTaskParallelType};
    }

    public BdAsyncTaskParallelType(String str, int i) {
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

    public static BdAsyncTaskParallelType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BdAsyncTaskParallelType) Enum.valueOf(BdAsyncTaskParallelType.class, str) : (BdAsyncTaskParallelType) invokeL.objValue;
    }

    public static BdAsyncTaskParallelType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BdAsyncTaskParallelType[]) $VALUES.clone() : (BdAsyncTaskParallelType[]) invokeV.objValue;
    }
}
