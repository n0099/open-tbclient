package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes6.dex */
class d implements Runnable {
    final /* synthetic */ BDHttpDns.a adq;
    final /* synthetic */ BDHttpDnsResult.ResolveType ads;
    final /* synthetic */ h.a adt;
    final /* synthetic */ BDHttpDns adu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.adu = bDHttpDns;
        this.adq = aVar;
        this.ads = resolveType;
        this.adt = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adq.a(new BDHttpDnsResult(this.ads, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.adt.b(), this.adt.c()));
    }
}
