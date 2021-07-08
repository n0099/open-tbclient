package com.baidu.android.common.others.url;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.java.Patterns;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.Domains;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class UrlUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String PERCENT_PATTEN = "%(?![0-9a-fA-F]{2})";
    public static final String PERCENT_TO_REPLACE = "%25";
    public static final String TAG = "UrlUtils";
    public static final String UTF_8 = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;

    public UrlUtil() {
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

    public static String addParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str4 = str2 + "=";
            int indexOf = str.indexOf("?");
            String str5 = null;
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str5 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?");
                sb2.append(str4);
                sb2.append(str3);
                if (str5 != null) {
                    sb2.append(str5);
                }
                return sb2.toString();
            }
            if (str.indexOf("&" + str4, indexOf) < 0) {
                if (str.indexOf("?" + str4, indexOf) < 0) {
                    int indexOf3 = str.indexOf("#");
                    if (indexOf3 < 0) {
                        sb = new StringBuilder(str);
                    } else {
                        str5 = str.substring(indexOf3);
                        str = str.substring(0, indexOf3);
                        sb = new StringBuilder(str);
                    }
                    if (!str.endsWith("&") && !str.endsWith("?")) {
                        sb.append("&");
                    }
                    sb.append(str4);
                    sb.append(str3);
                    if (str5 != null) {
                        sb.append(str5);
                    }
                    return sb.toString();
                }
                return str;
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String addSchemeIfNeed(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("rtsp://")) {
                return str;
            }
            return "http://" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String appendParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return str.trim();
            }
            HashMap hashMap = new HashMap();
            hashMap.put(str2, str3);
            return appendParams(str, hashMap);
        }
        return (String) invokeLLL.objValue;
    }

    public static String appendParams(String str, @NonNull Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, map)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (map.size() == 0) {
                return str.trim();
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : map.keySet()) {
                stringBuffer.append(str2);
                stringBuffer.append("=");
                stringBuffer.append(map.get(str2));
                stringBuffer.append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            String trim = str.trim();
            int length = trim.length();
            int indexOf = trim.indexOf("?");
            if (indexOf <= -1) {
                return trim + "?" + stringBuffer.toString();
            } else if (length - 1 == indexOf) {
                return trim + stringBuffer.toString();
            } else {
                return trim + "&" + stringBuffer.toString();
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String decodeUrl(String str, String str2) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) ? URLDecoder.decode(str, str2) : (String) invokeLL.objValue;
    }

    public static String decodeWithUTF8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String delAllParamsFromUrl(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("?")) > 0) ? str.substring(0, indexOf) : str : (String) invokeL.objValue;
    }

    public static String deleteParam(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, set)) == null) {
            if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
                return str;
            }
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
            } catch (MalformedURLException unused) {
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            CharSequence deleteQueryParam = deleteQueryParam(str2, set);
            return TextUtils.isEmpty(deleteQueryParam) ? str : str.replace(str2, deleteQueryParam);
        }
        return (String) invokeLL.objValue;
    }

    public static String deleteParamAllowAll(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, set)) == null) {
            if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
                return str;
            }
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
            } catch (MalformedURLException unused) {
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str == null ? str : str.replace(str2, deleteQueryParam(str2, set));
        }
        return (String) invokeLL.objValue;
    }

    public static String deleteQueryParam(String str, Set<String> set) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, set)) == null) {
            if (TextUtils.isEmpty(str) || set == null || (split = str.split("&")) == null || split.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length > 0 && !set.contains(split2[0])) {
                    sb.append(str2);
                    sb.append("&");
                }
            }
            int length = sb.length();
            if (length > 0) {
                int i2 = length - 1;
                if (sb.charAt(i2) == '&') {
                    sb.deleteCharAt(i2);
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String encodeUrl(String str, String str2) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) ? URLEncoder.encode(str, str2) : (String) invokeLL.objValue;
    }

    public static String fixUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str == null) {
                return "";
            }
            int indexOf = str.indexOf(58);
            boolean z = true;
            for (int i2 = 0; i2 < indexOf; i2++) {
                char charAt = str.charAt(i2);
                if (!Character.isLetter(charAt)) {
                    break;
                }
                z &= Character.isLowerCase(charAt);
                if (i2 == indexOf - 1 && !z) {
                    str = str.substring(0, indexOf).toLowerCase() + str.substring(indexOf);
                }
            }
            if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("rtsp://")) {
                return str;
            }
            if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS) || str.startsWith("rtsp:")) {
                if (!str.startsWith("http:/") && !str.startsWith("https:/") && !str.startsWith("rtsp:/")) {
                    return str.replaceFirst(":", "://");
                }
                return str.replaceFirst("/", "//");
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String getCookieStr(String str, String str2, String str3, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, str2, str3, Long.valueOf(j)})) == null) {
            return str2 + "=" + str3 + ";domain=" + str + ";path=/;max-age=" + j + ";";
        }
        return (String) invokeCommon.objValue;
    }

    public static String getHost(String str) throws MalformedURLException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? new URL(str).getHost() : (String) invokeL.objValue;
    }

    public static String getMime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            String lowerCase = Uri.parse(str).getPath().toLowerCase();
            return lowerCase.contains(FileHelper.FILE_CACHE_CSS) ? "text/css" : lowerCase.contains(".js") ? "application/x-javascript" : (lowerCase.contains(".jpg") || lowerCase.contains(".gif") || lowerCase.contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) || lowerCase.contains(".jpeg")) ? BdUploadHandler.IMAGE_MIME_TYPE : SapiWebView.DATA_MIME_TYPE;
        }
        return (String) invokeL.objValue;
    }

    public static String getParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                return str.substring(indexOf + 1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getUrlField(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, str, str2, str3, str4)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                String str5 = str2 + str3;
                int indexOf = str.indexOf("?");
                if (indexOf == -1) {
                    indexOf = 0;
                }
                int indexOf2 = str.indexOf(str5, indexOf);
                if (indexOf2 != -1) {
                    int indexOf3 = str.indexOf(str4, indexOf2);
                    if (indexOf3 != -1) {
                        return str.substring(indexOf2 + str5.length(), indexOf3);
                    }
                    return str.substring(indexOf2 + str5.length());
                }
            }
            return "";
        }
        return (String) invokeLLLL.objValue;
    }

    public static String getUrlhost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            try {
                return new URL(str).getHost();
            } catch (MalformedURLException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String handleAbnormalUrlIfNeeded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? (TextUtils.isEmpty(str) || !isUrl(str)) ? str : addSchemeIfNeed(fixUrl(str).trim()) : (String) invokeL.objValue;
    }

    public static boolean isBaiduDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String host = Uri.parse(str).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            return host.endsWith(Domains.BAIDU) || host.equals("baidu.com");
        }
        return invokeL.booleanValue;
    }

    public static boolean isHttpSecurity(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("https://") : invokeL.booleanValue;
    }

    public static boolean isUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            try {
                return Patterns.COARSE_WEB_URL.matcher(str).matches();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isUrlAuxiliary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            try {
                return Pattern.compile("(https?|ftp)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]").matcher(str).matches();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isValidUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) ? isUrl(str) || isUrlAuxiliary(str) : invokeL.booleanValue;
    }

    public static String mapToString(Map<String, String> map) {
        InterceptResult invokeL;
        String encode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                String str2 = map.get(str);
                if (str != null) {
                    try {
                        encode = URLEncoder.encode(str, "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                    }
                } else {
                    encode = "";
                }
                sb.append(encode);
                sb.append("=");
                sb.append(str2 != null ? URLEncoder.encode(str2, "UTF-8") : "");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Map<String, String> stringToMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    hashMap.put(URLDecoder.decode(split[0], "UTF-8"), split.length > 1 ? URLDecoder.decode(split[1], "UTF-8") : "");
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e2);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Uri toFileUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Uri.fromFile(new File(str));
        }
        return (Uri) invokeL.objValue;
    }

    public static String toFileUriString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Uri.fromFile(new File(str)).toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getUrlField(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, str, str2)) == null) ? getUrlField(str, str2, "=", "&") : (String) invokeLL.objValue;
    }

    public static String addParam(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, map)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String mapToString = mapToString(map);
            if (TextUtils.isEmpty(mapToString)) {
                return str;
            }
            if (str.contains("?")) {
                return str + "&" + mapToString;
            }
            return str + "?" + mapToString;
        }
        return (String) invokeLL.objValue;
    }
}
