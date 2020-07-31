package com.baidu.platform.comapi.wnplatform.l;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b extends Handler {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.platform.comapi.wnplatform.c.b bVar;
        com.baidu.platform.comapi.wnplatform.c.b bVar2;
        switch (message.what) {
            case 1:
                WLocData wLocData = (WLocData) message.obj;
                bVar = this.a.h;
                if (bVar != null) {
                    bVar2 = this.a.h;
                    bVar2.a(wLocData);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
