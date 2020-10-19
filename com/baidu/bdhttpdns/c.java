package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes12.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a adY;
    final /* synthetic */ BDHttpDnsResult.ResolveType aea;
    final /* synthetic */ h.a aeb;
    final /* synthetic */ BDHttpDns aed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.aed = bDHttpDns;
        this.adY = aVar;
        this.aea = resolveType;
        this.aeb = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adY.a(new BDHttpDnsResult(this.aea, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.aeb.b(), null));
    }
}
