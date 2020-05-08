package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a aaP;
    final /* synthetic */ BDHttpDnsResult.ResolveType aaR;
    final /* synthetic */ h.a aaS;
    final /* synthetic */ BDHttpDns aaT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.aaT = bDHttpDns;
        this.aaP = aVar;
        this.aaR = resolveType;
        this.aaS = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaP.a(new BDHttpDnsResult(this.aaR, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.aaS.b(), null));
    }
}
