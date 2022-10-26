package com.baidu.down.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.down.common.NameValuePair;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public class URLEncodedUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final String NAME_VALUE_SEPARATOR = "=";
    public static final String PARAMETER_SEPARATOR = "&";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(936061222, "Lcom/baidu/down/utils/URLEncodedUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(936061222, "Lcom/baidu/down/utils/URLEncodedUtils;");
        }
    }

    public URLEncodedUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String decode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str2 == null) {
                try {
                    str2 = DEFAULT_CONTENT_CHARSET;
                } catch (UnsupportedEncodingException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            return URLDecoder.decode(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String encode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str2 == null) {
                try {
                    str2 = DEFAULT_CONTENT_CHARSET;
                } catch (UnsupportedEncodingException e) {
                    throw new IllegalArgumentException(e);
                }
            }
            return URLEncoder.encode(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String format(List list, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            StringBuilder sb = new StringBuilder();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                NameValuePair nameValuePair = (NameValuePair) it.next();
                String encode = encode(nameValuePair.getName(), str);
                String value = nameValuePair.getValue();
                if (value != null) {
                    str2 = encode(value, str);
                } else {
                    str2 = "";
                }
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(encode);
                sb.append("=");
                sb.append(str2);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
