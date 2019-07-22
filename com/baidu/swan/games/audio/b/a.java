package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aBB;
    private MediaPlayer.OnPreparedListener bff;
    private boolean bfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        GW();
    }

    private synchronized MediaPlayer GW() {
        if (this.aBB == null) {
            this.aBB = new MediaPlayer();
            this.aBB.setAudioStreamType(3);
            this.aBB.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        if (a.this.bff != null) {
                            a.this.bff.onPrepared(a.this.aBB);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.aBB;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(String str) throws Exception {
        if (Rc()) {
            this.aBB.setDataSource(str);
            this.aBB.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void cM(boolean z) {
        if (Rc()) {
            this.aBB.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(float f) {
        if (Rc()) {
            this.aBB.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bff = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        GW().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.aBB != null && !a.this.aBB.isLooping()) {
                    a.this.destroy();
                }
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(null);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        GW().setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        GW().setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        GW().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        GW().setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean Rb() {
        return this.bfg;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (Rc()) {
            this.aBB.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (Rc()) {
            this.aBB.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(float f) {
        if (Rc()) {
            this.aBB.seekTo((int) f);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (Rc()) {
            this.aBB.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.aBB != null) {
            synchronized (this.aBB) {
                unregisterListener();
                this.aBB.release();
                this.aBB = null;
            }
        }
        this.bfg = true;
    }

    private boolean Rc() {
        return (this.aBB == null || this.bfg) ? false : true;
    }

    private void unregisterListener() {
        if (this.aBB != null) {
            this.aBB.setOnPreparedListener(null);
            this.aBB.setOnCompletionListener(null);
            this.aBB.setOnInfoListener(null);
            this.aBB.setOnErrorListener(null);
            this.aBB.setOnSeekCompleteListener(null);
            this.aBB.setOnBufferingUpdateListener(null);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return GW().getDuration();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return GW().getCurrentPosition();
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return !GW().isPlaying();
    }
}
