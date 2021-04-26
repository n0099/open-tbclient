package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.io.FileDescriptor;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public abstract class PlayerProvider {
    public abstract void changeProxyDynamic(String str, boolean z);

    public abstract int getCurrentPosition();

    public abstract int getCurrentPositionSync();

    public abstract int getDecodeMode();

    public abstract long getDownloadSpeed();

    public abstract int getDuration();

    public abstract long getPlayedTime();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public abstract boolean isPlaying();

    public abstract boolean isRemotePlayer();

    public abstract void muteOrUnmuteAudio(boolean z);

    public abstract void pause();

    public abstract void prepareAsync();

    public abstract void release();

    public abstract void reset();

    public abstract void seekTo(long j);

    public void sendCommand(int i2, int i3, long j, String str) {
    }

    public void setClarityInfo(String str) {
    }

    public abstract void setDataSource(Context context, Uri uri);

    public abstract void setDataSource(Context context, Uri uri, Map<String, String> map);

    public abstract void setDataSource(FileDescriptor fileDescriptor);

    public abstract void setDataSource(String str);

    public abstract void setDataSource(String str, Map<String, String> map);

    public abstract void setDisplay(SurfaceHolder surfaceHolder);

    public void setEnableDumediaUA(boolean z) {
    }

    public abstract void setLooping(boolean z);

    public abstract void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener);

    public abstract void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener);

    public abstract void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener);

    public abstract void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener);

    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
    }

    public abstract void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener);

    public abstract void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener);

    public abstract void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener);

    public void setOption(String str, long j) {
    }

    public void setOption(String str, String str2) {
    }

    public void setPlayJson(String str) {
    }

    public abstract void setScreenOnWhilePlaying(boolean z);

    public abstract void setSpeed(float f2);

    public abstract void setSurface(Surface surface);

    public abstract void setVolume(float f2, float f3);

    public abstract void setWakeMode(Context context, int i2);

    public abstract void start();

    public abstract void stop();

    public void switchMediaSource(int i2) {
    }
}
