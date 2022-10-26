package com.baidu.adp.lib.network.http;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URL;
import java.util.Map;
/* loaded from: classes.dex */
public interface IHttpNet {
    void a(URL url, int i, int i2) throws Exception;

    Map b();

    int c() throws Exception;

    void connect() throws Exception;

    URL d();

    void disconnect();

    void e(URL url);

    byte[] execute() throws Exception;

    void f();

    void g(URL url, boolean z);

    String getContentEncoding();

    long getContentLength();

    String getContentType();

    int getResponseCode() throws Exception;

    void h() throws Exception;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public final class HttpNetType {
        public static final /* synthetic */ HttpNetType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HttpNetType GET;
        public static final HttpNetType POST_BYTE;
        public static final HttpNetType POST_FORM;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1543835352, "Lcom/baidu/adp/lib/network/http/IHttpNet$HttpNetType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1543835352, "Lcom/baidu/adp/lib/network/http/IHttpNet$HttpNetType;");
                    return;
                }
            }
            GET = new HttpNetType("GET", 0);
            POST_FORM = new HttpNetType("POST_FORM", 1);
            HttpNetType httpNetType = new HttpNetType("POST_BYTE", 2);
            POST_BYTE = httpNetType;
            $VALUES = new HttpNetType[]{GET, POST_FORM, httpNetType};
        }

        public HttpNetType(String str, int i) {
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

        public static HttpNetType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (HttpNetType) Enum.valueOf(HttpNetType.class, str);
            }
            return (HttpNetType) invokeL.objValue;
        }

        public static HttpNetType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (HttpNetType[]) $VALUES.clone();
            }
            return (HttpNetType[]) invokeV.objValue;
        }
    }
}
