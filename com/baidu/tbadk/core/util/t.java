package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aVH;
    private long aVC = 0;
    private long aVD = 0;
    private String aVE = "";
    private String aVF = "";
    private final long aVG = 120000;

    public static t Cp() {
        if (aVH == null) {
            synchronized (t.class) {
                if (aVH == null) {
                    aVH = new t();
                }
            }
        }
        return aVH;
    }

    public String Cq() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aVC > 120000) {
            if (com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aVC = currentTimeMillis;
            this.aVE = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aVE;
    }

    public String ee(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aVD > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aVD = currentTimeMillis;
            this.aVF = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aVF;
        }
        return this.aVF;
    }
}
