package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w aaa;
    private long ZV = 0;
    private long ZW = 0;
    private String ZX = "";
    private String ZY = "";
    private final long ZZ = 120000;

    public static w uu() {
        if (aaa == null) {
            synchronized (w.class) {
                if (aaa == null) {
                    aaa = new w();
                }
            }
        }
        return aaa;
    }

    public String uv() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZV > 120000) {
            if (com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.ZV = currentTimeMillis;
            this.ZX = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.ZX;
    }

    public String dm(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.ZW > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.ZW = currentTimeMillis;
            this.ZY = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.ZY;
        }
        return this.ZY;
    }
}
