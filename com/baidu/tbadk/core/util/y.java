package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class y {
    private static y DW;
    private long DR = 0;
    private long DS = 0;
    private String DT = "";
    private String DU = "";
    private final long DV = 120000;

    public static y lT() {
        if (DW == null) {
            synchronized (y.class) {
                if (DW == null) {
                    DW = new y();
                }
            }
        }
        return DW;
    }

    public String lU() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.DR > 120000) {
            if (com.baidu.adp.lib.util.m.fu()) {
                return "";
            }
            this.DR = currentTimeMillis;
            this.DT = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.DT;
    }

    public String bE(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.DS > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.m.fu()) {
                return "";
            }
            this.DS = currentTimeMillis;
            this.DU = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.DU;
        }
        return this.DU;
    }
}
