package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ BDHttpDns.a HE;
    final /* synthetic */ BDHttpDnsResult.ResolveType HG;
    final /* synthetic */ h.a HH;
    final /* synthetic */ BDHttpDns HI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.HI = bDHttpDns;
        this.HE = aVar;
        this.HG = resolveType;
        this.HH = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.HE.a(new BDHttpDnsResult(this.HG, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.HH.b(), null));
    }
}
