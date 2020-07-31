package com.baidu.b.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class g {
    public static String df(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
