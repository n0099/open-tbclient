package com.baidu.swan.apps.ap;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ai {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

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

    public static String deleteParam(String str, Set<String> set) {
        if (!TextUtils.isEmpty(str) && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && set != null && set.size() != 0) {
            String str2 = null;
            try {
                str2 = new URL(str).getQuery();
            } catch (MalformedURLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                CharSequence deleteQueryParam = deleteQueryParam(str2, set);
                return !TextUtils.isEmpty(deleteQueryParam) ? str.replace(str2, deleteQueryParam) : str;
            }
            return str;
        }
        return str;
    }

    public static String a(Uri uri, Set<String> set) {
        if (uri == null) {
            return "";
        }
        if (set == null || set.size() == 0) {
            return uri.toString();
        }
        String uri2 = uri.toString();
        String query = uri.getQuery();
        if (!TextUtils.isEmpty(query)) {
            String deleteQueryParam = deleteQueryParam(query, set);
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(uri.getScheme());
            builder.authority(uri.getAuthority());
            builder.path(uri.getPath());
            if (!TextUtils.isEmpty(deleteQueryParam)) {
                builder.query(deleteQueryParam);
            }
            return builder.build().toString();
        }
        return uri2;
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

    public static String tb(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(File.separator)) {
                str = str.substring(1);
            }
            if (str.endsWith(File.separator)) {
                return str.substring(0, str.length() - 1);
            }
            return str;
        }
        return str;
    }

    public static String tc(String str) {
        return tb(delAllParamsFromUrl(str));
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
            hashMap.put(decodeWithUTF8(split[0]), split.length > 1 ? decodeWithUTF8(split[1]) : "");
        }
        return hashMap;
    }

    public static String getCookieStr(String str, String str2, String str3, long j) {
        return str2 + ETAG.EQUAL + str3 + ";domain=" + str + ";path=/;max-age=" + j + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
    }

    public static boolean isUrlAuxiliary(String str) {
        return Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]|(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).*").matcher(str).matches();
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

    public static String getCookieValue(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        int length = split.length;
        for (int i = 0; i != length; i++) {
            String trim = split[i].trim();
            String[] split2 = trim.split(ETAG.EQUAL);
            if (split2.length >= 2 && TextUtils.equals(str2, split2[0])) {
                if (split2.length == 2) {
                    return split2[1];
                } else {
                    return trim.substring(split2[0].length() + 1);
                }
            }
        }
        return null;
    }

    public static String j(Uri uri) {
        if (uri == null) {
            return "";
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return null;
        }
        return pathSegments.get(0);
    }

    public static String a(@NonNull String str, @NonNull Uri uri, boolean z) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        if (substring.endsWith(File.separator)) {
            substring = substring.substring(0, substring.length() - 1);
        }
        String replaceAll = substring.replaceAll("/+", "/");
        if (!z && replaceAll.startsWith(File.separator)) {
            return replaceAll.substring(1);
        }
        return replaceAll;
    }

    public static boolean a(String str, StringBuffer stringBuffer) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                URL url = new URL(str);
                String protocol = url.getProtocol();
                String host = url.getHost();
                if (TextUtils.isEmpty(protocol) || TextUtils.isEmpty(host)) {
                    stringBuffer.append(str);
                } else {
                    z = (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) ? true : true;
                    stringBuffer.append(protocol).append("://").append(host);
                }
            } catch (MalformedURLException e) {
                stringBuffer.append(str);
            }
        }
        return z;
    }

    public static String cw(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errcode", str);
            jSONObject.put("errMsg", str2);
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }
}
