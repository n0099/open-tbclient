package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private MediaPlayer azR;
    private MediaPlayer.OnPreparedListener bah;
    private boolean bai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        Es();
    }

    private synchronized MediaPlayer Es() {
        if (this.azR == null) {
            this.azR = new MediaPlayer();
            this.azR.setAudioStreamType(3);
            this.azR.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        a.this.play();
                        if (a.this.bah != null) {
                            a.this.bah.onPrepared(a.this.azR);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.azR;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        if (Ns()) {
            this.azR.setDataSource(str);
            this.azR.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        if (Ns()) {
            this.azR.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        if (Ns()) {
            this.azR.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bah = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        Es().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.azR != null && !a.this.azR.isLooping()) {
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
        return this.bai;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (Ns()) {
            this.azR.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (Ns()) {
            this.azR.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
        if (Ns()) {
            this.azR.seekTo(i);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (Ns()) {
            this.azR.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.azR != null) {
            synchronized (this.azR) {
                unregisterListener();
                this.azR.release();
                this.azR = null;
            }
        }
        this.bai = true;
    }

    private boolean Ns() {
        return (this.azR == null || this.bai) ? false : true;
    }

    private void unregisterListener() {
        if (this.azR != null) {
            this.azR.setOnPreparedListener(null);
            this.azR.setOnCompletionListener(null);
            this.azR.setOnInfoListener(null);
            this.azR.setOnErrorListener(null);
            this.azR.setOnSeekCompleteListener(null);
            this.azR.setOnBufferingUpdateListener(null);
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
