package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class s {
    private static s afn;
    private long afi = 0;
    private long afj = 0;
    private String afk = "";
    private String afl = "";
    private final long afm = 120000;

    public static s uS() {
        if (afn == null) {
            synchronized (s.class) {
                if (afn == null) {
                    afn = new s();
                }
            }
        }
        return afn;
    }

    public String uT() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afi > 120000) {
            if (com.baidu.adp.lib.util.k.hx()) {
                return "";
            }
            this.afi = currentTimeMillis;
            this.afk = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.afk;
    }

    public String dH(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afj > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hx()) {
                return "";
            }
            this.afj = currentTimeMillis;
            this.afl = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.afl;
        }
        return this.afl;
    }
}
