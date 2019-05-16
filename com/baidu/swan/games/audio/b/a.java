package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
/* loaded from: classes2.dex */
public class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private MediaPlayer aAT;
    private MediaPlayer.OnPreparedListener ber;
    private boolean bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        create();
    }

    private void create() {
        Gm();
    }

    private synchronized MediaPlayer Gm() {
        if (this.aAT == null) {
            this.aAT = new MediaPlayer();
            this.aAT.setAudioStreamType(3);
            this.aAT.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.a.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    try {
                        if (a.this.ber != null) {
                            a.this.ber.onPrepared(a.this.aAT);
                        }
                    } catch (Exception e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        return this.aAT;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(String str) throws Exception {
        if (Qk()) {
            this.aAT.setDataSource(str);
            this.aAT.prepareAsync();
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void cJ(boolean z) {
        if (Qk()) {
            this.aAT.setLooping(z);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(float f) {
        if (Qk()) {
            this.aAT.setVolume(f, f);
        }
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.ber = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(final MediaPlayer.OnCompletionListener onCompletionListener) {
        Gm().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.a.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (a.this.aAT != null && !a.this.aAT.isLooping()) {
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
        Gm().setOnInfoListener(onInfoListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        Gm().setOnErrorListener(onErrorListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        Gm().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        Gm().setOnBufferingUpdateListener(onBufferingUpdateListener);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean Qj() {
        return this.bes;
    }

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        if (Qk()) {
            this.aAT.start();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        if (Qk()) {
            this.aAT.pause();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(float f) {
        if (Qk()) {
            this.aAT.seekTo((int) f);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        if (Qk()) {
            this.aAT.stop();
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        if (this.aAT != null) {
            synchronized (this.aAT) {
                unregisterListener();
                this.aAT.release();
                this.aAT = null;
            }
        }
        this.bes = true;
    }

    private boolean Qk() {
        return (this.aAT == null || this.bes) ? false : true;
    }

    private void unregisterListener() {
        if (this.aAT != null) {
            this.aAT.setOnPreparedListener(null);
            this.aAT.setOnCompletionListener(null);
            this.aAT.setOnInfoListener(null);
            this.aAT.setOnErrorListener(null);
            this.aAT.setOnSeekCompleteListener(null);
            this.aAT.setOnBufferingUpdateListener(null);
        }
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return Gm().getDuration();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return Gm().getCurrentPosition();
    }

    @Override // com.baidu.swan.games.audio.a
    public boolean isPaused() {
        return !Gm().isPlaying();
    }
}
