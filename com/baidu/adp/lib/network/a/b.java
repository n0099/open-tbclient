package com.baidu.adp.lib.network.a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class b {
    public static boolean hg() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static int hh() {
        if (hg()) {
            try {
                return R(((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo().getSubtype());
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    public static boolean hi() {
        return 1 == hh();
    }

    public static int R(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 0;
        }
    }

    public static boolean al(String str) {
        return str != null && str.contains("vnd.wap.wml");
    }
}
