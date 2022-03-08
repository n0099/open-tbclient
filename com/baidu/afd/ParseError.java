package com.baidu.afd;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ParseError extends Exception {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_INVALID_DATA = 2;
    public static final int ERROR_INVALID_JSON_ROOT = 1;
    public static final int ERROR_OK = 0;
    public static final ParseError ERROR_SMOOTH_SCROLL;
    public static final int _ERROR_SMOOTH_SCROLL = 4;
    public transient /* synthetic */ FieldHolder $fh;
    public final int errorCode;
    public final String errorMessage;
    public String tplName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-33732184, "Lcom/baidu/afd/ParseError;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-33732184, "Lcom/baidu/afd/ParseError;");
                return;
            }
        }
        ERROR_SMOOTH_SCROLL = new ParseError(4, "");
    }

    public ParseError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tplName = "";
        this.errorCode = i2;
        this.errorMessage = str;
    }
}
