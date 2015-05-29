package com.baidu.adp.lib.h;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                a.iB().iF();
                a.iB().hG();
                return;
            case 2:
                removeMessages(2);
                a.iB().iH();
                return;
            default:
                return;
        }
    }
}
