package com.baidu.swan.pms.model;
/* loaded from: classes6.dex */
public class h extends e {
    public String appKey;
    public String appName;
    public String domains;
    public long maxAge;
    public String token;

    public long bgo() {
        return System.currentTimeMillis() / 1000;
    }

    public boolean bgp() {
        return bgo() - this.updateTime > this.maxAge;
    }
}
