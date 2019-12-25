package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BDHttpDns.a Hf;
    final /* synthetic */ BDHttpDnsResult.ResolveType Hh;
    final /* synthetic */ h.a Hi;
    final /* synthetic */ BDHttpDns Hj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.Hj = bDHttpDns;
        this.Hf = aVar;
        this.Hh = resolveType;
        this.Hi = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Hf.a(new BDHttpDnsResult(this.Hh, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.Hi.b(), null));
    }
}
