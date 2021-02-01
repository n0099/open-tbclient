package com.baidu.mobstat;
/* loaded from: classes3.dex */
public class bc extends ba {
    private static bc c = new bc();

    /* renamed from: b  reason: collision with root package name */
    private boolean f3743b;

    private bc() {
    }

    public static bc c() {
        return c;
    }

    public void a(boolean z) {
        this.f3743b = z;
    }

    @Override // com.baidu.mobstat.ba
    public String a() {
        return "BaiduMobStat";
    }

    @Override // com.baidu.mobstat.ba
    public boolean b() {
        return this.f3743b;
    }
}
