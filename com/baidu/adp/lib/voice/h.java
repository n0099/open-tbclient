package com.baidu.adp.lib.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class h {
    public static int uA = 3;
    private static final String[] uB = {"meizu"};
    public static int uz;

    public static String getString(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean hD() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < uB.length; i++) {
            if (uB[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }
}
