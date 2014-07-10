package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends Handler {
    final /* synthetic */ VerticalTranslateLayout a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        u uVar;
        u uVar2;
        u uVar3;
        u uVar4;
        u uVar5;
        uVar = this.a.v;
        if (uVar.g) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    uVar5 = this.a.v;
                    uVar5.d();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    uVar2 = this.a.v;
                    uVar2.c();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case -102:
                default:
                    return;
                case -101:
                    uVar3 = this.a.v;
                    uVar3.b();
                    return;
                case -100:
                    uVar4 = this.a.v;
                    uVar4.a();
                    return;
            }
        }
    }
}
