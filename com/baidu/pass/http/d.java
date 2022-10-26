package com.baidu.pass.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";
    public static final String b = "Set-Cookie";
    public static final String c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    public static final String d = "Cookie";
    public static final String e = "https://";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-727620274, "Lcom/baidu/pass/http/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-727620274, "Lcom/baidu/pass/http/d;");
        }
    }

    public d() {
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

    public static String a(String str, String str2, String str3, long j, boolean z) {
        InterceptResult invokeCommon;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("=");
            sb.append(str3);
            sb.append(";domain=");
            sb.append(str);
            sb.append(";path=/;expires=");
            sb.append(simpleDateFormat.format(calendar.getTime()));
            sb.append(";httponly");
            if (z) {
                str4 = ";secure";
            } else {
                str4 = "";
            }
            sb.append(str4);
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void a(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        Map<String, List<String>> headerFields;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, httpURLConnection, passHttpParamDTO) == null) {
            try {
                String str = a;
                StringBuilder sb = new StringBuilder();
                sb.append("asyncCookie");
                sb.append(passHttpParamDTO.asyncCookie);
                e.a(str, sb.toString());
                if (passHttpParamDTO.asyncCookie && (headerFields = httpURLConnection.getHeaderFields()) != null && !headerFields.isEmpty() && (list = headerFields.get("Set-Cookie")) != null && !list.isEmpty()) {
                    CookieSyncManager.createInstance(context);
                    CookieManager cookieManager = CookieManager.getInstance();
                    cookieManager.setAcceptCookie(true);
                    if (!cookieManager.acceptCookie()) {
                        return;
                    }
                    for (String str2 : list) {
                        if (!TextUtils.isEmpty(str2)) {
                            List<HttpCookie> parse = HttpCookie.parse(str2);
                            if (!parse.isEmpty()) {
                                HttpCookie httpCookie = parse.get(0);
                                if (a(passHttpParamDTO.url, httpCookie)) {
                                    String str3 = a;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("httpcookie:");
                                    sb2.append(httpCookie.toString());
                                    Log.e(str3, sb2.toString());
                                    String a2 = a(httpCookie.getDomain(), httpCookie.getName(), httpCookie.getValue(), (httpCookie.getMaxAge() * 1000) + System.currentTimeMillis(), httpCookie.getSecure());
                                    String str4 = a;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("httpcookie build:");
                                    sb3.append(a2);
                                    Log.e(str4, sb3.toString());
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("https://");
                                    sb4.append(httpCookie.getDomain());
                                    cookieManager.setCookie(sb4.toString(), a2);
                                }
                            }
                        }
                    }
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        cookieManager.flush();
                    }
                }
            } catch (Exception e2) {
                String str5 = a;
                e.a(str5, "asyncNaCookie2Webview:" + e2.toString());
            }
        }
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (str.equals(str2)) {
                return true;
            }
            if ((str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !e.b(str)) || str.endsWith(str2) || str2.startsWith(".") || !e.b(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(String str, HttpCookie httpCookie) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, httpCookie)) == null) {
            try {
                URL url = new URL(str);
                if (!httpCookie.getDiscard() && !httpCookie.hasExpired() && a(url.getHost(), httpCookie.getDomain()) && b(url.getPath(), httpCookie.getPath())) {
                    if (a(str, httpCookie.getSecure())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (z && !str.startsWith("https://")) {
                return false;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static void b(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        HttpCookie httpCookie;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, httpURLConnection, passHttpParamDTO) == null) {
            try {
                CookieSyncManager.createInstance(context);
                CookieManager cookieManager = CookieManager.getInstance();
                URI uri = new URI(passHttpParamDTO.url);
                StringBuilder sb = new StringBuilder();
                sb.append("https://");
                sb.append(uri.getHost());
                String cookie = cookieManager.getCookie(sb.toString());
                String str = a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("asyncCookie");
                sb2.append(passHttpParamDTO.asyncCookie);
                e.a(str, sb2.toString());
                String str2 = a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("webviewCookies");
                sb3.append(cookie);
                e.a(str2, sb3.toString());
                String[] strArr = null;
                if (!passHttpParamDTO.asyncCookie) {
                    cookie = null;
                }
                List<HttpCookie> list = passHttpParamDTO.cookie;
                if (TextUtils.isEmpty(cookie) && (list == null || list.isEmpty())) {
                    return;
                }
                String str3 = "";
                if (!TextUtils.isEmpty(cookie)) {
                    strArr = cookie.split(ParamableElem.DIVIDE_PARAM);
                }
                if (strArr != null && strArr.length > 0) {
                    for (String str4 : strArr) {
                        if (!TextUtils.isEmpty(str4)) {
                            List<HttpCookie> parse = HttpCookie.parse(str4);
                            if (!parse.isEmpty() && (httpCookie = parse.get(0)) != null && !httpCookie.hasExpired()) {
                                if (list != null) {
                                    for (HttpCookie httpCookie2 : list) {
                                        if (httpCookie.getName().equals(httpCookie2.getName()) && a(passHttpParamDTO.url, httpCookie)) {
                                            httpCookie = httpCookie2;
                                        }
                                    }
                                }
                                if (!httpCookie.hasExpired()) {
                                    str3 = str3 + httpCookie.getName() + "=" + httpCookie.getValue() + ParamableElem.DIVIDE_PARAM;
                                }
                                String str5 = a;
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("httpCookie webview item name:");
                                sb4.append(httpCookie.getName());
                                sb4.append(",value:");
                                sb4.append(httpCookie.getValue());
                                e.a(str5, sb4.toString());
                            }
                        }
                    }
                }
                if (list != null) {
                    for (HttpCookie httpCookie3 : list) {
                        if (a(passHttpParamDTO.url, httpCookie3)) {
                            str3 = str3 + httpCookie3.getName() + "=" + httpCookie3.getValue() + ParamableElem.DIVIDE_PARAM;
                        }
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                String substring = str3.substring(0, str3.length() - 1);
                String str6 = a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("cookieStr");
                sb5.append(substring);
                e.a(str6, sb5.toString());
                httpURLConnection.setRequestProperty("Cookie", substring);
            } catch (Exception e2) {
                e.a(a, "asyncWebviewCookie2NA:" + e2.toString());
            }
        }
    }

    public static boolean b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            if (str.equals(str2)) {
                return true;
            }
            if (str.startsWith(str2)) {
                if (str2.endsWith("/") || str.charAt(str2.length()) == '/') {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
