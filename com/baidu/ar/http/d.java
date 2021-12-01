package com.baidu.ar.http;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static String MULTIPART_BOUNDARY;
    public static final Charset qO;
    public static String[] qP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(19863790, "Lcom/baidu/ar/http/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(19863790, "Lcom/baidu/ar/http/d;");
                return;
            }
        }
        qO = StandardCharsets.UTF_8;
        MULTIPART_BOUNDARY = "------baiduARFormBoundary--";
        qP = new String[]{"accept:*/*", "connection:Keep-Alive"};
    }
}
