package com.baidu.ala.recorder.video.screen;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes15.dex */
public class AlaScreenRecorderHandler extends Handler {
    private static final int MSG_PAUSE_RECORD = 2;
    private static final int MSG_RESUME_RECORD = 3;
    private static final int MSG_SHUT_DOWN = 1;
    private WeakReference<AlaScreenRecorderThread> mWeakRenderThread;

    public AlaScreenRecorderHandler(AlaScreenRecorderThread alaScreenRecorderThread) {
        this.mWeakRenderThread = new WeakReference<>(alaScreenRecorderThread);
    }

    public void sendShutDown() {
        sendMessage(obtainMessage(1));
    }

    public void sendPauseRecord() {
        sendMessage(obtainMessage(2));
    }

    public void sendResumeRecord() {
        sendMessage(obtainMessage(3));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        AlaScreenRecorderThread alaScreenRecorderThread = this.mWeakRenderThread.get();
        switch (i) {
            case 1:
                alaScreenRecorderThread.quit();
                return;
            case 2:
                alaScreenRecorderThread.setIsVideoThreadRun(false);
                return;
            case 3:
                alaScreenRecorderThread.setIsVideoThreadRun(true);
                return;
            default:
                return;
        }
    }
}
