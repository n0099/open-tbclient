package com.baidu.platform.comapi.walknavi.g.c;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ab implements IWNPCEngineInitListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3022a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(c cVar, String str, String str2) {
        this.c = cVar;
        this.f3022a = str;
        this.b = str2;
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onSuccess() {
        this.c.b(this.f3022a, this.b);
        com.baidu.platform.comapi.walknavi.b.a().K().b(this.f3022a, this.b);
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onFail(String str) {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.c.Y;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.c.Y;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
