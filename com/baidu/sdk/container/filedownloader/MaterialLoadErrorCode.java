package com.baidu.sdk.container.filedownloader;

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
public final class MaterialLoadErrorCode {
    public static final /* synthetic */ MaterialLoadErrorCode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MaterialLoadErrorCode ERROR_CODE_CACHE_ERROR;
    public static final MaterialLoadErrorCode ERROR_CODE_PARSE_ERROR;
    public static final MaterialLoadErrorCode ERROR_CODE_REQUEST_ERROR;
    public static final MaterialLoadErrorCode ERROR_CODE_TYPE_ERROR;
    public static final MaterialLoadErrorCode ERROR_CODE_URL_NULL;
    public static final MaterialLoadErrorCode ERROR_CODE_VIEW_NULL;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;
    public String msg;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1081503008, "Lcom/baidu/sdk/container/filedownloader/MaterialLoadErrorCode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1081503008, "Lcom/baidu/sdk/container/filedownloader/MaterialLoadErrorCode;");
                return;
            }
        }
        ERROR_CODE_REQUEST_ERROR = new MaterialLoadErrorCode("ERROR_CODE_REQUEST_ERROR", 0, 0, "请求异常");
        ERROR_CODE_URL_NULL = new MaterialLoadErrorCode("ERROR_CODE_URL_NULL", 1, 1, "图片url为空");
        ERROR_CODE_VIEW_NULL = new MaterialLoadErrorCode("ERROR_CODE_VIEW_NULL", 2, 2, "图片view为空");
        ERROR_CODE_PARSE_ERROR = new MaterialLoadErrorCode("ERROR_CODE_PARSE_ERROR", 3, 3, "图片获取异常");
        ERROR_CODE_TYPE_ERROR = new MaterialLoadErrorCode("ERROR_CODE_TYPE_ERROR", 4, 4, "图片类型异常，非静态图");
        MaterialLoadErrorCode materialLoadErrorCode = new MaterialLoadErrorCode("ERROR_CODE_CACHE_ERROR", 5, 5, "缓存异常");
        ERROR_CODE_CACHE_ERROR = materialLoadErrorCode;
        $VALUES = new MaterialLoadErrorCode[]{ERROR_CODE_REQUEST_ERROR, ERROR_CODE_URL_NULL, ERROR_CODE_VIEW_NULL, ERROR_CODE_PARSE_ERROR, ERROR_CODE_TYPE_ERROR, materialLoadErrorCode};
    }

    public MaterialLoadErrorCode(String str, int i2, int i3, String str2) {
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

    public static MaterialLoadErrorCode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaterialLoadErrorCode) Enum.valueOf(MaterialLoadErrorCode.class, str) : (MaterialLoadErrorCode) invokeL.objValue;
    }

    public static MaterialLoadErrorCode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaterialLoadErrorCode[]) $VALUES.clone() : (MaterialLoadErrorCode[]) invokeV.objValue;
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
