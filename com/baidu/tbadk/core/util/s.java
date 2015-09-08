package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class s {
    private static s ZQ;
    private long ZL = 0;
    private long ZM = 0;
    private String ZN = "";
    private String ZO = "";
    private final long ZP = 120000;

    public static s ub() {
        if (ZQ == null) {
            synchronized (s.class) {
                if (ZQ == null) {
                    ZQ = new s();
                }
            }
        }
        return ZQ;
    }

    public String uc() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZL > 120000) {
            if (com.baidu.adp.lib.util.k.jb()) {
                return "";
            }
            this.ZL = currentTimeMillis;
            this.ZN = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.ZN;
    }

    public String cY(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZM > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.jb()) {
                return "";
            }
            this.ZM = currentTimeMillis;
            this.ZO = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.ZO;
        }
        return this.ZO;
    }
}
