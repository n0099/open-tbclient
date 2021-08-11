package com.baidu.mobads.container.widget.player;

import android.content.res.Configuration;
import com.baidu.mobads.container.widget.player.AdVideoViewListener;
/* loaded from: classes5.dex */
public interface IAdVideoView {
    int getCurrentPosition();

    int getDuration();

    boolean isPlaying();

    void onConfigurationChanged(Configuration configuration);

    void onPause();

    void onResume();

    void seekTo(int i2);

    void setAdVideoViewListener(AdVideoViewListener adVideoViewListener);

    void setDestroyedListener(AdVideoViewListener.DestroyedListener destroyedListener);

    void setPlayBackSpeed(float f2);

    void setPreparedListener(AdVideoViewListener.PreparedListener preparedListener);

    void setVideoMute(boolean z);

    void setVideoUrl(String str);

    void startPlay(String str);

    void stopAndRelease();
}
