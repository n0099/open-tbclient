package com.baidu.platform.comapi.walknavi.g.b;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
/* loaded from: classes2.dex */
public class ab implements IWNPCEngineInitListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9992a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9993b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f9994c;

    public ab(c cVar, String str, String str2) {
        this.f9994c = cVar;
        this.f9992a = str;
        this.f9993b = str2;
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onFail(String str) {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f9994c.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f9994c.W;
            iWNPCLoadAndInitListener2.onFail();
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onSuccess() {
        this.f9994c.b(this.f9992a, this.f9993b);
        com.baidu.platform.comapi.walknavi.b.a().H().b(this.f9992a, this.f9993b);
    }
}
