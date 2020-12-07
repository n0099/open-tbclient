package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes25.dex */
public class d implements c {
    private int dVS;
    private MediaPlayer.OnPreparedListener dWK;
    private MediaPlayer.OnCompletionListener dWL;
    private MediaPlayer.OnErrorListener dWM;
    private MediaPlayer.OnSeekCompleteListener dWN;
    private com.baidu.swan.nalib.audio.c dWO;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer dWJ = SwanAudioPlayer.getInstance();
    private Handler dWP = b.aVq().aVs();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.dWP.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.dWJ.getState(d.this.dVS)) {
                    d.this.dWJ.play(d.this.dVS, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.dWP.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dWJ.pause(d.this.dVS);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.dWP.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.dWJ.seek(d.this.dVS, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.dWP.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.dWJ.stop(d.this.dVS);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.dWJ.release(this.dVS);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.dWJ.getDuration(this.dVS);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.dWJ.getPosition(this.dVS);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.dWP.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.dVS = d.this.dWJ.setDataSource(str, (int) file.length());
                    d.this.dWJ.setOnPreparedListener(d.this.dVS, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.dWK != null) {
                                d.this.dWK.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.dWJ.setOnCompletionListener(d.this.dVS, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.dWL != null) {
                                d.this.dWL.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.dWJ.setOnSeekCompleteListener(d.this.dVS, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.dWN != null) {
                                d.this.dWN.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.dWJ.setOnErrorListener(d.this.dVS, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.dWM != null) {
                                return d.this.dWM.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.dWJ.setOnPauseListener(d.this.dVS, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.dWO != null) {
                                d.this.dWO.onPause();
                            }
                        }
                    });
                    d.this.dWJ.prepare(d.this.dVS);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void hJ(final boolean z) {
        this.dWP.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dWJ.getState(d.this.dVS)) {
                    d.this.dWJ.setLoop(d.this.dVS, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.dWP.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dWJ.getState(d.this.dVS)) {
                    d.this.dWJ.setVolume(d.this.dVS, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dWK = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dWL = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dWM = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.dWN = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.dWO = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aVu() {
        return false;
    }
}
