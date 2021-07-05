package com.baidu.mobads.container.util;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public class AdURIUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AdURIUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Deprecated
    public static String addParameter(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            String fixedString = getFixedString(str);
            String queryString = getQueryString(str);
            if (TextUtils.isEmpty(queryString)) {
                str4 = str2 + "=" + str3;
            } else {
                str4 = queryString + "&" + str2 + "=" + str3;
            }
            return fixedString + "?" + str4;
        }
        return (String) invokeLLL.objValue;
    }

    public static String addParameters(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, hashMap)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (hashMap != null && !hashMap.isEmpty()) {
                sb.append("?");
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    try {
                        sb.append(entry.getKey());
                        sb.append("=");
                        sb.append(entry.getValue());
                        sb.append("&");
                    } catch (Exception e2) {
                        RemoteXAdLogger.getInstance().e(e2);
                    }
                }
                String sb2 = sb.toString();
                return sb2.substring(0, sb2.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String decodeURIComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String encodeURIComponent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String encodeUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (String) invokeL.objValue;
    }

    public static HashMap<String, String> getAllQueryParameters(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            Uri parse = Uri.parse(str);
            for (String str2 : getQueryParameterNames(parse)) {
                if (str2 != null && str2.length() > 0) {
                    hashMap.put(str2, parse.getQueryParameter(str2));
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String getFixedString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
        }
        return (String) invokeL.objValue;
    }

    public static HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, url)) == null) {
            if (url.getProtocol().toLowerCase().equals("https")) {
                RemoteSslUtils.ignoreSsl();
                return (HttpsURLConnection) url.openConnection();
            }
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static Set<String> getQueryParameterNames(Uri uri) {
        InterceptResult invokeL;
        Set<String> unmodifiableSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    unmodifiableSet = uri.getQueryParameterNames();
                } else {
                    String encodedQuery = uri.getEncodedQuery();
                    if (encodedQuery == null) {
                        unmodifiableSet = Collections.emptySet();
                    } else {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        int i2 = 0;
                        do {
                            int indexOf = encodedQuery.indexOf(38, i2);
                            if (indexOf == -1) {
                                indexOf = encodedQuery.length();
                            }
                            int indexOf2 = encodedQuery.indexOf(61, i2);
                            if (indexOf2 > indexOf || indexOf2 == -1) {
                                indexOf2 = indexOf;
                            }
                            linkedHashSet.add(Uri.decode(encodedQuery.substring(i2, indexOf2)));
                            i2 = indexOf + 1;
                        } while (i2 < encodedQuery.length());
                        unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
                    }
                }
                return unmodifiableSet;
            } catch (Exception unused) {
                return new HashSet();
            }
        }
        return (Set) invokeL.objValue;
    }

    public static String getQueryString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str == null) {
                return null;
            }
            String[] split = (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?") : null;
            if (split == null || split.length < 2) {
                return null;
            }
            return split[1];
        }
        return (String) invokeL.objValue;
    }

    public static String getRequestAdUrl(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, hashMap)) == null) {
            StringBuilder sb2 = new StringBuilder();
            if (hashMap != null) {
                int i2 = 0;
                for (String str2 : hashMap.keySet()) {
                    i2++;
                    String str3 = hashMap.get(str2);
                    if (i2 == 1) {
                        sb2.append(str2);
                        sb2.append("=");
                        sb2.append(str3);
                    } else {
                        sb2.append("&");
                        sb2.append(str2);
                        sb2.append("=");
                        sb2.append(str3);
                    }
                }
            }
            if (XAdSDKRemoteVersion.DEBUG.booleanValue()) {
                if (hashMap != null) {
                    for (String str4 : hashMap.keySet()) {
                        try {
                            String str5 = hashMap.get(str4);
                            if (str5 != null) {
                                hashMap.put(str4, URLEncoder.encode(str5, "UTF-8"));
                            }
                        } catch (UnsupportedEncodingException unused) {
                        }
                    }
                }
                sb = addParameters(str, hashMap) + "&b" + System.currentTimeMillis() + "=1";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("?code2=");
                sb3.append(Base64.encode(sb2.toString() + "&b" + System.currentTimeMillis() + "=1"));
                sb = sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("&b" + System.currentTimeMillis());
            sb4.append("=");
            sb4.append("1");
            return sb + sb4.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static Boolean isHttpProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP) : (Boolean) invokeL.objValue;
    }

    public static Boolean isHttpsProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : (Boolean) invokeL.objValue;
    }

    public static Boolean isMessageProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            return Boolean.valueOf(isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_SMS).booleanValue() || isXProtocol(str, "smsto:").booleanValue() || isXProtocol(str, "mms:").booleanValue());
        }
        return (Boolean) invokeL.objValue;
    }

    public static boolean isStringAvailable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? str != null && str.length() > 0 : invokeL.booleanValue;
    }

    public static Boolean isXProtocol(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, str2)) == null) {
            boolean z = false;
            if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    public static String replaceURLWithSupportProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) ? (AppConfigImp.getInstance().isSupportHttps() && isHttpProtocol(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str : (String) invokeL.objValue;
    }
}
