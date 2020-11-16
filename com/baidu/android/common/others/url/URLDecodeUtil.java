package com.baidu.android.common.others.url;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes8.dex */
public class URLDecodeUtil {
    public static final String PERCENT_PATTEN = "%(?![0-9a-fA-F]{2})";
    public static final String PERCENT_TO_REPLACE = "%25";
    public static final String UTF_8 = "UTF-8";

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
}
