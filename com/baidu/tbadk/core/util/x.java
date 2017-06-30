package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class x {
    private static x aeR;
    private long aeM = 0;
    private long aeN = 0;
    private String aeO = "";
    private String aeP = "";
    private final long aeQ = 120000;

    public static x uM() {
        if (aeR == null) {
            synchronized (x.class) {
                if (aeR == null) {
                    aeR = new x();
                }
            }
        }
        return aeR;
    }

    public String uN() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeM > 120000) {
            if (com.baidu.adp.lib.util.k.hz()) {
                return "";
            }
            this.aeM = currentTimeMillis;
            this.aeO = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aeO;
    }

    public String dE(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeN > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hz()) {
                return "";
            }
            this.aeN = currentTimeMillis;
            this.aeP = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aeP;
        }
        return this.aeP;
    }
}
