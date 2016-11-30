package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v aaL;
    private long aaG = 0;
    private long aaH = 0;
    private String aaI = "";
    private String aaJ = "";
    private final long aaK = 120000;

    public static v uN() {
        if (aaL == null) {
            synchronized (v.class) {
                if (aaL == null) {
                    aaL = new v();
                }
            }
        }
        return aaL;
    }

    public String uO() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aaG > 120000) {
            if (com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.aaG = currentTimeMillis;
            this.aaI = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aaI;
    }

    public String dq(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aaH > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.aaH = currentTimeMillis;
            this.aaJ = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aaJ;
        }
        return this.aaJ;
    }
}
