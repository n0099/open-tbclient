package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4420a = bVar;
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
        if (message.what == 4099) {
            int i3 = message.arg1;
            int i4 = message.arg2;
            if (i4 == 1 || i4 == 0) {
                if (i3 != 0) {
                    aVar = this.f4420a.f4418a;
                    if (aVar != null) {
                        aVar2 = this.f4420a.f4418a;
                        aVar2.a(i3);
                        return;
                    }
                    return;
                }
                com.baidu.platform.comapi.wnplatform.model.b R = com.baidu.platform.comapi.walknavi.b.a().R();
                b bVar = this.f4420a;
                i = this.f4420a.f4419b;
                a2 = bVar.a(i);
                i2 = this.f4420a.f4419b;
                R.a(a2, i2);
                aVar3 = this.f4420a.f4418a;
                if (aVar3 != null) {
                    aVar4 = this.f4420a.f4418a;
                    aVar4.b();
                }
            }
        }
    }
}
