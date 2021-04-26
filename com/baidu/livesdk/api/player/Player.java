package com.baidu.livesdk.api.player;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public interface Player {
    public static final int DECODE_MODE_HW = 2;
    public static final int DECODE_MODE_SW = 1;
    public static final int DECODE_MODE_SYS = 0;
    public static final int MEDIA_INFO_EXTEND_CARLTON_FOUND = 925;
    public static final int MEDIA_INFO_FIRST_DISP_INTERVAL = 904;
    public static final int MEDIA_INFO_NET_RECONNECTING = 923;
    public static final int MEDIA_INFO_VIDEO_NETWORK_DOWNLOAD_FIRST_PERIOD_SPEED = 909;
    public static final int VIDEO_SCALING_MODE_SCALE_16_TO_9 = 5;
    public static final int VIDEO_SCALING_MODE_SCALE_4_TO_3 = 4;
    public static final int VIDEO_SCALING_MODE_SCALE_5_TO_4 = 3;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FILL_WITH_CROPPING = 0;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;

    void createPlayerWithUrl(String str, Context context);

    int getCurrentPosition();

    int getDuration();

    View getPlayerView();

    int getVideoHeight();

    String getVideoPath();

    int getVideoWidth();

    boolean isPlaying();

    void muteOrUnmuteAudio(boolean z);

    void pause();

    void release();

    void reset();

    void seekTo(int i2);

    void setDecodeMode(int i2);

    void setExternalInfo(String str, Object obj);

    void setPlayerCallback(PlayerCallback playerCallback);

    void setVideoPath(String str);

    void setVideoRotation(int i2);

    void setVideoScalingMode(int i2);

    void setVideoViewHolder(FrameLayout frameLayout);

    void start();

    void stopPlayback();
}
