package com.baidu.swan.pms.model;
/* loaded from: classes10.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long art() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean aru() {
        return art() - this.updateTime > this.maxAge;
    }
}
