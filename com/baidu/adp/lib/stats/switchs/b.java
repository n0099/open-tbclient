package com.baidu.adp.lib.stats.switchs;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.stats.b.i;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
/* loaded from: classes.dex */
class b extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (message.obj instanceof BdUploadStatMsgData) {
                    i.iz().aA(((BdUploadStatMsgData) message.obj).parentType);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
