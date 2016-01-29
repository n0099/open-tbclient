package com.baidu.adp.lib.stats;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class g {
    public static String F(Context context) {
        if (com.baidu.adp.lib.util.i.ja()) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (com.baidu.adp.lib.util.i.isWap()) {
            return "2";
        }
        return "1";
    }

    public static String getNetType(Context context) {
        if (context == null) {
            return null;
        }
        if (com.baidu.adp.lib.util.i.ja()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.i.jb()) {
            int ji = com.baidu.adp.lib.util.i.ji();
            StringBuilder sb = new StringBuilder();
            switch (ji) {
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
            if (com.baidu.adp.lib.util.i.jd()) {
                sb.append("3G");
            } else if (com.baidu.adp.lib.util.i.jc()) {
                sb.append("4G");
            } else if (com.baidu.adp.lib.util.i.je()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
