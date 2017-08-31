package com.baidu.location.f;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ e Oe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Oe = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e.a aVar;
        e.a aVar2;
        if (com.baidu.location.f.isServing) {
            switch (message.what) {
                case 1:
                    this.Oe.f((Location) message.obj);
                    return;
                case 2:
                    aVar = this.Oe.Oa;
                    if (aVar != null) {
                        aVar2 = this.Oe.Oa;
                        aVar2.a((String) message.obj);
                        return;
                    }
                    return;
                case 3:
                    this.Oe.a("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.Oe.a("&og=2", (Location) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
