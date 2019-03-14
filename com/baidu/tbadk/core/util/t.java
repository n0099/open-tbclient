package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bJj;
    private long bJe = 0;
    private long bJf = 0;
    private String bJg = "";
    private String bJh = "";
    private final long bJi = 120000;

    public static t acy() {
        if (bJj == null) {
            synchronized (t.class) {
                if (bJj == null) {
                    bJj = new t();
                }
            }
        }
        return bJj;
    }

    public String acz() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJe > 120000) {
            if (com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJe = currentTimeMillis;
            this.bJg = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bJg;
    }

    public String mu(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJf > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJf = currentTimeMillis;
            this.bJh = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bJh;
        }
        return this.bJh;
    }
}
