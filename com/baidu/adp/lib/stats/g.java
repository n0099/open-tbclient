package com.baidu.adp.lib.stats;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
/* loaded from: classes.dex */
public class g {
    public static String v(Context context) {
        if (context == null) {
            return null;
        }
        if (com.baidu.adp.lib.util.i.fr()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.i.fs()) {
            int fz = com.baidu.adp.lib.util.i.fz();
            StringBuilder sb = new StringBuilder();
            switch (fz) {
                case 1:
                    sb.append('M');
                    break;
                case 2:
                    sb.append('U');
                    break;
                case 3:
                    sb.append('T');
                    break;
                default:
                    sb.append('N');
                    break;
            }
            if (com.baidu.adp.lib.util.i.isWap()) {
                sb.append("_WAP_");
            } else {
                sb.append("_NET_");
            }
            if (com.baidu.adp.lib.util.i.fu()) {
                sb.append("3G");
            } else if (com.baidu.adp.lib.util.i.ft()) {
                sb.append("4G");
            } else if (com.baidu.adp.lib.util.i.fv()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
