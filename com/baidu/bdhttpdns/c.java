package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes6.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a ado;
    final /* synthetic */ BDHttpDnsResult.ResolveType adq;
    final /* synthetic */ h.a adr;
    final /* synthetic */ BDHttpDns ads;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.ads = bDHttpDns;
        this.ado = aVar;
        this.adq = resolveType;
        this.adr = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ado.a(new BDHttpDnsResult(this.adq, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.adr.b(), null));
    }
}
