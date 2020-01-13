package com.baidu.e.a.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/* loaded from: classes12.dex */
public class k {
    public static String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    public static String cE(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    public static String cF(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
    }
}
