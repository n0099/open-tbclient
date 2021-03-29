package com.baidu.mobads.g;

import com.baidu.mobads.g.o;
/* loaded from: classes2.dex */
public class d implements o.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f8270a;

    public d(c cVar) {
        this.f8270a = cVar;
    }

    @Override // com.baidu.mobads.g.o.a
    public void a(e eVar) {
        this.f8270a.a("OK", eVar, "download apk successfully, downloader exit");
        c unused = c.f8262f = null;
    }

    @Override // com.baidu.mobads.g.o.a
    public void b(e eVar) {
        this.f8270a.a("ERROR", eVar, "downloadApk failed");
    }
}
