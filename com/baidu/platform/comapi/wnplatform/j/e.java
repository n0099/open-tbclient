package com.baidu.platform.comapi.wnplatform.j;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3124a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f3124a = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        c cVar;
        a aVar;
        a aVar2;
        c cVar2;
        int i;
        Bundle a2;
        int i2;
        c cVar3;
        a aVar3;
        a aVar4;
        c cVar4;
        com.baidu.platform.comapi.wnplatform.d.a.b("WRoutePlaner", "msg.arg1" + message.arg1 + "; msg.what" + message.what);
        if (message.what == 4099) {
            int i3 = message.arg1;
            int i4 = message.arg2;
            if (i4 == 1 || i4 == 0) {
                if (i3 != 0) {
                    cVar = this.f3124a.f3123a;
                    if (cVar != null) {
                        cVar2 = this.f3124a.f3123a;
                        cVar2.a(i3);
                    }
                    aVar = this.f3124a.b;
                    if (aVar != null) {
                        aVar2 = this.f3124a.b;
                        aVar2.a(i3);
                        return;
                    }
                    return;
                }
                com.baidu.platform.comapi.wnplatform.model.b U = com.baidu.platform.comapi.walknavi.b.a().U();
                d dVar = this.f3124a;
                i = this.f3124a.d;
                a2 = dVar.a(i);
                i2 = this.f3124a.d;
                U.a(a2, i2);
                cVar3 = this.f3124a.f3123a;
                if (cVar3 != null) {
                    cVar4 = this.f3124a.f3123a;
                    cVar4.b();
                }
                aVar3 = this.f3124a.b;
                if (aVar3 != null) {
                    aVar4 = this.f3124a.b;
                    aVar4.a();
                }
            }
        } else if (message.what == 2008 && com.baidu.platform.comapi.wnplatform.a.a().f()) {
            bVar = this.f3124a.c;
            if (bVar != null && !com.baidu.platform.comapi.walknavi.b.a().h()) {
                if (com.baidu.platform.comapi.walknavi.b.a().U().a(this.f3124a.a())) {
                    this.f3124a.f = true;
                    bVar3 = this.f3124a.c;
                    bVar3.b();
                    return;
                }
                this.f3124a.f = false;
                bVar2 = this.f3124a.c;
                bVar2.a(message.arg1);
            }
        }
    }
}
