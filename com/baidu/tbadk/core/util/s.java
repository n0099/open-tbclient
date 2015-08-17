package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class s {
    private static s ZH;
    private long ZC = 0;
    private long ZD = 0;
    private String ZE = "";
    private String ZF = "";
    private final long ZG = 120000;

    public static s tW() {
        if (ZH == null) {
            synchronized (s.class) {
                if (ZH == null) {
                    ZH = new s();
                }
            }
        }
        return ZH;
    }

    public String tX() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZC > 120000) {
            if (com.baidu.adp.lib.util.k.je()) {
                return "";
            }
            this.ZC = currentTimeMillis;
            this.ZE = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.ZE;
    }

    public String cS(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZD > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.je()) {
                return "";
            }
            this.ZD = currentTimeMillis;
            this.ZF = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.ZF;
        }
        return this.ZF;
    }
}
