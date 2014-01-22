package com.baidu.sapi2.utils;

import android.os.Build;
import android.text.TextUtils;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class f {
    public static String a() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.VERSION.RELEASE) ? "" : Build.VERSION.RELEASE, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String b() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.BRAND) ? "" : Build.BRAND, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    public static String c() {
        try {
            return URLEncoder.encode(TextUtils.isEmpty(Build.MODEL) ? "" : Build.MODEL, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }
}
