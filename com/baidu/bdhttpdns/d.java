package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes18.dex */
class d implements Runnable {
    final /* synthetic */ BDHttpDns.a adI;
    final /* synthetic */ BDHttpDnsResult.ResolveType adK;
    final /* synthetic */ h.a adL;
    final /* synthetic */ BDHttpDns adM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.adM = bDHttpDns;
        this.adI = aVar;
        this.adK = resolveType;
        this.adL = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adI.a(new BDHttpDnsResult(this.adK, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.adL.b(), this.adL.c()));
    }
}
