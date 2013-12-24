package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {
    final /* synthetic */ HorizontalTranslateLayout a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        h hVar5;
        hVar = this.a.t;
        if (hVar.g) {
            switch (message.what) {
                case -105:
                    hVar5 = this.a.t;
                    hVar5.d();
                    return;
                case -104:
                    hVar2 = this.a.t;
                    hVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    hVar3 = this.a.t;
                    hVar3.b();
                    return;
                case -100:
                    hVar4 = this.a.t;
                    hVar4.a();
                    return;
            }
        }
    }
}
