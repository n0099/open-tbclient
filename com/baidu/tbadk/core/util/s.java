package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class s {
    private static s agI;
    private long agD = 0;
    private long agE = 0;
    private String agF = "";
    private String agG = "";
    private final long agH = 120000;

    public static s vc() {
        if (agI == null) {
            synchronized (s.class) {
                if (agI == null) {
                    agI = new s();
                }
            }
        }
        return agI;
    }

    public String vd() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.agD > 120000) {
            if (com.baidu.adp.lib.util.k.hH()) {
                return "";
            }
            this.agD = currentTimeMillis;
            this.agF = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.agF;
    }

    public String dN(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.agE > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hH()) {
                return "";
            }
            this.agE = currentTimeMillis;
            this.agG = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.agG;
        }
        return this.agG;
    }
}
