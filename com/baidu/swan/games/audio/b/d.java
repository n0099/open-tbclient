package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cYl;
    private MediaPlayer.OnPreparedListener cZd;
    private MediaPlayer.OnCompletionListener cZe;
    private MediaPlayer.OnErrorListener cZf;
    private MediaPlayer.OnSeekCompleteListener cZg;
    private com.baidu.swan.nalib.audio.c cZh;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer cZc = SwanAudioPlayer.getInstance();
    private Handler cZi = b.ayL().ayN();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.cZi.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.cZc.getState(d.this.cYl)) {
                    d.this.cZc.play(d.this.cYl, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.cZi.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cZc.pause(d.this.cYl);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.cZi.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.cZc.seek(d.this.cYl, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.cZi.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.cZc.stop(d.this.cYl);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.cZc.release(this.cYl);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.cZc.getDuration(this.cYl);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.cZc.getPosition(this.cYl);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.cZi.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cYl = d.this.cZc.setDataSource(str, (int) file.length());
                    d.this.cZc.setOnPreparedListener(d.this.cYl, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.cZd != null) {
                                d.this.cZd.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.cZc.setOnCompletionListener(d.this.cYl, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.cZe != null) {
                                d.this.cZe.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.cZc.setOnSeekCompleteListener(d.this.cYl, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.cZg != null) {
                                d.this.cZg.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.cZc.setOnErrorListener(d.this.cYl, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.cZf != null) {
                                return d.this.cZf.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.cZc.setOnPauseListener(d.this.cYl, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.cZh != null) {
                                d.this.cZh.onPause();
                            }
                        }
                    });
                    d.this.cZc.prepare(d.this.cYl);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void fN(final boolean z) {
        this.cZi.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cZc.getState(d.this.cYl)) {
                    d.this.cZc.setLoop(d.this.cYl, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.cZi.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cZc.getState(d.this.cYl)) {
                    d.this.cZc.setVolume(d.this.cYl, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cZd = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cZe = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cZf = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.cZg = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.cZh = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean ayP() {
        return false;
    }
}
