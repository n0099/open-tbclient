package com.baidu.android.common.others.url;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
/* loaded from: classes5.dex */
public final class UrlUtils {
    public static final Pattern COARSE_WEB_URL = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)([?/](?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_\\s+\\{\\}\\/\\[\\]\\$\\%\\<\\>\\^\\`\\|\\\\])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
    private static final String TAG = "UrlUtils";
    private static final String UTF_8 = "UTF-8";

    private UrlUtils() {
    }

    public static String decode(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return str;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public static String appendParams(String str, @NonNull Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (map.size() == 0) {
            return str.trim();
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : map.keySet()) {
            stringBuffer.append(str2).append("=").append(map.get(str2)).append(ETAG.ITEM_SEPARATOR);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String trim = str.trim();
        int length = trim.length();
        int indexOf = trim.indexOf("?");
        if (indexOf > -1) {
            if (length - 1 == indexOf) {
                return trim + stringBuffer.toString();
            }
            return trim + ETAG.ITEM_SEPARATOR + stringBuffer.toString();
        }
        return trim + "?" + stringBuffer.toString();
    }

    public static String appendParam(String str, String str2, String str3) {
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

    public static String getHost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            Log.e(TAG, "Incorrect url: " + e.getMessage());
            return null;
        }
    }

    public static boolean isBaiduDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        return host.endsWith(".baidu.com") || host.equals("baidu.com");
    }

    public static String deleteParam(String str, Set<String> set) {
        if (!TextUtils.isEmpty(str) && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && set != null && set.size() != 0) {
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
            } catch (MalformedURLException e) {
                Log.e(TAG, e.toString());
            }
            if (!TextUtils.isEmpty(str2)) {
                CharSequence deleteQueryParam = deleteQueryParam(str2, set);
                return !TextUtils.isEmpty(deleteQueryParam) ? str.replace(str2, deleteQueryParam) : str;
            }
            return str;
        }
        return str;
    }

    private static String deleteQueryParam(String str, Set<String> set) {
        String[] split;
        if (TextUtils.isEmpty(str) || set == null || (split = str.split(ETAG.ITEM_SEPARATOR)) == null || split.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length > 0 && !set.contains(split2[0])) {
                sb.append(str2).append(ETAG.ITEM_SEPARATOR);
            }
        }
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == '&') {
            sb.deleteCharAt(length - 1);
        }
        return sb.toString();
    }

    public static String deleteAllParams(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("?")) > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static Map<String, String> getParamsMap(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String str2 = null;
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str2 = str.substring(indexOf + 1);
        }
        if (TextUtils.isEmpty(str2)) {
            return hashMap;
        }
        for (String str3 : str2.split(ETAG.ITEM_SEPARATOR)) {
            String[] split = str3.split("=");
            try {
                hashMap.put(URLDecoder.decode(split[0], "UTF-8"), split.length > 1 ? URLDecoder.decode(split[1], "UTF-8") : "");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("This method requires UTF-8 encoding support", e);
            }
        }
        return hashMap;
    }

    public static String getParamValue(String str, String str2) {
        return getParamValue(str, str2, false);
    }

    public static String getParamValue(String str, String str2, boolean z) {
        return getUrlField(str, str2, z);
    }

    private static String getUrlField(String str, String str2, boolean z) {
        int indexOf;
        String substring;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String str3 = str2 + "=";
        int indexOf2 = str.indexOf("?");
        if (indexOf2 == -1 || (indexOf = str.indexOf(str3, indexOf2)) == -1) {
            return "";
        }
        int indexOf3 = str.indexOf(ETAG.ITEM_SEPARATOR, indexOf);
        if (indexOf3 != -1) {
            substring = str.substring(str3.length() + indexOf, indexOf3);
        } else {
            substring = str.substring(str3.length() + indexOf);
        }
        if (z) {
            return Uri.decode(substring);
        }
        return substring;
    }

    public static boolean isUrl(String str) {
        try {
            return COARSE_WEB_URL.matcher(str).matches();
        } catch (Exception e) {
            Log.e(TAG, "isValidUrl ： query.matcher failed! " + e.toString());
            return false;
        }
    }

    public static boolean isValidUrl(String str) {
        return isUrl(str) || isUrlAuxiliary(str);
    }

    public static boolean isUrlAuxiliary(String str) {
        try {
            return Pattern.compile("(https?|ftp)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]").matcher(str).matches();
        } catch (Exception e) {
            return false;
        }
    }

    public static String getMime(String str) {
        String lowerCase = Uri.parse(str).getPath().toLowerCase();
        if (lowerCase.contains(".css")) {
            return "text/css";
        }
        if (lowerCase.contains(".js")) {
            return "application/x-javascript";
        }
        if (!lowerCase.contains(".jpg") && !lowerCase.contains(".gif") && !lowerCase.contains(".png") && !lowerCase.contains(".jpeg")) {
            return "text/html";
        }
        return "image/*";
    }

    public static String handleAbnormalUrlIfNeeded(String str) {
        if (!TextUtils.isEmpty(str) && isValidUrl(str)) {
            return addSchemeIfNeed(fixUrl(str).trim());
        }
        return str;
    }

    public static String fixUrl(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(58);
        boolean z = true;
        String str2 = str;
        for (int i = 0; i < indexOf; i++) {
            char charAt = str2.charAt(i);
            if (!Character.isLetter(charAt)) {
                break;
            }
            z &= Character.isLowerCase(charAt);
            if (i == indexOf - 1 && !z) {
                str2 = str2.substring(0, indexOf).toLowerCase() + str2.substring(indexOf);
            }
        }
        if (!str2.startsWith("http://") && !str2.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) && !str2.startsWith("rtsp://")) {
            if (str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTP) || str2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HTTPS) || str2.startsWith("rtsp:")) {
                if (str2.startsWith("http:/") || str2.startsWith("https:/") || str2.startsWith("rtsp:/")) {
                    return str2.replaceFirst("/", "//");
                }
                return str2.replaceFirst(":", "://");
            }
            return str2;
        }
        return str2;
    }

    public static String addSchemeIfNeed(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("rtsp://")) ? str : "http://" + str;
    }

    public static boolean isHttps(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }
}
