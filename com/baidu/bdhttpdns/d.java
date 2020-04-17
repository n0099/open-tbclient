package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ BDHttpDns.a aaM;
    final /* synthetic */ BDHttpDnsResult.ResolveType aaO;
    final /* synthetic */ h.a aaP;
    final /* synthetic */ BDHttpDns aaQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.aaQ = bDHttpDns;
        this.aaM = aVar;
        this.aaO = resolveType;
        this.aaP = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaM.a(new BDHttpDnsResult(this.aaO, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.aaP.b(), this.aaP.c()));
    }
}
