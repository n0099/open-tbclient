package com.baidu.ala.recorder.video.camera;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.baidu.live.adp.lib.util.BdLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CameraHandler extends Handler {
    private static final int MSG_BEAUTY_LEVEL = 12;
    private static final int MSG_ENCODER_AVAILABLE = 9;
    private static final int MSG_FRAME_AVAILABLE = 3;
    private static final int MSG_POSITION = 7;
    private static final int MSG_REDRAW = 8;
    private static final int MSG_RESET_CAMERA = 14;
    private static final int MSG_ROTATE_VALUE = 6;
    private static final int MSG_SHUTDOWN = 2;
    private static final int MSG_SIZE_VALUE = 5;
    private static final int MSG_START_CAMERA = 15;
    private static final int MSG_START_SEND_DATA = 13;
    private static final int MSG_STOP_CAMERA = 16;
    private static final int MSG_SURFACE_CHANGED = 1;
    private static final int MSG_SWITCH_CAREMA = 10;
    private static final int MSG_SWITCH_FLASHLIGHT = 11;
    private static final int MSG_ZOOM_VALUE = 4;
    private List<Message> mBufferMessage;
    private volatile boolean mHasRecvStartMsg;
    private WeakReference<AlaCameraManager> mWeakRenderThread;

    public CameraHandler(AlaCameraManager alaCameraManager, Looper looper) {
        super(looper);
        this.mHasRecvStartMsg = false;
        this.mBufferMessage = new ArrayList();
        this.mWeakRenderThread = new WeakReference<>(alaCameraManager);
    }

    public void sendEncoderAvailable(Surface surface) {
        sendMessage(obtainMessage(9, surface));
    }

    public void sendSurfaceChanged(int i, int i2) {
        sendMessage(obtainMessage(1, i, i2));
    }

    public void sendFrameAvailable() {
        sendMessage(obtainMessage(3));
    }

    public void sendZoomValue(int i) {
        sendMessage(obtainMessage(4, i, 0));
    }

    public void sendSizeValue(int i) {
        sendMessage(obtainMessage(5, i, 0));
    }

    public void sendRotateValue(int i) {
        sendMessage(obtainMessage(6, i, 0));
    }

    public void sendPosition(int i, int i2) {
        sendMessage(obtainMessage(7, i, i2));
    }

    public void sendRedraw() {
        sendMessage(obtainMessage(8));
    }

    public void sendSwitchCarema() {
        sendMessage(obtainMessage(10));
    }

    public void sendBeauty(int i) {
        sendMessage(obtainMessage(12, i, 0));
    }

    public void sendSwitchFlashLight() {
        sendMessage(obtainMessage(11));
    }

    public void sendStartSendData() {
        sendMessage(obtainMessage(13));
    }

    public void sendResetCamera() {
        sendMessage(obtainMessage(14));
    }

    public void sendStartCamera() {
        sendMessage(obtainMessage(15));
    }

    public void sendStopCamera() {
        sendMessage(obtainMessage(16));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        AlaCameraManager alaCameraManager = this.mWeakRenderThread.get();
        if (alaCameraManager != null) {
            if (i == 15) {
                this.mHasRecvStartMsg = true;
                alaCameraManager.doStartCamera();
            } else if (!this.mHasRecvStartMsg) {
                if (i == 16) {
                    alaCameraManager.doStopCamera();
                } else {
                    this.mBufferMessage.add(message);
                }
            } else if (this.mBufferMessage.size() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < this.mBufferMessage.size()) {
                        myHandleMessage2(this.mBufferMessage.get(i3));
                        i2 = i3 + 1;
                    } else {
                        this.mBufferMessage.clear();
                        return;
                    }
                }
            } else {
                myHandleMessage2(message);
            }
        }
    }

    private void myHandleMessage2(Message message) {
        AlaCameraManager alaCameraManager = this.mWeakRenderThread.get();
        if (alaCameraManager != null) {
            int i = message.what;
            switch (i) {
                case 1:
                    alaCameraManager.surfaceChanged(message.arg1, message.arg2);
                    return;
                case 2:
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                default:
                    BdLog.e(getClass().getSimpleName() + " unknow message what ----- " + i);
                    return;
                case 10:
                    alaCameraManager.switchCamera();
                    return;
                case 11:
                    alaCameraManager.switchFlashingLight();
                    return;
                case 12:
                    alaCameraManager.setBeauty(message.arg1);
                    return;
                case 13:
                    alaCameraManager.startSendData();
                    return;
                case 14:
                    alaCameraManager.resetCamera2();
                    return;
                case 15:
                    alaCameraManager.doStartCamera();
                    return;
                case 16:
                    alaCameraManager.doStopCamera();
                    return;
            }
        }
    }
}
