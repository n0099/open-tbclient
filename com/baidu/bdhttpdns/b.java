package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes18.dex */
class b implements Runnable {
    final /* synthetic */ BDHttpDns.a adI;
    final /* synthetic */ BDHttpDns adJ;
    final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.adJ = bDHttpDns;
        this.adI = aVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.adI.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.b));
    }
}
