package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t agf;
    private long afZ = 0;
    private long aga = 0;
    private String agb = "";
    private String agc = "";
    private final long agd = 120000;

    public static t uH() {
        if (agf == null) {
            synchronized (t.class) {
                if (agf == null) {
                    agf = new t();
                }
            }
        }
        return agf;
    }

    public String uI() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afZ > 120000) {
            if (com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afZ = currentTimeMillis;
            this.agb = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.agb;
    }

    public String dG(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aga > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.aga = currentTimeMillis;
            this.agc = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.agc;
        }
        return this.agc;
    }
}
