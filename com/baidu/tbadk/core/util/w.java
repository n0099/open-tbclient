package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w UF;
    private long Uz = 0;
    private long UB = 0;
    private String UC = "";
    private String UD = "";
    private final long UE = 120000;

    public static w sP() {
        if (UF == null) {
            synchronized (w.class) {
                if (UF == null) {
                    UF = new w();
                }
            }
        }
        return UF;
    }

    public String sQ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Uz > 120000) {
            if (com.baidu.adp.lib.util.n.jl()) {
                return "";
            }
            this.Uz = currentTimeMillis;
            this.UC = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.UC;
    }

    public String cQ(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.UB > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.n.jl()) {
                return "";
            }
            this.UB = currentTimeMillis;
            this.UD = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.UD;
        }
        return this.UD;
    }
}
