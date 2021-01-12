package com.baidu.adp.lib.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public class h {
    public static int QN;
    public static int QO = 3;
    private static final String[] QP = {RomUtils.MANUFACTURER_MEIZU};

    public static String getString(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean nU() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < QP.length; i++) {
            if (QP[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }
}
