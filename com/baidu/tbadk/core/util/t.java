package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t ahd;
    private long agY = 0;
    private long agZ = 0;
    private String aha = "";
    private String ahb = "";
    private final long ahc = 120000;

    public static t va() {
        if (ahd == null) {
            synchronized (t.class) {
                if (ahd == null) {
                    ahd = new t();
                }
            }
        }
        return ahd;
    }

    public String vb() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.agY > 120000) {
            if (com.baidu.adp.lib.util.l.hf()) {
                return "";
            }
            this.agY = currentTimeMillis;
            this.aha = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aha;
    }

    public String dW(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.agZ > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.hf()) {
                return "";
            }
            this.agZ = currentTimeMillis;
            this.ahb = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.ahb;
        }
        return this.ahb;
    }
}
