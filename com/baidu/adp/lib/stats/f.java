package com.baidu.adp.lib.stats;

import android.content.Context;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class f {
    public static String ac(Context context) {
        if (context == null) {
            return null;
        }
        if (i.hk()) {
            return "WIFI";
        }
        if (i.hl()) {
            int hs = i.hs();
            StringBuilder sb = new StringBuilder();
            switch (hs) {
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
            if (i.hn()) {
                sb.append("3G");
            } else if (i.hm()) {
                sb.append("4G");
            } else if (i.ho()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return "unknown";
    }
}
