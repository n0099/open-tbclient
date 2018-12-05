package com.baidu.adp.lib.stats;

import android.content.Context;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class d {
    public static String getNetType(Context context) {
        if (context == null) {
            return null;
        }
        if (j.kW()) {
            return "WIFI";
        }
        if (j.kX()) {
            int ld = j.ld();
            StringBuilder sb = new StringBuilder();
            switch (ld) {
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
            if (j.isWap()) {
                sb.append("_WAP_");
            } else {
                sb.append("_NET_");
            }
            if (j.kZ()) {
                sb.append("3G");
            } else if (j.kY()) {
                sb.append("4G");
            } else if (j.la()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return "unknown";
    }
}
