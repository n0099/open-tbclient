package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t cZi;
    private long cZd = 0;
    private long cZe = 0;
    private String cZf = "";
    private String cZg = "";
    private final long cZh = 120000;

    public static t aFZ() {
        if (cZi == null) {
            synchronized (t.class) {
                if (cZi == null) {
                    cZi = new t();
                }
            }
        }
        return cZi;
    }

    public String aGa() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.cZd > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cZd = currentTimeMillis;
            this.cZf = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.cZf;
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
        if (currentTimeMillis - this.cZe > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.cZe = currentTimeMillis;
            this.cZg = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.cZg;
        }
        return this.cZg;
    }
}
