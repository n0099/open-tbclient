package com.baidu.platform.comapi.walknavi.c;

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
        int i;
        a aVar2;
        a aVar3;
        a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.a.e;
                if (aVar3 != null) {
                    aVar4 = this.a.e;
                    aVar4.b();
                    this.a.e = null;
                    return;
                }
                return;
            case 16:
            case 32:
                b.a(this.a, message.what);
                aVar = this.a.e;
                if (aVar != null) {
                    i = this.a.f;
                    if (i == 48) {
                        aVar2 = this.a.e;
                        aVar2.a();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
