package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bRX;
    private long bRS = 0;
    private long bRT = 0;
    private String bRU = "";
    private String bRV = "";
    private final long bRW = 120000;

    public static t aiv() {
        if (bRX == null) {
            synchronized (t.class) {
                if (bRX == null) {
                    bRX = new t();
                }
            }
        }
        return bRX;
    }

    public String aiw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bRS > 120000) {
            if (com.baidu.adp.lib.util.l.ks()) {
                return "";
            }
            this.bRS = currentTimeMillis;
            this.bRU = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bRU;
    }

    public String nO(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bRT > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ks()) {
                return "";
            }
            this.bRT = currentTimeMillis;
            this.bRV = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bRV;
        }
        return this.bRV;
    }
}
