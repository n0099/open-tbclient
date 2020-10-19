package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes10.dex */
public class d implements c {
    private int dCn;
    private MediaPlayer.OnPreparedListener dDf;
    private MediaPlayer.OnCompletionListener dDg;
    private MediaPlayer.OnErrorListener dDh;
    private MediaPlayer.OnSeekCompleteListener dDi;
    private com.baidu.swan.nalib.audio.c dDj;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer dDe = SwanAudioPlayer.getInstance();
    private Handler dDk = b.aOz().aOB();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.dDk.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.dDe.getState(d.this.dCn)) {
                    d.this.dDe.play(d.this.dCn, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.dDk.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.dDe.pause(d.this.dCn);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.dDk.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.dDe.seek(d.this.dCn, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.dDk.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.dDe.stop(d.this.dCn);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.dDe.release(this.dCn);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.dDe.getDuration(this.dCn);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.dDe.getPosition(this.dCn);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.dDk.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.dCn = d.this.dDe.setDataSource(str, (int) file.length());
                    d.this.dDe.setOnPreparedListener(d.this.dCn, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.dDf != null) {
                                d.this.dDf.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.dDe.setOnCompletionListener(d.this.dCn, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.dDg != null) {
                                d.this.dDg.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.dDe.setOnSeekCompleteListener(d.this.dCn, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.dDi != null) {
                                d.this.dDi.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.dDe.setOnErrorListener(d.this.dCn, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.dDh != null) {
                                return d.this.dDh.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.dDe.setOnPauseListener(d.this.dCn, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.dDj != null) {
                                d.this.dDj.onPause();
                            }
                        }
                    });
                    d.this.dDe.prepare(d.this.dCn);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void gV(final boolean z) {
        this.dDk.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dDe.getState(d.this.dCn)) {
                    d.this.dDe.setLoop(d.this.dCn, z);
                }
                d.this.mLoop = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.dDk.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.dDe.getState(d.this.dCn)) {
                    d.this.dDe.setVolume(d.this.dCn, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.dDf = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.dDg = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.dDh = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.dDi = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.dDj = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean aOD() {
        return false;
    }
}
