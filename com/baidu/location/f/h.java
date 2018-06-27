package com.baidu.location.f;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h extends Handler {
    final /* synthetic */ e Ym;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Ym = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e.a aVar;
        e.a aVar2;
        if (com.baidu.location.f.isServing) {
            switch (message.what) {
                case 1:
                    this.Ym.f((Location) message.obj);
                    return;
                case 2:
                    aVar = this.Ym.Yj;
                    if (aVar != null) {
                        aVar2 = this.Ym.Yj;
                        aVar2.a((String) message.obj);
                        return;
                    }
                    return;
                case 3:
                    this.Ym.a("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.Ym.a("&og=2", (Location) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
