package com.baidu.location.f;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ e Lv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Lv = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e.a aVar;
        e.a aVar2;
        if (com.baidu.location.f.isServing) {
            switch (message.what) {
                case 1:
                    this.Lv.f((Location) message.obj);
                    return;
                case 2:
                    aVar = this.Lv.Lr;
                    if (aVar != null) {
                        aVar2 = this.Lv.Lr;
                        aVar2.a((String) message.obj);
                        return;
                    }
                    return;
                case 3:
                    this.Lv.a("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.Lv.a("&og=2", (Location) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
