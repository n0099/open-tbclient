package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t bQX;
    private long bQS = 0;
    private long bQT = 0;
    private String bQU = "";
    private String bQV = "";
    private final long bQW = 120000;

    public static t aht() {
        if (bQX == null) {
            synchronized (t.class) {
                if (bQX == null) {
                    bQX = new t();
                }
            }
        }
        return bQX;
    }

    public String ahu() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bQS > 120000) {
            if (com.baidu.adp.lib.util.l.kh()) {
                return "";
            }
            this.bQS = currentTimeMillis;
            this.bQU = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.bQU;
    }

    public String nC(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.bQT > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.kh()) {
                return "";
            }
            this.bQT = currentTimeMillis;
            this.bQV = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.bQV;
        }
        return this.bQV;
    }
}
