package com.baidu.location.b;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2611a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.f2611a = eVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (com.baidu.location.f.isServing) {
            switch (message.what) {
                case 1:
                    this.f2611a.e((Location) message.obj);
                    return;
                case 2:
                default:
                    return;
                case 3:
                    this.f2611a.a("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.f2611a.a("&og=2", (Location) message.obj);
                    return;
            }
        }
    }
}
