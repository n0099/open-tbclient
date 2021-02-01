package com.baidu.bdhttpdns;

import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import java.util.ArrayList;
/* loaded from: classes6.dex */
class a implements Runnable {
    final /* synthetic */ BDHttpDns.a aeH;
    final /* synthetic */ BDHttpDns aeI;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ArrayList f1571b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BDHttpDns bDHttpDns, BDHttpDns.a aVar, ArrayList arrayList) {
        this.aeI = bDHttpDns;
        this.aeH = aVar;
        this.f1571b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeH.a(new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_NONEED, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, this.f1571b, null));
    }
}
