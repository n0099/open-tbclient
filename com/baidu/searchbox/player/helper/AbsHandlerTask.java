package com.baidu.searchbox.player.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes2.dex */
public abstract class AbsHandlerTask implements ITimerTask {
    public static final int REFRESH_ACTION = 1;
    public PrivateHandler mHandler = new PrivateHandler(Looper.getMainLooper());
    public int mInterval = 500;

    /* loaded from: classes2.dex */
    public class PrivateHandler extends Handler {
        public PrivateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            AbsHandlerTask.this.doTask();
            sendMessageDelayed(obtainMessage(1), AbsHandlerTask.this.mInterval);
        }
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void cancel() {
        this.mHandler.removeMessages(1);
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void setInterval(int i2) {
        if (i2 > 0) {
            this.mInterval = i2;
        }
    }

    @Override // com.baidu.searchbox.player.helper.ITimerTask
    @PublicMethod
    public void start() {
        cancel();
        this.mHandler.obtainMessage(1).sendToTarget();
    }
}
