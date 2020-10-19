package com.baidu.android.util.media;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpHost;
/* loaded from: classes15.dex */
public final class WebpUtils {
    public static final String TYPE_IMG_WEBP = "webp";
    public static final String TYPE_PARAM_H5 = "imgtype";
    public static final String TYPE_PARAM_NA = "imgtype";

    public static String addNAWebpParam(String str) {
        return addParam(str, "imgtype", TYPE_IMG_WEBP);
    }

    public static String deleteNAWebpParam(String str) {
        HashSet hashSet = new HashSet();
        hashSet.add("imgtype");
        return deleteParam(str, hashSet);
    }

    public static String addH5WebpParam(String str) {
        return addParam(str, "imgtype", TYPE_IMG_WEBP);
    }

    public static String deleteH5WebpParam(String str) {
        HashSet hashSet = new HashSet();
        hashSet.add("imgtype");
        return deleteParam(str, hashSet);
    }

    public static boolean isWebKitSupportWebp() {
        return isNAUseWebp();
    }

    public static boolean isNAUseWebp() {
        return true;
    }

    private static String addParam(String str, String str2, String str3) {
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

    private static String addParam(String str, Map<String, String> map) {
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

    private static String deleteParam(String str, Set<String> set) {
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

    private static String mapToString(Map<String, String> map) {
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

    private static String deleteQueryParam(String str, Set<String> set) {
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
}
