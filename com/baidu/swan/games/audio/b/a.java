package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import java.io.IOException;
/* loaded from: classes2.dex */
public class a implements e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer azW;
    private MediaPlayer.OnPreparedListener bam;
    private boolean ban;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        Eq();
    }

    private synchronized MediaPlayer Eq() {
        if (this.azW == null) {
            this.azW = new MediaPlayer();
            this.azW.setAudioStreamType(3);
            this.azW.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        a.this.play();
                        if (a.this.bam != null) {
                            a.this.bam.onPrepared(a.this.azW);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.azW;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setSrc(String str) throws IOException {
        if (Nq()) {
            this.azW.setDataSource(str);
            this.azW.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void ct(boolean z) {
        if (Nq()) {
            this.azW.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setVolume(float f) {
        if (Nq()) {
            this.azW.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bam = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.e
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        Eq().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.azW != null && !a.this.azW.isLooping()) {
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
        return this.ban;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (Nq()) {
            this.azW.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (Nq()) {
            this.azW.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(int i) {
        if (Nq()) {
            this.azW.seekTo(i);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (Nq()) {
            this.azW.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.azW != null) {
            synchronized (this.azW) {
                unregisterListener();
                this.azW.release();
                this.azW = null;
            }
        }
        this.ban = true;
    }

    private boolean Nq() {
        return (this.azW == null || this.ban) ? false : true;
    }

    private void unregisterListener() {
        if (this.azW != null) {
            this.azW.setOnPreparedListener(null);
            this.azW.setOnCompletionListener(null);
            this.azW.setOnInfoListener(null);
            this.azW.setOnErrorListener(null);
            this.azW.setOnSeekCompleteListener(null);
            this.azW.setOnBufferingUpdateListener(null);
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
