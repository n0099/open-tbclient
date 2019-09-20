package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bSE;
    private long bSz = 0;
    private long bSA = 0;
    private String bSB = "";
    private String bSC = "";
    private final long bSD = 120000;

    public static t aiB() {
        if (bSE == null) {
            synchronized (t.class) {
                if (bSE == null) {
                    bSE = new t();
                }
            }
        }
        return bSE;
    }

    public String aiC() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bSz > 120000) {
            if (com.baidu.adp.lib.util.l.ks()) {
                return "";
            }
            this.bSz = currentTimeMillis;
            this.bSB = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bSB;
    }

    public String nQ(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bSA > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ks()) {
                return "";
            }
            this.bSA = currentTimeMillis;
            this.bSC = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bSC;
        }
        return this.bSC;
    }
}
