package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t cZx;
    private long cZs = 0;
    private long cZt = 0;
    private String cZu = "";
    private String cZv = "";
    private final long cZw = 120000;

    public static t aGf() {
        if (cZx == null) {
            synchronized (t.class) {
                if (cZx == null) {
                    cZx = new t();
                }
            }
        }
        return cZx;
    }

    public String aGg() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cZs > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cZs = currentTimeMillis;
            this.cZu = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cZu;
    }

    public String to(String str) {
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

    public String tp(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cZt > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cZt = currentTimeMillis;
            this.cZv = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.cZv;
        }
        return this.cZv;
    }
}
