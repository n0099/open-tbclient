package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class b implements Runnable {
    final /* synthetic */ BDHttpDns.a afF;
    final /* synthetic */ BDHttpDns afG;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f1624b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.afG = bDHttpDns;
        this.afF = aVar;
        this.f1624b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afF.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, null, this.f1624b));
    }
}
