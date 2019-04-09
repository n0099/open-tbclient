package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bJm;
    private long bJh = 0;
    private long bJi = 0;
    private String bJj = "";
    private String bJk = "";
    private final long bJl = 120000;

    public static t acv() {
        if (bJm == null) {
            synchronized (t.class) {
                if (bJm == null) {
                    bJm = new t();
                }
            }
        }
        return bJm;
    }

    public String acw() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJh > 120000) {
            if (com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJh = currentTimeMillis;
            this.bJj = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bJj;
    }

    public String mv(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJi > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJi = currentTimeMillis;
            this.bJk = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bJk;
        }
        return this.bJk;
    }
}
