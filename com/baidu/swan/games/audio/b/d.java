package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cjG;
    private MediaPlayer.OnSeekCompleteListener ckA;
    private com.baidu.swan.nalib.audio.c ckB;
    private MediaPlayer.OnPreparedListener ckx;
    private MediaPlayer.OnCompletionListener cky;
    private MediaPlayer.OnErrorListener ckz;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer ckw = SwanAudioPlayer.getInstance();
    private Handler mAudioHandler = b.alz().alB();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.ckw.getState(d.this.cjG)) {
                    d.this.ckw.play(d.this.cjG, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckw.pause(d.this.cjG);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckw.seek(d.this.cjG, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckw.stop(d.this.cjG);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.ckw.release(this.cjG);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.ckw.getDuration(this.cjG);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.ckw.getPosition(this.cjG);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cjG = d.this.ckw.setDataSource(str, (int) file.length());
                    d.this.ckw.setOnPreparedListener(d.this.cjG, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.ckx != null) {
                                d.this.ckx.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckw.setOnCompletionListener(d.this.cjG, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.cky != null) {
                                d.this.cky.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckw.setOnSeekCompleteListener(d.this.cjG, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.ckA != null) {
                                d.this.ckA.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckw.setOnErrorListener(d.this.cjG, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.ckz != null) {
                                return d.this.ckz.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.ckw.setOnPauseListener(d.this.cjG, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.ckB != null) {
                                d.this.ckB.onPause();
                            }
                        }
                    });
                    d.this.ckw.prepare(d.this.cjG);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void ez(final boolean z) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.ckw.getState(d.this.cjG)) {
                    d.this.ckw.setLoop(d.this.cjG, z);
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
                if (2 == d.this.ckw.getState(d.this.cjG)) {
                    d.this.ckw.setVolume(d.this.cjG, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.ckx = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cky = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.ckz = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.ckA = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.ckB = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean alD() {
        return false;
    }
}
