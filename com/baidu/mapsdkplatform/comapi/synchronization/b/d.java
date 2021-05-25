package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* loaded from: classes2.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7725a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f7726b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7727c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f7728d;

    public d(b.a aVar, int i2, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.f7728d = aVar;
        this.f7725a = i2;
        this.f7726b = historyTraceQueryOptions;
        this.f7727c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i2;
        int i3;
        int i4;
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) {
            i2 = b.f7719g;
            if (i2 <= 2) {
                this.f7728d.a(this.f7727c, this.f7725a, this.f7726b);
                i3 = b.f7719g;
                int unused = b.f7719g = i3 + 1;
            }
        }
        i4 = b.f7719g;
        if (2 < i4) {
            this.f7728d.a(aVar, this.f7725a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        String str2 = b.f7715a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
        this.f7728d.a(3, str, this.f7725a, this.f7726b);
        int unused = b.f7719g = 0;
    }
}
