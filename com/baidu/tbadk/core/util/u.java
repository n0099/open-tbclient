package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class u {
    private static u apJ;
    private long apE = 0;
    private long apF = 0;
    private String apG = "";
    private String apH = "";
    private final long apI = 120000;

    public static u yO() {
        if (apJ == null) {
            synchronized (u.class) {
                if (apJ == null) {
                    apJ = new u();
                }
            }
        }
        return apJ;
    }

    public String yP() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.apE > 120000) {
            if (com.baidu.adp.lib.util.l.jT()) {
                return "";
            }
            this.apE = currentTimeMillis;
            this.apG = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.apG;
    }

    public String ez(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.apF > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.jT()) {
                return "";
            }
            this.apF = currentTimeMillis;
            this.apH = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.apH;
        }
        return this.apH;
    }
}
