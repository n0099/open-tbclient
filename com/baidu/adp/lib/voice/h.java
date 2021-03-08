package com.baidu.adp.lib.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public class h {
    public static int Sh;
    public static int Si = 3;
    private static final String[] Sj = {RomUtils.MANUFACTURER_MEIZU};

    public static String getString(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean nT() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < Sj.length; i++) {
            if (Sj[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }
}
