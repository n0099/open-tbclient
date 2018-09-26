package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t arI;
    private long arD = 0;
    private long arE = 0;
    private String arF = "";
    private String arG = "";
    private final long arH = 120000;

    public static t zI() {
        if (arI == null) {
            synchronized (t.class) {
                if (arI == null) {
                    arI = new t();
                }
            }
        }
        return arI;
    }

    public String zJ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.arD > 120000) {
            if (com.baidu.adp.lib.util.l.la()) {
                return "";
            }
            this.arD = currentTimeMillis;
            this.arF = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.arF;
    }

    public String eP(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.arE > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.la()) {
                return "";
            }
            this.arE = currentTimeMillis;
            this.arG = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.arG;
        }
        return this.arG;
    }
}
