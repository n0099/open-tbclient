package com.baidu.adp.lib.stats;

import android.content.Context;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class d {
    public static String ad(Context context) {
        if (context == null) {
            return null;
        }
        if (i.hs()) {
            return "WIFI";
        }
        if (i.ht()) {
            int hA = i.hA();
            StringBuilder sb = new StringBuilder();
            switch (hA) {
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
            if (i.hv()) {
                sb.append("3G");
            } else if (i.hu()) {
                sb.append("4G");
            } else if (i.hw()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return "unknown";
    }
}
