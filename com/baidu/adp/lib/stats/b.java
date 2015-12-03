package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                a.hl().ht();
                a.hl().hw();
                return;
            case 2:
                removeMessages(2);
                a.hl().hv();
                return;
            default:
                return;
        }
    }
}
