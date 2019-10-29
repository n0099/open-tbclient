package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aVo;
    private MediaPlayer.OnPreparedListener byw;
    private boolean byx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        LU();
    }

    private synchronized MediaPlayer LU() {
        if (this.aVo == null) {
            this.aVo = new MediaPlayer();
            this.aVo.setAudioStreamType(3);
            this.aVo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        if (a.this.byw != null) {
                            a.this.byw.onPrepared(a.this.aVo);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.aVo;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(String str) throws Exception {
        if (VW()) {
            this.aVo.setDataSource(str);
            this.aVo.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void dd(boolean z) {
        if (VW()) {
            this.aVo.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(float f) {
        if (VW()) {
            this.aVo.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.byw = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        LU().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.aVo != null && !a.this.aVo.isLooping()) {
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
        LU().setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        LU().setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        LU().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        LU().setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean VV() {
        return this.byx;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (VW()) {
            this.aVo.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (VW()) {
            this.aVo.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(float f) {
        if (VW()) {
            this.aVo.seekTo((int) f);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (VW()) {
            this.aVo.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.aVo != null) {
            synchronized (this.aVo) {
                unregisterListener();
                this.aVo.release();
                this.aVo = null;
            }
        }
        this.byx = true;
    }

    private boolean VW() {
        return (this.aVo == null || this.byx) ? false : true;
    }

    private void unregisterListener() {
        if (this.aVo != null) {
            this.aVo.setOnPreparedListener(null);
            this.aVo.setOnCompletionListener(null);
            this.aVo.setOnInfoListener(null);
            this.aVo.setOnErrorListener(null);
            this.aVo.setOnSeekCompleteListener(null);
            this.aVo.setOnBufferingUpdateListener(null);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return LU().getDuration();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return LU().getCurrentPosition();
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return !LU().isPlaying();
    }
}
