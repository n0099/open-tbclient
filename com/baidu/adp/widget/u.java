package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends Handler {
    final /* synthetic */ VerticalTranslateLayout a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        vVar = this.a.v;
        if (vVar.g) {
            switch (message.what) {
                case -105:
                    vVar5 = this.a.v;
                    vVar5.d();
                    return;
                case -104:
                    vVar2 = this.a.v;
                    vVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    vVar3 = this.a.v;
                    vVar3.b();
                    return;
                case -100:
                    vVar4 = this.a.v;
                    vVar4.a();
                    return;
            }
        }
    }
}
