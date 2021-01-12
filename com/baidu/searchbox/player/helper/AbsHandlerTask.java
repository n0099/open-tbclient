package com.baidu.searchbox.player.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes14.dex */
public abstract class AbsHandlerTask implements ITimerTask {
    private static final int REFRESH_ACTION = 1;
    PrivateHandler mHandler = new PrivateHandler(Looper.getMainLooper());
    private int mInterval = 500;

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void start() {
        cancel();
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void setInterval(int i) {
        if (i > 0) {
            this.mInterval = i;
        }
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void cancel() {
        this.mHandler.removeMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class PrivateHandler extends Handler {
        public PrivateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    AbsHandlerTask.this.doTask();
                    sendMessageDelayed(obtainMessage(1), AbsHandlerTask.this.mInterval);
                    return;
                default:
                    return;
            }
        }
    }
}
