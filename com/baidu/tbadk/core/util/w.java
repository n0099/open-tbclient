package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w aaC;
    private long aax = 0;
    private long aay = 0;
    private String aaz = "";
    private String aaA = "";
    private final long aaB = 120000;

    public static w uE() {
        if (aaC == null) {
            synchronized (w.class) {
                if (aaC == null) {
                    aaC = new w();
                }
            }
        }
        return aaC;
    }

    public String uF() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aax > 120000) {
            if (com.baidu.adp.lib.util.k.jf()) {
                return "";
            }
            this.aax = currentTimeMillis;
            this.aaz = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.aaz;
    }

    public String dl(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aay > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.jf()) {
                return "";
            }
            this.aay = currentTimeMillis;
            this.aaA = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aaA;
        }
        return this.aaA;
    }
}
