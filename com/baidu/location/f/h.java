package com.baidu.location.f;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ e aCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aCP = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e.a aVar;
        e.a aVar2;
        if (com.baidu.location.f.isServing) {
            switch (message.what) {
                case 1:
                    this.aCP.g((Location) message.obj);
                    return;
                case 2:
                    aVar = this.aCP.aCL;
                    if (aVar != null) {
                        aVar2 = this.aCP.aCL;
                        aVar2.a((String) message.obj);
                        return;
                    }
                    return;
                case 3:
                    this.aCP.a("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.aCP.a("&og=2", (Location) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
