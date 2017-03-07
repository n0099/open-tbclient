package com.baidu.adp.lib.stats;

import android.content.Context;
import com.baidu.adp.lib.util.i;
/* loaded from: classes.dex */
public class f {
    public static String ad(Context context) {
        if (context == null) {
            return null;
        }
        if (i.hf()) {
            return "WIFI";
        }
        if (i.hg()) {
            int hn = i.hn();
            StringBuilder sb = new StringBuilder();
            switch (hn) {
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
            if (i.hi()) {
                sb.append("3G");
            } else if (i.hh()) {
                sb.append("4G");
            } else if (i.hj()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return "unknown";
    }
}
