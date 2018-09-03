package com.baidu.tbadk.core.util;

import android.os.Build;
/* loaded from: classes.dex */
public class g {
    public static boolean ye() {
        boolean z = true;
        if (com.baidu.tbadk.p.aa.iq()) {
            String trim = Build.MODEL.trim();
            String[] strArr = {"ANE-AL00", "CLT-AL01", "PACM00", "vivo Y85A", "vivo X21A"};
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (strArr[i].equalsIgnoreCase(trim)) {
                    break;
                } else {
                    i++;
                }
            }
            return z;
        }
        return false;
    }

    public static boolean yf() {
        return ap.equals(Build.MODEL.trim(), "ANE-AL00");
    }
}
