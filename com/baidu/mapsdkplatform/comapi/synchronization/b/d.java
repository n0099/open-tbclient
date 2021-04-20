package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* loaded from: classes2.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7749a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f7750b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7751c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f7752d;

    public d(b.a aVar, int i, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.f7752d = aVar;
        this.f7749a = i;
        this.f7750b = historyTraceQueryOptions;
        this.f7751c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i;
        int i2;
        int i3;
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) {
            i = b.f7744g;
            if (i <= 2) {
                this.f7752d.a(this.f7751c, this.f7749a, this.f7750b);
                i2 = b.f7744g;
                int unused = b.f7744g = i2 + 1;
            }
        }
        i3 = b.f7744g;
        if (2 < i3) {
            this.f7752d.a(aVar, this.f7749a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        String str2 = b.f7740a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
        this.f7752d.a(3, str, this.f7749a, this.f7750b);
        int unused = b.f7744g = 0;
    }
}
