package com.baidu.searchbox.http.cookie;

import android.text.TextUtils;
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
import okhttp3.internal.Util;
/* loaded from: classes4.dex */
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

    private String encodeIllegalInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (str == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private List<Cookie> getCookies(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, httpUrl, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i = 0;
            while (i < length) {
                int delimiterOffset = Util.delimiterOffset(str, i, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
                int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, '=');
                String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (trimSubstring2.startsWith("\"") && trimSubstring2.endsWith("\"")) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                }
                String encodeIllegalInfo = encodeIllegalInfo(trimSubstring);
                String encodeIllegalInfo2 = encodeIllegalInfo(trimSubstring2);
                if (!TextUtils.isEmpty(encodeIllegalInfo) && this.cookieManager.shouldSendCookie(httpUrl.toString(), encodeIllegalInfo)) {
                    arrayList.add(new Cookie.Builder().name(encodeIllegalInfo).value(encodeIllegalInfo2).domain(httpUrl.host()).build());
                }
                i = delimiterOffset + 1;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
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

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, list) == null) || this.cookieManager == null) {
            return;
        }
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
