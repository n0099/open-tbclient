package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {
    final /* synthetic */ HorizontalTranslateLayout FN;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        h hVar5;
        hVar = this.FN.FH;
        if (hVar.FU) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    hVar5 = this.FN.FH;
                    hVar5.mG();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    hVar2 = this.FN.FH;
                    hVar2.mF();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    hVar3 = this.FN.FH;
                    hVar3.mE();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    hVar4 = this.FN.FH;
                    hVar4.mD();
                    return;
            }
        }
    }
}
