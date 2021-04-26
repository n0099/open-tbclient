package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
/* loaded from: classes2.dex */
public class d extends com.baidu.mapsdkplatform.comapi.synchronization.c.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8028a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HistoryTraceQueryOptions f8029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8030c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b.a f8031d;

    public d(b.a aVar, int i2, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.f8031d = aVar;
        this.f8028a = i2;
        this.f8029b = historyTraceQueryOptions;
        this.f8030c = str;
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(c.a aVar) {
        int i2;
        int i3;
        int i4;
        if (c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) {
            i2 = b.f8022g;
            if (i2 <= 2) {
                this.f8031d.a(this.f8030c, this.f8028a, this.f8029b);
                i3 = b.f8022g;
                int unused = b.f8022g = i3 + 1;
            }
        }
        i4 = b.f8022g;
        if (2 < i4) {
            this.f8031d.a(aVar, this.f8028a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.synchronization.c.e
    public void a(String str) {
        String str2 = b.f8018a;
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, "Request success, the result = " + str);
        this.f8031d.a(3, str, this.f8028a, this.f8029b);
        int unused = b.f8022g = 0;
    }
}
