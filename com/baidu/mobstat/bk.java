package com.baidu.mobstat;
/* loaded from: classes6.dex */
public class bk extends bh {
    private static bk b = new bk();

    private bk() {
    }

    public static bk c() {
        return b;
    }

    @Override // com.baidu.mobstat.bh
    public String a() {
        return "mtj.autotrace";
    }

    @Override // com.baidu.mobstat.bh
    public boolean b() {
        return false;
    }
}
