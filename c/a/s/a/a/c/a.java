package c.a.s.a.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
/* loaded from: classes.dex */
public class a implements CookieJar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieManager a;

    public a(CookieManager cookieManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cookieManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cookieManager;
    }

    public final String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
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

    public final List<Cookie> b(HttpUrl httpUrl, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, str)) == null) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int delimiterOffset = Util.delimiterOffset(str, i2, length, ';');
                int delimiterOffset2 = Util.delimiterOffset(str, i2, delimiterOffset, (char) com.alipay.sdk.encrypt.a.f31099h);
                String trimSubstring = Util.trimSubstring(str, i2, delimiterOffset2);
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (trimSubstring2.startsWith("\"") && trimSubstring2.endsWith("\"")) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                }
                String a = a(trimSubstring);
                String a2 = a(trimSubstring2);
                if (!Util.isTextEmpty(a) && this.a.shouldSendCookie(httpUrl.toString(), a)) {
                    arrayList.add(new Cookie.Builder().name(a).value(a2).domain(httpUrl.host()).build());
                }
                i2 = delimiterOffset + 1;
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpUrl)) == null) {
            ArrayList arrayList = new ArrayList();
            CookieManager cookieManager = this.a;
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie(httpUrl.toString());
                if (!Util.isTextEmpty(cookie)) {
                    arrayList.addAll(b(httpUrl, cookie));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, httpUrl, list) == null) || this.a == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        String httpUrl2 = httpUrl.toString();
        for (Cookie cookie : list) {
            String cookie2 = cookie.toString();
            if (!Util.isTextEmpty(cookie2) && this.a.shouldAcceptCookie(httpUrl2, cookie2)) {
                arrayList.add(cookie2);
            }
        }
        this.a.storeCookie(httpUrl.toString(), arrayList);
    }
}
