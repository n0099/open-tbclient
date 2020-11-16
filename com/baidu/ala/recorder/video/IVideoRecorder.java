package com.baidu.ala.recorder.video;

import android.view.View;
import com.baidu.ala.recorder.RecorderCallback;
/* loaded from: classes15.dex */
public interface IVideoRecorder {
    public static final int SENSE_CLOSE = 0;
    public static final int SENSE_RTC = 2;
    public static final int SENSE_RTMP = 1;

    /* loaded from: classes15.dex */
    public interface IVideoDataCallBack {
        void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j, long j2);

        void onError(int i);

        void onRawVideoFrameReceived(byte[] bArr, int i, int i2, int i3);
    }

    int getBitRate();

    int getOutputHeight();

    int getOutputWidth();

    View getPreview();

    VideoFormat getVideoFormat();

    boolean isForeBackgroundSwitchEnable();

    boolean isVideoThreadRun();

    void release();

    void setRecorderCallback(RecorderCallback recorderCallback);

    void setVideoConfig(AlaLiveVideoConfig alaLiveVideoConfig);

    void setVideoDataCallback(IVideoDataCallBack iVideoDataCallBack);

    void startGetDataToSend();

    void startRecord();

    void stopRecord();

    void willSwitchSense(int i);
}
