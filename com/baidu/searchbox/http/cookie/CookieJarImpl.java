package com.baidu.searchbox.http.cookie;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
/* loaded from: classes2.dex */
public class CookieJarImpl implements CookieJar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieManager cookieManager;

    public CookieJarImpl(CookieManager cookieManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cookieManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cookieManager = cookieManager;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpUrl)) == null) {
            ArrayList arrayList = new ArrayList();
            CookieManager cookieManager = this.cookieManager;
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie(httpUrl.toString());
                if (!TextUtils.isEmpty(cookie)) {
                    arrayList.addAll(getCookies(httpUrl, cookie));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static int delimiterOffset(String str, int i, int i2, char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c)})) == null) {
            while (i < i2) {
                if (str.charAt(i) == c) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            while (i < i2) {
                if (str2.indexOf(str.charAt(i)) != -1) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    private String encodeIllegalInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (str == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private List<Cookie> getCookies(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, httpUrl, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i = 0;
            while (i < length) {
                int delimiterOffset = delimiterOffset(str, i, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
                int delimiterOffset2 = delimiterOffset(str, i, delimiterOffset, (char) a.h);
                String trimSubstring = trimSubstring(str, i, delimiterOffset2);
                if (delimiterOffset2 < delimiterOffset) {
                    str2 = trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
                } else {
                    str2 = "";
                }
                if (str2.startsWith("\"") && str2.endsWith("\"")) {
                    str2 = str2.substring(1, str2.length() - 1);
                }
                String encodeIllegalInfo = encodeIllegalInfo(trimSubstring);
                String encodeIllegalInfo2 = encodeIllegalInfo(str2);
                if (!TextUtils.isEmpty(encodeIllegalInfo) && this.cookieManager.shouldSendCookie(httpUrl.toString(), encodeIllegalInfo)) {
                    arrayList.add(new Cookie.Builder().name(encodeIllegalInfo).value(encodeIllegalInfo2).domain(httpUrl.host()).build());
                }
                i = delimiterOffset + 1;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, str, i, i2)) == null) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static String trimSubstring(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i, i2)) == null) {
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i, i2);
            return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i2));
        }
        return (String) invokeLII.objValue;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, str, i, i2)) == null) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
            }
            return i;
        }
        return invokeLII.intValue;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, list) == null) && this.cookieManager != null) {
            ArrayList arrayList = new ArrayList();
            String httpUrl2 = httpUrl.toString();
            for (Cookie cookie : list) {
                String cookie2 = cookie.toString();
                if (!TextUtils.isEmpty(cookie2) && this.cookieManager.shouldAcceptCookie(httpUrl2, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
            this.cookieManager.storeCookie(httpUrl.toString(), arrayList);
        }
    }
}
