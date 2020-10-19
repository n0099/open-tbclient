package com.baidu.swan.pms.model;
/* loaded from: classes15.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long aXa() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean aXb() {
        return aXa() - this.updateTime > this.maxAge;
    }
}
