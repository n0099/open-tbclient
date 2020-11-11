package com.baidu.platform.core.a;
/* loaded from: classes7.dex */
public class c extends com.baidu.platform.base.e {
    public c(String str) {
        a(str);
    }

    private void a(String str) {
        this.f2816a.a("qt", "ext");
        this.f2816a.a("num", "1000");
        this.f2816a.a("l", "10");
        this.f2816a.a("ie", "utf-8");
        this.f2816a.a("oue", "1");
        this.f2816a.a("res", "api");
        this.f2816a.a("fromproduct", "android_map_sdk");
        this.f2816a.a("uid", str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.o();
    }
}
