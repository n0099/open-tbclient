package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* loaded from: classes2.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f7714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7715c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f7716d;

    public d(b.a aVar, int i, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.f7716d = aVar;
        this.f7713a = i;
        this.f7714b = historyTraceQueryOptions;
        this.f7715c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i;
        int i2;
        int i3;
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) {
            i = b.f7708g;
            if (i <= 2) {
                this.f7716d.a(this.f7715c, this.f7713a, this.f7714b);
                i2 = b.f7708g;
                int unused = b.f7708g = i2 + 1;
            }
        }
        i3 = b.f7708g;
        if (2 < i3) {
            this.f7716d.a(aVar, this.f7713a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        String str2 = b.f7704a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
        this.f7716d.a(3, str, this.f7713a, this.f7714b);
        int unused = b.f7708g = 0;
    }
}
