package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends Handler {
    final /* synthetic */ VerticalTranslateLayout yU;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        sVar = this.yU.yP;
        if (sVar.vg) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    sVar5 = this.yU.yP;
                    sVar5.kl();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    sVar2 = this.yU.yP;
                    sVar2.kk();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case SapiErrorCode.NOT_INIT /* -102 */:
                default:
                    return;
                case SapiErrorCode.SENT_SUCCEED /* -101 */:
                    sVar3 = this.yU.yP;
                    sVar3.kj();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    sVar4 = this.yU.yP;
                    sVar4.ki();
                    return;
            }
        }
    }
}
