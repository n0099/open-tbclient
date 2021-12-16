package com.baidu.cyberplayer.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import java.util.Map;
@Keep
/* loaded from: classes10.dex */
public interface ICyberVideoView {

    @Keep
    /* loaded from: classes10.dex */
    public interface OnSnapShotCompleteListener {
        void onSnapShotComplete(Bitmap bitmap);
    }

    void changeProxyDynamic(String str);

    void destory();

    int getCurrentPosition();

    int getDuration();

    long getPlayedTime();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    boolean isPlaying();

    void muteOrUnmuteAudio(boolean z);

    void pause();

    void reset();

    void seekTo(int i2);

    void seekTo(int i2, int i3);

    void setClarityInfo(String str);

    void setDecodeMode(int i2);

    void setExternalInfo(String str, Object obj);

    void setLooping(boolean z);

    void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener);

    void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener);

    void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener);

    void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener);

    void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setOption(String str, String str2);

    void setPlayJson(String str);

    void setRemote(boolean z);

    void setSpeed(float f2);

    void setVideoRotation(int i2);

    void setVideoScalingMode(int i2);

    void setVideoURI(Uri uri);

    void setVideoURI(Uri uri, Map<String, String> map);

    void start();

    void stopPlayback();

    void switchMediaSource(int i2);

    boolean takeSnapshotAsync(OnSnapShotCompleteListener onSnapShotCompleteListener);

    boolean takeSnapshotAsync(OnSnapShotCompleteListener onSnapShotCompleteListener, float f2, int i2, int i3);
}
