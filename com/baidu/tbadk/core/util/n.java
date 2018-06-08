package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class n {
    public static int et(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("game:detail")) {
                return 1;
            }
            if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                return 2;
            }
        }
        return 0;
    }
}
