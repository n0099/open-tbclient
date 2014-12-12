package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class af extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            ae aeVar = (ae) message.obj;
            if (aeVar != null) {
                aeVar.dL();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
