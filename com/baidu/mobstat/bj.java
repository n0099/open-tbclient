package com.baidu.mobstat;
/* loaded from: classes3.dex */
public class bj extends bh {
    private static bj c = new bj();
    private boolean b;

    private bj() {
    }

    public static bj c() {
        return c;
    }

    public void a(boolean z) {
        this.b = z;
    }

    @Override // com.baidu.mobstat.bh
    public String a() {
        return "BaiduMobStat";
    }

    @Override // com.baidu.mobstat.bh
    public boolean b() {
        return this.b;
    }
}
