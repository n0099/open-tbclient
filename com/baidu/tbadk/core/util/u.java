package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class u {
    private static u eXC;
    private long eXx = 0;
    private long eXy = 0;
    private String eXz = "";
    private String eXA = "";
    private final long eXB = 120000;

    public static u brS() {
        if (eXC == null) {
            synchronized (u.class) {
                if (eXC == null) {
                    eXC = new u();
                }
            }
        }
        return eXC;
    }

    public String brT() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eXx > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eXx = currentTimeMillis;
            this.eXz = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.eXz;
    }

    public String AG(String str) {
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

    public String AH(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.eXy > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.eXy = currentTimeMillis;
            this.eXA = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.eXA;
        }
        return this.eXA;
    }
}
