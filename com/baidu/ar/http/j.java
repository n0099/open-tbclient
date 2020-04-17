package com.baidu.ar.http;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
final class j {
    public static String a(String str, Charset charset) {
        String name;
        if (charset != null) {
            try {
                name = charset.name();
            } catch (UnsupportedEncodingException e) {
                return str;
            }
        } else {
            name = null;
        }
        return URLEncoder.encode(str, name);
    }

    public static String[] ai(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(58)) <= 0 || indexOf == str.length() - 1) {
            return null;
        }
        return new String[]{str.substring(0, indexOf), str.substring(indexOf + 1).trim()};
    }

    public static String aj(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
        return TextUtils.isEmpty(contentTypeFor) ? "application/octet-stream" : contentTypeFor;
    }

    public static String ak(String str) {
        return (str == null || !str.startsWith("\ufeff")) ? str : str.substring(1);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
