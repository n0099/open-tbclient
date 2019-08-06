package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bSd;
    private long bRY = 0;
    private long bRZ = 0;
    private String bSa = "";
    private String bSb = "";
    private final long bSc = 120000;

    public static t aix() {
        if (bSd == null) {
            synchronized (t.class) {
                if (bSd == null) {
                    bSd = new t();
                }
            }
        }
        return bSd;
    }

    public String aiy() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bRY > 120000) {
            if (com.baidu.adp.lib.util.l.ks()) {
                return "";
            }
            this.bRY = currentTimeMillis;
            this.bSa = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bSa;
    }

    public String nO(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bRZ > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ks()) {
                return "";
            }
            this.bRZ = currentTimeMillis;
            this.bSb = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bSb;
        }
        return this.bSb;
    }
}
