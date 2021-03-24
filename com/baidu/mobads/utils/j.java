package com.baidu.mobads.utils;
/* loaded from: classes2.dex */
public class j extends com.baidu.mobads.f.a<Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8540a;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f8541c;

    public j(h hVar, String str) {
        this.f8541c = hVar;
        this.f8540a = str;
    }

    @Override // com.baidu.mobads.f.a
    public Object a() {
        String str;
        String str2;
        try {
            Object a2 = this.f8541c.a("mapinfo");
            if (a2 != null) {
                String unused = h.f8533h = String.valueOf(a2);
                str2 = h.f8533h;
                return str2;
            }
            String unused2 = h.f8533h = new com.baidu.mobads.h.a(this.f8540a).a();
            h hVar = this.f8541c;
            str = h.f8533h;
            hVar.a("mapinfo", str);
            return null;
        } catch (Throwable th) {
            q.a().e(th);
            return null;
        }
    }
}
