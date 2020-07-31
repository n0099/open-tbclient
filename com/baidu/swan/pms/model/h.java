package com.baidu.swan.pms.model;
/* loaded from: classes19.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long aLh() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean aLi() {
        return aLh() - this.updateTime > this.maxAge;
    }
}
