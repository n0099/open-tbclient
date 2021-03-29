package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* loaded from: classes2.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f7715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7716c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f7717d;

    public d(b.a aVar, int i, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.f7717d = aVar;
        this.f7714a = i;
        this.f7715b = historyTraceQueryOptions;
        this.f7716c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i;
        int i2;
        int i3;
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) {
            i = b.f7709g;
            if (i <= 2) {
                this.f7717d.a(this.f7716c, this.f7714a, this.f7715b);
                i2 = b.f7709g;
                int unused = b.f7709g = i2 + 1;
            }
        }
        i3 = b.f7709g;
        if (2 < i3) {
            this.f7717d.a(aVar, this.f7714a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        String str2 = b.f7705a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
        this.f7717d.a(3, str, this.f7714a, this.f7715b);
        int unused = b.f7709g = 0;
    }
}
