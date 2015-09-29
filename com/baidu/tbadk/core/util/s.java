package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class s {
    private static s ZK;
    private long ZF = 0;
    private long ZG = 0;
    private String ZH = "";
    private String ZI = "";
    private final long ZJ = 120000;

    public static s tZ() {
        if (ZK == null) {
            synchronized (s.class) {
                if (ZK == null) {
                    ZK = new s();
                }
            }
        }
        return ZK;
    }

    public String ua() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZF > 120000) {
            if (com.baidu.adp.lib.util.k.jc()) {
                return "";
            }
            this.ZF = currentTimeMillis;
            this.ZH = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.ZH;
    }

    public String db(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZG > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.jc()) {
                return "";
            }
            this.ZG = currentTimeMillis;
            this.ZI = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.ZI;
        }
        return this.ZI;
    }
}
