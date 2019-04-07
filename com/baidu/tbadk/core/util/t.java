package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bJl;
    private long bJg = 0;
    private long bJh = 0;
    private String bJi = "";
    private String bJj = "";
    private final long bJk = 120000;

    public static t acv() {
        if (bJl == null) {
            synchronized (t.class) {
                if (bJl == null) {
                    bJl = new t();
                }
            }
        }
        return bJl;
    }

    public String acw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJg > 120000) {
            if (com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJg = currentTimeMillis;
            this.bJi = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bJi;
    }

    public String mv(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJh > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJh = currentTimeMillis;
            this.bJj = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bJj;
        }
        return this.bJj;
    }
}
