package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ HorizontalTranslateLayout a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        gVar = this.a.t;
        if (gVar.g) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    gVar5 = this.a.t;
                    gVar5.d();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    gVar2 = this.a.t;
                    gVar2.c();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case SapiErrorCode.NOT_INIT /* -102 */:
                default:
                    return;
                case SapiErrorCode.SENT_SUCCEED /* -101 */:
                    gVar3 = this.a.t;
                    gVar3.b();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    gVar4 = this.a.t;
                    gVar4.a();
                    return;
            }
        }
    }
}
