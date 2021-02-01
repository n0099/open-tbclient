package com.baidu.swan.pms.model;
/* loaded from: classes3.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long bcH() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean bcI() {
        return bcH() - this.updateTime > this.maxAge;
    }
}
