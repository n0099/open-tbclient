package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class a extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                BdStatisticsManager.getInstance().forceUploadAllLog();
                BdStatisticsManager.getInstance().startOrNextUploadTimer();
                return;
            case 2:
                removeMessages(2);
                BdStatisticsManager.getInstance().checkLogToUpload();
                return;
            default:
                return;
        }
    }
}
