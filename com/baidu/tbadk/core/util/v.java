package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v eZR;
    private long eZM = 0;
    private long eZN = 0;
    private String eZO = "";
    private String eZP = "";
    private final long eZQ = 120000;

    public static v bsm() {
        if (eZR == null) {
            synchronized (v.class) {
                if (eZR == null) {
                    eZR = new v();
                }
            }
        }
        return eZR;
    }

    public String bsn() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eZM > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eZM = currentTimeMillis;
            this.eZO = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eZO;
    }

    public String AX(String str) {
        try {
            String host = new URL(str).getHost();
            if (!TextUtils.isEmpty(host)) {
                return UtilHelper.getIpFromDomain(host);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
        return null;
    }

    public String AY(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eZN > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eZN = currentTimeMillis;
            this.eZP = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eZP;
        }
        return this.eZP;
    }
}
