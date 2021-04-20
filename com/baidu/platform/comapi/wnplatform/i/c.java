package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9850a;

    public c(b bVar) {
        this.f9850a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        int i;
        Bundle a2;
        int i2;
        a aVar3;
        a aVar4;
        com.baidu.platform.comapi.wnplatform.d.a.b("WRoutePlaner", "msg.arg1" + message.arg1 + "; msg.what" + message.what);
        if (message.what != 4099) {
            return;
        }
        int i3 = message.arg1;
        int i4 = message.arg2;
        if (i4 == 1 || i4 == 0) {
            if (i3 != 0) {
                aVar = this.f9850a.f9847a;
                if (aVar != null) {
                    aVar2 = this.f9850a.f9847a;
                    aVar2.a(i3);
                    return;
                }
                return;
            }
            com.baidu.platform.comapi.wnplatform.model.b R = com.baidu.platform.comapi.walknavi.b.a().R();
            b bVar = this.f9850a;
            i = bVar.f9848b;
            a2 = bVar.a(i);
            i2 = this.f9850a.f9848b;
            R.a(a2, i2);
            aVar3 = this.f9850a.f9847a;
            if (aVar3 != null) {
                aVar4 = this.f9850a.f9847a;
                aVar4.b();
            }
        }
    }
}
