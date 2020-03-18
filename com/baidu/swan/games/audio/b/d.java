package com.baidu.swan.games.audio.b;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes11.dex */
public class d implements c {
    private int cjT;
    private MediaPlayer.OnPreparedListener ckK;
    private MediaPlayer.OnCompletionListener ckL;
    private MediaPlayer.OnErrorListener ckM;
    private MediaPlayer.OnSeekCompleteListener ckN;
    private com.baidu.swan.nalib.audio.c ckO;
    private boolean mLoop;
    private String mSrc;
    private float mVolume;
    private SwanAudioPlayer ckJ = SwanAudioPlayer.getInstance();
    private Handler mAudioHandler = b.alE().alG();

    @Override // com.baidu.swan.games.audio.a
    public void play() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (2 != d.this.ckJ.getState(d.this.cjT)) {
                    d.this.ckJ.play(d.this.cjT, d.this.mVolume, d.this.mLoop);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void pause() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.2
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckJ.pause(d.this.cjT);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void seek(final float f) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckJ.seek(d.this.cjT, (int) f);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void stop() {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.4
            @Override // java.lang.Runnable
            public void run() {
                d.this.ckJ.stop(d.this.cjT);
            }
        });
    }

    @Override // com.baidu.swan.games.audio.a
    public void destroy() {
        this.ckJ.release(this.cjT);
        stop();
    }

    @Override // com.baidu.swan.games.audio.a
    public int getDuration() {
        return this.ckJ.getDuration(this.cjT);
    }

    @Override // com.baidu.swan.games.audio.a
    public int getCurrentTime() {
        return this.ckJ.getPosition(this.cjT);
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setSrc(final String str) throws Exception {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.mSrc = str;
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    d.this.cjT = d.this.ckJ.setDataSource(str, (int) file.length());
                    d.this.ckJ.setOnPreparedListener(d.this.cjT, new MediaPlayer.OnPreparedListener() { // from class: com.baidu.swan.games.audio.b.d.5.1
                        @Override // android.media.MediaPlayer.OnPreparedListener
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            if (d.this.ckK != null) {
                                d.this.ckK.onPrepared(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckJ.setOnCompletionListener(d.this.cjT, new MediaPlayer.OnCompletionListener() { // from class: com.baidu.swan.games.audio.b.d.5.2
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if (d.this.ckL != null) {
                                d.this.ckL.onCompletion(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckJ.setOnSeekCompleteListener(d.this.cjT, new MediaPlayer.OnSeekCompleteListener() { // from class: com.baidu.swan.games.audio.b.d.5.3
                        @Override // android.media.MediaPlayer.OnSeekCompleteListener
                        public void onSeekComplete(MediaPlayer mediaPlayer) {
                            if (d.this.ckN != null) {
                                d.this.ckN.onSeekComplete(mediaPlayer);
                            }
                        }
                    });
                    d.this.ckJ.setOnErrorListener(d.this.cjT, new MediaPlayer.OnErrorListener() { // from class: com.baidu.swan.games.audio.b.d.5.4
                        @Override // android.media.MediaPlayer.OnErrorListener
                        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            if (d.this.ckM != null) {
                                return d.this.ckM.onError(mediaPlayer, i, i2);
                            }
                            return false;
                        }
                    });
                    d.this.ckJ.setOnPauseListener(d.this.cjT, new com.baidu.swan.nalib.audio.c() { // from class: com.baidu.swan.games.audio.b.d.5.5
                        @Override // com.baidu.swan.nalib.audio.c
                        public void onPause() {
                            if (d.this.ckO != null) {
                                d.this.ckO.onPause();
                            }
                        }
                    });
                    d.this.ckJ.prepare(d.this.cjT);
                }
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void eA(final boolean z) {
        this.mAudioHandler.post(new Runnable() { // from class: com.baidu.swan.games.audio.b.d.6
            @Override // java.lang.Runnable
            public void run() {
                if (2 == d.this.ckJ.getState(d.this.cjT)) {
                    d.this.ckJ.setLoop(d.this.cjT, z);
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
                if (2 == d.this.ckJ.getState(d.this.cjT)) {
                    d.this.ckJ.setVolume(d.this.cjT, f);
                }
                d.this.mVolume = f;
            }
        });
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.ckK = onPreparedListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.ckL = onCompletionListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.ckM = onErrorListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.ckN = onSeekCompleteListener;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // com.baidu.swan.games.audio.b.c
    public void a(com.baidu.swan.nalib.audio.c cVar) {
        this.ckO = cVar;
    }

    @Override // com.baidu.swan.games.audio.b.c
    public boolean alI() {
        return false;
    }
}
