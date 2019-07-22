package com.baidu.swan.apps.an;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Set;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public final class aa {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean ip(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        return host.endsWith(".baidu.com") || host.equals("baidu.com");
    }

    public static String d(String str, Set<String> set) {
        String[] split;
        if (TextUtils.isEmpty(str) || set == null || (split = str.split("&")) == null || split.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length > 0 && !set.contains(split2[0])) {
                sb.append(str2).append("&");
            }
        }
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == '&') {
            sb.deleteCharAt(length - 1);
        }
        return sb.toString();
    }

    public static String iq(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("?")) > 0) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static String ir(String str) {
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

    public static String b(String str, String str2, String str3, long j) {
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;max-age=" + j + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
    }

    public static String is(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str)).toString();
    }

    public static Uri it(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str));
    }

    public static String iu(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), HTTP.UTF_8);
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
}
