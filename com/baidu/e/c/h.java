package com.baidu.e.c;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes14.dex */
public class h {
    public static String dA(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
