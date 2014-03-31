package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends Handler {
    final /* synthetic */ HorizontalTranslateLayout a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        gVar = this.a.s;
        if (gVar.g) {
            switch (message.what) {
                case -105:
                    gVar5 = this.a.s;
                    gVar5.d();
                    return;
                case -104:
                    gVar2 = this.a.s;
                    gVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    gVar3 = this.a.s;
                    gVar3.b();
                    return;
                case -100:
                    gVar4 = this.a.s;
                    gVar4.a();
                    return;
            }
        }
    }
}
