package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ BDHttpDns.a abL;
    final /* synthetic */ BDHttpDnsResult.ResolveType abN;
    final /* synthetic */ h.a abO;
    final /* synthetic */ BDHttpDns abP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.abP = bDHttpDns;
        this.abL = aVar;
        this.abN = resolveType;
        this.abO = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abL.a(new BDHttpDnsResult(this.abN, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.abO.b(), this.abO.c()));
    }
}
