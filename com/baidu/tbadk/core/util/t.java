package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bQW;
    private long bQR = 0;
    private long bQS = 0;
    private String bQT = "";
    private String bQU = "";
    private final long bQV = 120000;

    public static t aht() {
        if (bQW == null) {
            synchronized (t.class) {
                if (bQW == null) {
                    bQW = new t();
                }
            }
        }
        return bQW;
    }

    public String ahu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bQR > 120000) {
            if (com.baidu.adp.lib.util.l.kh()) {
                return "";
            }
            this.bQR = currentTimeMillis;
            this.bQT = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bQT;
    }

    public String nD(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bQS > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.kh()) {
                return "";
            }
            this.bQS = currentTimeMillis;
            this.bQU = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bQU;
        }
        return this.bQU;
    }
}
