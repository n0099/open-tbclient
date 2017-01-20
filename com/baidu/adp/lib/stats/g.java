package com.baidu.adp.lib.stats;

import android.content.Context;
/* loaded from: classes.dex */
public class g {
    public static String F(Context context) {
        if (context == null) {
            return null;
        }
        if (com.baidu.adp.lib.util.i.gl()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.i.gm()) {
            int gt = com.baidu.adp.lib.util.i.gt();
            StringBuilder sb = new StringBuilder();
            switch (gt) {
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
            if (com.baidu.adp.lib.util.i.go()) {
                sb.append("3G");
            } else if (com.baidu.adp.lib.util.i.gn()) {
                sb.append("4G");
            } else if (com.baidu.adp.lib.util.i.gp()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return "unknown";
    }
}
