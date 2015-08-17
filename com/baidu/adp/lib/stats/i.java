package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.stats.h;
/* loaded from: classes.dex */
class i extends Handler {
    final /* synthetic */ h wz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, Looper looper) {
        super(looper);
        this.wz = hVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        h.a aVar;
        switch (message.what) {
            case 5:
                if ((message.obj instanceof h.a) && (aVar = (h.a) message.obj) != null) {
                    aVar.B(false);
                    aVar.C(false);
                    aVar.X(0);
                    aVar.e(System.currentTimeMillis());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
