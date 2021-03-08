package com.baidu.ala.recorder;

import com.baidu.ala.helper.AlaLiveDebugInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class RecorderCallback {
    public static final int ERROR_CAMERA_CAN_NOT_OPEN_ERROR = 10;
    public static final int ERROR_CAMERA_EGL_ERROR = 3;
    public static final int ERROR_CAMERA_EXCEPTION = 13;
    public static final int ERROR_CAMERA_FRAME_ERROR = 1;
    public static final int ERROR_ENCODE_CODEC_ERROR = 12;
    public static final int ERROR_ENCODE_SENDH264DATA_ERROR = 11;
    public static final int ERROR_FU_GIFT_FILE_NOT_FOUND_ERROR = 5;
    public static final int ERROR_FU_GIFT_LOAD_ERROR = 6;
    public static final int ERROR_FU_GIFT_NOT_SUPPORT_FU_ERROR = 7;
    public static final int ERROR_NO_VIDEO_STREAM_ERROR = 4;
    public static final int ERROR_RECORDER_AUDIO = 15;
    public static final int ERROR_RECORDER_INIT = 14;
    public static final int ERROR_RECORDER_STOP = 16;
    public static final int ERROR_RECORDER_VIDEO = 17;
    public static final int ERROR_SCREEN_RECORD_ENCODE_ERROR = 4;
    public static final int ERROR_SCREEN_RECORD_PERMISSION_DENIED = 2;
    public static final int ERROR_VIDEO_HW_ENCODE_BITRATE = 18;
    public static final int EVENT_FU_GIFT_TRACK_FACE_STATUS_CHANGED = 8;

    public void flashLightSwitched(boolean z) {
    }

    public void cameraSwitched(boolean z) {
    }

    public void streamLostPackageRateReceived(double d) {
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
    }

    public void onVideoCollectionStart(boolean z, int i, int i2) {
    }

    public void onVideoCollectionStop() {
    }

    public void onAudioOpened(boolean z) {
    }

    public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
    }

    public void onError(int i, String str) {
    }

    public void onRtcConnected(int i) {
    }

    public void onPKPlayerFirstFrame() {
    }

    public void onFaceUnityEvent(int i, int i2, Object obj) {
    }

    public void onNetStateReport(int i, int i2) {
    }

    public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
    }

    public void sendBufferChanged(int i) {
    }
}
