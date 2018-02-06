package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aVT;
    private long aVO = 0;
    private long aVP = 0;
    private String aVQ = "";
    private String aVR = "";
    private final long aVS = 120000;

    public static t Cq() {
        if (aVT == null) {
            synchronized (t.class) {
                if (aVT == null) {
                    aVT = new t();
                }
            }
        }
        return aVT;
    }

    public String Cr() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aVO > 120000) {
            if (com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aVO = currentTimeMillis;
            this.aVQ = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aVQ;
    }

    public String ee(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aVP > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.oZ()) {
                return "";
            }
            this.aVP = currentTimeMillis;
            this.aVR = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aVR;
        }
        return this.aVR;
    }
}
