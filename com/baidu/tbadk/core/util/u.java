package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class u {
    private static u apj;
    private long ape = 0;
    private long apf = 0;
    private String apg = "";
    private String aph = "";
    private final long api = 120000;

    public static u yF() {
        if (apj == null) {
            synchronized (u.class) {
                if (apj == null) {
                    apj = new u();
                }
            }
        }
        return apj;
    }

    public String yG() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ape > 120000) {
            if (com.baidu.adp.lib.util.l.jU()) {
                return "";
            }
            this.ape = currentTimeMillis;
            this.apg = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.apg;
    }

    public String ex(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.apf > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.jU()) {
                return "";
            }
            this.apf = currentTimeMillis;
            this.aph = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aph;
        }
        return this.aph;
    }
}
