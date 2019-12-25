package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t cUW;
    private long cUR = 0;
    private long cUS = 0;
    private String cUT = "";
    private String cUU = "";
    private final long cUV = 120000;

    public static t aDw() {
        if (cUW == null) {
            synchronized (t.class) {
                if (cUW == null) {
                    cUW = new t();
                }
            }
        }
        return cUW;
    }

    public String aDx() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cUR > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cUR = currentTimeMillis;
            this.cUT = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cUT;
    }

    public String sW(String str) {
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

    public String sX(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cUS > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cUS = currentTimeMillis;
            this.cUU = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.cUU;
        }
        return this.cUU;
    }
}
