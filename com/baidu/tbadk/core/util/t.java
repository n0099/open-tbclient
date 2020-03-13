package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t cZk;
    private long cZf = 0;
    private long cZg = 0;
    private String cZh = "";
    private String cZi = "";
    private final long cZj = 120000;

    public static t aGb() {
        if (cZk == null) {
            synchronized (t.class) {
                if (cZk == null) {
                    cZk = new t();
                }
            }
        }
        return cZk;
    }

    public String aGc() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cZf > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cZf = currentTimeMillis;
            this.cZh = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cZh;
    }

    public String tp(String str) {
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

    public String tq(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cZg > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cZg = currentTimeMillis;
            this.cZi = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.cZi;
        }
        return this.cZi;
    }
}
