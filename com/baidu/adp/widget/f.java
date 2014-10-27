package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends Handler {
    final /* synthetic */ HorizontalTranslateLayout sJ;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        g gVar5;
        gVar = this.sJ.sD;
        if (gVar.sQ) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    gVar5 = this.sJ.sD;
                    gVar5.gZ();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    gVar2 = this.sJ.sD;
                    gVar2.gY();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case -102:
                default:
                    return;
                case -101:
                    gVar3 = this.sJ.sD;
                    gVar3.gX();
                    return;
                case -100:
                    gVar4 = this.sJ.sD;
                    gVar4.gW();
                    return;
            }
        }
    }
}
