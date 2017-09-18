package com.baidu.adp.lib.stats;

import android.content.Context;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class d {
    public static String ab(Context context) {
        if (context == null) {
            return null;
        }
        if (i.hj()) {
            return "WIFI";
        }
        if (i.hk()) {
            int hr = i.hr();
            StringBuilder sb = new StringBuilder();
            switch (hr) {
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
            if (i.isWap()) {
                sb.append("_WAP_");
            } else {
                sb.append("_NET_");
            }
            if (i.hm()) {
                sb.append("3G");
            } else if (i.hl()) {
                sb.append("4G");
            } else if (i.hn()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return "unknown";
    }
}
