package com.baidu.e.c;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes17.dex */
public class i {
    public static String getEncodeValue(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
