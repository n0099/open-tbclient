package com.baidu.location;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class CommonEncrypt {
    public static boolean a;

    static {
        try {
            System.loadLibrary("locSDK4d");
            a = true;
        } catch (Exception e) {
            a = false;
        }
        a = true;
    }

    public static String a(String str) {
        if (a) {
            try {
                return URLEncoder.encode(a(encrypt(str.getBytes())), "UTF-8");
            } catch (Exception e) {
                return "";
            }
        }
        return null;
    }

    public static String a(byte[] bArr) {
        try {
            return com.baidu.location.a.b.b.a(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static native byte[] encrypt(byte[] bArr);
}
