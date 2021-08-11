package com.baidu.android.common.others.url;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.SapiWebView;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.Domains;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class UrlUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern COARSE_WEB_URL;
    public static final String TAG = "UrlUtils";
    public static final String UTF_8 = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1617657405, "Lcom/baidu/android/common/others/url/UrlUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1617657405, "Lcom/baidu/android/common/others/url/UrlUtils;");
                return;
            }
        }
        COARSE_WEB_URL = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)([?/](?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_\\s+\\{\\}\\/\\[\\]\\$\\%\\<\\>\\^\\`\\|\\\\])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
    }

    public UrlUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String addSchemeIfNeed(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, map)) == null) {
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

    public static String decode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), str2);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String deleteAllParams(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("?")) > 0) ? str.substring(0, indexOf) : str : (String) invokeL.objValue;
    }

    public static String deleteParam(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, set)) == null) {
            if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
                return str;
            }
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
            } catch (MalformedURLException e2) {
                e2.toString();
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            CharSequence deleteQueryParam = deleteQueryParam(str2, set);
            return TextUtils.isEmpty(deleteQueryParam) ? str : str.replace(str2, deleteQueryParam);
        }
        return (String) invokeLL.objValue;
    }

    public static String deleteQueryParam(String str, Set<String> set) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, set)) == null) {
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

    public static String fixUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
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
                    str = str.substring(0, indexOf).toLowerCase(Locale.getDefault()) + str.substring(indexOf);
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

    public static String getHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                return new URL(str).getHost();
            } catch (MalformedURLException e2) {
                String str2 = "Incorrect url: " + e2.getMessage();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getMime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            String path = Uri.parse(str).getPath();
            if (path != null) {
                String lowerCase = path.toLowerCase(Locale.getDefault());
                if (lowerCase.contains(FileHelper.FILE_CACHE_CSS)) {
                    return "text/css";
                }
                if (lowerCase.contains(".js")) {
                    return "application/x-javascript";
                }
                if (lowerCase.contains(ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX) || lowerCase.contains(".gif") || lowerCase.contains(EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX) || lowerCase.contains(".jpeg")) {
                    return BdUploadHandler.IMAGE_MIME_TYPE;
                }
            }
            return SapiWebView.DATA_MIME_TYPE;
        }
        return (String) invokeL.objValue;
    }

    public static String getParamValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) ? getParamValue(str, str2, false) : (String) invokeLL.objValue;
    }

    public static Map<String, String> getParamsMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            int indexOf = str.indexOf("?");
            String substring = indexOf > 0 ? str.substring(indexOf + 1) : null;
            if (TextUtils.isEmpty(substring)) {
                return hashMap;
            }
            for (String str2 : substring.split("&")) {
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

    public static String getUrlField(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        int indexOf;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65551, null, str, str2, z)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            String str3 = str2 + "=";
            int indexOf2 = str.indexOf("?");
            if (indexOf2 == -1 || (indexOf = str.indexOf(str3, indexOf2)) == -1) {
                return "";
            }
            int indexOf3 = str.indexOf("&", indexOf);
            if (indexOf3 != -1) {
                substring = str.substring(indexOf + str3.length(), indexOf3);
            } else {
                substring = str.substring(indexOf + str3.length());
            }
            String str4 = substring;
            return z ? Uri.decode(str4) : str4;
        }
        return (String) invokeLLZ.objValue;
    }

    public static String handleAbnormalUrlIfNeeded(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? (TextUtils.isEmpty(str) || !isValidUrl(str)) ? str : addSchemeIfNeed(fixUrl(str).trim()) : (String) invokeL.objValue;
    }

    public static boolean isBaiduDomain(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
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

    public static boolean isHttps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? !TextUtils.isEmpty(str) && str.startsWith("https://") : invokeL.booleanValue;
    }

    public static boolean isUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            try {
                return COARSE_WEB_URL.matcher(str).matches();
            } catch (Exception e2) {
                String str2 = "isValidUrl ： query.matcher failed! " + e2.toString();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isUrlAuxiliary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) ? isUrl(str) || isUrlAuxiliary(str) : invokeL.booleanValue;
    }

    public static String getParamValue(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65549, null, str, str2, z)) == null) ? getUrlField(str, str2, z) : (String) invokeLLZ.objValue;
    }
}
