package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
import com.baidu.sapi2.shell.SapiErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {
    final /* synthetic */ HorizontalTranslateLayout FY;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h hVar;
        h hVar2;
        h hVar3;
        h hVar4;
        h hVar5;
        hVar = this.FY.FS;
        if (hVar.Gf) {
            switch (message.what) {
                case SapiErrorCode.GET_CERT_FAIL /* -105 */:
                    hVar5 = this.FY.FS;
                    hVar5.mn();
                    return;
                case SapiErrorCode.GETTING_CERT /* -104 */:
                    hVar2 = this.FY.FS;
                    hVar2.mm();
                    return;
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case SapiErrorCode.NOT_INIT /* -102 */:
                default:
                    return;
                case SapiErrorCode.SENT_SUCCEED /* -101 */:
                    hVar3 = this.FY.FS;
                    hVar3.ml();
                    return;
                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                    hVar4 = this.FY.FS;
                    hVar4.mk();
                    return;
            }
        }
    }
}
