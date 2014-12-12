package com.baidu.tbadk.cdnOptimize;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
class d extends Handler {
    final /* synthetic */ TbCDNTachometerService BG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(TbCDNTachometerService tbCDNTachometerService, Looper looper) {
        super(looper);
        this.BG = tbCDNTachometerService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (1002 != message.what) {
            return;
        }
        this.BG.BroadcastCdnIp();
    }
}
