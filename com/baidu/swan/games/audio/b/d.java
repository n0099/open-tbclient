package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes10.dex */
public class d implements c {
    private boolean bwy;
    private int cfC;
    private MediaPlayer.OnPreparedListener cgt;
    private MediaPlayer.OnCompletionListener cgu;
    private MediaPlayer.OnErrorListener cgv;
    private MediaPlayer.OnSeekCompleteListener cgw;
    private com.baidu.swan.nalib.audio.c cgx;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer cgs = SwanAudioPlayer.getInstance();
    private Handler mAudioHandler = b.ajl().ajn();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.cgs.getState(d.this.cfC)) {
                    d.this.cgs.play(d.this.cfC, d.this.mVolume, d.this.bwy);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.cgs.pause(d.this.cfC);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.cgs.seek(d.this.cfC, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.cgs.stop(d.this.cfC);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.cgs.release(this.cfC);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.cgs.getDuration(this.cfC);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.cgs.getPosition(this.cfC);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cfC = d.this.cgs.setDataSource(str, (int) file.length());
                    d.this.cgs.setOnPreparedListener(d.this.cfC, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.cgt != null) {
                                d.this.cgt.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.cgs.setOnCompletionListener(d.this.cfC, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.cgu != null) {
                                d.this.cgu.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.cgs.setOnSeekCompleteListener(d.this.cfC, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.cgw != null) {
                                d.this.cgw.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.cgs.setOnErrorListener(d.this.cfC, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.cgv != null) {
                                return d.this.cgv.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.cgs.setOnPauseListener(d.this.cfC, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.cgx != null) {
                                d.this.cgx.onPause();
                            }
                        }
                    });
                    d.this.cgs.prepare(d.this.cfC);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void es(final boolean z) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cgs.getState(d.this.cfC)) {
                    d.this.cgs.setLoop(d.this.cfC, z);
                }
                d.this.bwy = z;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setVolume(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.7
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.cgs.getState(d.this.cfC)) {
                    d.this.cgs.setVolume(d.this.cfC, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cgt = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cgu = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cgv = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.cgw = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.cgx = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean ajp() {
        return false;
    }
}
