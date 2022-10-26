package com.baidu.searchbox.player;

import android.graphics.drawable.Drawable;
/* loaded from: classes2.dex */
public interface IBVideoPlayer {
    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void play(String str);

    void prepare();

    void resume();

    void seekTo(int i);

    void setUserAgent(String str);

    void setVideoBackground(Drawable drawable);

    void setVideoRotation(int i);

    void setVideoScalingMode(int i);

    void setVideoUrl(String str);

    void start();

    void stop();
}
