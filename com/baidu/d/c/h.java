package com.baidu.d.c;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes11.dex */
public class h {
    public static String dt(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
