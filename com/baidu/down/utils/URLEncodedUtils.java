package com.baidu.down.utils;

import com.baidu.down.common.NameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public static String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final String NAME_VALUE_SEPARATOR = "=";
    public static final String PARAMETER_SEPARATOR = "&";

    public static String decode(String str, String str2) {
        if (str2 == null) {
            try {
                str2 = DEFAULT_CONTENT_CHARSET;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return URLDecoder.decode(str, str2);
    }

    public static String encode(String str, String str2) {
        if (str2 == null) {
            try {
                str2 = DEFAULT_CONTENT_CHARSET;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return URLEncoder.encode(str, str2);
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String encode = encode(nameValuePair.getName(), str);
            String value = nameValuePair.getValue();
            String encode2 = value != null ? encode(value, str) : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }
}
