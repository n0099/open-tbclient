package com.baidu.adp.lib.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class l {
    public static int zi;
    public static int zj = 3;
    private static final String[] zk = {"meizu"};

    public static String getString(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean jt() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < zk.length; i++) {
            if (zk[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }
}
