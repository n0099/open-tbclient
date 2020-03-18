package com.baidu.swan.pms.model;
/* loaded from: classes11.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long atM() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean atN() {
        return atM() - this.updateTime > this.maxAge;
    }
}
