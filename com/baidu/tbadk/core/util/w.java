package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class w {
    private static w abf;
    private long aba = 0;
    private long abb = 0;
    private String abc = "";
    private String abd = "";
    private final long abe = 120000;

    public static w uo() {
        if (abf == null) {
            synchronized (w.class) {
                if (abf == null) {
                    abf = new w();
                }
            }
        }
        return abf;
    }

    public String up() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.aba > 120000) {
            if (com.baidu.adp.lib.util.k.jg()) {
                return "";
            }
            this.aba = currentTimeMillis;
            this.abc = UtilHelper.getIpFromDomain("tieba.baidu.com");
        }
        return this.abc;
    }

    public String dp(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.abb > 120000) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0 || com.baidu.adp.lib.util.k.jg()) {
                return "";
            }
            this.abb = currentTimeMillis;
            this.abd = UtilHelper.getIpFromDomain(String.valueOf(str.substring(0, indexOf).replace("http://", "")) + "hiphotos.baidu.com");
            return this.abd;
        }
        return this.abd;
    }
}
