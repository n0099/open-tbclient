package com.baidu.searchbox.player;
/* loaded from: classes9.dex */
public interface IBVideoPlayer {
    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void play(String str);

    void prepare();

    void resume();

    void seekTo(int i2);

    void setParameter(String str, int i2);

    void setUserAgent(String str);

    void setVideoRotation(int i2);

    void setVideoScalingMode(int i2);

    void setVideoUrl(String str);

    void start();

    void stop();
}
