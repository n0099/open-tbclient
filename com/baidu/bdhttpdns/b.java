package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class b implements Runnable {
    final /* synthetic */ BDHttpDns.a ado;
    final /* synthetic */ BDHttpDns adp;
    final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.adp = bDHttpDns;
        this.ado = aVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ado.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.b));
    }
}
