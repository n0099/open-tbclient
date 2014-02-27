package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends Handler {
    final /* synthetic */ VerticalTranslateLayout a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        xVar = this.a.v;
        if (xVar.g) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    xVar5 = this.a.v;
                    xVar5.d();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    xVar2 = this.a.v;
                    xVar2.c();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case SapiErrorCode.NOT_INIT /* -102 */:
                default:
                    return;
                case SapiErrorCode.SENT_SUCCEED /* -101 */:
                    xVar3 = this.a.v;
                    xVar3.b();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    xVar4 = this.a.v;
                    xVar4.a();
                    return;
            }
        }
    }
}
