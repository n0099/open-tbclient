package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t agc;
    private long afX = 0;
    private long afY = 0;
    private String afZ = "";
    private String aga = "";
    private final long agb = 120000;

    public static t va() {
        if (agc == null) {
            synchronized (t.class) {
                if (agc == null) {
                    agc = new t();
                }
            }
        }
        return agc;
    }

    public String vb() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afX > 120000) {
            if (com.baidu.adp.lib.util.k.hy()) {
                return "";
            }
            this.afX = currentTimeMillis;
            this.afZ = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.afZ;
    }

    public String dI(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afY > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hy()) {
                return "";
            }
            this.afY = currentTimeMillis;
            this.aga = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aga;
        }
        return this.aga;
    }
}
