package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public interface c extends com.baidu.swan.games.audio.a {
    boolean VT();

    void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void dd(boolean z);

    void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener);

    void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    void setSrc(String str) throws Exception;

    void setVolume(float f);
}
