package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w WD;
    private long Wy = 0;
    private long Wz = 0;
    private String WA = "";
    private String WB = "";
    private final long WC = 120000;

    public static w tp() {
        if (WD == null) {
            synchronized (w.class) {
                if (WD == null) {
                    WD = new w();
                }
            }
        }
        return WD;
    }

    public String tq() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Wy > 120000) {
            if (com.baidu.adp.lib.util.k.fH()) {
                return "";
            }
            this.Wy = currentTimeMillis;
            this.WA = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.WA;
    }

    public String dk(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Wz > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.fH()) {
                return "";
            }
            this.Wz = currentTimeMillis;
            this.WB = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.WB;
        }
        return this.WB;
    }
}
