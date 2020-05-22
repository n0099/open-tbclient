package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ BDHttpDns.a abg;
    final /* synthetic */ BDHttpDnsResult.ResolveType abi;
    final /* synthetic */ h.a abj;
    final /* synthetic */ BDHttpDns abk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.abk = bDHttpDns;
        this.abg = aVar;
        this.abi = resolveType;
        this.abj = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abg.a(new BDHttpDnsResult(this.abi, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.abj.b(), this.abj.c()));
    }
}
