package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.bdhttpdns.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class d implements Runnable {
    final /* synthetic */ BDHttpDns.a abG;
    final /* synthetic */ BDHttpDnsResult.ResolveType abI;
    final /* synthetic */ h.a abJ;
    final /* synthetic */ BDHttpDns abK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BDHttpDns bDHttpDns, BDHttpDns.a aVar, BDHttpDnsResult.ResolveType resolveType, h.a aVar2) {
        this.abK = bDHttpDns;
        this.abG = aVar;
        this.abI = resolveType;
        this.abJ = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abG.a(new BDHttpDnsResult(this.abI, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.abJ.b(), this.abJ.c()));
    }
}
