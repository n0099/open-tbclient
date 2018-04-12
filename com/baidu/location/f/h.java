package com.baidu.location.f;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ e Qo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.Qo = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e.a aVar;
        e.a aVar2;
        if (com.baidu.location.f.isServing) {
            switch (message.what) {
                case 1:
                    this.Qo.f((Location) message.obj);
                    return;
                case 2:
                    aVar = this.Qo.Ql;
                    if (aVar != null) {
                        aVar2 = this.Qo.Ql;
                        aVar2.a((String) message.obj);
                        return;
                    }
                    return;
                case 3:
                    this.Qo.a("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.Qo.a("&og=2", (Location) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
