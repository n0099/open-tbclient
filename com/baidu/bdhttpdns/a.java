package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ BDHttpDns.a Hk;
    final /* synthetic */ BDHttpDns Hl;
    final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.Hl = bDHttpDns;
        this.Hk = aVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Hk.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.b, null));
    }
}
