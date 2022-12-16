package com.baidu.searchbox.network.support.okhttp.converters;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class HeadersConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HeadersConverter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void checkName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (str != null) {
                if (!str.isEmpty()) {
                    int length = str.length();
                    for (int i = 0; i < length; i++) {
                        char charAt = str.charAt(i);
                        if (charAt <= ' ' || charAt >= 127) {
                            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new NullPointerException("name == null");
        }
    }

    public static boolean checkValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str != null) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                        return false;
                    }
                }
                return true;
            }
            throw new NullPointerException("value for name " + str2 + " == null");
        }
        return invokeLL.booleanValue;
    }

    public static Headers fromOks(okhttp3.Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, headers)) == null) {
            ConverterUtils.requireNonNull(headers, "okHeaders should not be null");
            Map<String, List<String>> multimap = headers.toMultimap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, List<String>> entry : multimap.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String trim = entry.getKey().trim();
                    checkName(trim);
                    for (String str : entry.getValue()) {
                        if (checkValue(str, trim)) {
                            arrayList.add(trim);
                            arrayList.add(str);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            return Headers.of((String[]) arrayList.toArray(new String[0]));
        }
        return (Headers) invokeL.objValue;
    }

    public static okhttp3.Headers toOks(Headers headers) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, headers)) == null) {
            ConverterUtils.requireNonNull(headers, "headers should not be null");
            Map<String, List<String>> multimap = headers.toMultimap();
            String[] strArr = new String[headers.size() * 2];
            int i = 0;
            for (Map.Entry<String, List<String>> entry : multimap.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    String trim = entry.getKey().trim();
                    checkName(trim);
                    for (String str : entry.getValue()) {
                        if (checkValue(str, trim)) {
                            strArr[i] = trim;
                            strArr[i + 1] = str;
                            i += 2;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            return okhttp3.Headers.of(strArr);
        }
        return (okhttp3.Headers) invokeL.objValue;
    }
}
