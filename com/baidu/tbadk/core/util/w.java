package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w Xm;
    private long Xh = 0;
    private long Xi = 0;
    private String Xj = "";
    private String Xk = "";
    private final long Xl = 120000;

    public static w to() {
        if (Xm == null) {
            synchronized (w.class) {
                if (Xm == null) {
                    Xm = new w();
                }
            }
        }
        return Xm;
    }

    public String tp() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Xh > 120000) {
            if (com.baidu.adp.lib.util.k.fG()) {
                return "";
            }
            this.Xh = currentTimeMillis;
            this.Xj = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.Xj;
    }

    public String dj(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Xi > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.fG()) {
                return "";
            }
            this.Xi = currentTimeMillis;
            this.Xk = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.Xk;
        }
        return this.Xk;
    }
}
