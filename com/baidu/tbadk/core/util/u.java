package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class u {
    private static u apk;
    private long apf = 0;
    private long apg = 0;
    private String aph = "";
    private String api = "";
    private final long apj = 120000;

    public static u yD() {
        if (apk == null) {
            synchronized (u.class) {
                if (apk == null) {
                    apk = new u();
                }
            }
        }
        return apk;
    }

    public String yE() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.apf > 120000) {
            if (com.baidu.adp.lib.util.l.jU()) {
                return "";
            }
            this.apf = currentTimeMillis;
            this.aph = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aph;
    }

    public String ex(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.apg > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.jU()) {
                return "";
            }
            this.apg = currentTimeMillis;
            this.api = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.api;
        }
        return this.api;
    }
}
