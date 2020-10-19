package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class o extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f2233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f2233a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n nVar;
        s sVar;
        super.handleMessage(message);
        nVar = n.c;
        if (nVar != null) {
            sVar = this.f2233a.d;
            sVar.a(message);
        }
    }
}
