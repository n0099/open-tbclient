package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c extends Handler {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        int i;
        Bundle a;
        int i2;
        a aVar3;
        a aVar4;
        com.baidu.platform.comapi.wnplatform.c.a.b("WRoutePlaner", "msg.arg1" + message.arg1 + "; msg.what" + message.what);
        if (message.what == 4099) {
            int i3 = message.arg1;
            int i4 = message.arg2;
            if (i4 == 1 || i4 == 0) {
                if (i3 != 0) {
                    aVar = this.a.a;
                    if (aVar != null) {
                        aVar2 = this.a.a;
                        aVar2.a(i3);
                        return;
                    }
                    return;
                }
                com.baidu.platform.comapi.wnplatform.d.b M = com.baidu.platform.comapi.walknavi.b.a().M();
                b bVar = this.a;
                i = this.a.b;
                a = bVar.a(i);
                i2 = this.a.b;
                M.a(a, i2);
                aVar3 = this.a.a;
                if (aVar3 != null) {
                    aVar4 = this.a.a;
                    aVar4.b();
                }
            }
        }
    }
}
