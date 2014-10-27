package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class y {
    private static y DV;
    private long DQ = 0;
    private long DR = 0;
    private String DS = "";
    private String DT = "";
    private final long DU = 120000;

    public static y lT() {
        if (DV == null) {
            synchronized (y.class) {
                if (DV == null) {
                    DV = new y();
                }
            }
        }
        return DV;
    }

    public String lU() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.DQ > 120000) {
            if (com.baidu.adp.lib.util.m.fu()) {
                return "";
            }
            this.DQ = currentTimeMillis;
            this.DS = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.DS;
    }

    public String bE(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.DR > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.m.fu()) {
                return "";
            }
            this.DR = currentTimeMillis;
            this.DT = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.DT;
        }
        return this.DT;
    }
}
