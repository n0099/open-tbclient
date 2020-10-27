package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes12.dex */
class d implements Runnable {
    final /* synthetic */ BDHttpDns.a adZ;
    final /* synthetic */ BDHttpDnsResult.ResolveType aeb;
    final /* synthetic */ h.a aed;
    final /* synthetic */ BDHttpDns aee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.aee = bDHttpDns;
        this.adZ = aVar;
        this.aeb = resolveType;
        this.aed = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adZ.a(new BDHttpDnsResult(this.aeb, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.aed.b(), this.aed.c()));
    }
}
