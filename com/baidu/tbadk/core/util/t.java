package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t afm;
    private long afh = 0;
    private long afi = 0;
    private String afj = "";
    private String afk = "";
    private final long afl = 120000;

    public static t ux() {
        if (afm == null) {
            synchronized (t.class) {
                if (afm == null) {
                    afm = new t();
                }
            }
        }
        return afm;
    }

    public String uy() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afh > 120000) {
            if (com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afh = currentTimeMillis;
            this.afj = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.afj;
    }

    public String dA(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afi > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afi = currentTimeMillis;
            this.afk = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.afk;
        }
        return this.afk;
    }
}
