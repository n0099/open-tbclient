package com.baidu.searchbox.player.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.utils.MainThreadUtil;
/* loaded from: classes4.dex */
public class HandlerMessenger extends AbsMessenger {
    public static final int KEY_MESSAGE_EVENT = 153;
    public static final String TAG = "HandlerMessenger";
    @Nullable
    public PrivateHandler mHandler;
    public final HandlerThread mHandlerThread;

    @Override // com.baidu.searchbox.player.message.IMessenger
    public String getType() {
        return TAG;
    }

    /* loaded from: classes4.dex */
    public class PrivateHandler extends Handler {
        public PrivateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            Object obj = message.obj;
            if (!(obj instanceof VideoEvent)) {
                return;
            }
            final VideoEvent videoEvent = (VideoEvent) obj;
            MainThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.player.message.HandlerMessenger.PrivateHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!HandlerMessenger.this.isNeedIntercept(videoEvent)) {
                        HandlerMessenger.this.dispatchEvent(videoEvent);
                    }
                }
            });
        }
    }

    public HandlerMessenger() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new PrivateHandler(this.mHandlerThread.getLooper());
    }

    @Override // com.baidu.searchbox.player.message.AbsMessenger, com.baidu.searchbox.player.message.IMessenger
    public void release() {
        super.release();
        this.mHandlerThread.quit();
        PrivateHandler privateHandler = this.mHandler;
        if (privateHandler != null) {
            privateHandler.removeMessages(153);
        }
        this.mHandler = null;
    }

    @Override // com.baidu.searchbox.player.message.AbsMessenger
    public void publishEventToQueue(@NonNull VideoEvent videoEvent) {
        PrivateHandler privateHandler = this.mHandler;
        if (privateHandler != null) {
            privateHandler.obtainMessage(153, videoEvent).sendToTarget();
        }
    }
}
