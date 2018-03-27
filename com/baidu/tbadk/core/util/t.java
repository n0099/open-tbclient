package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aVJ;
    private long aVE = 0;
    private long aVF = 0;
    private String aVG = "";
    private String aVH = "";
    private final long aVI = 120000;

    public static t Cq() {
        if (aVJ == null) {
            synchronized (t.class) {
                if (aVJ == null) {
                    aVJ = new t();
                }
            }
        }
        return aVJ;
    }

    public String Cr() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aVE > 120000) {
            if (com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aVE = currentTimeMillis;
            this.aVG = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aVG;
    }

    public String ee(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aVF > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aVF = currentTimeMillis;
            this.aVH = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aVH;
        }
        return this.aVH;
    }
}
