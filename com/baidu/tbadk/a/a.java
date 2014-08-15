package com.baidu.tbadk.a;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class a {
    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("game:detail")) {
                return 1;
            }
            if (str.startsWith("http")) {
                return 2;
            }
        }
        return 0;
    }

    public static String b(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(":")) == null) {
            return null;
        }
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2) && str2.contains("TBCGameID=")) {
                int indexOf = str2.indexOf("=");
                return indexOf + 1 < str2.length() ? str2.substring(indexOf + 1, str2.length()) : null;
            }
        }
        return null;
    }
}
