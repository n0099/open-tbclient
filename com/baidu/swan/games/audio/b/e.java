package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public interface e extends com.baidu.swan.games.audio.a {
    boolean Nr();

    void ct(boolean z);

    void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener);

    void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener);

    void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener);

    void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener);

    void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener);

    void setSrc(String str) throws IOException;

    void setVolume(float f);
}
