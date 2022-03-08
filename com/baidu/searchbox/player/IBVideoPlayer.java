package com.baidu.searchbox.player;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public interface IBVideoPlayer {
    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void play(String str);

    void prepare();

    void resume();

    void seekTo(int i2);

    void setUserAgent(String str);

    void setVideoBackground(@Nullable Drawable drawable);

    void setVideoRotation(int i2);

    void setVideoScalingMode(int i2);

    void setVideoUrl(String str);

    void start();

    void stop();
}
