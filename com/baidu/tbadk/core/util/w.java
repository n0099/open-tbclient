package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w Wn;
    private long Wi = 0;
    private long Wj = 0;
    private String Wk = "";
    private String Wl = "";
    private final long Wm = 120000;

    public static w ts() {
        if (Wn == null) {
            synchronized (w.class) {
                if (Wn == null) {
                    Wn = new w();
                }
            }
        }
        return Wn;
    }

    public String tt() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Wi > 120000) {
            if (com.baidu.adp.lib.util.k.fG()) {
                return "";
            }
            this.Wi = currentTimeMillis;
            this.Wk = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.Wk;
    }

    public String dm(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.Wj > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.fG()) {
                return "";
            }
            this.Wj = currentTimeMillis;
            this.Wl = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.Wl;
        }
        return this.Wl;
    }
}
