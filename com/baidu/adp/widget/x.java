package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends Handler {
    final /* synthetic */ VerticalTranslateLayout a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        y yVar;
        y yVar2;
        y yVar3;
        y yVar4;
        y yVar5;
        yVar = this.a.v;
        if (yVar.g) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    yVar5 = this.a.v;
                    yVar5.d();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    yVar2 = this.a.v;
                    yVar2.c();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case SapiErrorCode.NOT_INIT /* -102 */:
                default:
                    return;
                case SapiErrorCode.SENT_SUCCEED /* -101 */:
                    yVar3 = this.a.v;
                    yVar3.b();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    yVar4 = this.a.v;
                    yVar4.a();
                    return;
            }
        }
    }
}
