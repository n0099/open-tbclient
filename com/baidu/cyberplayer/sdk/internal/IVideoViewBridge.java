package com.baidu.cyberplayer.sdk.internal;

import android.widget.RelativeLayout;
import com.baidu.cyberplayer.sdk.BVideoView;
/* loaded from: classes.dex */
public interface IVideoViewBridge {
    int getCurrentPosition();

    int getDuration();

    int getVideoHeight();

    RelativeLayout getVideoView();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void resume();

    void seekTo(int i);

    void setDecodeMode(int i);

    void setMediaControllerBridge(IVideoViewControllerBridge iVideoViewControllerBridge);

    void setOnCompletionListener(BVideoView.OnCompletionListener onCompletionListener);

    void setOnErrorListener(BVideoView.OnErrorListener onErrorListener);

    void setOnInfoListener(BVideoView.OnInfoListener onInfoListener);

    void setOnPlayingBufferCacheListener(BVideoView.OnPlayingBufferCacheListener onPlayingBufferCacheListener);

    void setOnPreparedListener(BVideoView.OnPreparedListener onPreparedListener);

    void setVideoPath(String str);

    void showCacheInfo(boolean z);

    void start();

    void stopPlayback();
}
