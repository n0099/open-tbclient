package com.baidu.nadcore.net.request;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class RequestMethod {
    public static final /* synthetic */ RequestMethod[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RequestMethod DELETE;
    public static final RequestMethod GET;
    public static final RequestMethod HEAD;
    public static final RequestMethod OPTIONS;
    public static final RequestMethod PATCH;
    public static final RequestMethod POST;
    public static final RequestMethod PUT;
    public static final RequestMethod TRACE;
    public transient /* synthetic */ FieldHolder $fh;
    public final String value;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1598378451, "Lcom/baidu/nadcore/net/request/RequestMethod$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1598378451, "Lcom/baidu/nadcore/net/request/RequestMethod$a;");
                    return;
                }
            }
            int[] iArr = new int[RequestMethod.values().length];
            a = iArr;
            try {
                iArr[RequestMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RequestMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RequestMethod.PATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RequestMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(659788554, "Lcom/baidu/nadcore/net/request/RequestMethod;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(659788554, "Lcom/baidu/nadcore/net/request/RequestMethod;");
                return;
            }
        }
        GET = new RequestMethod("GET", 0, "GET");
        POST = new RequestMethod("POST", 1, "POST");
        PUT = new RequestMethod(HttpPut.METHOD_NAME, 2, HttpPut.METHOD_NAME);
        DELETE = new RequestMethod(HttpDelete.METHOD_NAME, 3, HttpDelete.METHOD_NAME);
        HEAD = new RequestMethod("HEAD", 4, "HEAD");
        PATCH = new RequestMethod("PATCH", 5, "PATCH");
        OPTIONS = new RequestMethod(HttpOptions.METHOD_NAME, 6, HttpOptions.METHOD_NAME);
        RequestMethod requestMethod = new RequestMethod(HttpTrace.METHOD_NAME, 7, HttpTrace.METHOD_NAME);
        TRACE = requestMethod;
        $VALUES = new RequestMethod[]{GET, POST, PUT, DELETE, HEAD, PATCH, OPTIONS, requestMethod};
    }

    public RequestMethod(String str, int i2, String str2) {
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
        this.value = str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static RequestMethod reverse(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals(HttpOptions.METHOD_NAME)) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 79599:
                    if (upperCase.equals(HttpPut.METHOD_NAME)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2213344:
                    if (upperCase.equals("HEAD")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 75900968:
                    if (upperCase.equals("PATCH")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 80083237:
                    if (upperCase.equals(HttpTrace.METHOD_NAME)) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 2012838315:
                    if (upperCase.equals(HttpDelete.METHOD_NAME)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    return GET;
                case 1:
                    return POST;
                case 2:
                    return PUT;
                case 3:
                    return DELETE;
                case 4:
                    return HEAD;
                case 5:
                    return PATCH;
                case 6:
                    return OPTIONS;
                case 7:
                    return TRACE;
                default:
                    return GET;
            }
        }
        return (RequestMethod) invokeL.objValue;
    }

    public static RequestMethod valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (RequestMethod) Enum.valueOf(RequestMethod.class, str) : (RequestMethod) invokeL.objValue;
    }

    public static RequestMethod[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (RequestMethod[]) $VALUES.clone() : (RequestMethod[]) invokeV.objValue;
    }

    public boolean allowBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = a.a[ordinal()];
            return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : (String) invokeV.objValue;
    }
}
