package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer azV;
    private MediaPlayer.OnPreparedListener bal;
    private boolean bam;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        Eq();
    }

    private synchronized MediaPlayer Eq() {
        if (this.azV == null) {
            this.azV = new MediaPlayer();
            this.azV.setAudioStreamType(3);
            this.azV.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        a.this.play();
                        if (a.this.bal != null) {
                            a.this.bal.onPrepared(a.this.azV);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.azV;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        if (Nq()) {
            this.azV.setDataSource(str);
            this.azV.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        if (Nq()) {
            this.azV.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        if (Nq()) {
            this.azV.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bal = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        Eq().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.azV != null && !a.this.azV.isLooping()) {
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
        Eq().setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        Eq().setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Eq().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Eq().setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.swan.games.audio.b.e
    public boolean Np() {
        return this.bam;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (Nq()) {
            this.azV.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (Nq()) {
            this.azV.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
        if (Nq()) {
            this.azV.seekTo(i);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (Nq()) {
            this.azV.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.azV != null) {
            synchronized (this.azV) {
                unregisterListener();
                this.azV.release();
                this.azV = null;
            }
        }
        this.bam = true;
    }

    private boolean Nq() {
        return (this.azV == null || this.bam) ? false : true;
    }

    private void unregisterListener() {
        if (this.azV != null) {
            this.azV.setOnPreparedListener(null);
            this.azV.setOnCompletionListener(null);
            this.azV.setOnInfoListener(null);
            this.azV.setOnErrorListener(null);
            this.azV.setOnSeekCompleteListener(null);
            this.azV.setOnBufferingUpdateListener(null);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return Eq().getDuration();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return Eq().getCurrentPosition();
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return !Eq().isPlaying();
    }
}
