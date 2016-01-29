package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v abC;
    private long abx = 0;
    private long aby = 0;
    private String abz = "";
    private String abA = "";
    private final long abB = 120000;

    public static v vs() {
        if (abC == null) {
            synchronized (v.class) {
                if (abC == null) {
                    abC = new v();
                }
            }
        }
        return abC;
    }

    public String vt() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.abx > 120000) {
            if (com.baidu.adp.lib.util.k.jp()) {
                return "";
            }
            this.abx = currentTimeMillis;
            this.abz = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.abz;
    }

    public String dl(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aby > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.jp()) {
                return "";
            }
            this.aby = currentTimeMillis;
            this.abA = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.abA;
        }
        return this.abA;
    }
}
