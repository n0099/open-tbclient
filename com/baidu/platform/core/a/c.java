package com.baidu.platform.core.a;
/* loaded from: classes26.dex */
public class c extends com.baidu.platform.base.e {
    public c(String str) {
        a(str);
    }

    private void a(String str) {
        this.f2818a.a("qt", "ext");
        this.f2818a.a("num", "1000");
        this.f2818a.a("l", "10");
        this.f2818a.a("ie", "utf-8");
        this.f2818a.a("oue", "1");
        this.f2818a.a("res", "api");
        this.f2818a.a("fromproduct", "android_map_sdk");
        this.f2818a.a("uid", str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.o();
    }
}
