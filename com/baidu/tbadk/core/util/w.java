package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w TV;
    private long TQ = 0;
    private long TR = 0;
    private String TS = "";
    private String TT = "";
    private final long TU = 120000;

    public static w sh() {
        if (TV == null) {
            synchronized (w.class) {
                if (TV == null) {
                    TV = new w();
                }
            }
        }
        return TV;
    }

    public String si() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.TQ > 120000) {
            if (com.baidu.adp.lib.util.n.iW()) {
                return "";
            }
            this.TQ = currentTimeMillis;
            this.TS = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.TS;
    }

    public String cB(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.TR > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.n.iW()) {
                return "";
            }
            this.TR = currentTimeMillis;
            this.TT = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.TT;
        }
        return this.TT;
    }
}
