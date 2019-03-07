package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bJi;
    private long bJd = 0;
    private long bJe = 0;
    private String bJf = "";
    private String bJg = "";
    private final long bJh = 120000;

    public static t acy() {
        if (bJi == null) {
            synchronized (t.class) {
                if (bJi == null) {
                    bJi = new t();
                }
            }
        }
        return bJi;
    }

    public String acz() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJd > 120000) {
            if (com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJd = currentTimeMillis;
            this.bJf = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bJf;
    }

    public String mu(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bJe > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.ln()) {
                return "";
            }
            this.bJe = currentTimeMillis;
            this.bJg = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bJg;
        }
        return this.bJg;
    }
}
