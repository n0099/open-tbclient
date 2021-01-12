package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes6.dex */
class d implements Runnable {
    final /* synthetic */ BDHttpDns.a aeO;
    final /* synthetic */ BDHttpDnsResult.ResolveType aeQ;
    final /* synthetic */ h.a aeR;
    final /* synthetic */ BDHttpDns aeS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.aeS = bDHttpDns;
        this.aeO = aVar;
        this.aeQ = resolveType;
        this.aeR = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeO.a(new BDHttpDnsResult(this.aeQ, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.aeR.b(), this.aeR.c()));
    }
}
