package com.baidu.adp.lib.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class q {
    public static int oD = 3;
    private static final String[] oE = new String[0];
    private static final String[] oF = {"meizu"};

    public static String getString(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean fK() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < oF.length; i++) {
            if (oF[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean fL() {
        String str = Build.MODEL;
        if (str == null) {
            return true;
        }
        for (int i = 0; i < oE.length; i++) {
            if (oE[i].equals(str)) {
                return false;
            }
        }
        return true;
    }
}
