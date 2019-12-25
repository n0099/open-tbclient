package com.baidu.swan.pms.model;
/* loaded from: classes9.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long ara() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean arb() {
        return ara() - this.updateTime > this.maxAge;
    }
}
