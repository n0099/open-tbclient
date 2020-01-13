package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ BDHttpDns.a Hk;
    final /* synthetic */ BDHttpDnsResult.ResolveType Hm;
    final /* synthetic */ h.a Hn;
    final /* synthetic */ BDHttpDns Ho;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.Ho = bDHttpDns;
        this.Hk = aVar;
        this.Hm = resolveType;
        this.Hn = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Hk.a(new BDHttpDnsResult(this.Hm, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.Hn.b(), this.Hn.c()));
    }
}
