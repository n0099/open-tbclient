package com.baidu.platform.comapi.walknavi.g.b;

import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ab implements IWNPCEngineInitListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(c cVar, String str, String str2) {
        this.c = cVar;
        this.a = str;
        this.b = str2;
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onSuccess() {
        this.c.b(this.a, this.b);
        com.baidu.platform.comapi.walknavi.b.a().H().b(this.a, this.b);
    }

    @Override // com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener
    public void onFail(String str) {
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener;
        IWNPCLoadAndInitListener iWNPCLoadAndInitListener2;
        iWNPCLoadAndInitListener = this.c.W;
        if (iWNPCLoadAndInitListener != null) {
            iWNPCLoadAndInitListener2 = this.c.W;
            iWNPCLoadAndInitListener2.onFail();
        }
    }
}
