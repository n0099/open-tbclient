package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class s {
    private static s agK;
    private long agF = 0;
    private long agG = 0;
    private String agH = "";
    private String agI = "";
    private final long agJ = 120000;

    public static s vc() {
        if (agK == null) {
            synchronized (s.class) {
                if (agK == null) {
                    agK = new s();
                }
            }
        }
        return agK;
    }

    public String vd() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.agF > 120000) {
            if (com.baidu.adp.lib.util.k.hH()) {
                return "";
            }
            this.agF = currentTimeMillis;
            this.agH = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.agH;
    }

    public String dN(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.agG > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hH()) {
                return "";
            }
            this.agG = currentTimeMillis;
            this.agI = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.agI;
        }
        return this.agI;
    }
}
