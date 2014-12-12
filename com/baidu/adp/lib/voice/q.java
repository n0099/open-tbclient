package com.baidu.adp.lib.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class q {
    public static int oC = 3;
    private static final String[] oD = new String[0];
    private static final String[] oE = {"meizu"};

    public static String getString(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean fM() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < oE.length; i++) {
            if (oE[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean fN() {
        String str = Build.MODEL;
        if (str == null) {
            return true;
        }
        for (int i = 0; i < oD.length; i++) {
            if (oD[i].equals(str)) {
                return false;
            }
        }
        return true;
    }
}
