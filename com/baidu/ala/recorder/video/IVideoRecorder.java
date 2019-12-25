package com.baidu.ala.recorder.video;

import android.view.View;
import com.baidu.ala.recorder.RecorderCallback;
/* loaded from: classes2.dex */
public interface IVideoRecorder {

    /* loaded from: classes2.dex */
    public interface IVideoDataCallBack {
        void onEncodeVideoFrameRecived(byte[] bArr, int i, int i2, int i3, long j);

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
}
