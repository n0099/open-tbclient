package com.baidu.a.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes12.dex */
public class g {
    public static String de(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
