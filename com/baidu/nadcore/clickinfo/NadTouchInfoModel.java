package com.baidu.nadcore.clickinfo;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class NadTouchInfoModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class CRCErrorCode {
        public static final /* synthetic */ CRCErrorCode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CRCErrorCode NO_IM_TIME_SIGN;
        public static final CRCErrorCode NO_OUT_PATTERN_MATCHER;
        public transient /* synthetic */ FieldHolder $fh;
        public int errorType;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-429203235, "Lcom/baidu/nadcore/clickinfo/NadTouchInfoModel$CRCErrorCode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-429203235, "Lcom/baidu/nadcore/clickinfo/NadTouchInfoModel$CRCErrorCode;");
                    return;
                }
            }
            NO_IM_TIME_SIGN = new CRCErrorCode("NO_IM_TIME_SIGN", 0, -1);
            CRCErrorCode cRCErrorCode = new CRCErrorCode("NO_OUT_PATTERN_MATCHER", 1, -2);
            NO_OUT_PATTERN_MATCHER = cRCErrorCode;
            $VALUES = new CRCErrorCode[]{NO_IM_TIME_SIGN, cRCErrorCode};
        }

        public CRCErrorCode(String str, int i, int i2) {
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
            this.errorType = i2;
        }

        public static CRCErrorCode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (CRCErrorCode) Enum.valueOf(CRCErrorCode.class, str);
            }
            return (CRCErrorCode) invokeL.objValue;
        }

        public static CRCErrorCode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (CRCErrorCode[]) $VALUES.clone();
            }
            return (CRCErrorCode[]) invokeV.objValue;
        }

        public int getErrorType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.errorType;
            }
            return invokeV.intValue;
        }
    }

    public NadTouchInfoModel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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
