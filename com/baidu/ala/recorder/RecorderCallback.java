package com.baidu.ala.recorder;

import com.baidu.ala.helper.AlaLiveDebugInfo;
/* loaded from: classes12.dex */
public interface RecorderCallback {
    public static final int ERROR_CAMERA_EGL_ERROR = 3;
    public static final int ERROR_CAMERA_FRAME_ERROR = 1;
    public static final int ERROR_FU_GIFT_FILE_NOT_FOUND_ERROR = 5;
    public static final int ERROR_FU_GIFT_LOAD_ERROR = 6;
    public static final int ERROR_FU_GIFT_NOT_SUPPORT_FU_ERROR = 7;
    public static final int ERROR_NO_VIDEO_STREAM_ERROR = 4;
    public static final int ERROR_SCREEN_RECORD_ENCODE_ERROR = 4;
    public static final int ERROR_SCREEN_RECORD_PERMISSION_DENIED = 2;
    public static final int EVENT_FU_GIFT_TRACK_FACE_STATUS_CHANGED = 8;

    void cameraSwitched(boolean z);

    void flashLightSwitched(boolean z);

    void onAudioOpened(boolean z);

    void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo);

    void onError(int i, String str);

    void onFaceUnityEvent(int i, int i2, Object obj);

    void onPKPlayerFirstFrame();

    void onRtcConnected(int i);

    void onVideoCollectionStart(boolean z, int i, int i2);

    void onVideoCollectionStop();

    void streamLostPackageRateReceived(double d);

    void streamStateReceived(int i, boolean z, int i2, boolean z2);
}
