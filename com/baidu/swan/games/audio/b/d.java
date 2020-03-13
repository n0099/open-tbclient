package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cjI;
    private MediaPlayer.OnCompletionListener ckA;
    private MediaPlayer.OnErrorListener ckB;
    private MediaPlayer.OnSeekCompleteListener ckC;
    private com.baidu.swan.nalib.audio.c ckD;
    private MediaPlayer.OnPreparedListener ckz;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer cky = SwanAudioPlayer.getInstance();
    private Handler mAudioHandler = b.alB().alD();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.cky.getState(d.this.cjI)) {
                    d.this.cky.play(d.this.cjI, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cky.pause(d.this.cjI);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.cky.seek(d.this.cjI, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.cky.stop(d.this.cjI);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.cky.release(this.cjI);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.cky.getDuration(this.cjI);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.cky.getPosition(this.cjI);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cjI = d.this.cky.setDataSource(str, (int) file.length());
                    d.this.cky.setOnPreparedListener(d.this.cjI, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.ckz != null) {
                                d.this.ckz.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.cky.setOnCompletionListener(d.this.cjI, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.ckA != null) {
                                d.this.ckA.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.cky.setOnSeekCompleteListener(d.this.cjI, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.ckC != null) {
                                d.this.ckC.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.cky.setOnErrorListener(d.this.cjI, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.ckB != null) {
                                return d.this.ckB.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.cky.setOnPauseListener(d.this.cjI, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.ckD != null) {
                                d.this.ckD.onPause();
                            }
                        }
                    });
                    d.this.cky.prepare(d.this.cjI);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void ez(final boolean z) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cky.getState(d.this.cjI)) {
                    d.this.cky.setLoop(d.this.cjI, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cky.getState(d.this.cjI)) {
                    d.this.cky.setVolume(d.this.cjI, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.ckz = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.ckA = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.ckB = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.ckC = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.ckD = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean alF() {
        return false;
    }
}
