package com.baidu.adp.lib.h;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class f {
    public static String H(Context context) {
        if (k.iY()) {
            return TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        if (k.isWap()) {
            return "2";
        }
        return "1";
    }

    public static String getNetType(Context context) {
        if (context == null) {
            return null;
        }
        if (k.iY()) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (k.iZ()) {
            int jf = k.jf();
            StringBuilder sb = new StringBuilder();
            switch (jf) {
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
            if (k.isWap()) {
                sb.append("_WAP_");
            } else {
                sb.append("_NET_");
            }
            if (k.jb()) {
                sb.append("3G");
            } else if (k.ja()) {
                sb.append("4G");
            } else if (k.hi()) {
                sb.append("2G");
            } else {
                sb.append('N');
            }
            return sb.toString();
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
