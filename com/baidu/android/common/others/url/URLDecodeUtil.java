package com.baidu.android.common.others.url;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes.dex */
public class URLDecodeUtil {
    public static final String PERCENT_PATTEN = "%(?![0-9a-fA-F]{2})";
    public static final String PERCENT_TO_REPLACE = "%25";
    public static final String UTF_8 = "UTF-8";

    public static String decodeWithUTF8(String str) {
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
}
