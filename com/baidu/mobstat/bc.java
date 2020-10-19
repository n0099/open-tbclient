package com.baidu.mobstat;
/* loaded from: classes17.dex */
public class bc extends ba {
    private static bc c = new bc();
    private boolean b;

    private bc() {
    }

    public static bc c() {
        return c;
    }

    public void a(boolean z) {
        this.b = z;
    }

    @Override // com.baidu.mobstat.ba
    public String a() {
        return "BaiduMobStat";
    }

    @Override // com.baidu.mobstat.ba
    public boolean b() {
        return this.b;
    }
}
