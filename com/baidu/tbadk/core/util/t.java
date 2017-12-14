package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t afY;
    private long afT = 0;
    private long afU = 0;
    private String afV = "";
    private String afW = "";
    private final long afX = 120000;

    public static t uE() {
        if (afY == null) {
            synchronized (t.class) {
                if (afY == null) {
                    afY = new t();
                }
            }
        }
        return afY;
    }

    public String uF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afT > 120000) {
            if (com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afT = currentTimeMillis;
            this.afV = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.afV;
    }

    public String dG(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afU > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afU = currentTimeMillis;
            this.afW = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.afW;
        }
        return this.afW;
    }
}
