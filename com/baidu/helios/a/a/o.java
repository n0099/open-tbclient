package com.baidu.helios.a.a;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes6.dex */
class o {
    public static String a(Map<String, String> map) {
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
            if (str != null) {
                try {
                    encode = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e);
                }
            } else {
                encode = "";
            }
            sb.append(encode);
            sb.append(ETAG.EQUAL);
            sb.append(str2 != null ? URLEncoder.encode(str2, "UTF-8") : "");
        }
        return sb.toString();
    }

    public static String c(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a = a(map);
        if (TextUtils.isEmpty(a)) {
            return str;
        }
        if (str.contains("?")) {
            return str.lastIndexOf("?") == str.length() + (-1) ? str + a : str + ETAG.ITEM_SEPARATOR + a;
        }
        return str + "?" + a;
    }
}
