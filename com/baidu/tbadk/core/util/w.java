package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w TT;
    private long TO = 0;
    private long TP = 0;
    private String TQ = "";
    private String TR = "";
    private final long TS = 120000;

    public static w sh() {
        if (TT == null) {
            synchronized (w.class) {
                if (TT == null) {
                    TT = new w();
                }
            }
        }
        return TT;
    }

    public String si() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.TO > 120000) {
            if (com.baidu.adp.lib.util.n.iW()) {
                return "";
            }
            this.TO = currentTimeMillis;
            this.TQ = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.TQ;
    }

    public String cB(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.TP > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.n.iW()) {
                return "";
            }
            this.TP = currentTimeMillis;
            this.TR = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.TR;
        }
        return this.TR;
    }
}
