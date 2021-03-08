package com.baidu.ala.recorder.video;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.RecorderCallback;
/* loaded from: classes5.dex */
public class RecorderHandler extends Handler {
    private static final String KEY_BUFFER_CHANGED = "buffer_chenged";
    private static final String KEY_CURLEVEL = "curlevel";
    private static final String KEY_ERROR_CODE = "error_code";
    private static final String KEY_ERROR_MSG = "error_msg";
    private static final String KEY_ISBETTER = "isbetter";
    private static final String KEY_ISFIRSTLEVEL = "isfirstlevel";
    private static final String KEY_LEVELPERCENT = "levelpercent";
    private static final String KEY_LOST_RATE = "lostrate";
    private static final String KEY_NET_STATE = "net_state";
    private static final String KEY_NET_STATE_VALUE = "net_state_value";
    private static final int MEG_SEND_BUFFER_CHANGED = 17;
    private static final int MEG_SEND_FU_FACE_TRACK_STATUS = 15;
    private static final int MEG_SEND_NET_STATE = 16;
    private static final int MSG_AUDIO_OPENED = 7;
    private static final int MSG_LOST_RATE = 3;
    private static final int MSG_SEND_DEBUG_INFO = 11;
    private static final int MSG_SEND_ERROR = 12;
    private static final int MSG_SEND_PK_PLAYER_FIRST_FRAME = 14;
    private static final int MSG_SEND_RECT_SIZE = 8;
    private static final int MSG_SEND_ROTATE_DEG = 10;
    private static final int MSG_SEND_RTC_CONNECTED = 13;
    private static final int MSG_SEND_ZOOM_AREA = 9;
    private static final int MSG_STREAM_STATE = 4;
    private static final int MSG_SWITCH_CAREMA = 2;
    private static final int MSG_SWITCH_FLASHLIGHT = 1;
    private static final int MSG_VIDEO_COLLECTION_START = 5;
    private static final int MSG_VIDEO_COLLECTION_STOP = 6;
    private RecorderCallback mRecorderCallback;

    public RecorderHandler(Looper looper) {
        super(looper);
        this.mRecorderCallback = null;
    }

    public void sendSwitchFlashLight(boolean z) {
        Message obtainMessage = obtainMessage(1);
        obtainMessage.arg1 = z ? 1 : 0;
        sendMessage(obtainMessage);
    }

    public void sendSwitchCarema(boolean z) {
        Message obtainMessage = obtainMessage(2);
        obtainMessage.arg1 = z ? 1 : 0;
        sendMessage(obtainMessage);
    }

    public void sendLostRate(double d) {
        Message obtainMessage = obtainMessage(3);
        Bundle bundle = new Bundle();
        bundle.putDouble(KEY_LOST_RATE, d);
        obtainMessage.setData(bundle);
        sendMessage(obtainMessage);
    }

