package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class b implements Runnable {
    final /* synthetic */ BDHttpDns.a aeO;
    final /* synthetic */ BDHttpDns aeP;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f1574b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.aeP = bDHttpDns;
        this.aeO = aVar;
        this.f1574b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeO.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.f1574b));
    }
}
