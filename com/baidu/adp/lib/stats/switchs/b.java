package com.baidu.adp.lib.stats.switchs;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.stats.b.j;
import com.baidu.adp.lib.stats.base.BdUploadStatMsgData;
/* loaded from: classes.dex */
class b extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (message.obj instanceof BdUploadStatMsgData) {
                    j.eQ().ax(((BdUploadStatMsgData) message.obj).parentType);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
