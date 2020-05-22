package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import java.net.URL;
/* loaded from: classes.dex */
public class t {
    private static t dMU;
    private long dMP = 0;
    private long dMQ = 0;
    private String dMR = "";
    private String dMS = "";
    private final long dMT = 120000;

    public static t aUv() {
        if (dMU == null) {
            synchronized (t.class) {
                if (dMU == null) {
                    dMU = new t();
                }
            }
        }
        return dMU;
    }

    public String aUw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dMP > 120000) {
            if (com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dMP = currentTimeMillis;
            this.dMR = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.dMR;
    }

    public String wl(String str) {
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

    public String wm(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dMQ > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.isMainThread()) {
                return "";
            }
            this.dMQ = currentTimeMillis;
            this.dMS = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.dMS;
        }
        return this.dMS;
    }
}
