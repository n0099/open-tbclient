package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer azS;
    private MediaPlayer.OnPreparedListener bai;
    private boolean baj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        Es();
    }

    private synchronized MediaPlayer Es() {
        if (this.azS == null) {
            this.azS = new MediaPlayer();
            this.azS.setAudioStreamType(3);
            this.azS.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        a.this.play();
                        if (a.this.bai != null) {
                            a.this.bai.onPrepared(a.this.azS);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.azS;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        if (Ns()) {
            this.azS.setDataSource(str);
            this.azS.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        if (Ns()) {
            this.azS.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        if (Ns()) {
            this.azS.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bai = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        Es().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.azS != null && !a.this.azS.isLooping()) {
                    a.this.destroy();
                }
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(null);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        Es().setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        Es().setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Es().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Es().setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public boolean Nr() {
        return this.baj;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (Ns()) {
            this.azS.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (Ns()) {
            this.azS.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
        if (Ns()) {
            this.azS.seekTo(i);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (Ns()) {
            this.azS.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.azS != null) {
            synchronized (this.azS) {
                unregisterListener();
                this.azS.release();
                this.azS = null;
            }
        }
        this.baj = true;
    }

    private boolean Ns() {
        return (this.azS == null || this.baj) ? false : true;
    }

    private void unregisterListener() {
        if (this.azS != null) {
            this.azS.setOnPreparedListener(null);
            this.azS.setOnCompletionListener(null);
            this.azS.setOnInfoListener(null);
            this.azS.setOnErrorListener(null);
            this.azS.setOnSeekCompleteListener(null);
            this.azS.setOnBufferingUpdateListener(null);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return Es().getDuration();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return Es().getCurrentPosition();
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return !Es().isPlaying();
    }
}
