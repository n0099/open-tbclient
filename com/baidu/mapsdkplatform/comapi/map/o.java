package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f2237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f2237a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n nVar;
        s sVar;
        super.handleMessage(message);
        nVar = n.c;
        if (nVar != null) {
            sVar = this.f2237a.d;
            sVar.a(message);
        }
    }
}
