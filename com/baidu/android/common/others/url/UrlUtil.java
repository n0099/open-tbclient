package com.baidu.android.common.others.url;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.common.others.java.Patterns;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.webkit.internal.ETAG;
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
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class UrlUtil {
    private static final boolean DEBUG = false;
    public static final String PERCENT_PATTEN = "%(?![0-9a-fA-F]{2})";
    public static final String PERCENT_TO_REPLACE = "%25";
    private static final String TAG = "UrlUtils";
    public static final String UTF_8 = "UTF-8";

    private UrlUtil() {
    }

    public static String encodeUrl(String str, String str2) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, str2);
    }

    public static String decodeUrl(String str, String str2) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, str2);
    }

    public static String decodeWithUTF8(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
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
            stringBuffer.append(str2).append(ETAG.EQUAL).append(map.get(str2)).append(ETAG.ITEM_SEPARATOR);
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

    public static String getHost(String str) throws MalformedURLException {
        return new URL(str).getHost();
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

    public static String addParam(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        String str4 = null;
        if (!TextUtils.isEmpty(str)) {
            String str5 = str2 + ETAG.EQUAL;
            int indexOf = str.indexOf("?");
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?").append(str5).append(str3);
                if (str4 != null) {
                    sb2.append(str4);
                }
                return sb2.toString();
            } else if (str.indexOf(ETAG.ITEM_SEPARATOR + str5, indexOf) < 0 && str.indexOf("?" + str5, indexOf) < 0) {
                int indexOf3 = str.indexOf("#");
                if (indexOf3 < 0) {
                    sb = new StringBuilder(str);
                } else {
                    str4 = str.substring(indexOf3);
                    str = str.substring(0, indexOf3);
                    sb = new StringBuilder(str);
                }
                if (!str.endsWith(ETAG.ITEM_SEPARATOR) && !str.endsWith("?")) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                sb.append(str5).append(str3);
                if (str4 != null) {
                    sb.append(str4);
                }
                return sb.toString();
            } else {
                return str;
            }
        }
        return str;
    }

    public static String addParam(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            String mapToString = mapToString(map);
            if (!TextUtils.isEmpty(mapToString)) {
                if (str.contains("?")) {
                    return str + ETAG.ITEM_SEPARATOR + mapToString;
                }
                return str + "?" + mapToString;
            }
            return str;
        }
        return str;
    }

    public static String deleteParamAllowAll(String str, Set<String> set) {
        if (!TextUtils.isEmpty(str) && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && set != null && set.size() != 0) {
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
            } catch (MalformedURLException e) {
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str != null ? str.replace(str2, deleteQueryParam(str2, set)) : str;
        }
        return str;
    }

    public static String deleteParam(String str, Set<String> set) {
        if (!TextUtils.isEmpty(str) && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && set != null && set.size() != 0) {
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
            } catch (MalformedURLException e) {
            }
            if (!TextUtils.isEmpty(str2)) {
                CharSequence deleteQueryParam = deleteQueryParam(str2, set);
                return !TextUtils.isEmpty(deleteQueryParam) ? str.replace(str2, deleteQueryParam) : str;
            }
            return str;
        }
        return str;
    }

    public static String deleteQueryParam(String str, Set<String> set) {
        String[] split;
        if (TextUtils.isEmpty(str) || set == null || (split = str.split(ETAG.ITEM_SEPARATOR)) == null || split.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            String[] split2 = str2.split(ETAG.EQUAL);
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

    public static String delAllParamsFromUrl(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("?")) > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static String getParams(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = null;
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                str2 = str.substring(indexOf + 1);
            }
            return str2;
        }
        return str;
    }

    public static String mapToString(Map<String, String> map) {
        String encode;
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            String str2 = map.get(str);
            if (str == null) {
                encode = "";
            } else {
                try {
                    encode = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e);
                }
            }
            sb.append(encode);
            sb.append(ETAG.EQUAL);
            sb.append(str2 != null ? URLEncoder.encode(str2, "UTF-8") : "");
        }
        return sb.toString();
    }

    public static Map<String, String> stringToMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(ETAG.ITEM_SEPARATOR)) {
            String[] split = str2.split(ETAG.EQUAL);
            try {
                hashMap.put(URLDecoder.decode(split[0], "UTF-8"), split.length > 1 ? URLDecoder.decode(split[1], "UTF-8") : "");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("This method requires UTF-8 encoding support", e);
            }
        }
        return hashMap;
    }

    public static String getUrlField(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return "";
        }
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
        return "";
    }

    public static String getUrlField(String str, String str2) {
        return getUrlField(str, str2, ETAG.EQUAL, ETAG.ITEM_SEPARATOR);
    }

    public static String getCookieStr(String str, String str2, String str3, long j) {
        return str2 + ETAG.EQUAL + str3 + ";domain=" + str + ";path=/;max-age=" + j + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
    }

    public static String getUrlhost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public static boolean isValidUrl(String str) {
        try {
            if (!isUrl(str)) {
                if (!isUrlAuxiliary(str)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isUrl(String str) {
        return Patterns.COARSE_WEB_URL.matcher(str).matches();
    }

    public static boolean isUrlAuxiliary(String str) {
        return Pattern.compile("(https?|ftp)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]").matcher(str).matches();
    }

    public static String toFileUriString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str)).toString();
    }

    public static Uri toFileUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str));
    }

    public static String getMime(String str) {
        String lowerCase = Uri.parse(str).getPath().toLowerCase();
        if (lowerCase.contains(".css")) {
            return "text/css";
        }
        if (lowerCase.contains(".js")) {
            return "application/x-javascript";
        }
        if (!lowerCase.contains(".jpg") && !lowerCase.contains(".gif") && !lowerCase.contains(ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX) && !lowerCase.contains(".jpeg")) {
            return "text/html";
        }
        return "image/*";
    }

    public static String handleAbnormalUrlIfNeeded(String str) {
        if (!TextUtils.isEmpty(str) && isUrl(str)) {
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

    public static boolean isHttpSecurity(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }
}
