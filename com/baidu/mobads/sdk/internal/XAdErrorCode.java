package com.baidu.mobads.sdk.internal;

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
public final class XAdErrorCode {
    public static final /* synthetic */ XAdErrorCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_CODE_MESSAGE = "msg";
    public static final XAdErrorCode INTERFACE_USE_PROBLEM;
    public static final XAdErrorCode SHOW_STANDARD_UNFIT;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;
    public String msg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-241145899, "Lcom/baidu/mobads/sdk/internal/XAdErrorCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-241145899, "Lcom/baidu/mobads/sdk/internal/XAdErrorCode;");
                return;
            }
        }
        INTERFACE_USE_PROBLEM = new XAdErrorCode("INTERFACE_USE_PROBLEM", 0, 1010001, "接口使用问题");
        XAdErrorCode xAdErrorCode = new XAdErrorCode("SHOW_STANDARD_UNFIT", 1, 3040001, "容器大小不达标");
        SHOW_STANDARD_UNFIT = xAdErrorCode;
        $VALUES = new XAdErrorCode[]{INTERFACE_USE_PROBLEM, xAdErrorCode};
    }

    public XAdErrorCode(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i3;
        this.msg = str2;
    }

    public static XAdErrorCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (XAdErrorCode) Enum.valueOf(XAdErrorCode.class, str) : (XAdErrorCode) invokeL.objValue;
    }

    public static XAdErrorCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (XAdErrorCode[]) $VALUES.clone() : (XAdErrorCode[]) invokeV.objValue;
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
    }

    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msg : (String) invokeV.objValue;
    }
}
