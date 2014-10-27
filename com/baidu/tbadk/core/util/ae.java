package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            ad adVar = (ad) message.obj;
            if (adVar != null) {
                adVar.dM();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
