package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes6.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a afF;
    final /* synthetic */ BDHttpDnsResult.ResolveType afH;
    final /* synthetic */ h.a afI;
    final /* synthetic */ BDHttpDns afJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.afJ = bDHttpDns;
        this.afF = aVar;
        this.afH = resolveType;
        this.afI = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afF.a(new BDHttpDnsResult(this.afH, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.afI.b(), null));
    }
}
