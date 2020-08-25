package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes2.dex */
public class v {
    private static v ejJ;
    private long ejE = 0;
    private long ejF = 0;
    private String ejG = "";
    private String ejH = "";
    private final long ejI = 120000;

    public static v biL() {
        if (ejJ == null) {
            synchronized (v.class) {
                if (ejJ == null) {
                    ejJ = new v();
                }
            }
        }
        return ejJ;
    }

    public String biM() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ejE > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.ejE = currentTimeMillis;
            this.ejG = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.ejG;
    }

    public String zX(String str) {
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

    public String zY(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ejF > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.ejF = currentTimeMillis;
            this.ejH = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.ejH;
        }
        return this.ejH;
    }
}
