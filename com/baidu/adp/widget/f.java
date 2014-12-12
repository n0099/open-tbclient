package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ HorizontalTranslateLayout uW;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        gVar = this.uW.uQ;
        if (gVar.vd) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    gVar5 = this.uW.uQ;
                    gVar5.iW();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    gVar2 = this.uW.uQ;
                    gVar2.iV();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case -102:
                default:
                    return;
                case -101:
                    gVar3 = this.uW.uQ;
                    gVar3.iU();
                    return;
                case -100:
                    gVar4 = this.uW.uQ;
                    gVar4.iT();
                    return;
            }
        }
    }
}
