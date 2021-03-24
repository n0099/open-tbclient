package com.baidu.platform.comapi.walknavi.g.b;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
/* loaded from: classes2.dex */
public class ab implements IWNPCEngineInitListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10074a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f10075b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f10076c;

    public ab(c cVar, String str, String str2) {
        this.f10076c = cVar;
        this.f10074a = str;
        this.f10075b = str2;
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onFail(String str) {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.f10076c.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.f10076c.W;
            iWNPCLoadAndInitListener2.onFail();
        }
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onSuccess() {
        this.f10076c.b(this.f10074a, this.f10075b);
        com.baidu.platform.comapi.walknavi.b.a().H().b(this.f10074a, this.f10075b);
    }
}
