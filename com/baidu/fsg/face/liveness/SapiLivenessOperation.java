package com.baidu.fsg.face.liveness;

import com.baidu.fsg.face.base.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SapiLivenessOperation implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OperationType operationType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class OperationType {
        public static final /* synthetic */ OperationType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OperationType RECOGNIZE;
        public static final OperationType VIDEORECOG;
        public transient /* synthetic */ FieldHolder $fh;
        public String name;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1317203486, "Lcom/baidu/fsg/face/liveness/SapiLivenessOperation$OperationType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1317203486, "Lcom/baidu/fsg/face/liveness/SapiLivenessOperation$OperationType;");
                    return;
                }
            }
            RECOGNIZE = new OperationType("RECOGNIZE", 0, "RECOGNIZE");
            OperationType operationType = new OperationType("VIDEORECOG", 1, "VIDEOREOCG");
            VIDEORECOG = operationType;
            $VALUES = new OperationType[]{RECOGNIZE, operationType};
        }

        public OperationType(String str, int i2, String str2) {
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
            this.name = str2;
        }

        public static OperationType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OperationType) Enum.valueOf(OperationType.class, str) : (OperationType) invokeL.objValue;
        }

        public static OperationType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OperationType[]) $VALUES.clone() : (OperationType[]) invokeV.objValue;
        }
    }

    public SapiLivenessOperation() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
