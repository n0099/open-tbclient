package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends Handler {
    final /* synthetic */ VerticalTranslateLayout a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        ab abVar5;
        abVar = this.a.v;
        if (abVar.g) {
            switch (message.what) {
                case -105:
                    abVar5 = this.a.v;
                    abVar5.d();
                    return;
                case -104:
                    abVar2 = this.a.v;
                    abVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    abVar3 = this.a.v;
                    abVar3.b();
                    return;
                case -100:
                    abVar4 = this.a.v;
                    abVar4.a();
                    return;
            }
        }
    }
}
