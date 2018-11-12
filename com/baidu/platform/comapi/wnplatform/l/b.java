package com.baidu.platform.comapi.wnplatform.l;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends Handler {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.platform.comapi.wnplatform.b.b bVar;
        com.baidu.platform.comapi.wnplatform.b.b bVar2;
        switch (message.what) {
            case 1:
                com.baidu.platform.comapi.wnplatform.d.a.a aVar = (com.baidu.platform.comapi.wnplatform.d.a.a) message.obj;
                bVar = this.a.h;
                if (bVar != null) {
                    bVar2 = this.a.h;
                    bVar2.a(aVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
