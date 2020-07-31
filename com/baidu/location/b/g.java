package com.baidu.location.b;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class g extends Handler {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (com.baidu.location.f.isServing) {
            switch (message.what) {
                case 1:
                    this.a.e((Location) message.obj);
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.a.a("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.a.a("&og=2", (Location) message.obj);
                    return;
            }
        }
    }
}
