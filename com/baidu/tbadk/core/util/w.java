package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w aan;
    private long aai = 0;
    private long aaj = 0;
    private String aak = "";
    private String aal = "";
    private final long aam = 120000;

    public static w uJ() {
        if (aan == null) {
            synchronized (w.class) {
                if (aan == null) {
                    aan = new w();
                }
            }
        }
        return aan;
    }

    public String uK() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aai > 120000) {
            if (com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.aai = currentTimeMillis;
            this.aak = UtilHelper.getIpFromDomain("c.tieba.baidu.com");
        }
        return this.aak;
    }

    /* renamed from: do  reason: not valid java name */
    public String m11do(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aaj > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.gC()) {
                return "";
            }
            this.aaj = currentTimeMillis;
            this.aal = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.aal;
        }
        return this.aal;
    }
}
