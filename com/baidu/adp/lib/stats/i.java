package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g gVar;
        a aVar;
        b bVar;
        switch (message.what) {
            case 1:
                this.a.b((f) message.obj, message.arg1 > 0, message.arg2 > 0);
                return;
            case 2:
                h hVar = this.a;
                gVar = this.a.t;
                hVar.a((f) gVar, true, true);
                h hVar2 = this.a;
                aVar = this.a.u;
                hVar2.a((f) aVar, true, true);
                h hVar3 = this.a;
                bVar = this.a.v;
                hVar3.a((f) bVar, true, true);
                this.a.l();
                return;
            case 3:
                this.a.c((f) message.obj, message.arg1 > 0);
                return;
            case 4:
                this.a.c((f) message.obj);
                return;
            default:
                return;
        }
    }
}
