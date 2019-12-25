package com.baidu.mobads.g;

import com.baidu.mobads.g.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements o.a {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.mobads.g.o.a
    public void a(e eVar) {
        this.a.a("OK", eVar, "download apk successfully, downloader exit");
        c unused = c.f = null;
    }

    @Override // com.baidu.mobads.g.o.a
    public void b(e eVar) {
        this.a.a("ERROR", eVar, "downloadApk failed");
    }
}
