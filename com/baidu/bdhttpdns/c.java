package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes6.dex */
class c implements Runnable {
    final /* synthetic */ BDHttpDns.a aeH;
    final /* synthetic */ BDHttpDnsResult.ResolveType aeJ;
    final /* synthetic */ h.a aeK;
    final /* synthetic */ BDHttpDns aeL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.aeL = bDHttpDns;
        this.aeH = aVar;
        this.aeJ = resolveType;
        this.aeK = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeH.a(new BDHttpDnsResult(this.aeJ, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.aeK.b(), null));
    }
}
