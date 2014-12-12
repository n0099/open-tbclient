package com.baidu.tbadk.core.util;

import android.text.TextUtils;
/* loaded from: classes.dex */
public class u {
    public static int cv(String str) {
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
}
