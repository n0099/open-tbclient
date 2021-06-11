package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* loaded from: classes2.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7768a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f7769b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f7770c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f7771d;

    public d(b.a aVar, int i2, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.f7771d = aVar;
        this.f7768a = i2;
        this.f7769b = historyTraceQueryOptions;
        this.f7770c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i2;
        int i3;
        int i4;
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) {
            i2 = b.f7762g;
            if (i2 <= 2) {
                this.f7771d.a(this.f7770c, this.f7768a, this.f7769b);
                i3 = b.f7762g;
                int unused = b.f7762g = i3 + 1;
            }
        }
        i4 = b.f7762g;
        if (2 < i4) {
            this.f7771d.a(aVar, this.f7768a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        String str2 = b.f7758a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
        this.f7771d.a(3, str, this.f7768a, this.f7769b);
        int unused = b.f7762g = 0;
    }
}
