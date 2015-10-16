package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class s {
    private static s ZM;
    private long ZH = 0;
    private long ZI = 0;
    private String ZJ = "";
    private String ZK = "";
    private final long ZL = 120000;

    public static s tZ() {
        if (ZM == null) {
            synchronized (s.class) {
                if (ZM == null) {
                    ZM = new s();
                }
            }
        }
        return ZM;
    }

    public String ua() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZH > 120000) {
            if (com.baidu.adp.lib.util.k.jc()) {
                return "";
            }
            this.ZH = currentTimeMillis;
            this.ZJ = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.ZJ;
    }

    public String dc(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZI > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.jc()) {
                return "";
            }
            this.ZI = currentTimeMillis;
            this.ZK = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.ZK;
        }
        return this.ZK;
    }
}
