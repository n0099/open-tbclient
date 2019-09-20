package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aBZ;
    private MediaPlayer.OnPreparedListener bfD;
    private boolean bfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        Ha();
    }

    private synchronized MediaPlayer Ha() {
        if (this.aBZ == null) {
            this.aBZ = new MediaPlayer();
            this.aBZ.setAudioStreamType(3);
            this.aBZ.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        if (a.this.bfD != null) {
                            a.this.bfD.onPrepared(a.this.aBZ);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.aBZ;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(String str) throws Exception {
        if (Rg()) {
            this.aBZ.setDataSource(str);
            this.aBZ.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void cM(boolean z) {
        if (Rg()) {
            this.aBZ.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(float f) {
        if (Rg()) {
            this.aBZ.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.bfD = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        Ha().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.aBZ != null && !a.this.aBZ.isLooping()) {
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
        Ha().setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        Ha().setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Ha().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Ha().setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean Rf() {
        return this.bfE;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (Rg()) {
            this.aBZ.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (Rg()) {
            this.aBZ.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(float f) {
        if (Rg()) {
            this.aBZ.seekTo((int) f);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (Rg()) {
            this.aBZ.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.aBZ != null) {
            synchronized (this.aBZ) {
                unregisterListener();
                this.aBZ.release();
                this.aBZ = null;
            }
        }
        this.bfE = true;
    }

    private boolean Rg() {
        return (this.aBZ == null || this.bfE) ? false : true;
    }

    private void unregisterListener() {
        if (this.aBZ != null) {
            this.aBZ.setOnPreparedListener(null);
            this.aBZ.setOnCompletionListener(null);
            this.aBZ.setOnInfoListener(null);
            this.aBZ.setOnErrorListener(null);
            this.aBZ.setOnSeekCompleteListener(null);
            this.aBZ.setOnBufferingUpdateListener(null);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return Ha().getDuration();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return Ha().getCurrentPosition();
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return !Ha().isPlaying();
    }
}
