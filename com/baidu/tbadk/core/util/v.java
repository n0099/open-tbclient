package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class v {
    private static v ejN;
    private long ejI = 0;
    private long ejJ = 0;
    private String ejK = "";
    private String ejL = "";
    private final long ejM = 120000;

    public static v biL() {
        if (ejN == null) {
            synchronized (v.class) {
                if (ejN == null) {
                    ejN = new v();
                }
            }
        }
        return ejN;
    }

    public String biM() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ejI > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.ejI = currentTimeMillis;
            this.ejK = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.ejK;
    }

    public String zY(String str) {
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

    public String zZ(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ejJ > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.ejJ = currentTimeMillis;
            this.ejL = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.ejL;
        }
        return this.ejL;
    }
}
