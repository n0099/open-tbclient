package com.baidu.ar.http;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, Charset charset) {
        InterceptResult invokeLL;
        String name;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, charset)) == null) {
            if (charset != null) {
                try {
                    name = charset.name();
                } catch (UnsupportedEncodingException unused) {
                    return str;
                }
            } else {
                name = null;
            }
            return URLEncoder.encode(str, name);
        }
        return (String) invokeLL.objValue;
    }

    public static String[] aq(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(58)) <= 0 || indexOf == str.length() - 1) {
                return null;
            }
            return new String[]{str.substring(0, indexOf), str.substring(indexOf + 1).trim()};
        }
        return (String[]) invokeL.objValue;
    }

    public static String ar(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
            return TextUtils.isEmpty(contentTypeFor) ? "application/octet-stream" : contentTypeFor;
        }
        return (String) invokeL.objValue;
    }

    public static String as(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (str == null || !str.startsWith(ResultParser.BYTE_ORDER_MARK)) ? str : str.substring(1) : (String) invokeL.objValue;
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
