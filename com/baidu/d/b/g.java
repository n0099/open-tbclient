package com.baidu.d.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class g {
    public static String dq(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