    public void sendStreamState(int i, boolean z, int i2, boolean z2) {
        Message obtainMessage = obtainMessage(4);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_LEVELPERCENT, i);
        bundle.putBoolean(KEY_ISFIRSTLEVEL, z);
        bundle.putInt(KEY_CURLEVEL, i2);
        bundle.putBoolean(KEY_ISBETTER, z2);
        obtainMessage.setData(bundle);
        sendMessage(obtainMessage);
    }

    public void sendVideoCollectionStart(boolean z, int i, int i2) {
        Message obtainMessage = obtainMessage(5);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.obj = Boolean.valueOf(z);
        sendMessage(obtainMessage);
    }

    public void sendVideoCollectionStop() {
        sendMessage(obtainMessage(6));
    }

    public void sendAudioOpened(boolean z) {
        Message obtainMessage = obtainMessage(7);
        obtainMessage.arg1 = z ? 1 : 0;
        sendMessage(obtainMessage);
    }

    public void sendRectSize(int i, int i2) {
        sendMessage(obtainMessage(8, i, i2));
    }

    public void sendZoomArea(int i, int i2) {
        sendMessage(obtainMessage(9, i, i2));
    }

    public void sendRotateDeg(int i) {
        sendMessage(obtainMessage(10, i, 0));
    }

    public void sendDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        Message obtainMessage = obtainMessage(11);
        obtainMessage.obj = alaLiveDebugInfo;
        sendMessage(obtainMessage);
    }

    public void sendError(int i, String str) {
        Message obtainMessage = obtainMessage(12);
        Bundle bundle = new Bundle();
        bundle.putInt("error_code", i);
        bundle.putString("error_msg", str);
        obtainMessage.setData(bundle);
        sendMessage(obtainMessage);
    }

    public void sendRtcConnected(int i) {
        Message obtainMessage = obtainMessage(13);
        obtainMessage.arg1 = i;
        sendMessage(obtainMessage);
    }

    public void sendPkPlayerOnFirstFrame() {
        sendMessage(obtainMessage(14));
    }

    public void sendFuTrackFace(int i) {
        sendMessage(obtainMessage(15, i, 0));
    }

    public void sendNetState(int i, int i2) {
        Message obtainMessage = obtainMessage(16);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NET_STATE, i);
        bundle.putInt(KEY_NET_STATE_VALUE, i2);
        obtainMessage.setData(bundle);
        sendMessage(obtainMessage);
    }

    public void sendBufferChanged(int i) {
        Message obtainMessage = obtainMessage(17);
        obtainMessage.arg1 = i;
        sendMessage(obtainMessage);
    }

    public void setRecorderCallback(RecorderCallback recorderCallback) {
        this.mRecorderCallback = recorderCallback;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Bundle data;
        Bundle data2;
        Bundle data3;
        Bundle data4;
        int i = message.what;
        switch (i) {
            case 1:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.flashLightSwitched(message.arg1 == 1);
                    return;
                }
                return;
            case 2:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.cameraSwitched(message.arg1 == 1);
                    return;
                }
                return;
            case 3:
                if (this.mRecorderCallback != null && (data4 = message.getData()) != null) {
                    this.mRecorderCallback.streamLostPackageRateReceived(data4.getDouble(KEY_LOST_RATE));
                    return;
                }
                return;
            case 4:
                if (this.mRecorderCallback != null && (data3 = message.getData()) != null) {
                    this.mRecorderCallback.streamStateReceived(data3.getInt(KEY_LEVELPERCENT), data3.getBoolean(KEY_ISFIRSTLEVEL), data3.getInt(KEY_CURLEVEL), data3.getBoolean(KEY_ISBETTER));
                    return;
                }
                return;
            case 5:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.onVideoCollectionStart(((Boolean) message.obj).booleanValue(), message.arg1, message.arg2);
                    return;
                }
                return;
            case 6:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.onVideoCollectionStop();
                    return;
                }
                return;
            case 7:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.onAudioOpened(message.arg1 == 1);
                    return;
                }
                return;
            case 8:
            case 9:
            case 10:
            default:
                throw new RuntimeException("unknown message " + i);
            case 11:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.onDebugInfo((AlaLiveDebugInfo) message.obj);
                    return;
                }
                return;
            case 12:
                if (this.mRecorderCallback != null && (data2 = message.getData()) != null) {
                    this.mRecorderCallback.onError(data2.getInt("error_code"), data2.getString("error_msg"));
                    return;
                }
                return;
            case 13:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.onRtcConnected(message.arg1);
                    return;
                }
                return;
            case 14:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.onPKPlayerFirstFrame();
                    return;
                }
                return;
            case 15:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.onFaceUnityEvent(8, message.arg1, null);
                    return;
                }
                return;
            case 16:
                if (this.mRecorderCallback != null && (data = message.getData()) != null) {
                    this.mRecorderCallback.onNetStateReport(data.getInt(KEY_NET_STATE), data.getInt(KEY_NET_STATE_VALUE));
                    return;
                }
                return;
            case 17:
                if (this.mRecorderCallback != null) {
                    this.mRecorderCallback.sendBufferChanged(message.arg1);
                    return;
                }
                return;
        }
    }
}
