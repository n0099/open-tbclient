package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes19.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a aef;
    final /* synthetic */ BDHttpDnsResult.ResolveType aeh;
    final /* synthetic */ h.a aei;
    final /* synthetic */ BDHttpDns aej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.aej = bDHttpDns;
        this.aef = aVar;
        this.aeh = resolveType;
        this.aei = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aef.a(new BDHttpDnsResult(this.aeh, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.aei.b(), null));
    }
}
