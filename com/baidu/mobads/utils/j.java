package com.baidu.mobads.utils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2485a;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, String str) {
        this.c = hVar;
        this.f2485a = str;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        Object a2;
        String str;
        String str2;
        try {
            a2 = this.c.a("mapinfo");
        } catch (Throwable th) {
            q.a().e(th);
        }
        if (a2 != null) {
            String unused = h.h = String.valueOf(a2);
            str2 = h.h;
            return str2;
        }
        String unused2 = h.h = new com.baidu.mobads.h.a(this.f2485a).a();
        h hVar = this.c;
        str = h.h;
        hVar.a("mapinfo", str);
        return null;
    }
}
