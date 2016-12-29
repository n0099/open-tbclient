package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v aaf;
    private long aaa = 0;
    private long aab = 0;
    private String aac = "";
    private String aad = "";
    private final long aae = 120000;

    public static v uz() {
        if (aaf == null) {
            synchronized (v.class) {
                if (aaf == null) {
                    aaf = new v();
                }
            }
        }
        return aaf;
    }

    public String uA() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aaa > 120000) {
            if (com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.aaa = currentTimeMillis;
            this.aac = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aac;
    }

    public String dr(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aab > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.aab = currentTimeMillis;
            this.aad = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aad;
        }
        return this.aad;
    }
}
