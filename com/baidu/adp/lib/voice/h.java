package com.baidu.adp.lib.voice;

import android.app.Application;
import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes.dex */
public class h {
    public static int QM;
    public static int QN = 3;
    private static final String[] QO = {RomUtils.MANUFACTURER_MEIZU};

    public static String getString(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        return app == null ? "" : app.getString(i);
    }

    public static boolean ot() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (int i = 0; i < QO.length; i++) {
            if (QO[i].equals(lowerCase)) {
                return true;
            }
        }
        return false;
    }
}
