package com.baidu.searchbox.ai;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class AlgorithmType {
    public static final /* synthetic */ AlgorithmType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AlgorithmType GBDT_CLASSIFIER;
    public static final AlgorithmType GBDT_REGRESSOR;
    public static final AlgorithmType GLM_CLASSIFIER;
    public static final AlgorithmType GLM_REGRESSOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1685026241, "Lcom/baidu/searchbox/ai/AlgorithmType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1685026241, "Lcom/baidu/searchbox/ai/AlgorithmType;");
                return;
            }
        }
        GBDT_REGRESSOR = new AlgorithmType("GBDT_REGRESSOR", 0, 1);
        GBDT_CLASSIFIER = new AlgorithmType("GBDT_CLASSIFIER", 1, 2);
        GLM_REGRESSOR = new AlgorithmType("GLM_REGRESSOR", 2, 3);
        AlgorithmType algorithmType = new AlgorithmType("GLM_CLASSIFIER", 3, 4);
        GLM_CLASSIFIER = algorithmType;
        $VALUES = new AlgorithmType[]{GBDT_REGRESSOR, GBDT_CLASSIFIER, GLM_REGRESSOR, algorithmType};
    }

    public AlgorithmType(String str, int i, int i2) {
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
        this.value = i2;
    }

    public static AlgorithmType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AlgorithmType) Enum.valueOf(AlgorithmType.class, str) : (AlgorithmType) invokeL.objValue;
    }

    public static AlgorithmType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AlgorithmType[]) $VALUES.clone() : (AlgorithmType[]) invokeV.objValue;
    }

    public int value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
