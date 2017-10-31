package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t afH;
    private long afC = 0;
    private long afD = 0;
    private String afE = "";
    private String afF = "";
    private final long afG = 120000;

    public static t uE() {
        if (afH == null) {
            synchronized (t.class) {
                if (afH == null) {
                    afH = new t();
                }
            }
        }
        return afH;
    }

    public String uF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afC > 120000) {
            if (com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afC = currentTimeMillis;
            this.afE = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.afE;
    }

    public String dG(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.afD > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.hx()) {
                return "";
            }
            this.afD = currentTimeMillis;
            this.afF = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.afF;
        }
        return this.afF;
    }
}
