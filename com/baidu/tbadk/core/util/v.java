package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v aeX;
    private long aeS = 0;
    private long aeT = 0;
    private String aeU = "";
    private String aeV = "";
    private final long aeW = 120000;

    public static v vn() {
        if (aeX == null) {
            synchronized (v.class) {
                if (aeX == null) {
                    aeX = new v();
                }
            }
        }
        return aeX;
    }

    public String vo() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeS > 120000) {
            if (com.baidu.adp.lib.util.k.hz()) {
                return "";
            }
            this.aeS = currentTimeMillis;
            this.aeU = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aeU;
    }

    public String dp(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeT > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hz()) {
                return "";
            }
            this.aeT = currentTimeMillis;
            this.aeV = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aeV;
        }
        return this.aeV;
    }
}
