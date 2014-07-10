package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            NetWorkCore netWorkCore = (NetWorkCore) message.obj;
            if (netWorkCore != null) {
                netWorkCore.b();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
