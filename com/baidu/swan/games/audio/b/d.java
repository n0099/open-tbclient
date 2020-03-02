package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cjH;
    private MediaPlayer.OnErrorListener ckA;
    private MediaPlayer.OnSeekCompleteListener ckB;
    private com.baidu.swan.nalib.audio.c ckC;
    private MediaPlayer.OnPreparedListener cky;
    private MediaPlayer.OnCompletionListener ckz;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer ckx = SwanAudioPlayer.getInstance();
    private Handler mAudioHandler = b.alB().alD();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.ckx.getState(d.this.cjH)) {
                    d.this.ckx.play(d.this.cjH, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckx.pause(d.this.cjH);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckx.seek(d.this.cjH, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckx.stop(d.this.cjH);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.ckx.release(this.cjH);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.ckx.getDuration(this.cjH);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.ckx.getPosition(this.cjH);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cjH = d.this.ckx.setDataSource(str, (int) file.length());
                    d.this.ckx.setOnPreparedListener(d.this.cjH, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.cky != null) {
                                d.this.cky.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckx.setOnCompletionListener(d.this.cjH, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.ckz != null) {
                                d.this.ckz.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckx.setOnSeekCompleteListener(d.this.cjH, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.ckB != null) {
                                d.this.ckB.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckx.setOnErrorListener(d.this.cjH, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.ckA != null) {
                                return d.this.ckA.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.ckx.setOnPauseListener(d.this.cjH, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.ckC != null) {
                                d.this.ckC.onPause();
                            }
                        }
                    });
                    d.this.ckx.prepare(d.this.cjH);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void ez(final boolean z) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.ckx.getState(d.this.cjH)) {
                    d.this.ckx.setLoop(d.this.cjH, z);
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
                if (2 == d.this.ckx.getState(d.this.cjH)) {
                    d.this.ckx.setVolume(d.this.cjH, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cky = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.ckz = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.ckA = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.ckB = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.ckC = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean alF() {
        return false;
    }
}
