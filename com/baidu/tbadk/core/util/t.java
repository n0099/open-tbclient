package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class t {
    private static t aAL;
    private long aAG = 0;
    private long aAH = 0;
    private String aAI = "";
    private String aAJ = "";
    private final long aAK = 120000;

    public static t Da() {
        if (aAL == null) {
            synchronized (t.class) {
                if (aAL == null) {
                    aAL = new t();
                }
            }
        }
        return aAL;
    }

    public String Db() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aAG > 120000) {
            if (com.baidu.adp.lib.util.l.lk()) {
                return "";
            }
            this.aAG = currentTimeMillis;
            this.aAI = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aAI;
    }

    public String fw(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aAH > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.l.lk()) {
                return "";
            }
            this.aAH = currentTimeMillis;
            this.aAJ = UtilHelper.getIpFromDomain(str.substring(0, indexOf).replace("http://", "") + "hiphotos.baidu.com");
            return this.aAJ;
        }
        return this.aAJ;
    }
}
