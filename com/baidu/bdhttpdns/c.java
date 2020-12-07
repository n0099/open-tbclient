package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes5.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a afa;
    final /* synthetic */ BDHttpDnsResult.ResolveType afc;
    final /* synthetic */ h.a afd;
    final /* synthetic */ BDHttpDns afe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.afe = bDHttpDns;
        this.afa = aVar;
        this.afc = resolveType;
        this.afd = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afa.a(new BDHttpDnsResult(this.afc, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.afd.b(), null));
    }
}
