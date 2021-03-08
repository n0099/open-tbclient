package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes5.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a afZ;
    final /* synthetic */ BDHttpDnsResult.ResolveType agb;
    final /* synthetic */ h.a agc;
    final /* synthetic */ BDHttpDns agd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.agd = bDHttpDns;
        this.afZ = aVar;
        this.agb = resolveType;
        this.agc = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afZ.a(new BDHttpDnsResult(this.agb, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.agc.b(), null));
    }
}
