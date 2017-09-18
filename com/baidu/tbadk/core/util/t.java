package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t agb;
    private long afW = 0;
    private long afX = 0;
    private String afY = "";
    private String afZ = "";
    private final long aga = 120000;

    public static t va() {
        if (agb == null) {
            synchronized (t.class) {
                if (agb == null) {
                    agb = new t();
                }
            }
        }
        return agb;
    }

    public String vb() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afW > 120000) {
            if (com.baidu.adp.lib.util.k.hy()) {
                return "";
            }
            this.afW = currentTimeMillis;
            this.afY = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.afY;
    }

    public String dI(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afX > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hy()) {
                return "";
            }
            this.afX = currentTimeMillis;
            this.afZ = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.afZ;
        }
        return this.afZ;
    }
}
