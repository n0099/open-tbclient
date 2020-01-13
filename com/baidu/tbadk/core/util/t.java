package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t cVg;
    private long cVb = 0;
    private long cVc = 0;
    private String cVd = "";
    private String cVe = "";
    private final long cVf = 120000;

    public static t aDP() {
        if (cVg == null) {
            synchronized (t.class) {
                if (cVg == null) {
                    cVg = new t();
                }
            }
        }
        return cVg;
    }

    public String aDQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cVb > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cVb = currentTimeMillis;
            this.cVd = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cVd;
    }

    public String sZ(String str) {
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

    public String ta(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cVc > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cVc = currentTimeMillis;
            this.cVe = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.cVe;
        }
        return this.cVe;
    }
}
