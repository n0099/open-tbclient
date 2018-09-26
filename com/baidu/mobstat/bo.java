package com.baidu.mobstat;
/* loaded from: classes3.dex */
public class bo extends bh {
    private static bo b = new bo();

    private bo() {
    }

    public static bo c() {
        return b;
    }

    @Override // com.baidu.mobstat.bh
    public String a() {
        return "mtj.fulltrace";
    }

    @Override // com.baidu.mobstat.bh
    public boolean b() {
        return false;
    }
}
