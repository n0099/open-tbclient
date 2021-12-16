package com.baidu.apollon.restnet.http;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes9.dex */
public abstract class HttpDefines {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class HttpMethod {
        public static final /* synthetic */ HttpMethod[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HttpMethod DELETE;
        public static final HttpMethod GET;
        public static final HttpMethod HEAD;
        public static final HttpMethod OPTIONS;
        public static final HttpMethod POST;
        public static final HttpMethod PUT;
        public static final HttpMethod TRACE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1368726139, "Lcom/baidu/apollon/restnet/http/HttpDefines$HttpMethod;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1368726139, "Lcom/baidu/apollon/restnet/http/HttpDefines$HttpMethod;");
                    return;
                }
            }
            GET = new HttpMethod("GET", 0);
            POST = new HttpMethod("POST", 1);
            HEAD = new HttpMethod("HEAD", 2);
            OPTIONS = new HttpMethod(HttpOptions.METHOD_NAME, 3);
            PUT = new HttpMethod(HttpPut.METHOD_NAME, 4);
            DELETE = new HttpMethod(HttpDelete.METHOD_NAME, 5);
            HttpMethod httpMethod = new HttpMethod(HttpTrace.METHOD_NAME, 6);
            TRACE = httpMethod;
            $VALUES = new HttpMethod[]{GET, POST, HEAD, OPTIONS, PUT, DELETE, httpMethod};
        }

        public HttpMethod(String str, int i2) {
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

        public static HttpMethod valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HttpMethod) Enum.valueOf(HttpMethod.class, str) : (HttpMethod) invokeL.objValue;
        }

        public static HttpMethod[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HttpMethod[]) $VALUES.clone() : (HttpMethod[]) invokeV.objValue;
        }
    }

    public HttpDefines() {
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
