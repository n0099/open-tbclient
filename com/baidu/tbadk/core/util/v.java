package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v aeq;
    private long ael = 0;
    private long aem = 0;
    private String aen = "";
    private String aeo = "";
    private final long aep = 120000;

    public static v uA() {
        if (aeq == null) {
            synchronized (v.class) {
                if (aeq == null) {
                    aeq = new v();
                }
            }
        }
        return aeq;
    }

    public String uB() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ael > 120000) {
            if (com.baidu.adp.lib.util.k.hA()) {
                return "";
            }
            this.ael = currentTimeMillis;
            this.aen = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aen;
    }

    public String dn(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aem > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hA()) {
                return "";
            }
            this.aem = currentTimeMillis;
            this.aeo = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aeo;
        }
        return this.aeo;
    }
}
