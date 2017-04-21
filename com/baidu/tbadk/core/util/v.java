package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class v {
    private static v aeY;
    private long aeT = 0;
    private long aeU = 0;
    private String aeV = "";
    private String aeW = "";
    private final long aeX = 120000;

    public static v vn() {
        if (aeY == null) {
            synchronized (v.class) {
                if (aeY == null) {
                    aeY = new v();
                }
            }
        }
        return aeY;
    }

    public String vo() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeT > 120000) {
            if (com.baidu.adp.lib.util.k.hA()) {
                return "";
            }
            this.aeT = currentTimeMillis;
            this.aeV = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aeV;
    }

    public String dp(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aeU > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.hA()) {
                return "";
            }
            this.aeU = currentTimeMillis;
            this.aeW = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aeW;
        }
        return this.aeW;
    }
}
