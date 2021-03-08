package com.baidu.ala.recorder.audio;

import android.content.Context;
import com.baidu.ala.ndk.AlaAudioFrame;
/* loaded from: classes5.dex */
public interface IAudioService {
    public static final int BUFFER_LENGTH = 2048;
    public static final int ERROR_CLOSE_AEC_RECORDER = 202;
    public static final int ERROR_CLOSE_STD_RECORDER = 102;
    public static final int ERROR_NO_DATA_OSL_RECORDER = 300;
    public static final int ERROR_READ_AEC_RECORDER = 201;
    public static final int ERROR_READ_STD_RECORDER = 101;
    public static final int ERROR_SETUP_AEC_RECORDER = 200;
    public static final int ERROR_SETUP_STD_RECORDER = 100;
    public static final int MAX_WAIT_MS = 5000;
    public static final int TYPE_AEC = 2;
    public static final int TYPE_DUM = 4;
    public static final int TYPE_OSL = 3;
    public static final int TYPE_STD = 1;

    /* loaded from: classes5.dex */
    public interface FrameCallback {
        public static final int AUDIO_TYPE_MSG_ID = 1001;
        public static final int CHECK_AUDIO_MSG_ID = 1000;

        void onAudioData(AlaAudioFrame alaAudioFrame);

        void onError(int i, String str);

        void onMessage(int i, Object obj, String str);
    }

    int getType();

    void mute(boolean z);

    void onCreate(Context context, FrameCallback frameCallback);

    void onDestroy();

    AlaAudioFrame readFrame();

    boolean start(AlaAudioConfig alaAudioConfig);

    boolean stop();
}
