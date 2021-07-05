package com.baidu.searchbox.v8engine;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class JSExceptionType {
    public static final /* synthetic */ JSExceptionType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final JSExceptionType Error;
    public static final JSExceptionType RangeError;
    public static final JSExceptionType ReferenceError;
    public static final JSExceptionType SyntaxError;
    public static final JSExceptionType TypeError;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1920482444, "Lcom/baidu/searchbox/v8engine/JSExceptionType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1920482444, "Lcom/baidu/searchbox/v8engine/JSExceptionType;");
                return;
            }
        }
        RangeError = new JSExceptionType(V8ExceptionInfo.V8_EXCEPTION_RANGE_ERROR, 0);
        ReferenceError = new JSExceptionType(V8ExceptionInfo.V8_EXCEPTION_REFERENCE_ERROR, 1);
        SyntaxError = new JSExceptionType(V8ExceptionInfo.V8_EXCEPTION_SYNTAX_ERROR, 2);
        TypeError = new JSExceptionType(V8ExceptionInfo.V8_EXCEPTION_TYPE_ERROR, 3);
        JSExceptionType jSExceptionType = new JSExceptionType(V8ExceptionInfo.V8_EXCEPTION_ERROR, 4);
        Error = jSExceptionType;
        $VALUES = new JSExceptionType[]{RangeError, ReferenceError, SyntaxError, TypeError, jSExceptionType};
    }

    public JSExceptionType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static JSExceptionType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (JSExceptionType) Enum.valueOf(JSExceptionType.class, str) : (JSExceptionType) invokeL.objValue;
    }

    public static JSExceptionType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (JSExceptionType[]) $VALUES.clone() : (JSExceptionType[]) invokeV.objValue;
    }
}
