package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class u {
    private static u Zt;
    private long Zo = 0;
    private long Zp = 0;
    private String Zq = "";
    private String Zr = "";
    private final long Zs = 120000;

    public static u ut() {
        if (Zt == null) {
            synchronized (u.class) {
                if (Zt == null) {
                    Zt = new u();
                }
            }
        }
        return Zt;
    }

    public String uu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Zo > 120000) {
            if (com.baidu.adp.lib.util.k.gA()) {
                return "";
            }
            this.Zo = currentTimeMillis;
            this.Zq = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.Zq;
    }

    public String dp(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Zp > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.gA()) {
                return "";
            }
            this.Zp = currentTimeMillis;
            this.Zr = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.Zr;
        }
        return this.Zr;
    }
}
