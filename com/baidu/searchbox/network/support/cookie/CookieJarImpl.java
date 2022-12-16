package com.baidu.searchbox.network.support.cookie;

import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.UrlWrapper;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.support.cookie.Cookie;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
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

    @Override // com.baidu.searchbox.network.support.cookie.CookieJar
    public List<Cookie> loadForRequest(UrlWrapper urlWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, urlWrapper)) == null) {
            ArrayList arrayList = new ArrayList();
            CookieManager cookieManager = this.cookieManager;
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie(urlWrapper.toString());
                if (!Util.isTextEmpty(cookie)) {
                    arrayList.addAll(getCookies(urlWrapper, cookie));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
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

    private List<Cookie> getCookies(UrlWrapper urlWrapper, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, urlWrapper, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i = 0;
            while (i < length) {
                int delimiterOffset = Util.delimiterOffset(str, i, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
                int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, (char) a.h);
                String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
                if (delimiterOffset2 < delimiterOffset) {
                    str2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
                } else {
                    str2 = "";
                }
                if (str2.startsWith("\"") && str2.endsWith("\"")) {
                    str2 = str2.substring(1, str2.length() - 1);
                }
                String encodeIllegalInfo = encodeIllegalInfo(trimSubstring);
                String encodeIllegalInfo2 = encodeIllegalInfo(str2);
                if (!Util.isTextEmpty(encodeIllegalInfo) && this.cookieManager.shouldSendCookie(urlWrapper.toString(), encodeIllegalInfo)) {
                    arrayList.add(new Cookie.Builder().name(encodeIllegalInfo).value(encodeIllegalInfo2).domain(urlWrapper.host()).build());
                }
                i = delimiterOffset + 1;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // com.baidu.searchbox.network.support.cookie.CookieJar
    public void saveFromResponse(UrlWrapper urlWrapper, List<Cookie> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlWrapper, list) == null) && this.cookieManager != null) {
            ArrayList arrayList = new ArrayList();
            String urlWrapper2 = urlWrapper.toString();
            for (Cookie cookie : list) {
                String cookie2 = cookie.toString();
                if (!Util.isTextEmpty(cookie2) && this.cookieManager.shouldAcceptCookie(urlWrapper2, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
            this.cookieManager.storeCookie(urlWrapper.toString(), arrayList);
        }
    }
}
