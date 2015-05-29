package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends Handler {
    final /* synthetic */ VerticalTranslateLayout JF;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        v vVar;
        v vVar2;
        v vVar3;
        v vVar4;
        v vVar5;
        vVar = this.JF.JA;
        if (vVar.FU) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    vVar5 = this.JF.JA;
                    vVar5.nZ();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    vVar2 = this.JF.JA;
                    vVar2.nY();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    vVar3 = this.JF.JA;
                    vVar3.nX();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    vVar4 = this.JF.JA;
                    vVar4.nW();
                    return;
            }
        }
    }
}
