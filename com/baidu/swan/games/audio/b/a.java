package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aUW;
    private MediaPlayer.OnPreparedListener bxF;
    private boolean bxG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        LV();
    }

    private synchronized MediaPlayer LV() {
        if (this.aUW == null) {
            this.aUW = new MediaPlayer();
            this.aUW.setAudioStreamType(3);
            this.aUW.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        if (a.this.bxF != null) {
                            a.this.bxF.onPrepared(a.this.aUW);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.aUW;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(String str) throws Exception {
        if (VU()) {
            this.aUW.setDataSource(str);
            this.aUW.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void dd(boolean z) {
        if (VU()) {
            this.aUW.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(float f) {
        if (VU()) {
            this.aUW.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bxF = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        LV().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.aUW != null && !a.this.aUW.isLooping()) {
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
        LV().setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        LV().setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        LV().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        LV().setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean VT() {
        return this.bxG;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (VU()) {
            this.aUW.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (VU()) {
            this.aUW.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(float f) {
        if (VU()) {
            this.aUW.seekTo((int) f);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (VU()) {
            this.aUW.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.aUW != null) {
            synchronized (this.aUW) {
                unregisterListener();
                this.aUW.release();
                this.aUW = null;
            }
        }
        this.bxG = true;
    }

    private boolean VU() {
        return (this.aUW == null || this.bxG) ? false : true;
    }

    private void unregisterListener() {
        if (this.aUW != null) {
            this.aUW.setOnPreparedListener(null);
            this.aUW.setOnCompletionListener(null);
            this.aUW.setOnInfoListener(null);
            this.aUW.setOnErrorListener(null);
            this.aUW.setOnSeekCompleteListener(null);
            this.aUW.setOnBufferingUpdateListener(null);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return LV().getDuration();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return LV().getCurrentPosition();
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return !LV().isPlaying();
    }
}
