package com.baidu.adp.lib.stats;

import android.content.Context;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class d {
    public static String getNetType(Context context) {
        if (context == null) {
            return null;
        }
        if (j.kd()) {
            return "WIFI";
        }
        if (j.ke()) {
            int kk = j.kk();
            StringBuilder sb = new StringBuilder();
            switch (kk) {
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
            if (j.ko()) {
                sb.append("_WAP_");
            } else {
                sb.append("_NET_");
            }
            if (j.kg()) {
                sb.append("3G");
            } else if (j.kf()) {
                sb.append("4G");
            } else if (j.kh()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return "unknown";
    }
}
