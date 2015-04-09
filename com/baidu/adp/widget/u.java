package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends Handler {
    final /* synthetic */ VerticalTranslateLayout JO;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        vVar = this.JO.JJ;
        if (vVar.Gf) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    vVar5 = this.JO.JJ;
                    vVar5.nI();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    vVar2 = this.JO.JJ;
                    vVar2.nH();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case SapiErrorCode.NOT_INIT /* -102 */:
                default:
                    return;
                case SapiErrorCode.SENT_SUCCEED /* -101 */:
                    vVar3 = this.JO.JJ;
                    vVar3.nG();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    vVar4 = this.JO.JJ;
                    vVar4.nF();
                    return;
            }
        }
    }
}
