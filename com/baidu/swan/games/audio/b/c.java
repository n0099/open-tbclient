package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
/* loaded from: classes11.dex */
public interface c extends com.baidu.swan.games.audio.a {
    void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void a(com.baidu.swan.nalib.audio.c cVar);

    boolean axJ();

    void fI(boolean z);

    void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener);

    void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    void setSrc(String str) throws Exception;

    void setVolume(float f);
}
