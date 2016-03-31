package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w aaN;
    private long aaI = 0;
    private long aaJ = 0;
    private String aaK = "";
    private String aaL = "";
    private final long aaM = 120000;

    public static w vL() {
        if (aaN == null) {
            synchronized (w.class) {
                if (aaN == null) {
                    aaN = new w();
                }
            }
        }
        return aaN;
    }

    public String vM() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aaI > 120000) {
            if (com.baidu.adp.lib.util.k.jv()) {
                return "";
            }
            this.aaI = currentTimeMillis;
            this.aaK = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aaK;
    }

    public String dp(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aaJ > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.jv()) {
                return "";
            }
            this.aaJ = currentTimeMillis;
            this.aaL = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aaL;
        }
        return this.aaL;
    }
}
