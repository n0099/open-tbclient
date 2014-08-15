package com.baidu.tbadk.cdnOptimize;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
class c extends Handler {
    final /* synthetic */ TbCDNTachometerService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbCDNTachometerService tbCDNTachometerService, Looper looper) {
        super(looper);
        this.a = tbCDNTachometerService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        super.handleMessage(message);
        if (1002 != message.what) {
            if (1003 == message.what) {
                z = this.a.canBroadCast;
                if (!z) {
                    this.a.canBroadCast = true;
                    this.a.isNormal = false;
                }
                this.a.judgeIsBroadcastCdnIp();
                return;
            }
            return;
        }
        this.a.BroadcastCdnIp();
    }
}
