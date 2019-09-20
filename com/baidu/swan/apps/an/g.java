package com.baidu.swan.apps.an;

import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class g {
    private static String baq;

    public static String Pq() {
        if (TextUtils.isEmpty(baq)) {
            synchronized (g.class) {
                baq = Pr();
            }
        }
        return baq;
    }

    private static String Pr() {
        String replace;
        String replace2;
        String replace3;
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            replace = "NUL";
        } else {
            replace = str.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        String str2 = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str2)) {
            replace2 = "0.0";
        } else {
            replace2 = str2.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        int i = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str3)) {
            replace3 = "NUL";
        } else {
            replace3 = str3.replace("_", Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        return replace + "_" + replace2 + "_" + i + "_" + replace3;
    }
}
