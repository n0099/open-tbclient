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
import java.util.Iterator;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
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
    public List loadForRequest(HttpUrl httpUrl) {
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

    private List getCookies(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, httpUrl, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i = 0;
            while (i < length) {
                int delimiterOffset = Util.delimiterOffset(str, i, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
                int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, '=');
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
    public void saveFromResponse(HttpUrl httpUrl, List list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, list) == null) && this.cookieManager != null) {
            ArrayList arrayList = new ArrayList();
            String httpUrl2 = httpUrl.toString();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String cookie = ((Cookie) it.next()).toString();
                if (!TextUtils.isEmpty(cookie) && this.cookieManager.shouldAcceptCookie(httpUrl2, cookie)) {
                    arrayList.add(cookie);
                }
            }
            this.cookieManager.storeCookie(httpUrl.toString(), arrayList);
        }
    }
}
