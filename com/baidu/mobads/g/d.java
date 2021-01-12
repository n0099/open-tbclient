package com.baidu.mobads.g;

import com.baidu.mobads.g.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class d implements o.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3330a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f3330a = cVar;
    }

    @Override // com.baidu.mobads.g.o.a
    public void a(e eVar) {
        this.f3330a.a("OK", eVar, "download apk successfully, downloader exit");
        c unused = c.f = null;
    }

    @Override // com.baidu.mobads.g.o.a
    public void b(e eVar) {
        this.f3330a.a("ERROR", eVar, "downloadApk failed");
    }
}
