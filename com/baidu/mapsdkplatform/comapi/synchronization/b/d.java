package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f3088a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HistoryTraceQueryOptions f3089b;
    final /* synthetic */ String c;
    final /* synthetic */ b.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b.a aVar, int i, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.d = aVar;
        this.f3088a = i;
        this.f3089b = historyTraceQueryOptions;
        this.c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i;
        int i2;
        int i3;
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) {
            i = b.g;
            if (i <= 2) {
                this.d.a(this.c, this.f3088a, this.f3089b);
                i2 = b.g;
                int unused = b.g = i2 + 1;
            }
        }
        i3 = b.g;
        if (2 < i3) {
            this.d.a(aVar, this.f3088a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.f3085a, "Request success, the result = " + str);
        this.d.a(3, str, this.f3088a, this.f3089b);
        int unused = b.g = 0;
    }
}
