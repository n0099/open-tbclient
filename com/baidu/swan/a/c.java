package com.baidu.swan.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class c {
    private static String sUrl = "";

    public static String arv() {
        return sUrl;
    }

    public static void setDownloadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("url can not be empty");
        }
        sUrl = str;
    }
}
