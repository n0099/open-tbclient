package com.baidu.android.common.others.url;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.java.Patterns;
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
@Deprecated
/* loaded from: classes.dex */
public class UrlUtil {
    public static final boolean DEBUG = false;
    public static final String PERCENT_PATTEN = "%(?![0-9a-fA-F]{2})";
    public static final String PERCENT_TO_REPLACE = "%25";
    public static final String TAG = "UrlUtils";
    public static final String UTF_8 = "UTF-8";

    @Deprecated
    public static String addParam(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
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

    @Deprecated
    public static String addSchemeIfNeed(String str) {
        return UrlUtils.addSchemeIfNeed(str);
    }

    @Deprecated
    public static String appendParam(String str, String str2, String str3) {
        return UrlUtils.appendParam(str, str2, str3);
    }

    @Deprecated
    public static String appendParams(String str, @NonNull Map<String, String> map) {
        return UrlUtils.appendParams(str, map);
    }

    @Deprecated
    public static String decodeUrl(String str, String str2) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, str2);
    }

    @Deprecated
    public static String decodeWithUTF8(String str) {
        return UrlUtils.decode(str, "UTF-8");
    }

    @Deprecated
    public static String delAllParamsFromUrl(String str) {
        return UrlUtils.deleteAllParams(str);
    }

    @Deprecated
    public static String deleteParam(String str, Set<String> set) {
        return UrlUtils.deleteParam(str, set);
    }

    @Deprecated
    public static String deleteParamAllowAll(String str, Set<String> set) {
        return deleteParam(str, set);
    }

    @Deprecated
    public static String deleteQueryParam(String str, Set<String> set) {
        String[] split;
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
            int i = length - 1;
            if (sb.charAt(i) == '&') {
                sb.deleteCharAt(i);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static String encodeUrl(String str, String str2) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, str2);
    }

    @Deprecated
    public static String fixUrl(String str) {
        return UrlUtils.fixUrl(str);
    }

    @Deprecated
    public static String getCookieStr(String str, String str2, String str3, long j) {
        return CookieUtils.getCookieStr(str, str2, str3, j);
    }

    @Deprecated
    public static String getHost(String str) throws MalformedURLException {
        return new URL(str).getHost();
    }

    @Deprecated
    public static String getMime(String str) {
        return UrlUtils.getMime(str);
    }

    @Deprecated
    public static String getParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    @Deprecated
    public static String getUrlField(String str, String str2, String str3, String str4) {
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

    @Deprecated
    public static String getUrlhost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Deprecated
    public static String handleAbnormalUrlIfNeeded(String str) {
        return UrlUtils.handleAbnormalUrlIfNeeded(str);
    }

    @Deprecated
    public static boolean isBaiduDomain(String str) {
        return UrlUtils.isBaiduDomain(str);
    }

    @Deprecated
    public static boolean isHttpSecurity(String str) {
        return UrlUtils.isHttps(str);
    }

    @Deprecated
    public static boolean isUrl(String str) {
        try {
            return Patterns.COARSE_WEB_URL.matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    public static boolean isUrlAuxiliary(String str) {
        try {
            return Pattern.compile("(https?|ftp)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    public static boolean isValidUrl(String str) {
        return isUrl(str) || isUrlAuxiliary(str);
    }

    @Deprecated
    public static String mapToString(Map<String, String> map) {
        String encode;
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

    @Deprecated
    public static Map<String, String> stringToMap(String str) {
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

    @Deprecated
    public static Uri toFileUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str));
    }

    @Deprecated
    public static String toFileUriString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str)).toString();
    }

    @Deprecated
    public static String getUrlField(String str, String str2) {
        return getUrlField(str, str2, "=", "&");
    }

    @Deprecated
    public static String addParam(String str, Map<String, String> map) {
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
}
