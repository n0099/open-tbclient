package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends Handler {
    final /* synthetic */ VerticalTranslateLayout wV;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        sVar = this.wV.wQ;
        if (sVar.sQ) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    sVar5 = this.wV.wQ;
                    sVar5.iD();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    sVar2 = this.wV.wQ;
                    sVar2.iC();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case -102:
                default:
                    return;
                case -101:
                    sVar3 = this.wV.wQ;
                    sVar3.iB();
                    return;
                case -100:
                    sVar4 = this.wV.wQ;
                    sVar4.iA();
                    return;
            }
        }
    }
}
