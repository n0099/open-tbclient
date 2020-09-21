package com.baidu.swan.pms.model;
/* loaded from: classes24.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long aUr() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean aUs() {
        return aUr() - this.updateTime > this.maxAge;
    }
}
